/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import java.text.ParseException;
import java.util.ArrayList;
import manager.ProgramManager;
import manager.StudentManager;
import models.Program;
import models.Student;
import utilities.DateModifier;
import utilities.Loader;
import utilities.Menu;

/**
 *
 * @author Administrator
 */
public class MainControler {

    private final Menu menu;

    public MainControler() {
        menu = new Menu("Aboard program management system.");
        menu.addOption("Manage aboard programs");
        menu.addOption("Manage Student");
        menu.addOption("Register a program for a student");
        menu.addOption("Report");
        menu.addOption("Quit");
    }

    public void main(StudentManager sm, ProgramManager pm) {
        while (true) {
            menu.printMenu();
            int choice = menu.getChoice();
            switch (choice) {
                case 1:
                    ProgramControler pc = new ProgramControler();
                    pm = pc.main(pm);
                    break;
                case 2:
                    StudentControler sc = new StudentControler();
                    sm = sc.main(sm);
                    break;
                case 3, 4:
                    ReportControler rc = new ReportControler();
                    rc.main(sm, pm, choice);
                    break;
                case 5:
                    return;
            }
        }
    }

    public static StudentManager loadStudentData(String filepath) {
        StudentManager sm = new StudentManager();
        ArrayList<String> data = Loader.readFromFile(filepath);
        for (String line : data) {
            if (line == null || line.isEmpty()) {
                continue;
            }
            String[] lineSplit = line.split(",");
            sm.add(new Student(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5], lineSplit[6]));
        }
        return sm;
    }

    public static ProgramManager loadProgramData(String filepath) throws ParseException {
        ProgramManager pm = new ProgramManager();
        ArrayList<String> data = Loader.readFromFile(filepath);
        for (String line : data) {
            if (line == null || line.isEmpty()) {
                continue;
            }
            String[] lineSplit = line.split(",");
            pm.add(new Program(lineSplit[0], lineSplit[1], lineSplit[2],
                    DateModifier.toDate(lineSplit[3], null),
                    DateModifier.toDate(lineSplit[4], null),
                    Integer.parseInt(lineSplit[5]),
                    lineSplit[6],
                    Double.parseDouble(lineSplit[7]),
                    lineSplit[8]));
        }
        return pm;
    }
}
