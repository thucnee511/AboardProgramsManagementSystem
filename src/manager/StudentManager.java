/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.util.Date;
import java.util.TreeSet;
import models.Student;
import utilities.Inputter;

/**
 *
 * @author Administrator
 */
public class StudentManager extends TreeSet<Student> {

    public void display() {
        int count = 1;
        System.out.println("|No. |Student id|Student Name        |Major|Email                         |Phone     |Passport  |Address        |");
        for (Student s : this) {
            String no = String.format("|%4s", count);
            System.out.print(no);
            s.display();
            count++;
        }
    }

    public Student find(String id) {
        for (Student s : this) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public void add() {
        String id;
        while (true) {
            id = Inputter.getString("Enter student id: ", "This field cannot be empty.");
            if (find(id) == null) {
                break;
            } else {
                System.out.println("Id must be unique.");
            }
        }
        String name = Inputter.getString("Enter student name: ", "This field cannot be empty.");
        String major = Inputter.getString("Enter progam time: ", "SE, SB, GD, MC", "([sS](([eE])|([Bb])))|([Gg][Dd])|([Mm][Cc])");
        String email = Inputter.getString("Enter studetn email: ", "Must contain \"@fpt.edu.vn\"", ".*(@fpt\\.edu\\.vn)$");
        String phone = Inputter.getString("Enter student phone: ", "This field cannot be empty.");
        String passport = Inputter.getString("Enter student passport: ", "This field cannot be empty.");
        String address = Inputter.getString("Enter student address: ", "This field cannot be empty.");
        this.add(new Student(id, name, major, email, phone, passport, address));
    }

    public void update() {
        String id = Inputter.getString("Enter student id: ", "This field cannot be empty.");
        if (find(id) == null) {
            System.out.println("This student does not exist.");
        } else {
            Student s = find(id) ;
            String name = Inputter.getString("Enter student name: ", "This field cannot be empty.");
            String major = Inputter.getString("Enter progam time: ", "SE, SB, GD, MC", "([sS](([eE])|([Bb])))|([Gg][Dd])|([Mm][Cc])");
            String email = Inputter.getString("Enter studetn email: ", "Must contain \"@fpt.edu.vn\"", ".*(@fpt\\.edu\\.vn)$");
            String phone = Inputter.getString("Enter student phone: ", "This field cannot be empty.");
            String passport = Inputter.getString("Enter student passport: ", "This field cannot be empty.");
            String address = Inputter.getString("Enter student address: ", "This field cannot be empty.");
            s.setAddress(address);
            s.setEmail(email);
            s.setName(name);
            s.setMajor(major);
            s.setPassport(passport);
            s.setPhone(phone);
            System.out.println("Update successfully.");
        }
    }
}
