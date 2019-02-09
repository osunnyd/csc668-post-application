package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TransactionManager {
  private ArrayList<String> receipts;

  void parseTransactionFile(String fileName, HashMap catalog) throws IOException {
    FileReader fr = new FileReader(new File(fileName));
    BufferedReader br = new BufferedReader(fr);
    String line;
    while ((line = br.readline()) != null) {
      while(line != "<") {
        //add customer name only once
        //NextInt for upc
          //check catalog
        //NextInt for #items
        //Nextfloat for price
        //repeat for next item
        }
      //grab customer total
      //set customer payment Type
      //call add total amount
      //setChange
      }
    br.close();
    fr.close();
  }

}
