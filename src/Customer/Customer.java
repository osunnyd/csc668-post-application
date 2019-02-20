package Customer;
/*
   Robert Quinones
*/

public class Customer {
  private String name;
  private String date;

  public Customer(String name, String date) {
    this.name = name;
    this.date = date;
  }

  public String getName() {
    return this.name;
  }

  public String getDate() {
    return this.date;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDate(String date) {
    this.date = date;
  }
}