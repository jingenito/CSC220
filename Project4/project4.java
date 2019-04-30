// project4.java
// Name       : Joe Ingenito, Maxwell Toledo
// Date       : 4/30/19
// Description: Write a program to predict the diet/exercise regime for an individual based on SNP genotypes and the provided flow chart.
// javac project4.java
// java project4

import java.util.*;
import java.io.*;

public class project4
{
    public static void main(String[] args)
    {
        if(args.length < 1){ return;}
        try(Scanner sc = new Scanner(new File(args[0])))
        {
            //read from file
            while(sc.hasNext()) 
            { 
                String line = sc.nextLine();
                
            } 
        }
        catch(FileNotFoundException fnfEx)
        {
            System.out.println("Error: " + fNfEx);
        }
    }
}