
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

