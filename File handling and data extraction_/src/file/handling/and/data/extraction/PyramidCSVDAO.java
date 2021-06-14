/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.handling.and.data.extraction;

import java.io.File;
import java.io.FileNotFoundException;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdalnassef
 */
public class PyramidCSVDAO {

    public PyramidCSVDAO() {

    }

    public List<Pyramid> readPyramidsFromCSV(String filename) {
       
        List  <Pyramid> Pyramidinfo =new ArrayList<Pyramid>();

        try {
            Scanner sc = new Scanner(new File(filename));
            String line[];
            sc.useDelimiter("\n");
            //For ignore header line 
            sc.next();
            while (sc.hasNext()){
                line =sc.next().split(",");
                
                Pyramidinfo.add(createPyramid(line));
            }
            sc.close();
            return Pyramidinfo ;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PyramidCSVDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("File Not Found , kindly check name or path");
        }
        return Pyramidinfo ;
    }

    public Pyramid createPyramid(String[] metadata) {
                for (int i = 0;i<metadata.length ; i++){
                    metadata[i]=metadata[i].trim();
                    metadata[i] = metadata[i].replaceAll("[(?)*]", "");
                    //System.out.println(sc.next());
                }
                //System.out.println(metadata[7]);
                if(metadata[7].equals("") )metadata[7]="0";
                
                Pyramid p = new Pyramid(metadata[0],metadata[2],metadata[4],Double.parseDouble(metadata[7])) ;

//sssss
        return p;
                
    }

}
