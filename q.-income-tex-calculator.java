import java.util.*;
public class Main{
    public static void main(String[]args){
        
        Scanner sc = new Scanner(System.in);
        
        int income=sc.nextInt();
        
        if(income<=5){
            System.out.print("0% of tex: no need to pay the tex");
        }
        
        if(income>=5 && income<=10){
            System.out.print("Pay 20% tex");
            
        }else if(income>=10){
            System.out.print("pay 30% tex");
        }
        
    }
}