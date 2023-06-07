/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import java.io.IOException;
import manager.ProgramManager;
import manager.StudentManager;
import utilities.Menu;

/**
 *
 * @author Administrator
 */
public class ReportControler {

    private final Menu menu;

    public ReportControler() {
        menu = new Menu("Report.");
        menu.addOption("Print out the registration by student’s id");
        menu.addOption("Print out the students that registered more than 2 programs");
        menu.addOption("Count students that registered the program");
        menu.addOption("Back to main menu");
    }

    public void main(StudentManager sm, ProgramManager pm, int option) {
        try {
            Report report = new Report();
            if (option == 3){
                report.registration(pm, sm);
                return ;
            }
            menu.printMenu();
            int choice = menu.getChoice();
            switch (choice) {
                case 1:
                    report.showRegistration(sm);
                    break;
                case 2:
                    report.showStudentHaveManyRegistration(sm);
                    break;
                case 3:
                    report.countStudentRegisteredProgram(pm);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
