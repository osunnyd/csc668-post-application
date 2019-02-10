package Main;

/*




*/

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Customer {
  private String name;
  private String date;
  private String paymentType;
  private String amountTendered;
  private String receipt = "";
  private float billTotal = 0;
  private float change = 0;
  private ArrayList<SalesLineItem> purchasedItems;

  public Customer ( String name, String date, String paymentType, String amountTendered,
                    ArrayList<SalesLineItem> purchasedItems) {

    this.name = name;
    this.date = date;
    this.paymentType = paymentType;
    this.amountTendered = amountTendered;
    this.purchasedItems = purchasedItems;
  }

  public void calculateBill ( Catalog productCatalog ) {
    for ( int index = 0; index < this.purchasedItems.size(); index++ ) {

      SalesLineItem currentSalesLineItem = purchasedItems.get( index );
      UPC productUPC = currentSalesLineItem.getUPC();

      Item currentItem = productCatalog.getItem( productUPC );
      currentSalesLineItem.setUnitPrice( currentItem.getPrice() );
      currentSalesLineItem.setDescription( currentItem.getDescription() );

      float currentLineTotal = currentItem.getPrice() * currentSalesLineItem.getQuantity();
      updateTotal( currentLineTotal );

    }
  }

  public void calculateChange () {
    if ( paymentType.equals( "CASH" ) ) {
      this.change = Float.parseFloat( this.amountTendered ) - this.billTotal;
    }
  }

  public void generateReceipt () {
    DecimalFormat twoDecimals = new DecimalFormat( "###.##" );

    generateReceiptHeader( twoDecimals );
    generateReceiptFooter( twoDecimals );
  }

  private void generateReceiptHeader( DecimalFormat twoDecimals) {
    this.receipt += this.name + "\t" + this.date + "\n";

    for( int index = 0; index < purchasedItems.size(); index++ ) {
      SalesLineItem currentItem = purchasedItems.get( index );

      this.receipt += currentItem.getDescription() +
        ": " + currentItem.getQuantity() +
        " @ $" + twoDecimals.format( currentItem.getUnitPrice() ) + "\n";
    }

    this.receipt += "-----\n";
  }

  private void generateReceiptFooter( DecimalFormat twoDecimals) {
    this.receipt += "Total: $" + this.billTotal + "\n";

    if( this.paymentType.equals( "CASH" ) ) {
      this.receipt += "Amount Tendered: $" + this.amountTendered + "\n" +
        "Amount Returned: $" + twoDecimals.format(this.change) + "\n";

    } else if ( this.paymentType.equals("CREDIT") ) {
      this.receipt += "Paid by Credit Card " + this.amountTendered;

    } else {
      this.receipt += "Paid by Check\n";

    }
  }

  public void updateTotal ( float total ) {
    this.billTotal += total;
  }

  public String getName () {
    return this.name;
  }

  public String getDate () {
    return this.date;
  }

  public String getPaymentType () {
    return this.paymentType;
  }

  public String getAmountTendered () {
    return amountTendered;
  }

  public String getReceipt() {
    return this.receipt;
  }

  public float getChange () {
    return this.change;
  }

}