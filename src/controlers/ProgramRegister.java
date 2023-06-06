/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import manager.ProgramManager;
import manager.StudentManager;
import models.Program;
import models.Student;
import utilities.DateModifier;
import utilities.Inputter;
import utilities.Loader;

/**
 *
 * @author Administrator
 */
public class ProgramRegister {

    public static String register(ProgramManager pm, StudentManager sm) {
        Program p;
        Student s;
        String pId = Inputter.getString("Enter program id: ", "This field cannot be empty.");
        if ((p = pm.find(pId)) == null) {
            System.out.println("The program does not exist.");
        }
        String sId = Inputter.getString("Enter student id: ", "This field cannot be empty.");
        if ((s = sm.find(sId)) == null) {
            System.out.println("The student does not exist.");
        }
        Date regisDate;
        while (true) {
            regisDate = Inputter.getDate("Enter registration date: ");
            if (DateModifier.inRange(p.getBeginDate(), p.getEndDate(), regisDate)) {
                break;
            }
            System.out.println("Registration date is invalid.");
        }
        String parentPhone = Inputter.getString("Enter parent phone: ", "This field cannot be empty.");
        String parentEmail = Inputter.getString("Enter parent email: ", "This field cannot be empty.");
        String path = "\\src\\registrationform\\" + initFileName(s, p);
        createForm(path, s, p, regidDate , parrentPhone, parrentEmail);
        return path;
    }

    private static void createForm(String path, Student s, Program p, Date regisDate , String parentPhone, String parentEmail) {
        ArrayList<String> dta = new ArrayList<String>() ;
        dta.add("                                             Aboard Program Registration Form");
        dta.add("Information of student: ");
        dta.add(String.format("Student id: %13s Student name: %s", s.getId(), s.getName()));
        dta.add(String.format("Major: %18s Email: %s    Phone: %s    Passport: %s", s.getMajor(),
                s.getPhone(), s.getPassport()));
        dta.add(String.format("Address: %16s Email of the parent: %s    Phone of the parents: %s",
                s.getAddress(), parentPhone, parentEmail));
        dta.add("Information of the aboard program:");
        dta.add(String.format("Program id: %13s Program name: %s", p.getId() , p.getName()));
        dta.add(String.format("Time: %19s Days: %d    Location: %s    Cost: %.2f$",p.getTime() , p.getLocation(),p.getDays(),p.getCost())) ;
        dta.add("Information of the registration:");
        dta.add("Registration date:        %s",DateModifier.toDateString(regisDate, null)) ;
        Loader.writeToFile(path, dta);
    }

    private static String initFileName(Student s, Program p) {
        String filename = ".txt";
        filename = s.getId() + "_" + p.getId() + filename;
        return filename;
    }
}
