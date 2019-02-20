package PaymentAuthorizer;

// Robert Quinones
import Transaction.Transaction;

public class CashPaymentAuthorizer extends PaymentAuthorizer {

  @Override
  public Boolean authorizePayment(Transaction transaction, String URI) {
    if (transaction.getChange() >= 0) {
      return true;
    }

    if (transaction.getBillTotal() < 0) {
      super.addError("Invalid Bill Total");
    }

    if (transaction.getChange() < 0) {
      super.addError("Insufficient Amount Tendered");
    }

    return false;
  }
}