
package util;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author micah
 */
public class Util {

    public static Map<String, Map<String, String>> getMap() {
        File file = new File("src//Vet.csv");
        
        Map<String, Map<String,String>> map = new HashMap<>();
        
        String[] branches = {"Army", "Navy", "Marines", "Air Force"};
        
        for (String branch : branches) {
            map.put(branch, new HashMap<>());
        }

        // this gives you a 2-dimensional array of strings
        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream;

        try{
            inputStream = new Scanner(file);
            while(inputStream.hasNext()){
                
                String line= inputStream.nextLine();
                String[] values = line.split(",");
                // this adds the currently parsed line to the 2-dimensional string array
                lines.add(Arrays.asList(values));
            }

            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // the following code lets you iterate through the 2-dimensional array
        for(List<String> line: lines) {
            String branch = line.get(0);
            String oldJob = line.get(1);
            String newJob = line.get(2);
            
            Map<String, String> temp = map.get(branch);
            temp.put(oldJob, newJob);
        }

        return map;
        
    }

} 
