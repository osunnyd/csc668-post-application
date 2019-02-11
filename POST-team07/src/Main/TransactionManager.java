package Main;
/*
  Juan Valdez, Robert Quinones
  This class is used to read the transactions.txt and build an a list of customer transactions
  that occur throughout the stores opening time.

*/
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class TransactionManager {

  Catalog catalog;
  private ArrayList< String > receipts;
  File transactions;

  public TransactionManager( File transactions, Catalog catalog ){
    this.transactions = transactions;
    this.catalog = catalog;
    this.receipts = new ArrayList<>();
  }

  public void parseTransactions() throws IOException {
    FileReader fileReader = new FileReader( transactions );
    BufferedReader bufferedReader = new BufferedReader( fileReader );
    String line;

    while ( ( line = bufferedReader.readLine() ) != null ) {
      boolean exit = true;
      String name = line;
      String date = ( new Date() ).toString();
      ArrayList< SalesLineItem>  purchasedItems = new ArrayList<>();

      line = bufferedReader.readLine();

      while ( exit ) {
        if ( !( line.substring( 0, 1 ).equals( "<" ) ) ) {
          addItemstoCostumerArray( line, purchasedItems );

        }

        if ( ( line.substring( 0, 1 ).equals( "<" ) ) ) {
          String tenderLine[] = line.split( "\\s+" );
          String tenderType = getTenderType( tenderLine[ 0 ] );
          String tenderValue = getTenderValue( tenderLine[ 1 ] );

          processTransaction( name, date, tenderType, tenderValue, purchasedItems );

          exit = !exit;
        }

        line = bufferedReader.readLine();
      }
    }

    bufferedReader.close();
    fileReader.close();
  }

  void addItemstoCostumerArray( String line, ArrayList< SalesLineItem > purchasedItems ) {
    String itemUPCandQuantity[] = line.split( "\\s+" );
    UPC tempUpc = new UPC( itemUPCandQuantity[ 0 ] );
    Item tempItem = this.catalog.getItem( tempUpc );

    if ( ( itemUPCandQuantity.length ) == 2 && !( tempItem.getUPC() ).equals( "" ) ) {
      purchasedItems.add( new SalesLineItem( itemUPCandQuantity[ 0 ], Integer.parseInt( itemUPCandQuantity[ 1 ] ) ) );

    } else if ( itemUPCandQuantity.length == 1 && !( tempItem.getUPC() ).equals( "" ) ) {
      purchasedItems.add( new SalesLineItem( itemUPCandQuantity[ 0 ], 1 ) );

    }
  }

  String getTenderType( String tenderType ) {
    return tenderType.replace( "<", "" );
  }

  String getTenderValue( String tenderValue ) {
    String value = tenderValue.replace( "$", "" );
    return value.replace( ">", "" );
  }

  void processTransaction( String name, String date, String tenderType, String tenderValue,
                           ArrayList< SalesLineItem > purchasedItems ) {

    Customer customerTransaction = new Customer( name, date, tenderType, tenderValue, purchasedItems );

    customerTransaction.calculateBill( this.catalog );
    customerTransaction.calculateChange();
    customerTransaction.generateReceipt();

    this.receipts.add( customerTransaction.getReceipt() );
  }

  public ArrayList<String> getReceipts() {
    return this.receipts;
  }
}