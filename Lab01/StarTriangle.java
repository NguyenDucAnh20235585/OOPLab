import java.util.Scanner;

public class StarTriangle {
    public static void main(String[] args){
        Scanner enter= new Scanner(System.in);
        int n= enter.nextInt();
        for(int i=0;i<n;i++){
            
            for(int k=n-1; k>i; k--){
                System.out.print(" ");
            }

            for(int j=1; j<=2*i+1;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
        enter.close();
    }
}
