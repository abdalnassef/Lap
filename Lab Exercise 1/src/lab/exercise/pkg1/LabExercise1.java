/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.exercise.pkg1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Abdalnassef
 */
public class LabExercise1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List <City> Cities = new ArrayList<City>();
        Cities = new ReadCSV().GetCityList("D:\\ITI\\Java\\Session 4\\cities.csv");
        List <country> countries = new ArrayList<country>();
        countries = new ReadCSV().GetCountryList("D:\\ITI\\Java\\Session 4\\countries.csv");
        
        Map <String,City> M = new HashMap<>();


        for ( City c : Cities){
            M.put(c.getName(),c);  
        }
        
        
//        for ( Map.Entry<String, City> entry : M.entrySet()) {
//                String key = entry.getKey();
//                City tab = entry.getValue();
//                        System.out.println(key);
//                // do something with key and/or tab
//            }
        
        Map <String,City> M2 = new HashMap<>();
        List <City> cc = new ArrayList<City>();
        
        String CountryCode [] = {"Mumbai","Guangzhou","Tokyo","Shanghai"};
        for (String x : CountryCode){ 
            M2.put(x, M.get(x));
            cc.add(M.get(x));
        }
        Collections.sort(cc,new ValueComparator());

        
         for ( City c : cc){
            System.out.println(c.getName() + "    :    "+ c.getPopulation());
        }
    }
    
    
}
