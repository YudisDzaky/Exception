/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasKelas_Eksepsi;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author YUDDZAYAS
 */
public class ContohUnknownHostException {
    public static void main(String[] args) {
               String host = "http://sinau.uinsa.com";  
        try {
            URL url = new URL(host);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            System.out.println(con.getResponseCode());
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}



