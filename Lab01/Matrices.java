import java.util.Scanner;

public class AddMatrices {
    public static void main(String[] args){
        Scanner enter= new Scanner(System.in);
        System.out.print("Enter size:");
        int row= enter.nextInt();
        int col= enter.nextInt();
        int[][] matA= new int[row][col];
        int[][] matB= new int[row][col];
        int[][] matSum= new int[row][col];

        System.out.println("Enter matA:");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matA[i][j]= enter.nextInt();
            }
        }

        System.out.println("Enter matB:");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matB[i][j]= enter.nextInt();
            }
        }
        
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matSum[i][j]=matA[i][j]+ matB[i][j];
            }
        }
        
        System.out.println("Sum of two matrices is:");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.printf("%d ", matSum[i][j]);
            }
            System.out.println("");
        }
        enter.close();
    }
}   

