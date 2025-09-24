/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasKelas_Eksepsi.SocketException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 *
 * @author YUDDZAYAS
 */
public class MyServer {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Server()).start();
    }

    static class Server implements Runnable {
        @Override
        public void run() {
            ServerSocket serverSocket = null;

            try {
                serverSocket = new ServerSocket(4444);

                while (true) {
                    try {
                        Socket clientSocket = serverSocket.accept();

                        BufferedReader inputReader = new BufferedReader(
                                new InputStreamReader(clientSocket.getInputStream()));
                        System.out.println("Message from client: " + inputReader.readLine());
                    } catch (SocketTimeoutException ste) {
                        ste.printStackTrace();
                    }
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                try {
                    if (serverSocket != null) {
                        serverSocket.close();
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
}
