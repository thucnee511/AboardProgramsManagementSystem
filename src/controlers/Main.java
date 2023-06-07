/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import java.util.ArrayList;
import manager.ProgramManager;
import manager.StudentManager;
import utilities.Loader;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        StudentManager sm = MainControler.loadStudentData("data/students.dat");
        ProgramManager pm = null;
        try {
            pm = MainControler.loadProgramData("data/programs.dat");
        } catch (Exception e) {
        }
        MainControler mainCtrl = new MainControler();
        mainCtrl.main(sm, pm);
        Loader.writeToFile("data/programs.dat", pm.toArrayList());
        Loader.writeToFile("data/students.dat", sm.toArrayList());
    }
}
