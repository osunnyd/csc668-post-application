package Main;
import java.util.ArrayList;

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

    //Constructor
    Manager(String name){
        this.name = name
    };

    //Method Open store
    public void openStore(){

    }

    //Method Close Store
    public void closeStore(){

    }
    
    //Method tell store to set up Catalog, (or set up catalog and give it to store)
    public void setUpCatalog(File products){

        //read file and distinguish different products in own object/struct
        //1 product per line
        //UPC (1-4)  Text description (10-29)  Price (35 to end of line)
        //1234.....Item Description 1.......1.23

        //ArrayList<Item>
        Hashmap<String, Float> catalog = new HashMap<String, Float>();

        FileInputStream in = null;

        try {
            in = new FileInputStream(products);

            int c;
            while ((c = in.read()) != -1) {
                System.out.println("Stuff being read");
            }

        } finally {
            if (in != null) {
                in.close();
            }
        }


        //create hashmap with different products


        //Store.setCatalog() = hashmap I just made
    }

}
