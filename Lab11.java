// Lab11.java
// Name       : Joe Ingenito
// Date       : 4/29/19
// Description: Write a function that calls itslef recursively to form a triangle of ovals.
// javac -cp doodlepad.jar Lab11.java
// java -cp doodlepad.jar.; Lab11

import doodlepad.Oval;

public class Lab11
{
    private static final double diameter = 50;
    public static void main(String[] args)
    {
        stack(3, 10);
    }

    public static void stack(int n, int nbot)
    {
        if(n <= nbot)
        {
            stack(n + 1, nbot);
            for(int k = 0; k < n; k++)
            {
                double x = diameter * k;
                double y = diameter * n;
                Oval o = new Oval(x, y, diameter, diameter);
            }
        }
    }
}