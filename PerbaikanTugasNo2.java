/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasKelas_Eksepsi;
    import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author YUDDZAYAS
 */
public class PerbaikanTugasNo2 {


    public static void main(String[] args) {
        try (FileReader fr = new FileReader("data.txt");
             BufferedReader br = new BufferedReader(fr)) {
            
            String line = br.readLine();
     
            if (line == null) {
                System.out.println("Error: File kosong atau tidak ada data");
                return;
            }
            if (!line.matches("-?\\d+")) {
                System.out.println("Error: Format angka tidak valid: " + line);
                return;
            }
            
            int angka = Integer.parseInt(line);
            
            if (angka == 0) {
                System.out.println("Error: Tidak bisa membagi dengan nol");
                return;
            }
            
            int hasil = 10 / angka;
            System.out.println("Hasil: " + hasil);
            
        } catch (IOException e) {
            System.out.println("Error membaca file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Format angka tidak valid - " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error matematika: " + e.getMessage());
        }
    }

}
