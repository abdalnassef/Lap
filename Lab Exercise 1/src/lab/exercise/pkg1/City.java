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
    private double population;

    public City(String Code, String Name, String Country, double population) {
        this.Code = Code;
        this.Name = Name;
        this.Country = Country;
        this.population = population;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
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

    public double getPopulation() {
        return population;
    }

}
