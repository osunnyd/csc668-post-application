package Main;

/*
   Robert Quinones
   Hold Customer Transaction Data, Generate Change, and Receipts
*/

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

  private void updateTotal ( float total ) {
    this.billTotal += total;
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
    generateReceiptHeader();
    generateReceiptFooter();
  }

  private void generateReceiptHeader() {
    this.receipt += String.format( "%1$s\t%2$s\n", this.name, this.date );

    for( int index = 0; index < purchasedItems.size(); index++ ) {
      SalesLineItem currentItem = purchasedItems.get( index );

      // $s - String, $.2f - Float to 2 Decimal Points
      this.receipt += String.format( "<%1$s %2$s @ $%3$.2f - $%4$.2f>\n",
                                      currentItem.getDescription(),
                                      currentItem.getQuantity(),
                                      currentItem.getUnitPrice(),
                                      currentItem.getSubtotal()
                                    );
    }

    this.receipt += "-----\n";
  }

  private void generateReceiptFooter() {
    this.receipt += String.format( "Total: $%1$.2f \n", this.billTotal );

    if( this.paymentType.equals( "CASH" ) ) {
      generateCashPaymentFooter();

    } else {
      Random randomNumberGenerator = new Random();
      int randomNumber = randomNumberGenerator.nextInt( ( 10 - 1 ) + 1 ) + 1;

      if ( this.paymentType.equals( "CREDIT" ) ) {
        generateNonCashPaymentFooter( randomNumber, "Credit Card" );

      } else {
        generateNonCashPaymentFooter( randomNumber, "Check" );

      }
    }
  }

  private void generateCashPaymentFooter() {
    this.receipt += String.format( "Amount Tendered: $%1$.2f\nAmount Returned: $%2$.2f",
                                    this.amountTendered, this.change );

  }

  private void generateNonCashPaymentFooter( int randomNumber, String paymentType ) {
    if ( randomNumber == 1 ) {
      this.receipt += String.format( "Paid by %1$s - Payment Rejected", paymentType );

    } else {
      this.receipt += String.format( "Paid by %1$s %2$s \n", paymentType, this.amountTendered );

    }
  }

  public String getReceipt() {
    return this.receipt;
  }

}