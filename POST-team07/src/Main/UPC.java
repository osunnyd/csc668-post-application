package Main;

public class UPC {
  private String upc;
  // had to override to compare UPC codes correctly
  @Override
  public boolean equals(Object object) {

    if (object == this) return true;
    if (!(object instanceof UPC)) {
      return false;
    }

    UPC compare = (UPC) object;

    return compare.upc.equals(this.upc);
  }

  @Override
  public int hashCode() {
    return upc.hashCode();
  }

  // for default and loading in file into products
  public UPC() {
    this.upc = "";
  }
  
  // another constructor for UPC if needed
  public UPC( String upc) {
    this.upc = upc;
  }

  public String getUPC() {
    return this.upc;
  }

  public void setUPC( String setUPC ) {
    upc = setUPC;
  }
}
