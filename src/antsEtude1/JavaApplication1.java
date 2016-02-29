/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antsEtude1;

import java.awt.Point;
import java.util.Scanner;

/**
 *
 * @author James
 */
public class JavaApplication1 {

    private final Point N = new Point (0,1);
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s;
        
        Scanner in = new Scanner (System.in);
        
        //test line
        System.out.println("Enter a string");
        
        //get the line coming in
        s = in.nextLine();
        
        //check if this line is a # - this should be comments so ignore
        if(s.charAt(0)== '#'){
        System.out.println("in if statement");
            s = in.nextLine();
        //System.out.println(s);
        }else {
            //setup the DNA for the ant
            char DNA_State = s.charAt(0);
            
            
            
            
            
            
            
            char DNAToState1 = s.charAt(7);
            char DNAToState2 = s.charAt(8);
            char DNAToState3 = s.charAt(9);
            char DNAToState4 = s.charAt(10);
            
        }
        
        
        
        //echo the input
        System.out.println(s);
        
        
    }
    
   
    
}
