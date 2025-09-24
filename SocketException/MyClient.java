/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasKelas_Eksepsi.SocketException;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author YUDDZAYAS
 */
public class MyClient {
    public static void main(String[] args) {
        new Thread(new Client()).start();
    }

    static class Client implements Runnable {
        @Override
        public void run() {
            Socket socket = null;

            try {
                socket = new Socket("localhost", 4444);

                PrintWriter outWriter = new PrintWriter(socket.getOutputStream(), true);
                outWriter.println("Hello");

                outWriter.close();
                socket.close();

                outWriter = new PrintWriter(socket.getOutputStream(), true);
                outWriter.println("Hello again");
            } catch (UnknownHostException uhe) {
                uhe.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                try {
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
}
