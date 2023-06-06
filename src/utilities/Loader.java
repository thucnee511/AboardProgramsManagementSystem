/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Loader {

    private final static String SYSPATH = new File("").getAbsolutePath();

    public static String initPath(String path) {
        return SYSPATH + path;
    }

    public static ArrayList<String> readFromFile(String path) {
        String _path = initPath(path);
        File file = new File(_path);
        ArrayList<String> dta = new ArrayList<>();/* Lưu thông tin đọc*/
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String line;
            while ((line = input.readLine()) != null) {
                dta.add(line.trim());
            }
            input.close();
        } catch (IOException e) {
        }
        return dta;
    }

    public static boolean writeToFile(String filePath, ArrayList<String> dta) {
        String _path = initPath(filePath);
        File file = new File(_path);
        try {
            file.createNewFile();/* tạo tệp mới neeyu tệp chưa tồn tại*/
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            for (String line : dta) {
                output.write(line);
                output.newLine();
            }
            output.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
