package Main;
/*
Sunny Wong
Catalog puts the products into the hashmap holds the item UPC and and the Item
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

//Sunny 

public class Catalog {
  //keeps track of UPC and what the Item is
  HashMap< UPC, Item > catalog = new HashMap<>();

  //each item is a String line to be parsed
  private ArrayList< String > items = new ArrayList<>();

  public Catalog( File products ) throws IOException {
    parseProducts( products );

  }

  public void parseProducts( File products ) throws IOException {

    String item;
    int itrOfItems = 0;

    FileReader readFile = new FileReader( products );
    BufferedReader lineBuffer = new BufferedReader( readFile );

    while ( ( item = lineBuffer.readLine()) != null ) { // split each product to their own line
      items.add( item );
      itrOfItems++;
    }

    readFile.close();
    lineBuffer.close();

    parseItems( items );
  }

  private void parseItems( ArrayList items ) {
    String[] product;

    // parse each line by spaces
    for ( int itrOfItems = 0; itrOfItems < items.size(); itrOfItems++ ) {

      product = items.get( itrOfItems ).toString().split( "  +" ); // splits by 2 spaces or more

      String productUPC = product[ 0 ];
      String productDescription = product[ 1 ];
      float  productPrice = Float.parseFloat( product[ 2 ] );

      UPC upc = new UPC( productUPC );
      Item item = new Item( productUPC, productDescription, productPrice );

      catalog.put( upc, item );
    }
  }

  public Item getItem( UPC upc )  {

    Item itemToReturn = new Item();

    if ( catalog.containsKey( upc ) ) {
      itemToReturn = catalog.get( upc );

    } else {
      System.out.println("Item UPC: " + upc.getUPC() + " Not Found.\n");
    }

    return itemToReturn;
  }

  public HashMap getCatalog() {
    return catalog;
  }

  public void printCatalog() {
    for (UPC keys : catalog.keySet()) {
      System.out.println(keys.getUPC() + ", "+ catalog.get(keys).getDescription() + ", " + catalog.get(keys).getPrice());
    }
  }
}

