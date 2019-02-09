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
    Store store;


    //Constructor
    Manager(String name){
        this.name = name;
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
    public void setUpCatalog(File products){

        //read file and distinguish different products in own object/struct
        //1 product per line
        //UPC (1-4)  Text description (10-29)  Price (35 to end of line)
        //1234.....Item Description 1.......1.23

        //ArrayList<Item> catalog
        Hashmap<String, Float> catalogHashMap = new HashMap<String, Float>();

        try (BufferedReader br = new BufferedReader(new FileReader(products))) {
            //in = new FileInputStream(products);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                //add to hashmap
                //add to arraylist
            }



        } finally {
            if (br != null) {
                br.close();
            }
        }


        //create hashmap with different products


        //Store.setCatalog() = hashmap I just made
    }

}
