import java.util.*;
public class Main{
    public static void main(String[]args){
        
        Scanner sc=new Scanner(System.in);
        int weeks =sc.nextInt();
        
        switch(weeks){
            case 1: System.out.println("Monday");
                    break;
            case 2: System.out.println("Tuesday");
                    break;
            case 3: System.out.println("Wednesday");
                    break;
            case 4: System.out.println("Thusday");
                    break;
            case 5: System.out.println("Friday");
                    break;
            case 6: System.out.println("Saturday");
                    break;
            case 7: System.out.println("sunday");
                    break;
            default: System.out.println("wrong input number");
        }
    }
}