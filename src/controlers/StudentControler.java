/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import manager.StudentManager;
import utilities.Menu;

/**
 *
 * @author Administrator
 */
public class StudentControler {

    private final Menu menu;

    public StudentControler() {
        menu = new Menu("Manage Student.");
        menu.addOption("Display all students");
        menu.addOption("Add a new student");
        menu.addOption("Edit information of a student by id");
        menu.addOption("Back to main menu");
    }

    public StudentManager main(StudentManager sm) {
        menu.printMenu();
        int choice = menu.getChoice();
        switch (choice) {
            case 1:
                sm.display();
                break;
            case 2:
                sm.add();
                break;
            case 3:
                sm.update();
                break;
            default:
                break;
        }
        return sm ;
    }
}
