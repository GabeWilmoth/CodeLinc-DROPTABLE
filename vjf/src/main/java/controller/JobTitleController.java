/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Map;
import model.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import util.Util;

/**
 *
 * @author micah
 */
@RestController
public class JobTitleController {
     @PostMapping("/getJobTitle")
    public String NewJob(JobTitleRequest request){
        Map<String, Map<String, String>> map = Util.getMap();
       
        if(map.containsKey(request.getBranch()) &&
                map.get(request.getBranch()).containsKey(request.getOldJob())){
            
            return map.get(request.getBranch()).get(request.getOldJob());
        }
        else
            return "";
    }
    
}
