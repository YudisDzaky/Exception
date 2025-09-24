/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasKelas_Eksepsi;

/**
 *
 * @author YUDDZAYAS
 */
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class tugas41 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final int BUFFER_SIZE = 4096;

    public void uploadFile(String filePath) {
        FileInputStream fileInputStream = null;
        Socket socket = null;
        
        try {
            // Validasi file sebelum proses upload
            Path path = Paths.get(filePath);
            if (!Files.exists(path)) {
                throw new FileNotFoundException("File tidak ditemukan: " + filePath);
            }
            if (!Files.isReadable(path)) {
                throw new SecurityException("Tidak memiliki akses membaca file: " + filePath);
            }
            if (Files.size(path) == 0) {
                throw new IOException("File kosong tidak dapat diupload: " + filePath);
            }

            // Try-with-resources untuk automatic resource management
            try (FileInputStream fis = new FileInputStream(filePath);
                 Socket clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
                 OutputStream socketOutputStream = clientSocket.getOutputStream();
                 BufferedOutputStream bos = new BufferedOutputStream(socketOutputStream)) {
                
                System.out.println("Terhubung ke server, mulai upload...");
                
                // Baca dan kirim file
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead;
                long totalBytesRead = 0;
                long fileSize = Files.size(path);
                
                while ((bytesRead = fis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                    totalBytesRead += bytesRead;
                    
                    // Progress tracking
                    int progress = (int) ((totalBytesRead * 100) / fileSize);
                    System.out.printf("Progress: %d%%\r", progress);
                    
                    // Simulasi network delay untuk testing
                    Thread.sleep(10);
                }
                
                bos.flush();
                System.out.println("\nUpload berhasil! File terkirim: " + totalBytesRead + " bytes");
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IOException("Upload interrupted", e);
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("Error File: " + e.getMessage());
        } catch (SecurityException e) {
            System.err.println("Error Keamanan: " + e.getMessage());
        } catch (IOException e) {
            handleNetworkException(e);
        } catch (Exception e) {
            System.err.println("Error tak terduga: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void handleNetworkException(IOException e) {
        if (e instanceof java.net.ConnectException) {
            System.err.println("Error: Tidak dapat terhubung ke server " + SERVER_HOST + ":" + SERVER_PORT);
        } else if (e instanceof java.net.SocketTimeoutException) {
            System.err.println("Error: Timeout koneksi ke server");
        } else if (e instanceof java.net.UnknownHostException) {
            System.err.println("Error: Host server tidak dikenal: " + SERVER_HOST);
        } else if (e instanceof java.io.EOFException) {
            System.err.println("Error: Koneksi terputus secara tiba-tiba oleh server");
        } else {
            System.err.println("Error Jaringan: " + e.getMessage());
        }
    }
}