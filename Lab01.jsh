/*
*  Name: Joseph Ingenito
*  Date: January 31, 2019
*  File Name:  Lab01.jsh
*  Description: Puzzles
*/

/reset

/*Question 1: Convert a to a float and subtract 5 * b */
int a = 13;
long b = 2L;

float answer1 = (float)a - (b + b + b + b + b);
System.out.println(answer1);

/*question 2: k will always be greater than j - i */
int i = 1;
int j = 2;
int k = 3;

boolean answer2 = k > (j - i);
System.out.println(answer2);

/*question 3: used y to subtract or add what is necessary and used nada to type cast the result */
int x = 4;
int y = 1;
String nada = "";

String answer3 = ((x - (y + y + y + y)) + nada) + ((x - (y + y + y + y)) + nada) + ((x + (y + y + y)) + nada);
System.out.println(answer3);

/*Question 4: divide number by mph, and minutes is number % mph*/
int mph = 60;

String s1 = " minutes is equivalent to ";
String s2 = " hours and ";
String s3 = " minutes.";

int num1 = 1000;
int hours = num1 / mph;
int minutes = 1000 % mph;

String answer4 = num1 + s1 + hours + s2 + minutes + s3;
System.out.println(answer4);

/*Question 5: assigned a boolean equal to count == 0... then assigned count accordingly*/
int count = 0;

System.out.println("The value of count is " + count);

boolean isZero = count == 0;
count = isZero ? 1 : 0;
System.out.println("The value of count is " + count);

isZero = count == 0;
count = isZero ? 1 : 0;
System.out.println("The value of count is " + count);

isZero = count == 0;
count = isZero ? 1 : 0;
System.out.println("The value of count is " + count);

isZero = count == 0;
count = isZero ? 1 : 0;
System.out.println("The value of count is " + count);
