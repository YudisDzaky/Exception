/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasKelas_Eksepsi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author YUDDZAYAS
 */
public class test {
    public static void main(String[] args) {
        
    
    try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
    String line = br.readLine();
    if (line == null) {
        throw new IOException("File kosong!");
    }
    int angka = Integer.parseInt(line);
    if (angka == 0) {
        throw new ArithmeticException("Tidak boleh bagi nol!");
    }
    System.out.println("Hasil: " + (10 / angka));
} catch (FileNotFoundException e) {
    System.out.println("File tidak ditemukan: " + e.getMessage());
} catch (NumberFormatException e) {
    System.out.println("Isi file bukan angka valid: " + e.getMessage());
} catch (ArithmeticException e) {
    System.out.println("Error perhitungan: " + e.getMessage());
} catch (IOException e) {
    System.out.println("Kesalahan IO: " + e.getMessage());
}
    }
}
