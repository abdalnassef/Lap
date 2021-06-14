/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.handling.and.data.extraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Abdalnassef
 */
public class FileHandlingAndDataExtraction {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
       PyramidCSVDAO PyramidCSVDA = new PyramidCSVDAO();
       List  <Pyramid> Pyramids = PyramidCSVDA.readPyramidsFromCSV( "D:\\ITI\\Java\\Session 3\\pyramids.csv");
       
       
       for (int i=0 ; i <Pyramids.size();i++){
           System.out.print("# "+i);
           System.out.print("  : Pharaoh : "+Pyramids.get(i).getPharaoh());
           System.out.print(" : Modern name : "+Pyramids.get(i).getModern_name());
           System.out.print(" : Site : "+Pyramids.get(i).getSite());
           if(Pyramids.get(i).getHeight()!=0)
           System.out.println(" : Height (m) : "+Pyramids.get(i).getHeight());
           else System.out.println(" : Height (m) : UNKNOWN");
           
       }
       
       
    }
    
}
