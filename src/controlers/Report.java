package controlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import manager.ProgramManager;
import manager.StudentManager;
import utilities.Inputter;
import utilities.Loader;

/**
 * Report
 */
public class Report {

    private final ArrayList<String> formFilenames;

    public Report() throws IOException {
        formFilenames = Loader.getFilenameInPackage("data.registrationform");
    }

    public void registration(ProgramManager pm, StudentManager sm) {
        formFilenames.add(ProgramRegister.register(pm, sm));
    }

    public void showRegistration(StudentManager sm) {
        String id = Inputter.getString("Enter student id: ", "This field cannot be empty.");
        if (sm.find(id) == null) {
            System.out.println("This student does not exist.");
        }
        int count = 0;
        for (String path : formFilenames) {
            System.out.println(path);
            if (path.contains(id)) {
                ArrayList<String> form = Loader.readFromFile("data/registrationform/" + path);
                printForm(form);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("The student has no registration.");
        }
    }

    public void showStudentHaveManyRegistration(StudentManager pm) {
        HashMap<String, Integer> ids = new HashMap<>();
        for (String filename : formFilenames) {
            String stuId = filename.split("_")[0];
            if (ids.containsKey(stuId)) {
                Integer count = ids.get(stuId) + 1;
                ids.put(stuId, count);
            } else {
                ids.put(stuId, 1);
            }
        }
        int count = 0;
        for (Entry<String, Integer> pair : ids.entrySet()) {
            if (pair.getValue() > 1) {
                count++ ;
                pm.find(pair.getKey()).display();
            }
        }
        if(count == 0) System.out.println("There is no student registered more than 2 programs.");
    }

    public void countStudentRegisteredProgram(ProgramManager pm) {
        String id = Inputter.getString("Enter program id: ", "This field cannot be empty.");
        if (pm.find(id) == null) {
            System.out.println("This program does not exist.");
        }
        int count = 0;
        for (String filename : formFilenames) {
            String proId = filename.split("_")[1];
            proId = proId.substring(0, proId.length() - 4);
            if (proId.equals(id)) {
                count++;
            }
        }
        System.out.println("Number of student registered program " + id + " is " + count);
    }

    private void printForm(ArrayList<String> form) {
        for (String line : form) {
            System.out.println(line);
        }
    }
}
