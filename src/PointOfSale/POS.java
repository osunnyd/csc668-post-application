package PointOfSale;

//Jarek, Tommy
import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;
import Main.*;
import Customer.Customer;
import UserInterface.*;
import Transaction.*;;

public class POS implements Observer {

  private PaymentListener paymentListener;
  private ProductListener productListener;
  TransactionManager transactionManager;
  private SalesLog salesLog;
  private Transaction transaction;
  ArrayList<String> receipts;
  POS_GUI pos_GUI;

  public POS(Catalog catalog){
    //testing purposes, do not use this constructor, delete before submission
    addListeners();
    this.pos_GUI = new POS_GUI(paymentListener, productListener, catalog);
  }

  public POS(Catalog catalog, String uri) {
    addListeners();
    this.pos_GUI = new POS_GUI(paymentListener, productListener, catalog);
    this.transaction = new Transaction();
    this.salesLog = new SalesLog(uri);
  }

  private void addListeners() {
    this.paymentListener = new PaymentListener();
    this.paymentListener.addObserver(this);
    this.productListener = new ProductListener();
    this.productListener.addObserver(this);

  }

  public void buildReceipts() {
    // TODO Update this to saleslog
    // receipts = transactionManager.getReceipts();
    this.receipts = salesLog.getReceipts();
    for (int index = 0; index < this.receipts.size(); index++) {
      System.out.println(this.receipts.get(index));
      System.out.println();
    }
  }

  @Override
  public void update(Observable listener, Object object) {
      if (listener instanceof PaymentListener) {
        processPayment();
        pos_GUI.resetGUI();

      } else if (listener instanceof ProductListener) {
        addItem();
        pos_GUI.displayItemAdded();
      }
  }

  private void addItem(){
    UPC upc = pos_GUI.getUPCcode();
    int quantity = pos_GUI.getQuantity().intValue();
    transaction.addPurchasedItem(new SalesLineItem(upc.getUPC(), quantity));
  }

  private void processPayment(){
    String name = pos_GUI.getName();
    String date = pos_GUI.getDate();
    transaction.setCustomer(new Customer(name, date ));
    transaction.setPaymentType(pos_GUI.getPaymentType());
    transaction.setAmountTendered(pos_GUI.getAmountTendered());

  }

}
