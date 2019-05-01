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
    public enum Results
    {
        P12("[12%] Genetic Privilege: Any exercise works for you"), 
        P16("[16%] Genetic Privilege: Any diet works for you"), 
        P39("[39%] Genetic Disprivilege: You will lose 2.5x as much weight on a low fat diet"), 
        P45("[45%] Genetic Dispriviliege: You will lose 2.5x as much weight on a low carb diet"), 
        P88("[88%] Genetic Disprivilege: Only high intensity exercise will help you lose weight");

        private String ResultString;

        Results(String s)
        {
            this.ResultString = s;
        }

        public String toString()
        {
            return ResultString;
        }
    }

    public enum GeneLookup
    {
        gene1("rs4994"), 
        gene2("rs1042713"), 
        gene3("i6010053"),
        gene4("rs1801282"),
        gene5("rs1042714"),
        gene6("rs1801282");

        private String LookupString;

        GeneLookup(String s)
        {
            this.LookupString = s;
        }

        public String toString()
        {
            return LookupString;
        }
    }

    public static void main(String[] args)
    {
        if(args.length < 1){ return;}

        HashMap<String, String> genotypes = new HashMap<String, String>();

        try(Scanner sc = new Scanner(new File(args[0])))
        {
            genotypes = getHashMap(sc);
            FlowChart(genotypes);
        }
        catch(FileNotFoundException fNfEx)
        {
            System.out.println("Error: " + fNfEx);
        }
    }

    private static HashMap<String, String> getHashMap(Scanner sc)
    {
        HashMap<String, String> h = new HashMap<String, String>();
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

    private static void FlowChart(HashMap<String, String> genotypes)
    {
        //Check 1
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