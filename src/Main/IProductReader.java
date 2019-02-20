package Main;
/*
   Omar Alaniz
*/
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.net.URL;


public abstract class IProductReader{
  String productString;

  public IProductReader(String productString) {
    this.productString = productString;
}


  public abstract Object getProductList();
  public abstract void read(String productString) throws IOException;
  
  public int check(){
    URL uri;
    File filename;

    int flag = 0;

    try {
      uri = new URL(productString);
    } catch (Exception e1) {
      System.out.println(e1);
      return flag = flag - 1;
    }

    /*try {
      filename = new File(productString);
    } catch (IOException e) {
      System.out.println(e);
      return flag = flag + 1;
    }*/
    return flag;
  }


//   public abstract Item[] restParse(String productString);
//   public abstract ArrayList<Item> fileParse(String productString);
}