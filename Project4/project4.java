// project4.java
// Name       : Joe Ingenito, Maxwell Toledo
// Date       : 4/30/19 - 5/9/19
// Description: Write a program to predict the diet/exercise regime for an individual based on SNP genotypes and the provided flow chart.

// javac project4.java          (to compile)
// java project4 report04.txt           (to run the code: needs a report in line next to it)

//  imports all java methods of util and io
import java.util.*;
import java.io.*;

//  the main class that this file's properties and methods fall under
public class project4
{
    //  this makes a collection of constants under the category of Results; holds the String text for each Genetic Privelidge result
    public enum Results
    {
        P12("[12%] Genetic Privilege: Any exercise works for you"), 
        P16("[16%] Genetic Privilege: Any diet works for you"), 
        P39("[39%] Genetic Disprivilege: You will lose 2.5x as much weight on a low fat diet"), 
        P45("[45%] Genetic Dispriviliege: You will lose 2.5x as much weight on a low carb diet"), 
        P88("[88%] Genetic Disprivilege: Only high intensity exercise will help you lose weight");

//  makes a string to hold the inputted result when calling this enum collection
        private String ResultString;

//  this method makes whatever String is inputted into this enum collection move itself into the actual String of Results; allows enum constants to be read
        Results(String s)
        {
            this.ResultString = s;
        }

//  this method allows the enum string constant to print out
        public String toString()
        {
            return ResultString;
        }
    }

//  this makes a collection of constants under the category of Genes; holds the String text for each gene the program has to check for
    public enum GeneLookup
    {
        gene1("rs4994"), 
        gene2("rs1042713"), 
        gene3("i6010053"),
        gene4("rs1801282"),
        gene5("rs1042714"),
        gene6("rs1801282");

//  makes a string to hold the inputted gene when calling this enum collection
        private String LookupString;

//   this method makes whatever String is inputted into this enum collection move itself into the actual String of Lookup; allows enum constants to be read
        GeneLookup(String s)
        {
            this.LookupString = s;
        }
//  this method allows the enum string constant to print out
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

//  makes a scanner that reads an inputted file on the String Array args zero'th spot
        try(Scanner sc = new Scanner(new File(args[0])))
        {
            //  allows the hashmap Genotypes to use the getHashMap's hashmap. This puts the scanners content from a hashmap into the offical Genotype one
            HashMap<String, String> genotypes = getHashMap(sc);
            //  starts the checking process of the flowchart's paths: uses the Genotype hashmap's values according to the instructions on the original flowchart and then prints out all the information that is derived from the paths and enums
            FlowChart(genotypes);
        }
        //  this statement says if the report file inputted into args[0] is not found, that there is an Error
        catch(FileNotFoundException fNfEx)
        {
            System.out.println("Error: " + fNfEx);
        }
    }

//  displays the use of the getHashMap mehtod which takes the scanner in it's parameters, which reads a report file after the "#" symbols so the scanner takes in only the data and puts it's ID and genotype in an hashmap
    private static HashMap<String, String> getHashMap(Scanner sc)
    {
        //  the first hashmap that holds the scanner values
        HashMap<String, String> h = new HashMap<String, String>();
        //  this whole loop says: if the scanner has another line to read on the file and it is not information followed by a "#" key, copy the ID and genotype into the hashmap
        while(sc.hasNext()) 
        { 
            String line = sc.nextLine();
            if(!line.contains("#"))
            {
                String[] items = line.split("\t");
                h.put(items[0], items[3]);
            }
        } 
        return h;
    }

//  creates the method used for plugging in the Genotype hashmap values and providing the series of checks; which then derives the results
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