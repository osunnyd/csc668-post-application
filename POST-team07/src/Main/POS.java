package Main;

//Jarek

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class POS {

  TransactionManager transactionManager;
  ArrayList<String> receipts;

  public POS( Catalog catalog, File transactions ) {

    transactionManager = new TransactionManager( transactions, catalog );

    try{
      transactionManager.parseTransactions();

    } catch( IOException error ){
      System.out.println( error );

    }
  }

  public void buildReceipts() {
    receipts = transactionManager.getReceipts();

    for ( int index = 0; index < receipts.size(); index++ ) {
      System.out.println( receipts.get( index ) );
      System.out.println();
    }
  }




}
