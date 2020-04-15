
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main { 
   private static String nums; 
   private static Scanner console = new Scanner(System.in); 
    public static void main(String[] args) {
        System.out.println("Welcome to the GimmeYourMoney Lottery Central!");
        System.out.println("You will choose which game to play from among Megabucks, Powerball, and Megamillions");
        System.out.println("You will then choose to pick your own numbers or have me generate a quick pick ticket for you.");
        System.out.println("I will play your ticket once per week until you win.  When you have won, I will tell you");
        System.out.println("how many years and weeks you played before winning the jackpot, how many games you played, ");
        System.out.println("and how much money you spent.");
        System.out.println("Note that one Megabucks ticket costs $0.50, while Powerball and Magamillions tickets each cost $2.00");
        System.out.println("Which game do you want to play? Respond with PowerBall, MegaMillions, or MegaBucks"); 
        String lottery = console.next(); 
        System.out.println("Will you pick your own numbers or do you want a quick pick ticket? Respond with numbers or quick"); 
        nums = console.next(); 
        if (lottery.equals("PowerBall")) {
            power(); 
        }
        
        if (lottery.equals("MegaMillions")) {
            mega(); 
        }
        
        if (lottery.equals("MegaBucks")) {
            mega2(); 
        }
        
        
    }
    
    public static void power() {
        if (nums.equals("numbers")) {
           System.out.println("Please enter 6 numbers that obey PowerBall rules (first 5 numbers are unique and between 1 and 69 and last number between 1 and 26)");
           int i1 = console.nextInt(); 
           int i2 = console.nextInt(); 
           int i3 = console.nextInt(); 
           int i4 = console.nextInt(); 
           int i5 = console.nextInt(); 
           int i6 = console.nextInt(); 
           int[] input = new int[]{i1, i2, i3, i4, i5, i6}; 
           PowerBall power = new PowerBall(input); 
           power.run(input);          
        } 
        if (nums.equals("quick")) {
            PowerBall power = new PowerBall();
            int[] choices = new int[power.getPicks().size()]; 
            for (int i = 0; i < choices.length; i++) {
                choices[i] = power.getPicks().get(i); 
            }
            power.run(choices); 
        }
    }
    
    
    public static void mega() {
        if (nums.equals("numbers")) {
           System.out.println("Please enter 6 numbers that obey MegaMillions rules (first 5 numbers are unique between 1 and 70 and last number between 1 and 25)");
           int i1 = console.nextInt(); 
           int i2 = console.nextInt(); 
           int i3 = console.nextInt(); 
           int i4 = console.nextInt(); 
           int i5 = console.nextInt(); 
           int i6 = console.nextInt(); 
           int[] input = new int[]{i1, i2, i3, i4, i5, i6}; 
           MegaMillions mega = new MegaMillions(input); 
           mega.run(input);          
        }
        if (nums.equals("quick")) {
            MegaMillions mega = new MegaMillions();
            int[] choices = new int[mega.getPicks().size()]; 
            for (int i = 0; i < choices.length; i++) {
                choices[i] = mega.getPicks().get(i); 
            }
            mega.run(choices); 
        }
    }
    
    public static void mega2() {
        if (nums.equals("numbers")) {
           System.out.println("Please enter 6 numbers that obey MegaBucks rules (6 unique numbers between 1 and 49)");
           int i1 = console.nextInt(); 
           int i2 = console.nextInt(); 
           int i3 = console.nextInt(); 
           int i4 = console.nextInt(); 
           int i5 = console.nextInt(); 
           int i6 = console.nextInt(); 
           int[] input = new int[]{i1, i2, i3, i4, i5, i6}; 
           MegaBucks mega2 = new MegaBucks(input); 
           mega2.run(input);          
        }
        if (nums.equals("quick")) {
            MegaBucks mega2 = new MegaBucks();
            int[] choices = new int[mega2.getPicks().size()]; 
            for (int i = 0; i < choices.length; i++) {
                choices[i] = mega2.getPicks().get(i); 
            }
            mega2.run(choices); 
        }
    }
    
    
     
    public static int[] toIntArray(List<Integer> list){
      int[] wow = new int[list.size()];
      for(int i = 0;i < wow.length;i++)
          wow[i] = list.get(i);
       return wow;
    }
    
    
    
}

