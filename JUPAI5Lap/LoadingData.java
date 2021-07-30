/*
 * Copyright 2021 ActFramework.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package iti.mans.g1.jupai5lap;

/**
 *
 * @author Abdalnassef
 */

import tech.tablesaw.api.Table;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.NumericColumn;
import tech.tablesaw.joining.DataFrameJoiner;
import tech.tablesaw.selection.Selection;

public class LoadingData {
    public LoadingData() {
    }
   public static void main(String[] args ) {
     String Path = "src/main/resources/data/titanic.csv";
     String Path2 = "src/main/resources/data/vgsales.csv";
      
     //using 2 Coulmns from second table
     MergeTwoTables(Path,Path2);
     
     AddCoulmnFor2Table(Path,Path2);
     
        String Coulmnname="age";
        GetMinMaxStdForCoulmn(Coulmnname,Path);
       

  

   }
   public static void GetMinMaxStdForCoulmn(String name,String Path){
        Table hrAnalytics  = null;
       try {
           hrAnalytics = Table.read().csv(Path);
           Table structure = hrAnalytics.structure();
           System.out.println(structure);
       
     
        NumericColumn MinCoulmn = hrAnalytics.numberColumn (name);
        double Min = MinCoulmn.min();
        System.out.println("   Min     :   "+ Min);
        
        NumericColumn MaxCoulmn = hrAnalytics.numberColumn (name);
        double Max = MaxCoulmn.max();
        System.out.println("   Max     :   "+ Max);
        
        NumericColumn STDCoulmn = hrAnalytics.numberColumn (name);
        double STD = STDCoulmn.standardDeviation();
        System.out.println("   Std     :   "+ STD);
     
           System.out.println("Summary for All Table : "+hrAnalytics.summary());
       } catch (IOException e) {
           e.printStackTrace ();
           System.out.println("Pug");
       }
       
  }
   public static void AddCoulmnFor2Table(String Path , String Path2){
       //Titanic Table
      Table TitancTable  = null;
        try {
            TitancTable = Table.read().csv(Path);
             } catch (IOException ex) {
            Logger.getLogger(LoadingData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(TitancTable.structure());
       
//VGSales Table 
        Table VGSalesTable  = null;
        try {
            VGSalesTable = Table.read().csv(Path2);
             } catch (IOException ex) {
            Logger.getLogger(LoadingData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(VGSalesTable.structure());

        int rowCount = TitancTable.rowCount();
        double[] theIndexing = new double[rowCount];
        for(int i = 0;i < rowCount;i++) theIndexing[i]=i;
        DoubleColumn myIndexColumn = DoubleColumn.create ("theIndexes", theIndexing);
        TitancTable.insertColumn (0, myIndexColumn);
        
        
        
        rowCount = VGSalesTable.rowCount();
        theIndexing = new double[rowCount];
        for(int i = 0;i < rowCount;i++) theIndexing[i]=i;
        myIndexColumn = DoubleColumn.create ("theIndexes", theIndexing);
        VGSalesTable.insertColumn (0, myIndexColumn);
     
   }
   
   public static void MergeTwoTables(String Path,String Path2){
       
   
    Table TitancTable  = null;
        try {
            TitancTable = Table.read().csv(Path);
             } catch (IOException ex) {
            Logger.getLogger(LoadingData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(TitancTable.structure());
       
//VGSales Table 
        Table VGSalesTable  = null;
        try {
            VGSalesTable = Table.read().csv(Path2);
             } catch (IOException ex) {
            Logger.getLogger(LoadingData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
Table a3 = TitancTable.addColumns(VGSalesTable.column("Year").first(TitancTable.rowCount()),VGSalesTable.column("Global_Sales").first(TitancTable.rowCount()));
       System.out.println(a3.summary());
       System.out.println(a3.first(10));
 
   }
}
