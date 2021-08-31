/* Egor Kolyshkin, CS 211, 1/11/2021
 * Chapter 9b Assignment
 * Programming Project #2, Page 665 */

import java.awt.Color;

public class Frog implements Animal
{
    // FIELDS
    private int dir;    // north, west, south, east
    private int steps;  // steps taken


    // CONSTRUCTORS
    public Frog()
    {
        this.setDirection();
        this.steps = 0;
    }

    
    // ACCESSORS
    public String toString()
    {
        return "F";
    }

    public int getMove()
    {
        if (steps < 3)  // if 3 steps not taken yet
        {  
            steps++;        // increase steps taken
            return dir;     // move in current direction
        }
        else            // when 3 steps taken
        {                   
            setDirection(); // change direction
            steps = 1;      // take a step
            return dir;     // move in current direction
        }
    }

    public Color getColor()
    {
        return Color.GREEN;     // green color
    }


    // SETTERS
    private void setDirection() // sets random direction
    {
        double r = Math.random();
        
        if (r < 0.25)           // picks one of four directions at random
            this.dir = NORTH;   // using random float from 0 to 1
        else if (r < 0.5)
            this.dir = SOUTH;
        else if (r < 0.75)
            this.dir = EAST;
        else
            this.dir = WEST;
    }
}
