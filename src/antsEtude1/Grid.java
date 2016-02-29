/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antsEtude1;

import java.awt.Point;

/**
 *
 * @author James
 */
public class Grid {

    private Point p;
    private char state;
    
    public Grid(Point p, char s) {
        this.p = p;
        this.state = s;
        System.out.println("#");
                
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }
    
    
    
}
