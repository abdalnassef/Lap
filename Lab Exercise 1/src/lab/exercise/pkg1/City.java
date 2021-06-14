/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.exercise.pkg1;

/**
 *
 * @author Abdalnassef
 */
public class City {

    private String Code;
    private String Name;
    private String Country;
    private int population;
    private String ISO3;
    private String Cpital;

    public City(String Code, String Name, String Country, String ISO3,String Cpital, int population) {
        this.Code = Code;
        this.Name = Name;
        this.Country = Country;
        this.population = population;
        this.ISO3 = ISO3;
        this.Cpital = Cpital;
        
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }
    
    public String getCpital() {
        return Cpital;
    }

    public void setCpital(String Cpital) {
        this.Cpital = Cpital;
    }
    
    public String getISO3() {
        return ISO3;
    }

    public void setISO3(String ISO3) {
        this.ISO3 = ISO3;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return Name;
    }

    public int getPopulation() {
        return population;
    }
    
    public City getCity() {
        return this;
    }

}
