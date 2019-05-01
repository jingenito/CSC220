// project4.java
// Name       : Joe Ingenito, Maxwell Toledo
// Date       : 4/30/19
// Description: Write a program to predict the diet/exercise regime for an individual based on SNP genotypes and the provided flow chart.
// javac project4.java
// java project4

import java.util.*;

import com.sun.net.httpserver.Authenticator.Result;

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
        gene2("rs10422713"), 
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
        }
        catch(FileNotFoundException fNfEx)
        {
            System.out.println("Error: " + fNfEx);
        }

        FlowChart(genotypes);
    }

    private static HashMap<String, String> getHashMap(Scanner sc)
    {
        HashMap<String, String> h = new HashMap<String, String>();
        while(sc.hasNext()) 
        { 
            String line = sc.nextLine();
            String[] items = line.split("\t");
            h.put(items[0], items[3]);
        } 
        return h;
    }
    
    private static void FlowChart(HashMap<String, String> genotypes)
    {
        //Check 1
        if(genotypes(GeneLookup.gene1) == "AA" || genotypes(GeneLookup.gene2) == "TT")
        {
            //Check 2
            if(genotypes(gene2) == "AA" || genotypes(gene2) == "TT")
            {

            }
            else
            {

            }
        }
        else
        {
            System.out.println(Results.P88);
        }
    }
    
}