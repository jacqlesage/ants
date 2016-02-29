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
    private Grid position;
    private char previousDirection;

    public Ant(Grid position, char previousDirection) {
        this.position = position;
        this.previousDirection = previousDirection;
    }

    public Grid getPosition() {
        return position;
    }

    public char getPreviousDirection() {
        return previousDirection;
    }

    public void setPosition(Grid position) {
        this.position = position;
    }

    public void setPreviousDirection(char previousDirection) {
        this.previousDirection = previousDirection;
    }
    
    
}
