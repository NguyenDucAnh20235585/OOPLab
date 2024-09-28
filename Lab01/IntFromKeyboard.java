import java.util.Scanner;
public class InputFromKeyboard{
    public static void main(String[] args){
        Scanner keyborad= new Scanner(System.in);

        System.out.println("What's your name?");
        String name= keyborad.nextLine();
        System.out.println("How old are you?");
        int age= keyborad.nextInt();
        System.out.println("How tall are you (m)?");
        double height= keyborad.nextDouble();

        System.out.printf("Hi Mrs/Ms. %s, %d years old. Your height is %.2f", name, age, height);
        keyborad.close();
    }
}