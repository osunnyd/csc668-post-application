package Main;
/*
    This class runs our entire application. Helps manager initialize a store
    with a products.txt and transactions.txt passed in from the command line



*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

  Manager manager = new Manager("JohnDoe");
  //File products; -- Unsure if this should be removed?
  //File transactions;
  Store store;
  // When True Prints to Console
  static Boolean debugOn = false;

  public static void main(String[] args) {
    if ( args.length > 2 ) {
      System.out.println("Invalid Amount of Command Line Arguments. Please try again.");

    } else {
      // Files are located in src/InputFiles/ -- DELETE this comment later
      File products = new File( args[0] );
      File transactions = new File( args[1] );

      if ( debugOn ) {
        printFileContents( products );
        printFileContents( transactions );
      }

      // TODO Manager Opens Store
      // TODO Store Processes Transactions
      // TODO Manager Closes Store

      System.out.println( "\nEnd of Program" ); // DELETE LATER
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
