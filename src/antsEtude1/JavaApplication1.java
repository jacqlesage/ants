/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antsEtude1;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author James
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s;
        ArrayList<DNA> obj = new ArrayList<DNA>();
        try {
            FileInputStream is = new FileInputStream(new File("C:\\Users\\James\\Documents\\NetBeansProjects\\AntsEtude1\\src\\antsEtude1\\input.txt"));
            System.setIn(is);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner in = new Scanner(System.in);

        //test line
        //System.out.println("Enter a string");
        //get the line coming in
        
      
        
        while (in.hasNextLine()) {
            s = in.nextLine();
            //check if this line is a # - this should be comments so ignore
            if (s.charAt(0) == '#') {
                System.out.println("in if statement, comment found");
                //s = in.nextLine();
                //System.out.println(s);
            // check if character is digit
            } else if (Character.isDigit(s.charAt(0))) {
                Integer stepsToTake = Integer.parseInt(s);
                System.out.println("in int statement");
                System.out.println(stepsToTake);
            } else {
                //setup the DNA for the ant
                char DNA_State = s.charAt(0);
                System.out.println("state = " + DNA_State);

                char compassN = s.charAt(2);
                char compassE = s.charAt(3);
                char compassS = s.charAt(4);
                char compassW = s.charAt(5);

                System.out.println("compass = " + compassN + " " + compassE + " " + compassS + " " + compassW);

                char DNAToStateN = s.charAt(7);
                char DNAToStateE = s.charAt(8);
                char DNAToStateS = s.charAt(9);
                char DNAToStateW = s.charAt(10);

                System.out.println("DNAToState = " + DNAToStateN + " " + DNAToStateE + " " + DNAToStateS + " " + DNAToStateW);
                
                DNA e = new DNA(DNA_State,compassN, compassE,compassS,compassW,DNAToStateN,DNAToStateE,DNAToStateS,DNAToStateW);
                
                obj.add(e);
            }

            //echo the input
           

        }
    }
}
