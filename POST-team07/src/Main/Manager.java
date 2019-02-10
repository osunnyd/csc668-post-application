package Main;
import java.io.File;
import java.io.FileNotFoundException;
//Jarek

/*
Manager is in charge of starting initialization.
-Initialize Catalog
-Set up Posts
-Open the store
*/



public class Manager {
  String name = "";
  Store store;
  Catalog catalog;

    //Constructor
  Manager(String name){
    this.name = name;
  }

  //Method Open store
  public void openStore( File products ){
    try{
      catalog = new Catalog(products);
      store = new Store(catalog);
      store.openStore();
    }catch(Exception e){
    }
  }

  //Method Process Transactions

  public void processTransactions(File transactions){
//    store.processTransactions(transactions);
  }

  //Method Close Store
  public void closeStore(){
    store.closeStore();
  }

}
