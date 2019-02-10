package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Stock {

  /*
    Stock Hashmap holds the item UPC and and the quantity of each item
    Because in this scope of this project, the quantity is infinite aka set to 1000000
  */
  private HashMap< UPC, Integer > stock = new HashMap<>();
  private ArrayList< String > items = new ArrayList<>();

  public Stock( File filename ) throws IOException {
    parseProducts( filename );
  }

  //Parses the products text file
  private void parseProducts( File products ) throws IOException {
    String item;

    FileReader readFile = new FileReader( products );
    BufferedReader lineBuffer = new BufferedReader( readFile );

    while ( ( item = lineBuffer.readLine() ) != null) {
      items.add( item );
    }

    readFile.close();
    lineBuffer.close();
    parseItems( items ); //Parses each element (item) in the arraylist items
  }

  private void parseItems( ArrayList items ) {
    String[] product;

    for ( int iteratorOfItems = 0; iteratorOfItems < items.size(); iteratorOfItems++ ) {
      UPC upc = new UPC();
      int qty = 1000000;

      product = items.get(iteratorOfItems).toString().split("  +");

      upc.setUPC(product[0]);
      stock.put(upc, qty);
    }
  }

  public HashMap getStock() { return stock; } //Gives access to the hashmap

  //prints the stock hashmap onto the console if need be
  public void printStock() {

    for ( UPC keys : stock.keySet()) {
      System.out.println( keys.getUPC() + ", "+ stock.get( keys ) );
    }

  }
}