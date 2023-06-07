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
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * @author Administrator
 */
public class Loader {

    private final static String SYSPATH = new File("").getAbsolutePath() + "\\src\\" ;

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
                dta.add(line);
            }
            input.close();
        } catch (IOException e) {
        }
        return dta;
    }
    /**
     * 
     * @param filePath
     * @param dta
     * write all String in @param dta to file ca @param filePath 
     * @return
     */
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
    /**
     * 
     * @param packageName
     * @return ArrayList<String> of all filename exist in packageName
     * @throws IOException 
     */
    public static ArrayList<String> getFilenameInPackage(String packageName) throws IOException{
        ArrayList<String> filenames = new ArrayList<>();
        String packagePath = packageName.replace('.', '/');
        URL url = Thread.currentThread().getContextClassLoader().getResource(packagePath);
        if (url != null) {
            String protocol = url.getProtocol();
            if (protocol.equals("file")) {
                String directoryPath = url.getPath();
                filenames.addAll(getFilenamesInDirectory(directoryPath));
                
            } else if (protocol.equals("jar")) {
                JarURLConnection jarConnection = (JarURLConnection) url.openConnection();
                JarFile jarFile = jarConnection.getJarFile();
                Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry entry = entries.nextElement();
                    String entryName = entry.getName();
                    
                    if (!entry.isDirectory() && entryName.startsWith(packagePath)) {
                        filenames.add(entryName);
                    }
                }
                
                jarFile.close();
            }
        }
        return filenames;
    }
    
    private static ArrayList<String> getFilenamesInDirectory(String directoryPath){
        ArrayList<String> filenames = new ArrayList<>() ;
        File directory = new File(directoryPath) ;
        File[] files = directory.listFiles() ;
        if(files != null){
            for(File file : files){
                if (file.isFile()){
                    filenames.add(file.getName());
                }
            }
        }
        return filenames ;
    }
}
