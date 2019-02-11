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
  Stock stock;
  Catalog catalog;

    //Constructor
  Manager(String name){
    this.name = name;
  }

  //Method Open store
  public void openStore( File products ){
    try{
      catalog = new Catalog(products);
      stock = new Stock(products);
      store = new Store(catalog, stock );

    }catch(Exception e){
    }
  }

  //Method Process Transactions

  public void processTransactions(String transactions){
    store.openStore(transactions);
//    store.processTransactions(transactions);
  }

  //Method Close Store
  public void closeStore(){
    store.closeStore();
  }

}
