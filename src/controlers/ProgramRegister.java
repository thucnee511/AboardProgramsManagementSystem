/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        String parrentPhone = Inputter.getString("Enter parrent phone: ", "This field cannot be empty.");
        String parrentEmail = Inputter.getString("Enter parrent email: ", "This field cannot be empty.");
        String path = "\\src\\registrationform\\" + initFileName(s, p);
        createForm(path, s, p, parrentPhone, parrentEmail);
        return path;
    }

//  Student id: Student name:...
//  Major: Email:
//  Address:                  Email:
    
    private static void createForm(String path, Student s, Program p, String parrentPhone, String parrentEmail) {
        File file = new File(Loader.initPath(path)) ;
        try {
            file.createNewFile();
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write("Information Student:");
            String stuLine1 = String.format("Student id: %13s Student name: %s",s.getId() , s.getName());
            String stuLine2 = String.format("Major: %18s Email: %s    Phone: %s    Passport: %s",s.getMajor() , s.getPhone() , s.getPassport());
            String stuLine3 = String.format("", );
            output.newLine();
            output.close();
        } catch (IOException e) {
        }
    }

    private static String initFileName(Student s, Program p) {
        String filename = ".txt";
        filename = s.getId() + "_" + p.getId() + filename;
        return filename;
    }
}
