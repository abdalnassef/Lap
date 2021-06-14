/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.exercise.pkg2;

import java.util.function.Function;


/**
 *
 * @author Abdalnassef
 */
public class LabExercise2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String string1="Ahmed";
        String string2="Mohamed";
        
        String x = BString_.CheckbetterString(string1,string2,(s1,s2) -> s1.length()>s2.length()); 
//        System.out.println(x);
        


// check whether a string contains only alphabets
        String str2="Mohamed2";

        Function<String,Boolean> CheckCharFunc;
        CheckCharFunc = Str->{
                for (int i = 0; i < Str.length(); i++) 
                            if ((Character.isLetter(Str.charAt(i)) == false)) 
                                return false;   
                              
                            return true;   
                        };
        System.out.println(CheckCharFunc.apply(str2));

    }
    
    
    
}
