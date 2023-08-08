import java.util.Scanner;
import java.lang.Math;

public class noguessgame {
    /**
     * 
     */
    public static void game(){
        Scanner sc = new Scanner(System.in);
        int ran_no = (int) (Math.random()*100);
        int K= 6;       //number of trials

        int i , guess;

        System.out.println("Choose a number between 1 to 100  Guess the number with in 5 chances.");
        System.out.println();
    
    for( i=1; i<K; i++){
        System.out.println("Guess the number:");
        guess= sc.nextInt();
        System.out.println("");

         if(ran_no == guess){
            System.out.println("Congratulations!  You guessed the number.");
        break;
            
        }
        else if(ran_no > guess && i != K - 1) {
            System.out.println("The number is greater than " + guess);
        }
        else if(ran_no< guess && i != K - 1) {
            System.out.println("The number is less than " + guess);
        }
        
        System.out.println("number of chances remain " +(5-i));
    }
    if (i == K) {
        System.out.println( "You have exhausted chnaces.");

        System.out.println("The number was " + ran_no);
    }
    

     
        
}

    public static void main(String[] args) {
         game();
        
    }
    
}

/* another way of doing the same logic */

// import java.util.Random;
// Random random = new Random();   
// Generates random integers 0 to 49  
//int x = random.nextInt(50);