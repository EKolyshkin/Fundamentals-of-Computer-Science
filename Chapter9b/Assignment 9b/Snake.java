/* Egor Kolyshkin, CS 211, 1/11/2021
 * Chapter 9b Assignment
 * Programming Project #2, Page 665 */

import java.awt.Color;

public class Snake implements Animal
{
    // FIELDS
    private int dir;        // direction (south, east, or west)
    private int steps;      // steps moved horizontally
    private int stepsTo;    // steps to move horizontally


    // CONSTRUCTORS
    public Snake()
    {
        this.dir = EAST;
        this.steps = 0;
        this.stepsTo = 0;
    }
    

    // ACCESSORS
    public String toString()
    {
        return "S";
    }

    public int getMove()
    {   
        if (steps < stepsTo)    // if not all steps taken yet
        {
            steps++;    // increase steps taken
            return dir; // move to current direction
        }
        else    // if all steps have been taken
        {
            steps = 0; // reset steps taken
            stepsTo++; // increment steps to take next time
            
            if (stepsTo % 2 != 0)   // if odd number of total steps
                dir = EAST;         // then move east next
            else
                dir = WEST;         // if even then west
            
            return SOUTH;       // move south
        }
    }

    public Color getColor()
    {
        return Color.magenta;   // magenta color
    }
    
}