package Main;

//Jarek

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class POS {

  //Fields
  TransactionManager transactionManager;
  ArrayList<String> receipts;
  SalesLog saleslog;

  public POS(Catalog catalog, File transactions){
    transactionManager = new TransactionManager( transactions, catalog );
    try{
      transactionManager.parseTransactions();
    }
    catch(IOException e){

    }
  }
  //Methods
  public void buildReceipts(ArrayList transactionsList){
    receipts = new ArrayList();
    //build from Trasnactions manager receipts or on you own.
  }




}
