/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import manager.ProgramManager;
import manager.StudentManager;
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
    }
    
    public void main(StudentManager sm , ProgramManager pm){
        menu.printMenu();
        int choice = menu.getChoice();
        switch (choice) {
            case 1:
                ProgramControler pc = new ProgramControler() ;
                pm = pc.main(pm) ;
                break;
            case 2:
                StudentControler sc = new StudentControler() ;
                sm= sc.main(sm) ;
                break;
            case 3,4:
                ReportControler rc = new ReportControler();
                rc.main(sm, pm, choice);
                break;
            default:
                break;
        }
    }
}
