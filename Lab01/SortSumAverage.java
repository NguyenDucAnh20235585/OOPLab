import java.util.Scanner;
import java.util.Arrays;

public class SortSumAve {
    public static void main(String[] args){
        Scanner enter= new Scanner(System.in);
        int n= enter.nextInt();
        double[] arr= new double[n];
        double sum=0;

        for(int i=0;i<n;i++){
            arr[i]= enter.nextDouble();
            sum+= arr[i];
        } 

        Arrays.sort(arr);

        System.out.print(Arrays.toString(arr));
        System.out.println("");
        System.out.printf("Sum= %.2f",sum);
        System.out.printf(" Average= %.2f", sum/n);
        
        enter.close();   
    } 
}

