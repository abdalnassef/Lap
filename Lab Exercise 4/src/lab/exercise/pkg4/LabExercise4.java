/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.exercise.pkg4;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import static javax.management.Query.value;
import lab.exercise.pkg1.*;
/**
 *
 * @author Abdalnassef
 */
public class LabExercise4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
                
        List <City> Cities = new ArrayList<City>();
        Cities = new ReadCSV().GetCityList("D:\\ITI\\Java\\Session 4\\cities.csv");
        
         

              
//        System.out.println(Cities.stream().min(Comparator.comparing(City::getPopulation)).get().getName());
//        System.out.println(Cities.stream().max(Comparator.comparing(City::getPopulation)).get().getName());
//        
double sum_ = Cities.stream().collect(Collectors.summingDouble(City::getPopulation));
//          System.out.println(Cities.stream().collect(Collectors.summingDouble(City::getPopulation)));
//          System.out.println(Cities.stream().mapToInt(City::getPopulation).sum());

        System.out.println("Average : "+sum_/Cities.size());




  
//double average = sum_ / Cities.size();
//        System.out.println(Cities.size());
//        System.out.println(sum_);
//        System.out.println(average);
        
        
    //  Median Quartile
      List <City> sortedCities =  Cities.stream().sorted(Comparator.comparing(City::getPopulation)).collect(Collectors.toList());
      int mid =sortedCities.size()/2; 
      System.out.println("Cities Size : "+sortedCities.size());
      System.out.println("Median index : "+mid);
      System.out.print("Median quartile City Name : "+sortedCities.get(mid).getName());     
      System.out.println( " it's population : "+sortedCities.get(mid).getPopulation());

      
    //  Lower Quartile
      int lower =sortedCities.size()/4; 
      System.out.println("lower index : "+lower);
      System.out.print("lower quartile City Name : "+sortedCities.get(lower).getName());     
      System.out.println( " it's population : "+sortedCities.get(lower).getPopulation());

      
    //  Upper Quartile      
      int upper =lower+mid; 
      System.out.println("upper index : "+upper);
      System.out.print("upper quartile City Name : "+sortedCities.get(upper).getName());     
      System.out.println( " it's population : "+sortedCities.get(upper).getPopulation());

    //List of Cities in first Q1,Q2
      List <City> midCitiesL = sortedCities.stream().collect(Collectors.toList()).subList(0, mid );
    //List of Cities in first Q3,Q4
      List <City> midCitiesH =  sortedCities.stream().collect(Collectors.toList()).subList(mid ,sortedCities.size());

    //List of Cities in first Q1      
      List <City> LowerCitiesL = sortedCities.stream().collect(Collectors.toList()).subList(0, lower );
    //List of Cities in first Q2      
      List <City> LowerCitiesH = sortedCities.stream().collect(Collectors.toList()).subList(lower, mid);
      
    //List of Cities in first Q3
      List <City> UpperCitiesL = sortedCities.stream().collect(Collectors.toList()).subList(mid, upper );
    //List of Cities in first Q4      
      List <City> UpperCitiesH = sortedCities.stream().collect(Collectors.toList()).subList(upper, sortedCities.size());
      
      
      
    


    }
    
}
