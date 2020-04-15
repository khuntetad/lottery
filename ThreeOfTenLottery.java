import java.util.ArrayList;
import java.util.List;

public class ThreeOfTenLottery {
    private static int ticketsSold = 0; // static because this is class-level.  We want only one of these!
    private int ticketNumber;
    public List<Integer> picks = new ArrayList<Integer>(); 
    
    public ThreeOfTenLottery() { // a Quick Pick ticket
        ticketsSold++;
        ticketNumber = ticketsSold;
        picks = new ArrayList<Integer>();
        while(picks.size() != 3) {
            int num = pickUniqueVal(); 
            if (!picks.contains(num)) {
                picks.add(num); 
            }
        }
         if (!validate()) {
            throw new java.lang.IllegalStateException("ticket invalid");
        }
    }
    
    public ThreeOfTenLottery(int[] choices) { // user's choice lotter ticket
        ticketsSold++;
        ticketNumber = ticketsSold;
        picks = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            picks.add(choices[i]);
        }
         if (!validate()) {
            throw new java.lang.IllegalStateException("ticket invalid");
        }
    }
    
    //  returns an Integer with value in rage 1-10 inclusive such that
    //    this Integers is NOT contained in the list picks.
    private int pickUniqueVal() {
        return (int)(Math.random() * 10) + 1;  
    }

     
              
    
        //returns true only if picks contains 3 unique numbers in range 1-10
    
    
    /*
    TO DO:
    - run an if statement which checks if picks
    */
    
    public boolean validate() {
        
        for (int i = 0; i < picks.size(); i++) {
            for (int j = i + 1; j < picks.size(); j++) {
                if (picks.get(i) == picks.get(j)) {
                    return false; 
                }
            }
        }
        return true; 
    }
    
    // returns true if this ticket matches winningTicket, containing the same numbers (order not important)
    public boolean grandPrizeWinner(ThreeOfTenLottery winningTicket) {
        
        for (int i = 0; i < 3; i++) {
            if (!(winningTicket.picks.contains(picks.get(i)))) {
                return false; 
            }
        }
        return true; 
    }  
      
    @Override
    public String toString() {
       
        return "3 of 10 lottery ticket #" + ticketNumber + ", picks: " + picks.toString();
        
       
    }
    public int getTicketNumber() {
        return ticketNumber;
    }
    
    
    public int get(int i) {
        picks = new ArrayList();
        return picks.get(i); 
      
    }
    
     
/*
  Let's test the 3 of 10 Lottery game!

my ticket is 3 of 10 lottery ticket #1, picks: [1, 5, 9]
The winning ticket is 3 of 10 lottery ticket #2, picks: [9, 4, 3]
Shucks......

my ticket is 3 of 10 lottery ticket #1, picks: [1, 5, 9]
The winning ticket is 3 of 10 lottery ticket #3, picks: [1, 9, 5]

I won after 2 games!!! I'm rich!!! WoooooooooHoooooooooo!!!!  
 */
}
