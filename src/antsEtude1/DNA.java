/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antsEtude1;

import java.awt.Point;

/**
 *
 * @author Prabhat
 */
public class DNA {
    private char state;
    private char north_dir;
    private char east_dir;
    private char south_dir;
    private char west_dir;
    private char north_state;
    private char east_state;
    private char south_state;
    private char west_state;
    
    public DNA(char state, char north_dir, char east_dir, char south_dir, char west_dir,
            char north_state, char east_state, char south_state, char west_state) {
        this.state = state;
        this.north_dir = north_dir;
        this.east_dir = east_dir;
        this.south_dir = south_dir;
        this.west_dir = west_dir;
        this.north_state = north_state;
        this.east_state = east_state;
        this.south_state = south_state;
        this.west_state = west_state;
    }
    
    public Grid moveAnt(Ant ant) {
        char previousDirection = ant.getPreviousDirection();
        Grid currentGrid = ant.getCurrentGrid();
        Point p = new Point(currentGrid.getP());
        int x = 0;
        int y = 0;
        switch (previousDirection) {
            case 'n' :
                p.translate(x, y);
        }
        return currentGrid;
    }
    
}
