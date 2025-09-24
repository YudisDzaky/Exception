/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasKelas_Eksepsi;

/**
 *
 * @author YUDDZAYAS
 */
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class ContohFileNotFoundException {
  
    public static void main(String args[]) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("myfile.txt"));
            String data = null;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}


