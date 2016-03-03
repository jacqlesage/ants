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
 * @author Prabhat
 * @author Ali
 *
 * Main method for project: - Reads input from System.in: stores DNA in DNA
 * objects list, stores number of steps - Simulates the ants journey - Outputs
 * to System.out: Echoed DNA lines, ant's final location
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Scenario> scenarioList = new ArrayList<>();
        readInput(scenarioList);
        for (Scenario s : scenarioList) {
            ArrayList<DNA> dnaList = s.getDNAlist();
            Integer numSteps = s.getNumSteps();
            startAntJourney(dnaList, numSteps);
        }
    }

    /**
     * A method which reads in input and makes changes on it as per customers
     * requirements
     *
     * @param scenarioList - An Arraylist which holds the DNA objects
     * @return numSteps - the amount of lines to process
     */
    private static void readInput(ArrayList<Scenario> scenarioList) {
        Integer numSteps = 0;
        String s;
        boolean scenarioComplete;
//        try {
//            FileInputStream is = new FileInputStream(new File("C:\\Users\\admin\\Documents\\Otago uni\\COSC326\\ants\\ants\\src\\antsEtude1\\input.txt"));
//            System.setIn(is);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        Scanner in = new Scanner(System.in);

        //get the line coming in
        while (in.hasNextLine()) {
            scenarioComplete = false;
            Scenario scenario = new Scenario();
            while (!scenarioComplete) {
                s = in.nextLine();
//                System.out.println("s: " + s);
                //check if this line is a # - this should be comments so ignore
//                if (s.equals(null) && s.charAt(0) == '#') {
//                    // check if character is digit - then we are at the number of times/lines there will be
//                } else 
                if (!s.equals("") && Character.isDigit(s.charAt(0)) && s.charAt(0) != '#') {
                    numSteps = Integer.parseInt(s);
                    scenario.setNumSteps(numSteps);
                    scenarioComplete = true;

                } else if (!s.equals("") && !Character.isDigit(s.charAt(0)) && s.charAt(0) != '#') {
                    //we have to capture the input from the line and break it down for our DNA constructor   
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
                    DNA dna = new DNA(DNA_State, compassN, compassE, compassS, compassW, DNAToStateN, DNAToStateE, DNAToStateS, DNAToStateW);

                    //adds DNA object to ArrayList
                    scenario.addDNA(dna);
                }
            }
            scenarioList.add(scenario);
        }
        /*
        A test for the objects
        for (DNA e : DNAlist) {
        //System.out.println(e.toString());
        }
         */
        in.close();
    }

    /**
     * A method which in theory moves an ant around keeping track of the "Point"
     * and checking that if the ant goes back to a previously visited point,
     * what that state was, and finally the final position of the Ant
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

        grid.put(new Point(0, 0), initialState);
        Ant ant = new Ant('N', new Point(0, 0));

        for (int i = 0; i < numSteps; i++) {

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
              //test : print out each location            
//            Point location = ant.getLocation();
//            int x = location.x;
//            int y = location.y;
//            System.out.println(x + ", " + y);
        }

        //print out of the input as the customer requested.
        //echo DNA input lines
        for (DNA dna : DNAlist) {
            System.out.println(dna.toString());
        }

        //print final location : "# x y"
        Point finalLocation = ant.getLocation();
        int x = finalLocation.x;
        int y = finalLocation.y;
        System.out.println("# " + x + " " + y);
        System.out.println();
    }
}
