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
    /**
     * A method which reads in input and makes changes on it as per customers requirements
     * 
     * @param DNAlist - An Arraylist which holds the lines from the input
     * @return numSteps - the amount of lines to process
     */
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

        //get the line coming in
        while (in.hasNextLine()) {
            s = in.nextLine();
            //check if this line is a # - this should be comments so ignore
            if (s.charAt(0) == '#') {
                // check if character is digit - then we are at the number of times/lines there will be
            } else if (Character.isDigit(s.charAt(0))) {
                numSteps = Integer.parseInt(s);

            } else {
             //we have to capture the input from the line and break it down for our DNA constructor   
                System.out.println(s + "\n");
//                setup the DNA for the ant
                char DNA_State = s.charAt(0);

                char compassN = s.charAt(2);
                char compassE = s.charAt(3);
                char compassS = s.charAt(4);
                char compassW = s.charAt(5);

                char DNAToStateN = s.charAt(7);
                char DNAToStateE = s.charAt(8);
                char DNAToStateS = s.charAt(9);
                char DNAToStateW = s.charAt(10);

                //place the info into our constructor for the DNA object
                DNA e = new DNA(DNA_State, compassN, compassE, compassS, compassW, DNAToStateN, DNAToStateE, DNAToStateS, DNAToStateW);

                DNAlist.add(e);

            }
        }
        /*
        A test for the objects
        for (DNA e : DNAlist) {
        //System.out.println(e.toString());
        }
        */
        return numSteps;
    }
    /**
     * A method which in theory moves an ant around keeping track of the "Point"
     * and checking that if the ant goes back to a previously visited point, what that 
     * state was, and finally the final position of the Ant
     * 
     * @param DNAList the array list of input
     * @param numSteps - the number of steps to take
     * 
     */
    private static void startAntJourney(ArrayList<DNA> DNAlist, Integer numSteps) {
        HashMap grid = new HashMap();
        char currentState = ' ';
        Point currentPoint;
        char initialState = DNAlist.get(0).getState();

        grid.put(new Point(0,0), initialState);
        Ant ant = new Ant('N', new Point(0,0));

        for (int i = 1; i < numSteps; i++) {

            currentPoint = ant.getLocation();

            if (grid.containsKey(currentPoint)) {
                currentState = (char) grid.get(currentPoint);
            } else {
                grid.put(currentPoint, initialState);
                currentState = initialState;
            }

            for (DNA dna : DNAlist) {
                char dna_state = dna.getState();
                if (currentState == dna_state) {
                    dna.moveAnt(ant, grid);
                }
            }

        }
        //print out of the input as the customer requested.
        Point finalLocation = ant.getLocation();
        int x = finalLocation.x;
        int y = finalLocation.y;
        System.out.println("# " + x + " " + y);
    }
}
