package Main;
/*
    Robert Quinones
    This class runs our entire application. Helps manager initialize a store
    with a products.txt and transactions.txt passed in from the command line
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList; // Remove later
import java.util.Date;
import java.util.Scanner;

public class Driver {

    Manager manager = new Manager("JohnDoe");
    //File products; -- Unsure if this should be removed?
    //File transactions;
    Store store;
    // When True Prints to Console
    static Boolean debugOn = true;

    public static void main(String[] args) {
        if ( args.length > 2 ) {
            System.out.println("Invalid Amount of Command Line Arguments. Please try again.");

        } else {
            // Files are located in src/InputFiles/ -- DELETE this comment later
            File products = new File( args[0] );
            File transactions = new File( args[1] );

            if ( debugOn ) { // Delete all of this before we submit
//                printFileContents( products );
//                printFileContents( transactions );

                try {
                    // Create Catalog
                    Catalog productCatalog = new Catalog( products );
                    TransactionManager transactionManager = new TransactionManager( transactions, productCatalog);
                    transactionManager.parseTransactions();
                   
                } catch ( IOException error ) {
                    System.out.print( error );
                }

                // Calculate Customer's Bill Testing
            }

            // TODO Manager Opens Store
            // TODO Store Processes Transactions
            // TODO Manager Closes Store

        }
    }


  // Debug Function - Delete later
  public static void printFileContents( File file ) {

    try( Scanner tester = new Scanner( file ) ) {

      while( tester.hasNextLine() ) {
        System.out.println( tester.nextLine() );
      }

      System.out.println();

    } catch ( FileNotFoundException e ) {
      System.out.println( e );
    }
  }
}