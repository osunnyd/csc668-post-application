package Main;

/*




*/

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

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

      float currentLineSubtotal = currentItem.getPrice() * currentSalesLineItem.getQuantity();
      currentSalesLineItem.setSubtotal( currentLineSubtotal );

      updateTotal( currentLineSubtotal );

    }
  }

  public void calculateChange () {
    if ( paymentType.equals( "CASH" ) ) {

      if ( this.billTotal <= 0 ) {
        this.change = Float.parseFloat( this.amountTendered );
        this.receipt += "----- INVALID TRANSACTION -----\n";

      } else {
        this.change = Float.parseFloat( this.amountTendered ) - this.billTotal;

      }
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


      this.receipt += currentItem.getQuantity() + " x " + currentItem.getDescription() +
                      " @ $" + currentItem.getUnitPrice() + " - $" + currentItem.getSubtotal() + "\n";
    }

    this.receipt += "-----\n";
  }

  private void generateReceiptFooter( DecimalFormat twoDecimals) {
    this.receipt += "Total: $" + this.billTotal + "\n";

    if( this.paymentType.equals( "CASH" ) ) {
      generateCashPaymentFooter( twoDecimals );

    } else {
      Random randomNumberGenerator = new Random();
      int randomNumber = randomNumberGenerator.nextInt( (10 - 1) + 1 ) + 1;

      if ( this.paymentType.equals("CREDIT") ) {
        generateCreditPaymentFooter( randomNumber );

      } else {
        generateCheckPaymentFooter( randomNumber );

      }
    }
  }

  private void generateCashPaymentFooter( DecimalFormat twoDecimals ) {
    this.receipt += "Amount Tendered: $" + this.amountTendered + "\n" +
                    "Amount Returned: $" + twoDecimals.format(this.change) + "\n";
  }

  private void generateCreditPaymentFooter( int randomNumber ) {
    if ( randomNumber == 1 ) {
      this.receipt += "Paid by Credit Card - Payment Rejected";

    } else {
      this.receipt += "Paid by Credit Card " + this.amountTendered;

    }
  }

  private void generateCheckPaymentFooter( int randomNumber ) {
    if ( randomNumber == 1 ) {
      this.receipt += "Paid by Check - Payment Rejected";

    } else {
      this.receipt += "Paid by Check: $" + this.amountTendered;

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