import java.util.Scanner;
public class DaysOfMonth {
    public static void main(String[] args){
        Scanner enter= new Scanner(System.in);
        int monthInt= 0;

        while(true){
            System.out.print("Enter month:");
            String month= enter.nextLine();
            switch(month){
                case "January":
                case "Jan.":
                case "Jan":
                case "1":
                    monthInt= 1;

                case "February":
                case "Feb.":
                case "Feb":
                case "2":
                    monthInt= 2;
                    break;

                case "March":
                case "Mar.":
                case "Mar":
                case "3":
                    monthInt= 3;
                    break;
                
                case "April":
                case "Apr.":
                case "Apr":
                case "4":
                    monthInt= 4;
                    break;
                    
                case "May":
                case "May.":
                case "5":
                    monthInt= 5;
                    break;
                    
                case "June":
                case "Jun.":
                case "Jun":
                case "6":
                    monthInt= 6;
                    break;
                    
                case "July":
                case "Jul.":
                case "Jul":
                case "7":
                    monthInt= 7;
                    break;
                    
                case "August":
                case "Aug.":
                case "Aug":
                case "8":
                    monthInt= 8;
                    break;
                    
                case "September":
                case "Sep.":
                case "Sep":
                case "9":
                    monthInt= 9;
                    break;
                    
                case "Octorber":
                case "Oct.":
                case "Oct":
                case "10":
                    monthInt= 10;
                    break;
                    
                case "November":
                case "Nov.":
                case "Nov":
                case "11":
                    monthInt= 11;
                    break;

                case "December":
                case "Dec.":
                case "Dec":
                case "12":
                    monthInt= 12;
                    break;
            }
            if(monthInt>=1 && monthInt<=12){
                break;
            }
            else{
                System.out.println("Invalid month. Try again!");
            }
        }
        int yearInt=0;
        while(true){
            System.out.print("Enter year:");
            int year= enter.nextInt();
            if(year>=0){
                yearInt= year;
                break;
            }
            else{
                System.out.println("Invalid year. Try again!");
            }
        }
        if(monthInt==2){
            if(yearInt%100==0){
                if(yearInt%400==0){
                    System.out.println("29 days");
                }
                else{
                    System.out.println("28 days");
                }
            }
            else if(yearInt%4==0){
                System.out.println("29 days");
            }
            else{
                System.out.println("28 days");
            }
        }
        else{
            switch(monthInt){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println("31 days");
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    System.out.println("30 days");
                    break;
            }
        }
        enter.close();
    }
}
