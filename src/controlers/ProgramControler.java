/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import manager.ProgramManager;
import utilities.Menu;

/**
 *
 * @author Administrator
 */
public class ProgramControler {
    private final Menu menu;

    public ProgramControler() {
        menu = new Menu("Manage aboard programs.");
        menu.addOption("Display all aboard programs");
        menu.addOption("Add a new aboard programs");
        menu.addOption("Edit information of a program by id");
        menu.addOption("Serach and display a program by id");
        menu.addOption("Back to main menu");
    }

    public ProgramManager main(ProgramManager pm) {
        menu.printMenu();
        int choice = menu.getChoice();
        switch (choice) {
            case 1:
                pm.display();
                break;
            case 2:
                pm.add();
                break;
            case 3:
                pm.update();
                break;
            case 4:
                pm.search();
                break;
        }
        return pm ;
    }
}
