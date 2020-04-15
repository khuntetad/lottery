// Included the rest of the code as a comment

public class MegaBucks extends Lottery {
    private static int ticketsSold; 
    private int ticketNumber;
    
    public MegaBucks() {
        super("MegaBucks", 6, 49, 1); 
        ticketsSold++;
        ticketNumber = ticketsSold; 
        
    }
    
    public MegaBucks(int[] choices) {
        super("MegaBucks", 6, 49, 1); 
        ticketsSold++;
        ticketNumber = ticketsSold; 
    }
    
      
    
    @Override
    public boolean grandPrizeWinner(Lottery winningTicket) {
        MegaBucks winningMegaTicket = (MegaBucks)(winningTicket); 
        for (int i : winningMegaTicket.getPicks())
            if (!this.getPicks().contains(i))
                return false;
        return true;
    }
    
    @Override
    public double ticketsSold() {
        return this.ticketsSold; 
    }
    @Override
    public String toString() {
        int d1 = (int) (this.ticketsSold()); 
        return "ticket number " + d1 + ", #s  " + this.getPicks().toString();
    }
    public double getMoney() {
        return 0.50 * ticketsSold; 
    }
    
    
    
   public void run(int[] nums) {
        System.out.println("Let's play MegaBucks!\n");
        //int[] myNums = {56, 34, 45, 67, 23, 20};

        MegaBucks myTicket = new MegaBucks(nums);
        int timeInWeeks = 0; 
        //LittleLotteryTicket winningTicket = new LittleLotteryTicket(myNums);  // used to test grandPrizeWinner
        int gamesPlayed = 0;
        boolean notRich = true;
        while (notRich) {
            MegaBucks winningTicket = new MegaBucks();
            gamesPlayed++;
            if (winningTicket.ticketsSold() % 10000.0 == 0 ) {
            System.out.println("my ticket is " + myTicket);
            System.out.println("The winning ticket is " + winningTicket);
            timeInWeeks++; 
            }
            else if (myTicket.grandPrizeWinner(winningTicket)) {
                System.out.println("\nI won after " + gamesPlayed + " games!!! I'm rich!!! WoooooooooHoooooooooo!!!!");
                notRich = false;
                double money = winningTicket.getMoney(); 
                System.out.println("my ticket is " + myTicket);
                System.out.println("The winning ticket is " + winningTicket);
                System.out.printf("This cost you $%.0f\n" , money);
                System.out.println("It took " + (timeInWeeks / 52) +  " years " + (timeInWeeks % 52) + " weeks for you to win"); 
            }
        }
    }

}

/*
POWERBALL:

public class PowerBall extends Lottery {
    private static int ticketsSold; 
    private int ticketNumber; 
     
    
    public PowerBall() {
        super("PowerBall", 5, 69, 1); 
        this.getPicks().add(pickUniqueVal26());
        ticketsSold++;
        ticketNumber = ticketsSold; 
        
        
    }
    
    public PowerBall(int[] choices) {
        super("PowerBall", 6, 69, choices, 1); 
        ticketsSold++;
        ticketNumber = ticketsSold; 
        if (!this.validate()) {
            throw new java.lang.IllegalStateException("ticket invalid");
        }
    }
    
      public int pickUniqueVal26() {
        int val = (int)(Math.random() * 26) + 1; 
        return val;
    }
    
    @Override
    public boolean grandPrizeWinner(Lottery winningTicket) {
        PowerBall winningPowerTicket = (PowerBall)(winningTicket); 
        for (int i : winningPowerTicket.getPicks())
            if (!this.getPicks().contains(i))
                return false;
        return true;
    }
    
    @Override
    public double ticketsSold() {
        return this.ticketsSold; 
    }
    @Override
   public String toString() {
        int d1 = (int) (this.ticketsSold()); 
        return "ticket number " + d1 + ", #s  " + this.getPicks().toString();
    }
    
    public double getMoney() {
        return 2.00 * ticketsSold; 
    }
    
    
   public void run(int[] nums) {
        System.out.println("Let's play PowerBall!\n"); 
        PowerBall myTicket = new PowerBall(nums);       
        int gamesPlayed = 0;
        boolean notRich = true;
        
        while (notRich) {
            PowerBall winningTicket = new PowerBall();
            gamesPlayed++;
            
            if (winningTicket.ticketsSold() % 10000.0 == 0 ) {
            System.out.println("my ticket is " + myTicket);
            System.out.println("The winning ticket is " + winningTicket);
            }
            else if (myTicket.grandPrizeWinner(winningTicket)) {
                System.out.println("\nI won after " + gamesPlayed + " games!!! I'm rich!!! WoooooooooHoooooooooo!!!!");
                notRich = false;
                double money = winningTicket.getMoney(); 
                System.out.printf("This cost you $ %.0f\n" , money);
            }
        }
    }

}

MEGAMILLIONS:


import java.util.ArrayList;
import java.util.List;


public class MegaMillions extends Lottery {
      private static double ticketsSold; 
      private double ticketNumber; 
    
    public MegaMillions() {
        super("Mega", 5, 70, 1); 
        ticketsSold++;
        ticketNumber = ticketsSold; 
        this.getPicks().add(pickUniqueVal25()); 
        
    }
    
    public MegaMillions(int[] choices) {
        super("Mega", 6, 70, choices, 1); 
        ticketsSold++;
        ticketNumber = ticketsSold; 
        if (!this.validate()) {
            throw new java.lang.IllegalStateException("ticket invalid");
        }
    }
   
    public int pickUniqueVal25() {
        int val = (int)(Math.random() * 25) + 1; 
        return val;
    }
    
    @Override
    public boolean grandPrizeWinner(Lottery winningTicket) {
        MegaMillions winningMegaTicket = (MegaMillions)(winningTicket); 
        for (int i : winningMegaTicket.getPicks())
            if (!this.getPicks().contains(i))
                return false;
        return true;
    }
    
    @Override
    public double ticketsSold() {
       return this.ticketsSold; 
    }
    @Override
    public String toString() {
        int d1 = (int) (this.ticketsSold()); 
        return "ticket number " + d1 + ", #s  " + this.getPicks().toString();
    }
    
    public double getMoney() {
        return 2.00 * ticketsSold; 
    }
    
    
    
    public void run(int[] nums) {
        System.out.println("MegaMillions! Let's play!\n");
        MegaMillions myTicket = new MegaMillions(nums);
        int gamesPlayed = 0;
        boolean notRich = true;
        
        while (notRich) {
            MegaMillions winningTicket = new MegaMillions();
            gamesPlayed++;
            if (winningTicket.ticketsSold() % 10000.0 == 0 ) {
            System.out.println("my ticket is " + myTicket);
            System.out.println("The winning ticket is " + winningTicket);
            }
            else if (myTicket.grandPrizeWinner(winningTicket)) {
                System.out.println("my ticket is " + myTicket);
                System.out.println("The winning ticket is " + winningTicket);
                System.out.println("\nI won after " + gamesPlayed + " games!!! I'm rich!!! WoooooooooHoooooooooo!!!!");
                notRich = false;
                double money = winningTicket.getMoney(); 
                System.out.printf("This cost you $ %.0f\n" , money);
            }
            
        }
    }

}

MAIN:


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

OUTPUT OF USER'S MEGABUCKS:

Welcome to the GimmeYourMoney Lottery Central!
You will choose which game to play from among Megabucks, Powerball, and Megamillions
You will then choose to pick your own numbers or have me generate a quick pick ticket for you.
I will play your ticket once per week until you win.  When you have won, I will tell you
how many years and weeks you played before winning the jackpot, how many games you played, 
and how much money you spent.
Note that one Megabucks ticket costs $0.50, while Powerball and Magamillions tickets each cost $2.00
Which game do you want to play? Respond with PowerBall, MegaMillions, or MegaBucks
MegaBucks
Will you pick your own numbers or do you want a quick pick ticket? Respond with numbers or quick
numbers
Please enter 6 numbers that obey MegaBucks rules (6 unique numbers between 1 and 49)
1
23
43
2
6
9

The winning ticket is ticket number 38100000, #s  [35, 1, 27, 25, 34, 17]
my ticket is ticket number 38110000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38110000, #s  [49, 17, 18, 19, 20, 13]
my ticket is ticket number 38120000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38120000, #s  [27, 49, 32, 40, 4, 1]
my ticket is ticket number 38130000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38130000, #s  [25, 18, 46, 33, 48, 34]
my ticket is ticket number 38140000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38140000, #s  [29, 11, 9, 10, 36, 23]
my ticket is ticket number 38150000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38150000, #s  [17, 47, 39, 4, 24, 31]
my ticket is ticket number 38160000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38160000, #s  [17, 31, 22, 37, 48, 18]
my ticket is ticket number 38170000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38170000, #s  [14, 24, 46, 28, 40, 18]
my ticket is ticket number 38180000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38180000, #s  [37, 42, 18, 21, 8, 49]
my ticket is ticket number 38190000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38190000, #s  [12, 14, 19, 22, 2, 38]
my ticket is ticket number 38200000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38200000, #s  [7, 1, 30, 24, 13, 32]
my ticket is ticket number 38210000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38210000, #s  [40, 47, 11, 32, 15, 1]
my ticket is ticket number 38220000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38220000, #s  [40, 1, 21, 28, 6, 23]
my ticket is ticket number 38230000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38230000, #s  [45, 3, 39, 42, 29, 11]
my ticket is ticket number 38240000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38240000, #s  [43, 11, 49, 48, 45, 18]
my ticket is ticket number 38250000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38250000, #s  [38, 24, 4, 19, 16, 21]
my ticket is ticket number 38260000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38260000, #s  [23, 49, 28, 13, 36, 1]
my ticket is ticket number 38270000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38270000, #s  [29, 39, 6, 30, 40, 48]
my ticket is ticket number 38280000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38280000, #s  [35, 15, 25, 33, 26, 21]
my ticket is ticket number 38290000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38290000, #s  [32, 29, 10, 45, 22, 20]
my ticket is ticket number 38300000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38300000, #s  [27, 10, 6, 14, 49, 20]
my ticket is ticket number 38310000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38310000, #s  [22, 7, 6, 35, 10, 9]
my ticket is ticket number 38320000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38320000, #s  [34, 19, 11, 22, 8, 6]
my ticket is ticket number 38330000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38330000, #s  [9, 13, 23, 34, 26, 35]
my ticket is ticket number 38340000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38340000, #s  [35, 25, 32, 5, 38, 31]
my ticket is ticket number 38350000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38350000, #s  [44, 26, 25, 42, 45, 12]
my ticket is ticket number 38360000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38360000, #s  [41, 27, 43, 11, 44, 16]
my ticket is ticket number 38370000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38370000, #s  [26, 21, 31, 16, 10, 5]
my ticket is ticket number 38380000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38380000, #s  [3, 17, 48, 2, 24, 4]
my ticket is ticket number 38390000, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38390000, #s  [46, 35, 47, 22, 16, 6]

I won after 38393800 games!!! I'm rich!!! WoooooooooHoooooooooo!!!!
my ticket is ticket number 38393802, #s  [42, 19, 41, 1, 35, 5]
The winning ticket is ticket number 38393802, #s  [1, 5, 35, 19, 41, 42]
This cost you $19196901
It took 73 years 43 weeks for you to win

MEGAMILLIONS QUICKPICK:

Welcome to the GimmeYourMoney Lottery Central!
You will choose which game to play from among Megabucks, Powerball, and Megamillions
You will then choose to pick your own numbers or have me generate a quick pick ticket for you.
I will play your ticket once per week until you win.  When you have won, I will tell you
how many years and weeks you played before winning the jackpot, how many games you played, 
and how much money you spent.
Note that one Megabucks ticket costs $0.50, while Powerball and Magamillions tickets each cost $2.00
Which game do you want to play? Respond with PowerBall, MegaMillions, or MegaBucks
MegaMillions
Will you pick your own numbers or do you want a quick pick ticket? Respond with numbers or quick
quick

The winning ticket is ticket number 30930000, #s  [23, 34, 32, 41, 66, 24]
my ticket is ticket number 30940000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 30940000, #s  [4, 11, 28, 41, 8, 9]
my ticket is ticket number 30950000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 30950000, #s  [70, 54, 25, 2, 46, 2]
my ticket is ticket number 30960000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 30960000, #s  [33, 70, 25, 42, 47, 19]
my ticket is ticket number 30970000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 30970000, #s  [37, 48, 12, 8, 19, 5]
my ticket is ticket number 30980000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 30980000, #s  [30, 6, 53, 58, 35, 24]
my ticket is ticket number 30990000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 30990000, #s  [17, 67, 8, 51, 4, 19]
my ticket is ticket number 31000000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31000000, #s  [65, 51, 38, 36, 5, 23]
my ticket is ticket number 31010000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31010000, #s  [12, 55, 59, 46, 57, 11]
my ticket is ticket number 31020000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31020000, #s  [14, 56, 4, 70, 11, 24]
my ticket is ticket number 31030000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31030000, #s  [18, 8, 28, 3, 65, 3]
my ticket is ticket number 31040000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31040000, #s  [10, 58, 46, 65, 4, 15]
my ticket is ticket number 31050000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31050000, #s  [59, 67, 1, 19, 5, 19]
my ticket is ticket number 31060000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31060000, #s  [23, 7, 59, 44, 15, 4]
my ticket is ticket number 31070000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31070000, #s  [21, 32, 1, 18, 50, 18]
my ticket is ticket number 31080000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31080000, #s  [16, 69, 20, 10, 17, 12]
my ticket is ticket number 31090000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31090000, #s  [12, 24, 66, 60, 47, 19]
my ticket is ticket number 31100000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31100000, #s  [2, 39, 62, 34, 58, 15]
my ticket is ticket number 31110000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31110000, #s  [13, 69, 24, 20, 40, 11]
my ticket is ticket number 31120000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31120000, #s  [58, 37, 44, 11, 19, 1]
my ticket is ticket number 31130000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31130000, #s  [3, 46, 5, 35, 59, 12]
my ticket is ticket number 31140000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31140000, #s  [70, 40, 6, 49, 19, 16]
my ticket is ticket number 31150000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31150000, #s  [42, 4, 66, 27, 34, 7]
my ticket is ticket number 31160000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31160000, #s  [69, 30, 29, 58, 64, 1]
my ticket is ticket number 31170000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31170000, #s  [60, 17, 18, 6, 53, 20]
my ticket is ticket number 31180000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31180000, #s  [47, 5, 29, 52, 59, 17]
my ticket is ticket number 31190000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31190000, #s  [26, 40, 21, 22, 24, 9]
my ticket is ticket number 31200000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31200000, #s  [29, 28, 56, 52, 50, 15]
my ticket is ticket number 31210000, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31210000, #s  [67, 65, 12, 29, 15, 16]
my ticket is ticket number 31211606, #s  [62, 64, 33, 23, 2, 6]
The winning ticket is ticket number 31211606, #s  [62, 33, 2, 64, 6, 2]

I won after 31211604 games!!! I'm rich!!! WoooooooooHoooooooooo!!!!
This cost you $ 62423212


*/
