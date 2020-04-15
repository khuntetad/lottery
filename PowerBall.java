
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

