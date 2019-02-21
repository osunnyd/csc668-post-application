package Main;

/*
Sunny Wong and Omar Alaniz
*/


import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;

import Reader.RestProductReader;
import Reader.FileProductReader;

public class Catalog {

  private HashMap<UPC, Item> catalog = new HashMap<>();
 
  private Item[] item;

  FileProductReader fileProductReader;
  RestProductReader restProductReader;

  public Catalog(String productString) throws IOException {
    fileProductReader = new FileProductReader(productString);
    restProductReader = new RestProductReader(productString);
    setUpCatalogHashMap();
  }


  public void setUpCatalogHashMap() { 
    
    /*Checkfile lets us know if we are accesing the getProductList from either
    RestProductReader or FileProductReader. It returns true if is a file or true if it is a uri
    */
    if (fileProductReader.checkFile()) {
      item = fileProductReader.getProductList();
    }

    else if (restProductReader.checkUri()) {
      item = restProductReader.getProductList();
    } else {
      System.out.println("Can not create HashMap");
    }

    
    for (int i = 0; i < item.length;i++) {
      String itemUPC = item[i].getUPC();
      UPC upc = new UPC(itemUPC);
      catalog.put(upc, item[i]);
    }
  }

  public Item getItem(UPC upc) {

    Item itemToReturn = new Item();

    if (catalog.containsKey(upc)) {
      itemToReturn = catalog.get(upc);

    } else {
      System.out.println("Item UPC: " + upc.getUPC() + " Not Found.\n");
    }

    return itemToReturn;
  }
  
  public ArrayList<UPC> getUPCs(){
    ArrayList<UPC> arraylist = new ArrayList();
    for (UPC keys : catalog.keySet()) {
      arraylist.add(keys);
      //System.out.println(keys.getUPC());
    }
    return arraylist;
  }
  /*public String[] getUPCs(){
    ArrayList<String> arraylist = new ArrayList();
    for (UPC keys : catalog.keySet()) {
      arraylist.add(keys.getUPC());
      System.out.println(keys.getUPC());
    }
    String[] array = arraylist.toArray(new String[arraylist.size()]);
    return array;
  }*/


}
