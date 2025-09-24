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
import java.net.UnknownHostException;
import java.net.SocketException;

public class TugasNo3 {
    public static void main(String[] args) {
        String serverHost = "localhost"; 
        int serverPort = 5000;         
        String filePath = "data.txt";    

        try (
            FileInputStream fis = new FileInputStream(filePath);
            Socket socket = new Socket(serverHost, serverPort);
            OutputStream out = socket.getOutputStream()
        ) {
            System.out.println("Terhubung ke server: " + serverHost + ":" + serverPort);

            // kirim file
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
            System.out.println("File berhasil dikirim!");

        } catch (FileNotFoundException e) {
            System.err.println("File tidak ditemukan: " + e.getMessage());
        } catch (UnknownHostException e) {
            System.err.println("Host server tidak ditemukan: " + e.getMessage());
        } catch (SocketException e) {
            System.err.println("Masalah pada koneksi socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Kesalahan I/O saat mengirim file: " + e.getMessage());
        }
    }
}
