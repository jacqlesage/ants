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
import java.util.HashMap;
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
        ArrayList<DNA> DNAlist = new ArrayList<>();
        Integer numSteps = readInput(DNAlist);
        startAntJourney(DNAlist, numSteps);
    }

    private static Integer readInput(ArrayList<DNA> DNAlist) {
        Integer numSteps = 0;
        String s;
        try {
            FileInputStream is = new FileInputStream(new File("C:\\Users\\admin\\Documents\\Otago uni\\COSC326\\ants\\ants\\src\\antsEtude1\\input.txt"));
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
//                System.out.println("in if statement, comment found");
                //System.out.println(s);
                // check if character is digit
            } else if (Character.isDigit(s.charAt(0))) {
                numSteps = Integer.parseInt(s);
//                System.out.println("in int statement");
//                System.out.println(numSteps);
            } else {
                
                System.out.println(s + "\n");
//                setup the DNA for the ant
                char DNA_State = s.charAt(0);
//                System.out.println("state = " + DNA_State);

                char compassN = s.charAt(2);
                char compassE = s.charAt(3);
                char compassS = s.charAt(4);
                char compassW = s.charAt(5);

//                System.out.println("compass = " + compassN + " " + compassE + " " + compassS + " " + compassW);

                char DNAToStateN = s.charAt(7);
                char DNAToStateE = s.charAt(8);
                char DNAToStateS = s.charAt(9);
                char DNAToStateW = s.charAt(10);

//                System.out.println("DNAToState = " + DNAToStateN + " " + DNAToStateE + " " + DNAToStateS + " " + DNAToStateW);

                DNA e = new DNA(DNA_State, compassN, compassE, compassS, compassW, DNAToStateN, DNAToStateE, DNAToStateS, DNAToStateW);

                DNAlist.add(e);

            }
        }
        for (DNA e : DNAlist) {
//        System.out.println(e.toString());
        }
        return numSteps;
    }
    
    private static void startAntJourney(ArrayList<DNA> DNAlist, Integer numSteps) {
        HashMap grid = new HashMap();
        char currentState = ' ';
        Point currentPoint;
        char initialState = DNAlist.get(0).getState();
//        System.out.println("initial state = " + initialState);
        grid.put(new Point(0,0), initialState);
        Ant ant = new Ant('N', new Point(0,0));
//        System.out.println(ant.toString());
//        System.out.println("numSteps = " + numSteps);
        for (int i = 1; i < numSteps; i++) {
//            System.out.println("in for loop");
            currentPoint = ant.getLocation();
//            System.out.println("current point = " + currentPoint);
            if (grid.containsKey(currentPoint)) {
                currentState = (char) grid.get(currentPoint);
            } else {
                grid.put(currentPoint, initialState);
                currentState = initialState;
            }
//            System.out.println("current state = " + currentState);
            for (DNA dna : DNAlist) {
                char dna_state = dna.getState();
                if (currentState == dna_state) {
                    dna.moveAnt(ant, grid);
                }
            }
//            System.out.println(grid.toString());
        }
        Point finalLocation = ant.getLocation();
        int x = finalLocation.x;
        int y = finalLocation.y;
        System.out.println("# " + x + " " + y);
    }
}
