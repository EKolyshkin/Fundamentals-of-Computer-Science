/* Egor Kolyshkin
 * CS 211, 3/3/21
 * Chapter 16 Quiz
 * LinkedList<E> class
 * isPerfectMirror(), undoMirror() methods 
 */

import java.util.*;
// Class LinkedList<E> can be used to store a list of values of type E.
// from Buildingjavaprograms.com (2015)
// modified by W.P. Iverson, Bellevue College, January 2021 
// added backwards(); to check list in backwards order

public class LinkedList<E extends Comparable<E>> implements Iterable<E>
{  
	// 2017, removed implements List due to version differences of List
    private ListNode<E> front;  // first value in the list
    private ListNode<E> back;   // last value in the list
    private int size;           // current number of elements

    // NOTE: an empty list has TWO Nodes to mark front and back
    // post: constructs an empty list
    public LinkedList()
    {
        front = new ListNode<E>(null);
        back = new ListNode<E>(null);
        clear();
    }
    
// ADD MORE METHODS HERE (like for assigned CS211 work):
    
    /*  returns true if this list is a mirror.  Use the Chapter 15
        exercise #18 definition of mirror().  For example, if this
        LinkedList contains the values ["a", "b", "c", "c", "b", "a"]
        then isPerfectMirror() returns true, while ["a", "b", "c"]
        would return false.
    */
    public boolean isPerfectMirror()
    {
        if (size < 2 || size % 2 != 0)      // less than 2 values or odd size
            return false;                   // means no mirror possible
        
        for (int i = 0; i < (size / 2); i++)    // compares first half with second
        {
            if (get(i).compareTo(get(size - 1 - i)) != 0)   // if assymmetry detected
                return false;                               // then not mirrored
        }

        return true;    // if all checks out return mirrored
    }

    /*  a void method that will undo the mirror if this list is mirrored,
        as in isPerfectMirror() returns true.   Whenever isPerfectMirror()
        is false, the undoMirror() method leaves this list unchanged..
    */
    public void undoMirror()
    {
        if (!isPerfectMirror())             // if not mirrored don't do anything
            return;
        
        ListNode<E> n = front;
        for (int i = 0; i < size / 2; i++)  // finds last node in first half
        {
            n = n.next;
        }
        
        back = n.next;                      // points back to last node
        n.next.next = null;                 // makes next node null
        size /= 2;                          // adjust size
    }

    /* Write a method called deleteBack that deletes the last value
    (the value at the back of the list) and returns the deleted value.
    If the list is empty, throw a NoSuchElementException.
    */
    public E deleteBack()
    {
        if (isEmpty())
            throw new NoSuchElementException();

        E n = nodeAt(size() - 1).data;
        remove(size() - 1);

        return n;  // returns data in last node
    }

    /* Write a method called switchPairs that switches the order of
    values in the list in a pairwise fashion. Your method should switch
    the order of the first two values, then switch the order of the next
    two, switch the order of the next two, and so on. If the list contains
    an odd number of values, the final element is not moved. For example,
    if the list initially stores [10, 25, 31, 47, 52, 68, 77], your method
    should switch the first pair (10 and 25), the second pair (31 and 47),
    and the third pair (52 and 68) to yield [25, 10, 47, 31, 68, 52, 77].
    */
    public void switchPairs()
    {
        int s = size(); // static size value

        if (s > 1)  // at least 1 pair
        {
            for (int i = 0; i < s - 1; i += 2)
            {
                E n = nodeAt(i).data;   // saves data from first node 
                remove(i);
                add(i + 1, n);          // adds new node with data from first
            }
        }
    }

    /* Write a method called stutter that doubles the size of a list by
    replacing every integer in the list with two of that integer. For
    example, suppose a variable list stores the values [1, 8, 19, 4, 17],
    after a call of list.stutter(), it should store [1, 1, 8, 8, 19, 19,
    4, 4, 17, 17].
    */
    public void stutter()
    {
        for (int i = 0; i < size(); i += 2)    // moves to next value
        {
            add(i, nodeAt(i).data); // adds new node with data from first
        }
    }

    /* Write a method called removeAll that removes all occurrences of a
    particular value. For example, if a variable list stores the values
    [3, 9, 4, 2, 3, 8, 17, 4, 3, 18], the call of list.removeAll(3); would
    change the list to store [9, 4, 2, 8, 17, 4, 18].
    */
    public void removeAll(E n)
    {
        while (contains(n))
        {
           remove(indexOf(n)); 
        }
    }


    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the value at the given index in the list
    public E get(int index) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        return current.data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + front.next.data;
            ListNode<E> current = front.next.next;
            while (current != back) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }
    
    // post: creates a comma-separated, bracketed version of the list
    // Iverson creation
    public String backwards() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + back.prev.data;
            ListNode<E> current = back.prev.prev;
            while (current != front) {
                result += ", " + current.data;
                current = current.prev;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(E value) {
        int index = 0;
        ListNode<E> current = front.next;
        while (current !=  back) {
            if (current.data.equals(value)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    // post: appends the given value to the end of the list
    public void add(E value) {
        add(size, value);
    }

    // pre: 0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent values right
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ListNode<E> current = nodeAt(index - 1);
        ListNode<E> newNode = new ListNode<E>(value, current.next, current);
        current.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    // post: appends all values in the given list to the end of this list
    public void addAll(List<E> other) {
        for (E value: other) {
            add(value);
        }
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index - 1);
        current.next = current.next.next;
        current.next.prev = current;
        size--;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the value at the given index with the given value
    public void set(int index, E value) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        current.data = value;
    }

    // post: list is empty
    public void clear() {
        front.next = back;
        back.prev = front;
        size = 0;
    }

    // post: returns an iterator for this list
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

    // pre : 0 <= index < size()
    // post: returns the node at a specific index.  Uses the fact that the list
    //       is doubly-linked to start from the front or the back, whichever
    //       is closer.
    private ListNode<E> nodeAt(int index) {
        ListNode<E> current;
        if (index < size / 2) {
            current = front;
            for (int i = 0; i < index + 1; i++) {
                current = current.next;
            }
        } else {
            current = back;
            for (int i = size; i >= index + 1; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    private static class ListNode<E> {
        public E data;         // data stored in this node
        public ListNode<E> next;  // link to next node in the list
        public ListNode<E> prev;  // link to previous node in the list

        // post: constructs a node with given data and null links
        public ListNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with given data and given links
        public ListNode(E data, ListNode<E> next, ListNode<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private class LinkedIterator implements Iterator<E> {
        private ListNode<E> current;  // location of next value to return
        private boolean removeOK;  // whether it's okay to remove now

        // post: constructs an iterator for the given list
        public LinkedIterator() {
            current = front.next;
            removeOK = false;
        }

        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return current != back;
        }

        // pre : hasNext()
        // post: returns the next element in the iteration
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = current.data;
            current = current.next;
            removeOK = true;
            return result;
        }

        // pre : next() has been called without a call on remove (i.e., at most
        //       one call per call on next)
        // post: removes the last element returned by the iterator
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            ListNode<E> prev2 = current.prev.prev;
            prev2.next = current;
            current.prev = prev2;
            size--;
            removeOK = false;
        }
    }
}