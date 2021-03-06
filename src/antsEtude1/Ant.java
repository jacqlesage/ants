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
 * @author Prabhat
 * @author Ali
 */
public class Ant {
    private char previousDirection;
    private Point location;

    public Ant(char previousDirection, Point location) {
        this.previousDirection = previousDirection;
        this.location = location;
    }
    
    public Point getLocation() {
        return location;
    }

    public char getPreviousDirection() {
        return previousDirection;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void setPreviousDirection(char previousDirection) {
        this.previousDirection = previousDirection;
    }

    @Override
    public String toString() {
        return "Ant{" + "previousDirection=" + previousDirection + ", location=" + location + '}';
    }
}
