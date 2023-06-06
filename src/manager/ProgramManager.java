/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.util.Date;
import java.util.TreeSet;
import models.Program;
import utilities.Inputter;

/**
 *
 * @author Administrator
 */
public class ProgramManager extends TreeSet<Program> {

    public void display() {
        int count = 1;
        System.out.println("|No. |Program id|    Program name    |Time      |Begin Date| End Date |     Days     |Location                           |Cost    |");
        for (Program p : this) {
            String no = String.format("|%4s", count);
            System.out.print(no);
            p.display();
            count++;
        }
    }

    public Program find(String id) {
        for (Program p : this) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void add() {
        String id;
        while (true) {
            id = Inputter.getString("Enter program id: ", "This field cannot be empty.");
            if (find(id) == null) {
                break;
            } else {
                System.out.println("Id must be unique.");
            }
        }
        String name = Inputter.getString("Enter program name: ", "This field cannot be empty.");
        String time = Inputter.getString("Enter progam time: ", "January, March, May, July, September, November", "([jJ]anuary)|([mM]arch)|([mM]ay)|([jJ]uly)|([sS]eptember)|([nN]ovember)");
        Date beginDate = Inputter.getDate("Enter begin date: ");
        Date endDate = Inputter.getDate("Enter end date: ");
        int days = Inputter.getInt("Enter program length: ", "30 to 40 days", 30, 40);
        String location = Inputter.getString("Enter program location: ", "This field cannot be empty.");
        double cost = Inputter.getPositiveReal("Enter program cost: ", "This field must be a real number.");
        String content = Inputter.getString("Enter program content: ", "This feild cannot be empty");
        this.add(new Program(id, name, time, beginDate, endDate, days, location, cost, content));
    }

    public void update() {
        String id = Inputter.getString("Enter program id: ", "This field cannot be empty.");
        if (find(id) == null) {
            System.out.println("This program does not exist.");
        } else {
            Program p = find(id);
            String name = Inputter.getString("Enter program name: ", "This field cannot be empty.");
            String time = Inputter.getString("Enter progam time: ", "January, March, May, July, September, November", "([jJ]anuary)|([mM]arch)|([mM]ay)|([jJ]uly)|([sS]eptember)|([nN]ovember)");
            Date beginDate = Inputter.getDate("Enter begin date: ");
            Date endDate = Inputter.getDate("Enter end date: ");
            int days = Inputter.getInt("Enter program length: ", "30 to 40 days", 30, 40);
            String location = Inputter.getString("Enter program location: ", "This field cannot be empty.");
            double cost = Inputter.getPositiveReal("Enter program cost: ", "This field must be a real number.");
            String content = Inputter.getString("Enter program content: ", "This feild cannot be empty");
            p.setName(name);
            p.setTime(time);
            p.setBeginDate(beginDate);
            p.setEndDate(endDate);
            p.setDays(days);
            p.setLocation(location);
            p.setCost(cost);
            p.setContent(content);
            System.out.println("Update successfully.");
        }
    }

    public void find() {
        String id = Inputter.getString("Enter program id: ", "This field cannot be empty.");
        if (find(id) == null) {
            System.out.println("This program does not exist.");
        } else {
            Program p = find(id);
            p.display();
        }
    }
}
