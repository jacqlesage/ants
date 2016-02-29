/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antsEtude1;

/**
 *
 * @author Prabhat
 */
public class DNA {
    private char state;
    private int n_dir;
    private int e_dir;
    private int s_dir;
    private int w_dir;
    private char n_state;
    private char e_state;
    private char s_state;
    private char w_state;
    
    public DNA(char state, int n_dir, int e_dir, int s_dir, int w_dir,
            char n_state, char e_state, char s_state, char w_state) {
        this.state = state;
        this.n_dir = n_dir;
        this.e_dir = e_dir;
        this.s_dir = s_dir;
        this.w_dir = w_dir;
        this.n_state = n_state;
        this.e_state = e_state;
        this.s_state = s_state;
        this.w_state = w_state;
    }
    
    public Grid moveAnt(Grid current, char prevDirection) {
        
    }
    
}
