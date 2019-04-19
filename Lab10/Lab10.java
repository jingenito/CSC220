// Lab10.java
// Name       : Joe Ingenito
// Date       : 4/18/19
// Description: Open file "yob2017.txt" and print all the lines of the names containing "lion".
// javac Lab10.java
// java Lab10

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab10
{
    static final String FileName = "c:/users/jinge/source/repos/csc220/lab10/yob2017.txt";

    public static void main(String[] args)
    {
        try(Scanner sc  =  new Scanner(new File(FileName)))
        {
            //read from file
            while(sc.hasNext()) 
            { 
                String line = sc.nextLine();
                String[] items = line.split(","); 

                if(items[0].toLowerCase().contains("lion"))
                {
                    System.out.println(items[0].trim());
                }
            } 
        }
        catch(FileNotFoundException fNfEx)
        {
           System.out.println("Error: " + fNfEx);
        }
    }
}