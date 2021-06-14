/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.exercise.pkg2;

import static com.sun.org.apache.xpath.internal.axes.HasPositionalPredChecker.check;
import java.util.function.BiPredicate;
import java.util.function.Function;
import static sun.nio.ch.IOStatus.check;
import static sun.nio.ch.IOStatus.check;

/**
 *
 * @author Abdalnassef
 */
public class BString_ {

    public static String CheckbetterString(String First,String Second,BiPredicate<String,String> p){
        return p.test(First, Second) ? First : Second ;
                }
     
     }
     
