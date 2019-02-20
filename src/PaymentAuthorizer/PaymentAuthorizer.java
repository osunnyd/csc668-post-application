package PaymentAuthorizer;

// Robert Quinones
import java.util.HashMap;
import java.util.ArrayList;
import Transaction.Transaction;

public abstract class PaymentAuthorizer {
  public static final HashMap<String, PaymentAuthorizer> paymentAuthorizers = new HashMap<String, PaymentAuthorizer>();
  private ArrayList<String> errors;

  static {
    paymentAuthorizers.put("CASH", new CashPaymentAuthorizer());
    paymentAuthorizers.put("CREDIT", new CreditPaymentAuthorizer());
    paymentAuthorizers.put("CHECK", new CheckPaymentAuthorizer());
  }

  public static PaymentAuthorizer getPaymentAuthorizer(String paymentType) {
    return paymentAuthorizers.get(paymentType);
  }

  public static boolean containsPaymentAuthorizer(String paymentType) {
    return paymentAuthorizers.containsKey(paymentType);
  }

  public void addError(String error) {
    this.errors.add(error);
  }

  public Boolean containsErrors() {
    return !this.errors.isEmpty();
  }

  public ArrayList<String> getErrors() {
    return this.errors;
  }

  public abstract Boolean authorizePayment(Transaction transaction, String URI);

}