/* Egor Kolyshkin, CS 211, 1/11/2021
 * Chapter 9b Assignment
 * Programming Project #2, Page 665 */

import java.awt.Color;

public class Rabbit implements Animal
{
    // FIELDS
    private int dir;    // directions are north, east, or south
    private int steps;  // steps taken


    // CONSTRUCTORS
    public Rabbit()
    {
        this.dir = NORTH;    // starts by moving north
        this.steps = 0;
    }

    
    // ACCESSORS
    public String toString()
    {
        return "V";
    }

    public int getMove()
    {
        if (steps < 2)  // if 2 steps not taken
        {
            steps++;    // take a step
            return dir; // move in current direction
        }
        else
        {
            steps = 1; // reset steps and take a new one

            if (dir == NORTH)       // if north
            {
                dir = EAST;     // east is next
            }
            else if (dir == EAST)   // if east
            {
                dir = SOUTH;    // south is next
            }
            else                    // if south
            {
                dir = NORTH;    // north is next
            }

            return dir; // move in current direction
        }
    }

    public Color getColor()
    {
        return Color.LIGHT_GRAY;    // light gray color
    }
}