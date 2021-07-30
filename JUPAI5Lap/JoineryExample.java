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

import joinery.DataFrame;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

public class JoineryExample {
    public static void main(String args[]){
        try {
            DataFrame<Object>  df3= DataFrame.readCsv ("src/main/resources/data/titanic.csv");
//            CSVFormat csvFormat = CSVFormat.withAllowDuplicateHeaderNames();
                    

            System.out.println(df3.head());
            System.out.println("");
            System.out.println("");
            DataFrame<Object>  df4= DataFrame.readCsv ("src/main/resources/data/vgsales.csv");
            System.out.println(df4.head());
            System.out.println("");
            System.out.println("");

//            [pclass, survived, name, sex, age, sibsp, parch, ticket, fare, cabin, embarked, boat, body, home.dest]
//            [Rank, Name, Platform, Year, Genre, Publisher, NA_Sales, EU_Sales, JP_Sales, Other_Sales, Global_Sales]

            
            DataFrame<Object>  df= DataFrame.readCsv ("src/main/resources/data/titanic.csv")
                    .retain("pclass","survived","age")
                    .describe();
           System.out.println ("Max : "+df.max());
           System.out.println ("Min : "+df.min());
           System.out.println ("STD : "+df.stddev());
           System.out.println ("=========================================================================================");

           
             DataFrame<Object>  df1= DataFrame.readCsv ("src/main/resources/data/titanic.csv")
                    .retain("age","ticket","cabin","survived").head(20);
          
            DataFrame<Object>  df2= DataFrame.readCsv ("src/main/resources/data/vgsales.csv")
                    .retain("Genre","Global_Sales").head(20);
            
                        System.out.println(df1.head());
                        System.out.println(df2.head());

	df1 = df1.rename("age", "test");
        df2 = df2.rename("Global_Sales", "test");
        df2 = df2.unique("test");
        df1 = df1.unique("test");
        DataFrame<Object> joinedDf = df1.joinOn(df2, DataFrame.JoinType.LEFT, "test");
        System.out.println(joinedDf.head());
       
        try {
            DataFrame<Object> mergdf = df1.merge(df2);
        System.out.println(mergdf.head());
}catch(Exception e){
            System.out.println("Error : "+e.getMessage());
}
        
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
