/* Egor Kolyshkin
 * CS 211, 3/19/21
 * Chapter 18b Assignment
 * HeapPriorityQueue Class
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;
// for Iverson's CS211, Limit yourself to above imports
// these will help us maintain O(log N) run-time for this


// Implements a priority queue of comparable objects using a
// min-heap represented as an array.
public class HeapPriorityQueue<E extends Comparable<E>>
{
    private E[] elementData;    // queue represented as a balanced binary heap
    private int size;   // number of elements in array
    private Comparator<? super E> comparator;   // null by default;


    // CONSTRUCTORS:

    // Constructs an empty queue.
    @SuppressWarnings("unchecked")
    public HeapPriorityQueue()
    {
        this(10);
    }

    // Constructs a queue of length n
    @SuppressWarnings("unchecked")
    public HeapPriorityQueue(int n)
    {
        if (n < 1)
        {
            throw new IllegalArgumentException();
        }
        
        this.elementData = (E[]) new Comparable[n]; // was Object
        this.size = 0;
        this.comparator = null;
    }
    
    // Constructs a queue from Collection l
    /*  "HeapPriorityQueue(Collection) constructor loads up all the
        data from the provided Collection"
    */
    public HeapPriorityQueue(Collection<E> l)
    {
        this();
		for (E e : l)
        {
			add(e);
		}
    }

    // Constructs an empty queue with Comparator c
    /*  HeapPriorityQueue(Comparator) constructor that allows us to
        reverse into a max heap
    */
    public HeapPriorityQueue(Comparator<E> c)
    {
        this();
        this.comparator = c;
    }


    // ADD METHODS HERE for exercise solutions:
    
    // toArray() method returns an array containing the queue’s element
    // (starting from index 1, since index 0 is empty)
    public Object[] toArray()
    {
        return Arrays.copyOfRange(elementData, 1, size + 1);
    }
    
    // remove(Object) method to remove first occurrence of the provided object
    public boolean remove(E e)
    {
        boolean found = false; // have we found the object yet?
        int index = -1;
        
        // iterate over each element
        for (int i = 1; i < size; i++)
        {
            if (!found && compareAny(elementData[i], e) == 0)  // if we found the element
            {   
                    // remove the element
                elementData[i] = elementData[size]; // replace removed node with rightmost node
                index = i;
                found = true;

                    // bubble up
                if (compareAny(elementData[index], elementData[parent(index)]) < 0)
                {   // while node is smaller than parent
                    bubbleUp(index);
                }   // bubble down
                else if (compareAny(elementData[index], elementData[parent(index)]) > 0)
                {
                    bubbleDown(index);
                }
                // else we are done lmao
                elementData[size + 1] = null;
                size--;
                return true;
            }
        }

        return false;
    }
    
    // poll() is used by Oracle
    /*  The java.util.PriorityQueue.poll() method in Java is used to
    retrieve or fetch and remove the first element of the Queue or
    the element present at the head of the Queue. The peek() method
    only retrieved the element at the head but the poll() also
    removes the element along with the retrieval. It returns NULL if
    the queue is empty.
    */
    public E poll()
    {
        return remove();    // minimum value IS the first value
    }

    // clear() simply clears all the data
    public void clear()
    {
        for (int i = 1; i < size; i++)  // iterate over elements
        {
            elementData[i] = null;  // assign each to null
        }

        size = 0;   // change size to empty
    }
    
    // Adds the given element to this queue.
    public void add(E value)
    {
        // resize if necessary
        if (size + 1 >= elementData.length)
        { // O(N) issue here
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        
        // insert as new rightmost leaf
        elementData[size + 1] = value;
        bubbleUp(size + 1);
        size++;
    }
    
    // Returns true if there are no elements in this queue.
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    // Returns the minimum value in the queue without modifying the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public E peek()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }

        return elementData[1];
    }
    
    // Removes and returns the minimum value in the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public E remove()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }

        E result = peek();

        // move rightmost leaf to become new root
        elementData[1] = elementData[size];
        size--;
        
        bubbleDown(1);
        
        return result;
    }
    
    // Returns the number of elements in the queue.
    public int size()
    {
        return size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString()
    {
        String result = "[";

        if (!isEmpty())
        {
            result += elementData[1];

            for (int i = 2; i <= size; i++)
            {
                result += ", " + elementData[i];
            }
        }

        return result + "]";
    }
    
    // helpers for navigating indexes up/down the tree
    private int parent(int index)
    {
        return index / 2;
    }
    
    // returns index of left child of given index
    private int leftChild(int index)
    {
        return index * 2;
    }
    
    // returns index of right child of given index
    private int rightChild(int index) 
    {
        return index * 2 + 1;
    }
    
    // returns true if the node at the given index has a parent (is not the root)
    private boolean hasParent(int index)
    {
        return index > 1;
    }
    
    // returns true if the node at the given index has a non-empty left child
    private boolean hasLeftChild(int index)
    {
        return leftChild(index) <= size;
    }
    
    // returns true if the node at the given index has a non-empty right child
    private boolean hasRightChild(int index)
    {
        return rightChild(index) <= size;
    }
    
    // switches the values at the two given indexes of the given array
    private void swap(E[] a, int index1, int index2)
    {
        E temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }


    // HELPERS:

    // bubble up
    protected void bubbleUp(int index)
    {
        // "bubble up" toward root as necessary to fix ordering
        boolean found = false;   // have we found the proper place yet?

        while (!found && hasParent(index))
        {
            int parent = parent(index);

            if (compareAny(elementData[index], elementData[parent]) < 0)
            {
                swap(elementData, index, parent(index));
                index = parent(index);
            }
            else
            {
                found = true;  // found proper location; stop the loop
            }
        }
    }

    // bubble down (and decrease size)
    protected void bubbleDown(int i)
    {
        // "bubble down" root as necessary to fix ordering
        int index = i;
        boolean found = false;   // have we found the proper place yet?

        while (!found && hasLeftChild(index))
        {
            int left = leftChild(index);
            int right = rightChild(index);
            int child = left;

            if (hasRightChild(index) && compareAny(elementData[right], elementData[left]) < 0)
            {
                child = right;
            }
            
            if (compareAny(elementData[index], elementData[child]) > 0)
            {
                swap(elementData, index, child);
                index = child;
            }
            else
            {
                found = true;  // found proper location; stop the loop
            }
        }
    }

    // returns int for either Comparator or Comparable
    protected int compareAny(E x, E y)
    {
        if (comparator != null) // if using comparator
        {
            return comparator.compare(x, y);
        }
        else                    // if using comparable
        {
            return x.compareTo(y);
        }
    }
}
