// Lab09.java
// Name       : Joe Ingenito
// Date       : 4/15/19
// Description: Practice implementing the Comparable interface.

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Lab09
{
    static Random rnd;

    public static void main(String[] args)
    {
        rnd = new Random();

        ArrayList<RandomPenguin> penguins = new ArrayList<RandomPenguin>();
        for(int i = 0; i < 5; ++i)
        {
            penguins.add(new RandomPenguin());
        }

        System.out.println(penguins);
        Collections.sort(penguins);
        System.out.println(penguins);
    }

    public static class RandomPenguin implements Comparable<RandomPenguin>
    {
        private int _height;

        RandomPenguin()
        {
            this._height = rnd.nextInt(24) + 12;
        }

        public int getHeight()
        {
            return this._height;
        }

        public String toString()
        {
            return "RandomPenguin Height: " + this._height;
        }

        public int compareTo(RandomPenguin other)
        {
            return Integer.compare(this._height, other.getHeight());
        }
    }
}