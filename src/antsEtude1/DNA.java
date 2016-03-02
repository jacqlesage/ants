/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antsEtude1;

import java.awt.Point;
import java.util.*;

/**
 *
 * @author James
 * @author Prabhat
 * @author Ali
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
    
    public DNA(char state, 
            char north_dir, 
            char east_dir, 
            char south_dir, 
            char west_dir,
            char north_state, 
            char east_state, 
            char south_state, 
            char west_state) {
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
    
    public void moveAnt(Ant ant, HashMap grid) {
        char previousDirection = ant.getPreviousDirection();
//        System.out.println("previousDirection = " + previousDirection);
        Point originalPoint = new Point(ant.getLocation());
        Point translatePoint = new Point(originalPoint);
        switch (previousDirection) {
            case 'N' :
                translatePoint(translatePoint, north_dir);
//                System.out.println("translated point = " + translatePoint + ", new direction = " + north_dir);
                grid.put(new Point(originalPoint), north_state);
//                System.out.println("original point = " + originalPoint + ", new state = " + north_state);
                ant.setPreviousDirection(north_dir);
                break;
            case 'E' :
                translatePoint(translatePoint, east_dir);
//                System.out.println("translated point = " + translatePoint + ", new direction = " + east_dir);
                grid.put(new Point(originalPoint), east_state);
//                System.out.println("original point = " + originalPoint + ", new state = " + east_state);
                ant.setPreviousDirection(east_dir);
                break;
            case 'S' :
                translatePoint(translatePoint, south_dir);
//                System.out.println("translated point = " + translatePoint + ", new direction = " + south_dir);
                grid.put(new Point(originalPoint), south_state);
//                System.out.println("original point = " + originalPoint + ", new state = " + west_state);
                ant.setPreviousDirection(south_dir);
                break;
            case 'W' :
                translatePoint(translatePoint, west_dir);
//                System.out.println("translated point = " + translatePoint + ", new direction = " + west_dir);
                grid.put(new Point(originalPoint), west_state);
                ant.setPreviousDirection(west_dir);
                break;
        }        
        ant.setLocation(translatePoint);
    }
    
    private void translatePoint(Point p, char direction) {
        switch (direction) {
            case 'N':
                p.translate(0, 1);
                break;
            case 'E':
                p.translate(1, 0);
                break;
            case 'S':
                p.translate(0, -1);
                break;
            case 'W':
                p.translate(-1, 0);
                break;
        }
    }

    public char getState() {
        return state;
    }
    
    @Override
    public String toString() {
        return "DNA{" + "state=" + state + ", north_dir=" + north_dir + ", east_dir=" + east_dir + ", south_dir=" + south_dir + ", west_dir=" + west_dir + ", north_state=" + north_state + ", east_state=" + east_state + ", south_state=" + south_state + ", west_state=" + west_state + '}';
    }
    
}
