package Main;
/*
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

                    // Create Arraylist & Add Items
                    ArrayList< SalesLineItem > purchasedItems = new ArrayList<>();
//                    purchasedItems.add( new SalesLineItem( "2018", 1 ) );
//                    purchasedItems.add( new SalesLineItem( "1104", 1 ) );
//                    purchasedItems.add( new SalesLineItem( "9876", 3 ) );


                    // Create Customer - Name, Date, Payment Type, Amount Tendered, Array List of S.L.Is
                    Customer customer = new Customer( "John Doe", new Date().toString(),
                      "CASH", "47.65", purchasedItems);

                    // Calculate Bill, Change, Receipt in that order
                    customer.calculateBill( productCatalog );
                    customer.calculateChange();
                    customer.generateReceipt(); // Be sure to generate first

                    // Display Invoice - getReceipt returns the string
                    System.out.println(  customer.getReceipt() );

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