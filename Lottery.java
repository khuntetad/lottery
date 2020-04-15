import java.util.ArrayList;
import java.util.List;

/*
This class serves as the abstract superclass of the three concrete subclassers PowerballTicket, MegamillionsTicket, and MegabucksTicket
Note that the List picks will be used by MegamillionsTicket and PowerballTicket to store the primary, "white" balls of those tickets.
 */
public abstract class Lottery {
    private String name;
    private int ticketNumber;
    private List<Integer> picks;
    private int numVals;
    private int maxVal;

    //constructs a Quick Pick lotteryTicket by assigning to picks numVals unique ints in the range 1 through maxVal
    public Lottery(String name, int numVals, int maxVal, int number) {
        ticketNumber++; 
        this.name = name;
        this.maxVal = maxVal;
        this.numVals = numVals;
        picks = new ArrayList<Integer>();
        // use calls to helper pickUniqueVal() to fill the list
        for (int i = 1; i <= numVals; i++)
            picks.add(pickUniqueVal());
        // Set a unique ticketNumber based on the static counter. Be sure to increment the counter.
        if (!validate()) {
            throw new java.lang.IllegalStateException("ticket invalid");
        }
        this.ticketNumber = number; 
        

    }

    // constructs a user-created LotteryTicket, adding to picks all the client-specified numbers in parameter choices
    public Lottery(String name, int numVals, int maxVal, int[] choices, int number) {
        ticketNumber++; 
        this.name = name;
        this.maxVal = maxVal;
        this.numVals = numVals;
        picks = new ArrayList<Integer>(numVals);
        for (int i = 0; i < numVals; i++) {
            picks.add(choices[i]);
        }
        // Set a unique ticketNumber based on the static counter. Be sure to increment the counter.
        if (!validate()) {
            throw new java.lang.IllegalArgumentException("ticket invalid.");
        }
        this.ticketNumber = number;
    }

    // validates this ticket by ensuring that picks has the correct number of values, and that 
    // all values are unique and within range 1-maxVal inclusive
    public boolean validate() {
        if (picks.size() != numVals)
            return false;
        //List<Integer> picksCopy = new ArrayList(picks);
        for (int i = picks.size() - 1; i > 0; i--) {
            if (i != picks.indexOf(picks.get(i)))
                return false;
            
            if (picks.get(i) > maxVal) {
                return false; 
            }
        }
            
        return true;
    }
    
    

    // returns a value in range 1 through maxVal which is NOT currently in picks. Call this private helper multiple times
    // from the constructor to fill the list with unique values.
    private int pickUniqueVal() {
        
        int val = (int)(Math.random() * maxVal) + 1; // 1..maxVal
        while (picks.contains(val))
            val = (int)(Math.random() * maxVal) + 1;
        return val;
        
         
    }

    // returns true iff this ticket matches winningTicket, containing the same numbers (order not important)
    public boolean grandPrizeWinner(Lottery winningTicket) {
        /*
        for (int i : winningTicket.picks)
            if (!picks.contains(i))
                return false;
        return true;
        */
        for (int i = 0; i < numVals; i++) {
            if (!(winningTicket.picks.contains(picks.get(i)))) {
                return false; 
            }
        }
        return true; 
    }

    public String getName() {
        return name;
    }
    
    public String toString() {
        return "ticket number " + ticketNumber + ", #s  " + picks.toString();
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
    
    public List<Integer> getPicks() {
        return picks; 
    }
    
    
    
    /*
        Let's force the subclasses to have a public method accessing ticketsSold.
        This must be an abstract methid since we are not maintaining this variable in this superclass.
    */
    public abstract double  ticketsSold();
}

/*
// toArray() can return Integer array but not int array 
Integer[] integers = numbers.toArray(new Integer[numbers.size()]); 
// ArrayUtils of Apache Commons can change an Object array to primitive array 
int[] primitives = ArrayUtils.toPrimitive(integers);


*/
