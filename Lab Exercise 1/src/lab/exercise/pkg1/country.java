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
public class country {

    private String Continent;
    private String Country;
    private String Code;

    
    public country(String Continent, String Country, String Code) {
        this.Continent = Continent;
        this.Country = Country;
        this.Code = Code;
    }

        
    public String getContinent() {
        return Continent;
    }

    public String getCountry() {
        return Country;
    }

    public String getCode() {
        return Code;
    }

    public void setContinent(String Continent) {
        this.Continent = Continent;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }


}
