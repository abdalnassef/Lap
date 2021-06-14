/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.exercise.pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Abdalnassef
 */
public class ReadCSV {
    
    
    int i =0;
   public List<City> GetCityList(String citiespath){
        // TODO code application logic here
        List <City> CityList = new ArrayList<City>();
        try {
//            "D:\\ITI\\Java\\Session 4\\cities.csv"
//            "D:\\ITI\\Java\\Session 4\\countries.csv"
            Scanner cities = new Scanner(new File(citiespath));
            
            String line[];
            cities.useDelimiter("\n");
            //For ignore header line 
            cities.next();
            while (cities.hasNext()){
                line =cities.next().split(",");
                CityList.add(CityItem(line));
            }
            cities.close();
            
        } catch (FileNotFoundException ex) {

            System.out.println("File Not Found , kindly check name or path");
        }
        return CityList;
    }
    
   
   public List<country> GetCountryList(String countriespath){
        // TODO code application logic here
        List <country> CountryList = new ArrayList<country>();
        try {
//            "D:\\ITI\\Java\\Session 4\\cities.csv"
//            "D:\\ITI\\Java\\Session 4\\countries.csv"
            Scanner countries = new Scanner(new File(countriespath));
            
            String line[];
            countries.useDelimiter("\n");
            //For ignore header line 
            countries.next();
            while (countries.hasNext()){
                line =countries.next().split(",");
                CountryList.add(CountryItem(line));
            }
            countries.close();
            
        } catch (FileNotFoundException ex) {

            System.out.println("File Not Found , kindly check name or path");
        }
        return CountryList;
    }
   
    public City CityItem(String[] City_){
//        0           1            2        3      4        5     6         7                 8        9            10
//         city	city_ascii	lat	lng	country	iso2	iso3	admin_name	capital	population	id
//         public City(String Code, String Name,String country, int population) {
        if(City_[9].length()<2)City_[9]="000";
//        System.out.println(City_[8]);
        City C = new City(City_[10],City_[1],City_[4],City_[6],City_[8],Integer.parseInt(City_[9])) ;        
        return C;
    }
    
    
    
     public country CountryItem(String[] Country_){
//        0           1            2        3      4        5     6         7                 8        9            10
//         FIFA	official_name_en	Continent
//         public country(String Continent, String Country, String Code) {

//         System.out.println(Country_[2]);
        country C = new country(Country_[2],Country_[1],Country_[0]) ;        
        return C;
    }
}
