package Main;

//Jarek

import java.util.ArrayList;

public class POS {

  //Fields
  TransactionManager transactionManager;
  ArrayList<String> receipts;
  SalesLog saleslog;

  public POS(Catalog catalog){
    transactionManager = new transactionManager(catalog);
  }
  //Methods
  public void buildReceipts(ArrayList transactionsList){
    receipts = new ArrayList();
    //build from Trasnactions manager receipts or on you own.
  }




}
