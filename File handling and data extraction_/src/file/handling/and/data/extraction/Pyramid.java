/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.handling.and.data.extraction;

/**
 *
 * @author Abdalnassef
 */
public class Pyramid {

    private String Pharaoh; // 0
    private String modern_name; // 2
    private String site; // 4
    private double height; // 7

    public Pyramid(String Pharaoh, String modern_name, String site, double height) {
        this.Pharaoh = Pharaoh; 
        this.modern_name = modern_name;
        this.site = site;
        this.height = height;
    }

    /**
     * @return the Pharaoh
     */
    public String getPharaoh() {
        return Pharaoh;
    }

    /**
     * @param Pharaoh the Pharaoh to set
     */
    public void setPharaoh(String Pharaoh) {
        this.Pharaoh = Pharaoh;
    }

    /**
     * @return the modern_name
     */
    public String getModern_name() {
        return modern_name;
    }

    /**
     * @param modern_name the modern_name to set
     */
    public void setModern_name(String modern_name) {
        this.modern_name = modern_name;
    }

    /**
     * @return the site
     */
    public String getSite() {
        return site;
    }

    /**
     * @param site the site to set
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

}
