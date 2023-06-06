package controlers;

import java.util.ArrayList;
import java.util.HashMap;

import manager.ProgramManager;
import manager.StudentManager;
import utilities.Loader;

/**
 * Report
 */

public class Report {
    ArrayList<String> formFilename = Loader.readFromFile("\\src\\data\\formpath.dat");
    
    public void registration(ProgramManager pm , StudentManager sm){
        formFilename.add(ProgramRegister.register(pm, sm));
    }

    public void showRegistration(StudentManager sm){
        String id = Inputter.getString("Enter student id: ", "This field cannot be empty.");
        if (sm.find(id) == null) {
            System.out.println("This student does not exist.");
        }
        int count = 0 ;
        for(String path : formFilename){
            if (path.contains(id)){
                ArrayList<String> form = Loader.readFromFile(path);
                printForm(form);
                count++ ;
            }
        }
        if(count == 0) System.out.println("The student has no registration.");
    }

    public void showStudentHaveManyRegistration(StudentManager pm){
        HashMap<String,Integer> ids = new HashMapM<>() ;
        for(String path : formFilename){
            String filename = path.split("\\")[1] ;
            String stuId = filename.split("_")[0];
            if (ids.containsKey(stuId)){
                Integer count = ids.get(stuId) + 1;
                ids.put(stuId, count);
            }else{
                ids.put(stuId, 1);
            }
        }
        for(Entry<String,Integer> pair : ids.entrySet()){
            if(pair.getValue() > 1){
                pm.find(pair.getKey()).display();
            }
        }
    }

    public void countStudentRegisteredProgram(ProgramManager pm){
        String id = Inputter.getString("Enter program id: ", "This field cannot be empty.");
        if (pm.find(id) == null) {
            System.out.println("This program does not exist.");
        }
        int count = 0 ;
        for(String path : formFilename){
            String filename = path.split("\\")[1] ;
            String proId = filename.split("_")[1];
            if (proId.equals(id)) count++ ;
        }
        System.out.println("Number of student registered program " + id + " is " + count);
    }


    private void printForm(ArrayList<String> form){
        for(String line : form){
            System.out.println(line);
        }
    }
}