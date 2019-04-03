/*
*	File	   :	Lab08.java
*	Name	   :	Joe Ingenito
*	Date	   :	4/2/2019
*	Description:	Practice with class Inheritance
*	Commands   :	javac Lab08.java
*					java Lab08
*/

import java.util.ArrayList;

public class Lab08
{
    public static void main(String[] args)
    {
        // Create an instance of each kind of computer object
        MacintoshComputer myMac = new MacintoshComputer(64);         
        WindowsComputer   myWin = new WindowsComputer(32);

        // Should print "64-bit Macintosh Computer"         
        System.out.println( myMac );         
        // Should print "32-bit Windows Computer"         
        System.out.println( myWin );         
        // Should print "true"        
        System.out.println( myWin.hasInstalled( "skype" ) );         
        // Should print "false"         
        System.out.println( myWin.hasInstalled( "facetime" ) );
    }

    public static class Computer
    {
        private int _bits;
        private ArrayList<String> programs;

        public Computer(int bits)
        {
            this._bits = bits;
            programs = new ArrayList<String>();
        }

        public int getBits()
        {
            return _bits;
        }

        public void add(String ...programs)
        {
            for(String program : programs)
            {
                this.programs.add(program);
            }
        }

        public boolean hasInstalled(String program)
        {
            return programs.contains(program.toLowerCase());
        }
    }

    public static class WindowsComputer extends Computer
    {
        public WindowsComputer(int bits)
        {
            super(bits);
            this.add("skype");
        }

        @Override
        public String toString()
        {
            return this.getBits() + "-bit Windows Computer";
        }
    }

    public static class MacintoshComputer extends Computer
    {
        public MacintoshComputer(int bits)
        {
            super(bits);
            this.add("skype", "faceTime");
        }

        @Override
        public String toString()
        {
            return this.getBits() + "-bit Macintosh Computer";
        }
    }
}