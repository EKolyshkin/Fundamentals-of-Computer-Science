import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/** 
 * CS 211
 * <p>Assignment 15a - ArrayIntStack
 * <p>A stack array of integers.   
 * @author Egor Kolyshkin
 * @version 2/22/21
 */
public class ArrayIntStack
{
    // FIELDS
    private int[] stack;     // stack of integers - bottom [1, 2, 3] top
    private int count = 0;   // number of integers in stack



    // CONSTRUCTORS

    /**
     * Zero-parameter constructor which creates a stack of size 20.
     */
    public ArrayIntStack()
    {
        this(20);       // 20 is default size
    }

    /**
     * Default constructor which creates a stack of any size.
     * Pre: parameter size >= 0
     * @param size the size of the stack. 
     */
    public ArrayIntStack(int size)
    {
        if (size < 0)   // argument check
            throw new IllegalArgumentException("Size must be at least 0: " + size);

        stack = new int[size];
    }



    
    // ACCESSORS

    /**
     * Calls the IntStackIterator class.
     * @return Instance of IntStackIterator class.
     */
    public IntStackIterator iterator()
    {
        return new IntStackIterator(this);
    }

    /**
     * Tests whether this stack is empty.
     * @return Stack empty status.
     */
    public boolean empty()
    {
        if (count <= 0)
            return true;

        return false;
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     * Pre: number of elements in stack > 0
     * @return Next item in the stack.
     */
    public int peek()
    {
        if (empty())
            throw new EmptyStackException();

        return stack[count - 1];
    }

    // helpers

    protected int size()
    {
        return stack.length;
    }

    // Returns element at index i
    protected int get(int i)
    {
        return stack[i];
    }
    


    // MUTATORS

    /**
     * Removes the object at the top of this stack.
     * Pre: number of elements in stack > 0
     * @return Removed object as a value.
     */
    public int pop()
    {
        if (empty())                // stack has to have at least 1 item
            throw new EmptyStackException();

        int pop = stack[count - 1];
        count--;             // "removes" last int by decrementing count
        return pop;
    }

    /**
     * Pushes an item onto the top of this stack.
     * Pre: number of elements in stack < maximum stack size
     * @param item object to add to end of stack.
     * @return item object added to end of stack.
     */
    public int push(int item)
    {
        if (count >= size())    // stack has to have at least 1 space
            throw new StackOverflowError();

        stack[count] = item;  // adds item at end of stack
        count++;
        return item;
    }

    

    /**
     * Iterator class to iterate over ArrayIntStack.
     * @author Egor Kolyshkin
     */
    public class IntStackIterator
    {
        private ArrayIntStack stack;    // stack to iterate over
        private int pos;                // current position within the stack
        
        /**
         * Creates an iterator for ArrayIntStack.
         * @param stack Stack which to iterate.
         */
        public IntStackIterator(ArrayIntStack stack)
        {
            this.stack = stack;
            pos = stack.count - 1; // starts at top of stack
        }
        
        /**
         * Checks whether iterator has gone over all elements.
         * @return Uniterated elements exist.
         */
        public boolean hasNext()
        {
            return pos > -1;    // (-1 = index out of bounds)
        }
        
        /**
         * Iterates over the element in the current iterator position.
         * Pre: stack has next element
         * @return Next element to be iterated over.
         */
        public Integer next()
        {
            if (!hasNext())
                throw new NoSuchElementException();

            int result = stack.get(pos);
            pos--;

            return result;
        }
    }
}
