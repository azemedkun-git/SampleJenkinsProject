package com.example.ConsequetiveArmstrongNumbers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArmstrongController {

    @GetMapping("/greet")
    public String greeting(){
        return "hello user!";
    }


    @PostMapping("/numbers")
    public ResponseEntity<?> consequetiveArmstrongNumber(@RequestBody List<Integer> armNumbers){
        int count =0;
        boolean isArmstrong = false;
        List<Integer> theNumbers = new ArrayList<>();
        if(armNumbers.size()< 3){
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
        for(int i=0; i<armNumbers.size(); i++){
            isArmstrong = findIfArmstrong(armNumbers.get(i));
            if(isArmstrong){
                count++;
                theNumbers.add(armNumbers.get(i));
                if(count == 3 && theNumbers.size()==3){
                    return new ResponseEntity<>(new Result(true, theNumbers), HttpStatus.OK);
                }
            }
            else{
                count=0;
                theNumbers.clear();
            }
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
    private boolean findIfArmstrong(Integer n) {
        int input = n;
        int c = 0;
        while(n > 0){
            c = c + (int)Math.pow(n%10, 3);
           n = n/10;
        }
        if(c == input){
            return true;
        }
        return false;
    }
}
