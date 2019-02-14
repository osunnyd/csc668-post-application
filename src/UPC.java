package Main;

//Sunny 

public class UPC {
  private String upc;

  @Override
  public boolean equals( Object object ) {

    if ( object == this ) {
      return true;
    }

    if ( !( object instanceof UPC ) ) {
      return false;
    }

    UPC compare = ( UPC ) object;

    return compare.upc.equals( this.upc );
  }

  @Override
  public int hashCode() {
    return upc.hashCode();
  }

  public UPC() {
    this.upc = "";
  }
  
  public UPC( String upc ) {
    this.upc = upc;
  }

  public String getUPC() {
    return this.upc;
  }

  public void setUPC( String setUPC ) {
    upc = setUPC;
  }
}
