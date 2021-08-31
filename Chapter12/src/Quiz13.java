import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quiz13
{
    public static void main (String[] args)
    {
        int[] list = {};


        for (int i = 0; i < 100; i++)
        {
            list.add((int) Math.random());
        }

        long time1 = System.currentTimeMillis();
        System.out.println(list.toString());
        long time2 = System.currentTimeMillis();

        System.out.println();
        System.out.println("run time in ms: " + (time2-time1));
        System.out.println();

        time1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(list));
        time2 = System.currentTimeMillis();

        System.out.println();
        System.out.println("run time in ms: " + (time2-time1));
        System.out.println();

    }    
}
