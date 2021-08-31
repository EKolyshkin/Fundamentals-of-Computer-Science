/* Egor Kolyshkin, CS 211, 1/11/2021
 * Chapter 9b Assignment
 * Programming Project #2, Page 665 */

import java.awt.Color;

public class Wolf implements Animal
{
    // FIELDS
    private int dir;    // north, west, south, east
    private int steps;  // steps taken
    private int stepsTo; // steps to take
    

    // CONSTRUCTORS
    public Wolf()
    {
        setDirection();
        this.steps = 0;
        this.stepsTo = 1;
    }
    

    // ACCESSORS
    public String toString()
    {
        return "W";
    }

    public int getMove()    // takes incrementally larger number of steps in random direction
    {
        if (steps < stepsTo)  // if all steps not taken yet
        {  
            steps++;        // increase steps taken
            return dir;     // move in current direction
        }
        else            // when all steps taken
        {                   
            setDirection(); // change direction
            steps = 1;      // take a step
            stepsTo++;      // increase steps to take
            return dir;     // move in current direction
        }
    }

    public Color getColor()
    {
        return null;
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