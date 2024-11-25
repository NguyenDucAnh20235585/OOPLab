package hust.soict.dsai.Lab_01;
import java.util.Scanner;
import java.lang.Math;

public class Ex2255{
    public static void main(String[] args){
        Scanner mynums= new Scanner(System.in);
        double num1= mynums.nextDouble();
        double num2= mynums.nextDouble();
        System.out.println(num1+num2);
        System.out.println(num1-num2);
        System.out.println(num1*num2);
        System.out.println(num1/num2);
        mynums.close();
    }
}