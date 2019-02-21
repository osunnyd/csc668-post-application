package ProductReader;
/*
   Omar Alaniz
*/

import java.io.IOException;
import java.io.File;
import java.net.URL;

/*
Sunny Wong and Omar Alaniz
*/


public abstract class IProductReader{
  String productString;

  public IProductReader(String productString) {
    this.productString = productString;
}


  public abstract Item[] getProductList();
  public abstract void read(String productString) throws IOException;

  //checks used to see which class will return
  public boolean checkFile() {
    File filename = new File(productString);
    return filename.exists();
  }

  public boolean checkUri() {
    try {
      URL uri = new URL(productString);
    } catch (Exception e1) {
      return false;
    }
    return true;
  }

}