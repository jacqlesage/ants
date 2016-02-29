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

    public static Point p;
    public static char state;
    
    public Grid(Point p, char s) {
        this.p = p;
        this.state = s;
        
                
    }

    public static Point getP() {
        return p;
    }

    public static void setP(Point p) {
        Grid.p = p;
    }

    public static char getState() {
        return state;
    }

    public static void setState(char state) {
        Grid.state = state;
    }
    
    
    
}
