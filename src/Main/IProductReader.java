package Main;
/*
   Omar Alaniz
*/

import java.io.IOException;
import java.io.File;
import java.net.URL;


public abstract class IProductReader{
  String productString;

  public IProductReader(String productString) {
    this.productString = productString;
}


  public abstract Item[] getProductList();
  public abstract void read(String productString) throws IOException;

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