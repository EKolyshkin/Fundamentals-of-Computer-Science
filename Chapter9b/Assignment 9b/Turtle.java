/* Egor Kolyshkin, CS 211, 1/11/2021
 * Chapter 9b Assignment
 * Programming Project #2, Page 665 */

import java.awt.Color;

public class Turtle implements Animal
{
    // FIELDS
    private int dir;    // north, east, south, west
    private int steps;  // steps taken


    // CONSTRUCTORS
    public Turtle()
    {
        this.steps = 0;
        this.dir = SOUTH;    // starts by moving south
    }
    

    // ACCESSORS
    public String toString()
    {
        return "T";
    }

    public int getMove()
    {
        if (steps < 5)  // if 5 steps not taken
        {
            steps++;    // take a step
            return dir; // move in current direction
        }
        else
        {
            steps = 1; // reset steps and take a new one

            if (dir == SOUTH)       // if south
            {
                dir = WEST;     // west is next
            }
            else if (dir == WEST)   // if west
            {
                dir = NORTH;    // north is next
            }
            else if (dir == NORTH)   // if north
            {
                dir = EAST;    // east is next
            }
            else                    // if east
            {
                dir = SOUTH;    // south is next
            }

            return dir; // move in current direction
        }
    }

    public Color getColor()
    {
        return Color.CYAN;
    }
    
}