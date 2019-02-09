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
  File products;
  File transactions;
  Store store;


    //Constructor
  Manager(String name){
    this.name = name
  };

  //Method Open store
  public void openStore(){
  //ask console/Manager to continue or exit
  Store store = new Store();
    //create catalog
  }

  //Method Close Store
  public void closeStore(){
    //ask console/Manager to close or continue
    //true if closing
    //false if another file to be given for transactions]

    //OR

    //Give Driver signal to finish current current transactions and close store
  }

  //Method tell store to set up Catalog, (or set up catalog and give it to store)
  public void setUpCatalog(File products){  }

}
