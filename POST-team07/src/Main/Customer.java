package Main;

/*




*/

public class Customer {
  private String name;
  private String date;
  private String paymentType;
  private double amountTendered;
  private double total;
  private double change;

  public Customer(String name, String date, String paymentType, double amountTendered){
    this.name = name;
    this.date = date;
    this.paymentType = paymentType;
    this.amountTendered = amountTendered;

  }

  private void calculateChange(){
    if(paymentType.equals("CASH"))
    this.change = this.total - this.amountTendered;
  }

  public void setTotal(double total){
    this.total = total;
  }
  public String getName(){
    return this.name;
  }
  public String getDate(){
    return this.date;
  }
  public String getpPaymentType(){
    return this.paymentType;
  }
  public double getChange(){
    return this.change;
  }

}
