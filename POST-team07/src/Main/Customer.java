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
  private String receipt  = "";
  private float billTotal = 0;
  private float change    = 0;
  private ArrayList< SalesLineItem > purchasedItems;

  public Customer ( String name, String date, String paymentType, String amountTendered,
                    ArrayList< SalesLineItem > purchasedItems ) {

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
    if ( paymentType.equals( "CASH" ) || paymentType.equals( "CHECK" ) ) {

      float calculatedChange = Float.parseFloat( this.amountTendered ) - this.billTotal;

      if ( this.billTotal <= 0  || calculatedChange < 0 ) {
        this.change = calculatedChange;

      } else {
        this.change = calculatedChange;

      }
    }
  }

  public void generateReceipt () {
    generateReceiptHeader();
    generateReceiptFooter();
  }

  private void generateReceiptHeader() {
    this.receipt += String.format( "%1$s\t%2$s\n", this.name, this.date );

    if( purchasedItems.isEmpty() ) {
      this.receipt += "<NO ITEMS>\n";

    } else {
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
    }

    this.receipt += "-----\n";
  }

  private void generateReceiptFooter() {
    this.receipt += String.format( "Total: $%1$.2f \n", this.billTotal );

    if ( this.receipt.contains( "<NO ITEMS>\n" ) ) {
      this.receipt += "No Items Purchased - Payment Rejected\n";

    } else {

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
  }

  private void generateCashPaymentFooter() {
    if ( this.change < 0 ) {
      this.receipt += String.format( "Amount Tendered: $%1$s\nPaid by Cash - Payment Rejected",
                                      this.amountTendered);

    } else {
      this.receipt += String.format( "Amount Tendered: $%1$s\nAmount Returned: $%2$.2f",
                                      this.amountTendered, this.change);

    }
  }

  private void generateNonCashPaymentFooter( int randomNumber, String paymentType ) {
    if ( randomNumber == 1 || invalidCreditCardNumber() ) {
      this.receipt += String.format( "Paid by %1$s - Payment Rejected", paymentType );

    } else {
      this.receipt += String.format( "Paid by %1$s %2$s \n", paymentType, this.amountTendered );

    }
  }

  private boolean invalidCreditCardNumber() {
    return paymentType.equals( "CREDIT" ) && this.amountTendered.length() != 5;
  }

  public String getReceipt() {
    return this.receipt;
  }
}