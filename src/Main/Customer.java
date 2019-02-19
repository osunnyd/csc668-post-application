package Main;

/*
   Robert Quinones
   Hold Customer Transaction Data, Generate Change, and Receipts
*/

public class Customer {
  private String name;
  private String date;
  private Transaction transaction;

  public Customer() {
    this.name = "";
    this.date = "";
    this.transaction = new Transaction();
  }

  public void generateReceipt() {
    this.transaction.generateReceipt(this);
  }

  public String getName() {
    return this.name;
  }

  public String getDate() {
    return this.date;
  }

  public Transaction getTransaction() {
    return this.transaction;
  }

  public String getReceipt() {
    return this.transaction.getReceipt();
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDate(String date) {
    this.date = date;
  }
}