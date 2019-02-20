package Transaction;

/*
  Juan Valdez, Robert Quinones
  This class proccesses and helps authorize the transaction
*/
import PaymentAuthorizer.PaymentAuthorizer;
import Transaction.Transaction;

public class TransactionManager {

  Transaction transaction;
  String URI;

  public TransactionManager(Transaction transaction, String URI) {
    this.transaction = transaction;
    this.URI = URI;
  }

  public Transaction processTransaction() {
    this.transaction.calculateChange();
    this.transaction.setAuthorization(authorizeTransaction());
    this.transaction.generateReceipt();

    return this.transaction;
  }

  private Boolean authorizeTransaction() {
    PaymentAuthorizer paymentAuthorizer = PaymentAuthorizer.getPaymentAuthorizer(this.transaction.getPaymentType());
    return paymentAuthorizer.authorizePayment(this.transaction, this.URI);
  }
}