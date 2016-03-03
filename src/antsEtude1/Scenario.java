/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antsEtude1;

import java.util.ArrayList;

/**
 *
 * @author James
 * @author Prabhat
 * @author Ali
 * 
 * Class for storing DNA sequences and number of steps
 * 
 * @params 
 * @params
 */
public class Scenario {
    private ArrayList<DNA> dnaList;
    private int numSteps;
    
    public Scenario() {
        dnaList = new ArrayList<>();
        numSteps = 0;
    }

    public void addDNA(DNA dna) {
        dnaList.add(dna);
    }

    public void setNumSteps(int numSteps) {
        this.numSteps = numSteps;
    }
    
    public ArrayList<DNA> getDNAlist() {
        return dnaList;
    }
    
    public int getNumSteps() {
        return numSteps;
    }
    
}
