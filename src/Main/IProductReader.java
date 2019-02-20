package Main;
/*
   Omar Alaniz
*/
import java.net.MalformedURLException;
import java.util.ArrayList;
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

  public boolean checkFile(){
    try {
      filename = new File(productString);
    } catch (IOException e) {
      return false;
    }
    return true;
  }

  public boolean checkUri(){
    try {
      uri = new URL(productString);
    } catch (Exception e1) {
      return false;
    }
    return true;
  }

}