package Main;

public class UPC {
  private String upc;
  // had to override to compare UPC codes correctly
  @Override
  public boolean equals(Object o) {

    if (o == this) return true;
    if (!(o instanceof UPC)) {
      return false;
    }

    UPC compare = (UPC) o;

    return compare.upc.equals(this.upc);
  }

  @Override
  public int hashCode() {
    return upc.hashCode();
  }

  public UPC()
  {
    this.upc = "";
  }
  public String getUPC()
  {
    return this.upc;
  }

  public void setUPC(String setUPC)
  {
    upc = setUPC;
  }
}