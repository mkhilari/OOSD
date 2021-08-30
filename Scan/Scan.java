package Scan;

import java.util.Scanner;

public class Scan {
    
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter your height: ");
        
        double height = s.nextDouble();
        String restOfLine = s.nextLine();

        System.out.println("Enter your age: ");

        int age = s.nextInt();

        System.out.println("height = " + height + 
        ", restOfLine = " + restOfLine + 
        ", age = " + age);

        s.close();
    }
}