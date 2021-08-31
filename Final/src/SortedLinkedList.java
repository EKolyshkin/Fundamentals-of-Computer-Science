/* Egor Kolyshkin
 * CS 211, 3/23/21
 * Final Exam Part B (Winter 2021)
 * SortedLinkedList Class
 */

import java.util.NoSuchElementException;

/* Class SortedLinkedList<E> for final exam day
*  from Buildingjavaprograms.com
*  copyright Bellevue College, March 2021
*  added backwards() to check list in backwards order
*  plus many changes to enforce no imports, just java.lang.*
*/
public class SortedLinkedList<E extends Comparable<E>>
{ 
	// FIELDS:
    private ListNode<E> front;  // leftmost node of the list
    private ListNode<E> back;   // rightmost node of the list
    private int size;           // current number of elements

    // post: constructs an empty list
    public SortedLinkedList()
    {
        front = new ListNode<E>(null);
        back = new ListNode<E>(null);
        clear();
    }
    
    // TOTAL HACK, just to get three data points loaded
    // Keep this poor constructor, so initial testing is possible
    // Later on we'll write a better .add method and constructor(s)
	public SortedLinkedList(E i, E j, E k)
    {
		ListNode<E> a = new ListNode<E>(i,null,null);
		ListNode<E> b = new ListNode<E>(j,null,a);
		ListNode<E> c = new ListNode<E>(k,null,b);
        front = new ListNode<E>(null,a,null);
        back = new ListNode<E>(null,null,c);
        a.right = b; a.left = front;
		b.right = c;
		front.right = a;
		back.left = c;
		c.right = back;
		size = 3;
	}
    
// ADD METHODS (CONSTRUCTORS) FOR EXAM HERE: 
	// 1. count data items
	// 2. removeDuplicates
	// 3. deleteLast with O(constant) required 
	// 4. add method, that adds into correct position
	// 5. Constructor to load in any array for initial values
    
	
	/*  1. Write a dataCount method that counts duplicates in this list.
        The dataCount method will return an int count, and accept a single
        <E> parameter of the data to count.  For example, with list {-5,
        42, 42, 668}  .dataCount(668) returns 1.  The empty list should
        return zero.
	*/
    public int countData(E data)
    {
		int c = 0;
        ListNode<E> current = front.right;
        
        while (current != back)
        {
            if (current.data.equals(data))
            {
                c++;
            }

            current = current.right;
        }

        return c;
	}
	
	/*  2. Write a removeDuplicates method that has no return and no
        parameters.  The removeDuplicates method will simply remove all
        duplicates from this list, leaving only the first occurrence of any
        duplicated <E> data in this list.  For example {-544, 42, 42, 42, 668,
        668} after .removeDuplicates() the list changes to {-544, 42, 668}. 
        An empty list simply does nothing.
    */
	public void removeDuplicates()
    {
        ListNode<E> current = front.right;
        
        while (current != back)
        {
            if (current.data.equals(current.right.data))
            {   // attach current to one over right
                current.right = current.right.right;
                current.right.left = current;
                size--;
            }
            else
            {   // move to next different node
                current = current.right;
            }
        }
	}
	
	/*  3. Write a deleteLast method that simply deletes and returns the
        last element with O(constant) complexity, meaning you need to start
        at the end of the list and avoid all loops.  For example {-544, 42,
        668} after .deleteLast() the list changes to {-544, 42}.  An
        empty list will need to throw a new NoSuchElementException.
    */
	public E deleteLast()
    {
		if (back.left == front)
        {   // if empty throw exception
            throw new NoSuchElementException();
        }
        
        E last = back.left.data;
        back.left = back.left.left;
        back.left.right = back;
        size--;

        return last;
	}
	
	/*  4. Write an add method that adds <E> data into this list at the
        correct position according to the natural order of <E> (use compareTo).
        Be careful to test add cases for the middle, first, or end of this list,
        as each has different conditions to consider.  The standard is to return
        true after a successful add is done.  For example {42, 4242} after
        .add(668) the list changes to {42, 668, 4242}.
    */
	public boolean add(E item)
    {
		ListNode<E> current = front;

        if (current.right != back)
        {
            while (current.right != back && current.right.data.compareTo(item) < 0)
            {
                // if data is less, keep moving
                current = current.right;
            }

            ListNode<E> newNode = new ListNode<E>(item);
            newNode.right = current;
            current.left.right = newNode;
            newNode.left = current.left;
            current.left = newNode;
            size++;
            return true;
        }
        else if (front.right == back)
        {   // if list is empty
            ListNode<E> newNode = new ListNode<E>(item);
            newNode.right = back;
            back.left = newNode;
            front.right = newNode;
            newNode.left = front;
            size++;
            return true;
        }
        
        return false;
	}
	
	/*  5. Write another constructor to load in any <E> array passed in as
        a constructor parameter (see code below) for initial values loaded into
        the linked list, knowing the passed array is likely not in any particular
        order. 
    */
	public SortedLinkedList(E[] array)
    {
		this(); // empty SortedLinkedList
        for (E item : array)
        {   // automatically adds in order
            add(item);
        }
	}
	

    
//-------------------------------------------------------------------------
    // Below here is provided code from textbook, modified for CS211 exam
    
    // post: returns the current number of elements in the list
    public int size()
    {
        return size;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString()
    {
        if (size == 0)
        {
            return "[]";
        }
        else
        {
            String result = "[" + front.right.data;
            ListNode<E> current = front.right.right;
            while (current != back)
            {
                result += ", " + current.data;
                current = current.right;
            }
            result += "]";
            return result;
        }
    }
    
    // post: creates a comma-separated, bracketed version of the list
    // Creation to test reverse links in order
    public String backwards()
    {
        if (size == 0)
        {
            return "[]";
        }
        else
        {
            String result = "[" + back.left.data;
            ListNode<E> current = back.left.left;
            while (current != front)
            {
                result += ", " + current.data;
                current = current.left;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(E value)
    {
        int index = 0;
        ListNode<E> current = front.right;
        while (current !=  back)
        {
            if (current.data.equals(value))
            {
                return index;
            }
            index++;
            current = current.right;
        }
        return -1;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(E value)
    {
        return indexOf(value) >= 0;
    }

    // post: list is empty
    public void clear()
    {
        front.right = back;
        back.left = front;
        size = 0;
    }

//----------------------------------------------------------------------------
    // INNER Class to provide nodes for this linked list
    // changed to right and left so list could easily adapt to reversals

    private static class ListNode<E>
    {
        public E data;         	// data stored in this node
        public ListNode<E> right;  // link to the conceptual right 
        public ListNode<E> left;  // link to the conceptual left 
        // post: constructs a node with given data and null links
        public ListNode(E data)
        {
            this(data, null, null);
        }

        // post: constructs a node with given data and given links
        public ListNode(E item, ListNode<E> first, ListNode<E> second)
        {
            data = item;
            right = first;
            left = second;
        }
    }
}