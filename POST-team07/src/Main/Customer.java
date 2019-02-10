package Main;

/*




*/

import java.util.ArrayList;

public class Customer {
  private String name;
  private String date;
  private String paymentType;
  private double amountTendered;
  private double billTotal;
  private double change;
  private ArrayList< SalesLineItem > purchasedItems;

  public Customer( String name, String date, ArrayList< SalesLineItem > purchasedItems,
                   String paymentType, double amountTendered ){
    this.name = name;
    this.date = date;
    this.purchasedItems = purchasedItems;
    this.paymentType = paymentType;
    this.amountTendered = amountTendered;
    this.billTotal = 0.0;
    this.change = 0.0;
  }

  public void calculateBill( Catalog productCatalog ) {

    productCatalog.printCatalog();

    // Look through each sales like item
    for ( int index = 0; index < this.purchasedItems.size(); index++ ) {

      String productUPC = purchasedItems.get( index ).getUPC();
      System.out.println( productUPC );

      // We have a method for this I can use instead later
      Item currentItem = productCatalog.getItem( new UPC( productUPC ) );
      System.out.println(currentItem);

      // Delete later
//      System.out.println( currentItem.getUPC() + ", " + currentItem.getDescription() + ", " + currentItem.getPrice());
    }

  }

  public void calculateChange() {
    if( paymentType.equals("CASH") ) {
      this.change = this.billTotal - this.amountTendered;
    }
  }

  private void updateSalesLineItemPrice( Integer index, double price ) {
    this.purchasedItems.get( index ).setUnitPrice( price );
  }

  public void setTotal( double total ) {
    this.billTotal = total;
  }

  public String getName() {
    return this.name;
  }

  public String getDate() {
    return this.date;
  }

  public String getPaymentType() {
    return this.paymentType;
  }

  public double getAmountTendered () {
    return amountTendered;
  }

  public double getChange() {
    return this.change;
  }

}
