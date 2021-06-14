/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.exercise.pkg1;

import java.util.Comparator;

/**
 *
 * @author Abdalnassef
 */
class ValueComparator implements Comparator<City> {
    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    @Override
    public int compare(City a, City b) {
        try {
            if (a.getPopulation() >= b.getPopulation()) {
            return -1;
        } else {
            return 1;
        }
        
        }catch(Exception e){ }
        return 1;// returning 0 would merge keys
    }
}