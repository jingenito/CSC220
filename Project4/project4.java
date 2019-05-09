// project4.java
// Name       : Joe Ingenito, Maxwell Toledo
// Date       : 4/30/19 - 5/9/19
// Description: Write a program to predict the diet/exercise regime for an individual based on SNP genotypes and the provided flow chart.

// javac project4.java          (to compile)
// java project4 report04.txt           (to run the code: needs a report in line next to it)

import java.util.*;
import java.io.*;

public class project4
{
    //  created a Results enum which stores the Result String for each possible percentage of genetic privilege/disprivilege determined from the flow chart
    public enum Results
    {
        P12("[12%] Genetic Privilege: Any exercise works for you"), 
        P16("[16%] Genetic Privilege: Any diet works for you"), 
        P39("[39%] Genetic Disprivilege: You will lose 2.5x as much weight on a low fat diet"), 
        P45("[45%] Genetic Dispriviliege: You will lose 2.5x as much weight on a low carb diet"), 
        P88("[88%] Genetic Disprivilege: Only high intensity exercise will help you lose weight");

        //  string to store the result string for each output of the flow chart
        private String ResultString;

        //  Constructor method takes in the string representation as a parameter and assigns it to ResultString
        Results(String s)
        {
            this.ResultString = s;
        }

        //  Override toString method to print ResultString
        public String toString()
        {
            return ResultString;
        }
    }

    //  created a GeneLookup enum which stores the key to the hashmap (genotype RSID) for each node checkpoint in the flow chart
    public enum GeneLookup
    {
        gene1("rs4994"), 
        gene2("rs1042713"), 
        gene3("i6010053"),
        gene4("rs1801282"),
        gene5("rs1042714"),
        gene6("rs1801282");

        //  string to store the genotype RSID when calling this enum collection
        private String LookupString;

        //   Constructor takes in the string representation as a parameter and assigns the value to LookupString
        GeneLookup(String s)
        {
            this.LookupString = s;
        }
        //  Override toString method to print LookupString
        public String toString()
        {
            return LookupString;
        }
    }

    //  the main method in this class that runs when the class is called
    public static void main(String[] args)
    {
        //  if the project4 file is ran without a report file to read, then nothing will happen
        if(args.length < 1){ return;}

        //  makes a scanner that reads the file name at index 0 of args
        try(Scanner sc = new Scanner(new File(args[0])))
        {
            //  allows the hashmap Genotypes to use the getHashMap's hashmap. This puts the scanners content from a hashmap into the offical Genotype one
            HashMap<String, String> genotypes = getHashMap(sc);
            //  starts the flow chart algorithm: uses the Genotype hashmap's values according to the instructions on the original flowchart and then prints out all the information that is derived from the paths and enums
            FlowChart(genotypes);
        }
        //  this statement prints the string representation of the FileNotFoundException if caught
        catch(FileNotFoundException fNfEx)
        {
            System.out.println("Error: " + fNfEx);
        }
    }

    //  created getHashMap method which takes the scanner in it's parameters, which reads a report file after the "#" symbols so the scanner takes in only the data and puts it's ID and genotype in an hashmap
    private static HashMap<String, String> getHashMap(Scanner sc)
    {
        //  create a new hashmap that will be populated with the genotype RSID and value from the file opened by the scanner passed in
        HashMap<String, String> h = new HashMap<String, String>();
        //  if the scanner has another line to read on the file and it is not information followed by a "#" key, copy the ID and genotype into the hashmap
        while(sc.hasNext()) 
        { 
            String line = sc.nextLine();
            if(!line.startsWith("#"))
            {
                String[] items = line.split("\t");
                h.put(items[0], items[3]);
            }
        } 
        //return the populated hashmap
        return h; 
    }

    //  The algorithm followed by the flow chart can be broken into 7 nodes, 7th node being the end point of the algorithm.
    //  The ouput of the check at the nth node is independent of any node previous to n, and therefore will be the same if any number
    //  of nodes are checked previously to the nth node.
    //  Following from this property, each node is broken up into 6 different functions in order to preserve code used for each node check point,
    //  and make the code more readable and easier to debug.
    private static void FlowChart(HashMap<String, String> genotypes)
    {
        //  Check 1
        if(genotypes.get(GeneLookup.gene1.toString()).contains("AA") || genotypes.get(GeneLookup.gene1.toString()).contains("TT"))
        {
            Check2(genotypes);
        }
        else
        {
            System.out.println(Results.P88);
            Check3(genotypes);
        }
    }
    //  Check 2
    private static void Check2(HashMap<String, String> g)
    {
        if(g.get(GeneLookup.gene2.toString()).contains("AA") || g.get(GeneLookup.gene2.toString()).contains("TT"))
        {
            System.out.println(Results.P12);
            Check4(g);
        }
        else
        {
            System.out.println(Results.P88);
            Check3(g);
        }
    }
    //  Check 3
    private static void Check3(HashMap<String, String> g)
    {
        if(g.get(GeneLookup.gene3.toString()).contains("GG"))
        {
            Check4(g);
        }
        else
        {
            Check6(g);
        }
    }
    //  Check 4
    private static void Check4(HashMap<String, String> g)
    {
        if(g.get(GeneLookup.gene4.toString()).contains("CC"))
        {
            Check5(g);
        }
        else
        {
            System.out.println(Results.P39);
        }
    }
    //  Check 5
    private static void Check5(HashMap<String, String> g)
    {
        if(g.get(GeneLookup.gene5.toString()).contains("CC"))
        {
            System.out.println(Results.P16);
        }
        else
        {
            System.out.println(Results.P39);
        }
    }
    //  Check 6
    private static void Check6(HashMap<String, String> g)
    {
        if(g.get(GeneLookup.gene6.toString()).contains("CC"))
        {
            System.out.println(Results.P39);
        }
        else
        {
            System.out.println(Results.P45);
        }
    }
}