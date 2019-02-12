package Main;
/*
    Robert Quinones
    This class runs our entire application. Helps manager initialize a store
    with a products.txt and transactions.txt passed in from the command line
*/

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        if ( args.length > 2 ) {
            System.out.println("Invalid Amount of Command Line Arguments. Please try again.");

        } else {
          File products = new File( args[0] );
          File transactions = new File( args[1] );
          Manager manager = new Manager("John Doe");

          manager.openStore(products);
          manager.processTransactions(transactions);
          manager.closeStore();
        }
    }
}