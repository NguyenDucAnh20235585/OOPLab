import java.util.Scanner;

public class Ex2256 {
    static void FirstDegreeEqn(){
        Scanner coefficients= new Scanner(System.in);
        double a= coefficients.nextDouble();
        double b= coefficients.nextDouble();

        //Given condition: a!=0;
        if(a!=0){
            System.out.printf("x= %.2f", -b/a);
        }
        else if(b==0){
            System.out.println("Infinite solutions");
        }
        else{
            System.out.println("No solution");
        }
        coefficients.close();
    }

    static void LinearSystem(){
        //LinearSystem will have the form: AX=B;
        Scanner coefficients= new Scanner(System.in);
        double a11= coefficients.nextDouble();
        double a12= coefficients.nextDouble();
        double b1= coefficients.nextDouble();
        double a21= coefficients.nextDouble();
        double a22= coefficients.nextDouble();
        double b2= coefficients.nextDouble();

        double detA= a11*a22- a12*a21;
        double detA1B= b1*a22 - a12*b2;
        double detA2B= a11*b2- a21*b1;
        
        if(detA!=0){
            System.out.printf("x1= %.2f", detA1B/detA);
            System.out.printf(" x2= %.2f", detA2B/detA);
        }
        else if(detA1B!=0 && detA2B!=0){
            System.out.println("No solution");
        }
        else{
            System.out.println("Infinite solutions");
        }
        coefficients.close();
    }

    static void SecondDegreeEqn(){
        Scanner coefficients= new Scanner(System.in);
        double a= coefficients.nextDouble();
        double b= coefficients.nextDouble();
        double c= coefficients.nextDouble();
        
        double delta= b*b- 4*a*c;
        if(a!=0){
            if(delta>0){
                System.out.printf("x1= %.2f x2=%.2f", (-b+Math.sqrt(delta))/(2*a), (-b-Math.sqrt(delta))/(2*a));
            }
            else if(delta==0){
                System.out.printf("x= %.2f", -b/(2*a));
            }
            else{
                System.out.println("No solution");
            }
        }
        else{
            if(b!=0){
                System.out.printf("x= %.2f", -c/b);
            }
            else if(c==0){
                System.out.println("Infinite solutions");
            }
            else{
                System.out.println("No solution");
            }
        }
        coefficients.close();
    }

    public static void main(String[] args){
        System.out.println("Choose option: \n1. FirstDegreeEqn \n2. Linear system \n3. SecondDegreeEqn");
        Scanner option= new Scanner(System.in);
        int opt= option.nextInt();
        System.out.println(opt);
        if(opt==1){
            System.out.println("Enter values a= b=");
            FirstDegreeEqn();
        }
        else if(opt==2){
            System.out.println("Enter values a11= a12= b1= \na21= a22= b2=");
            LinearSystem();
        }
        else{
            System.out.println("Enter values a= b= c=");
            SecondDegreeEqn();
        }
        option.close();
    } 
}
