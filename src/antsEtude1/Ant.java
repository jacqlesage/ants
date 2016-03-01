/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antsEtude1;

/**
 *
 * @author admin
 */
public class Ant {
    private Grid currentGrid;
    private char previousDirection;

    public Ant(Grid position, char previousDirection) {
        this.currentGrid = position;
        this.previousDirection = previousDirection;
    }

    public Grid getCurrentGrid() {
        return currentGrid;
    }

    public char getPreviousDirection() {
        return previousDirection;
    }

    public void setCurrentGrid(Grid position) {
        this.currentGrid = position;
    }

    public void setPreviousDirection(char previousDirection) {
        this.previousDirection = previousDirection;
    }
        
}
