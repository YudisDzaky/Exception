/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasKelas_Eksepsi;
 import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ContohIOException {
   


    public static void main(String[] args) {
        String filePath = "file.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("An IOException occurred: " + e.getMessage());
            e.printStackTrace();
        
    }
}
}
