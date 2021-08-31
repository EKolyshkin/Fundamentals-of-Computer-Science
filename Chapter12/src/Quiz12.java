/* Egor Kolyshkin
 * CS 211, 2/3/21
 * Chapter 12 Quiz */

public class Quiz12
{
    public static void main(String[] x324)
    {
        System.out.println(removeDupChars("bookkkkkeeper"));
        System.out.println(removeDupChars("String"));
        System.out.println(removeDupChars(""));
    }

    public static String removeDupChars(String s)
    {
        int l = s.length();
        
        if (l == 0)
        {
            return "";
        }
        if (l == 1)  // base cases for 1
        {
            return s;   // no dupes to remove
        }
        else
        {
            if (s.charAt(l - 1) == s.charAt(l - 2)) // if last two chars match
            {
                s = s.substring(0, l - 1);  // remove last char
            }
            
            String add = "";


            if (s.charAt(s.length() - 1) != s.charAt(s.length() - 2))
            {
                add = "" + s.charAt(s.length() - 1);
            }
            // continue while ignoring vetted char
            return removeDupChars(s.substring(0, s.length() - 1)) + add;
        }
    }
}
