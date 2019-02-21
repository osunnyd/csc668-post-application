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
import ProductReader.*;

public class POS implements Observer {

  private PaymentListener paymentListener;
  private ProductListener productListener;
  TransactionManager transactionManager;
  private SalesLog salesLog;
  private Transaction transaction;
  ArrayList<String> receipts;
  POS_GUI pos_GUI;
  private Catalog catalog;
  private String uri;

  // public POS(Catalog catalog){
  // //testing purposes, do not use this constructor, delete before submission
  // addListeners();
  // this.catalog = catalog;
  // this.pos_GUI = new POS_GUI(paymentListener, productListener, catalog);
  // }

  public POS(Catalog catalog, String uri) {
    addListeners();
    this.uri = uri;
    this.catalog = catalog;
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
      if (check() == true) {
        processPayment();
        pos_GUI.displayPaymentMessage(transaction.isAuthorized());
        pos_GUI.resetGUI();
      }
    } else if (listener instanceof ProductListener) {
      addItem();
      pos_GUI.displayItemAdded();
    }
  }

  private void addItem() {
    UPC upc = pos_GUI.getUPCcode();
    int quantity = pos_GUI.getQuantity().intValue();

    // add item to invoice
    Item item = catalog.getItem(upc);
    pos_GUI.itemtoInvoice(item, quantity);

    // add item to transaction
    transaction.addPurchasedItem(new SalesLineItem(upc.getUPC(), quantity));
  }

  private void processPayment() {
    String name = pos_GUI.getName();
    String date = pos_GUI.getDate();
    transaction.setCustomer(new Customer(name, date));
    transaction.setPaymentType(pos_GUI.getPaymentType());
    transaction.setAmountTendered(pos_GUI.getAmountTendered());
    TransactionManager transactionManager = new TransactionManager(transaction, uri);
    Transaction transactionResult = transactionManager.processTransaction();
  }

  private boolean check() {
    if (pos_GUI.getName().length() == 0) {
      return false;
    } else if (pos_GUI.getAmountTendered().length() == 0) {
      return false;
    } else if (Float.valueOf(pos_GUI.getAmountTendered()) < Float.valueOf(pos_GUI.getAmountDue())) {
      return false;
    } else {
      return true;
    }
    // return true;
  }

}
