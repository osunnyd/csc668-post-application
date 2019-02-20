package PointOfSale;

//Jarek, Tommy
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;
import java.io.*;
import Main.*;
import UserInterface.*;
import Transaction.TransactionManager;;

public class POS implements Observer {

  private PaymentListener paymentListener;
  private ProductListener productListener;
  TransactionManager transactionManager;
  private Transaction transaction;
  ArrayList<String> receipts;
  POS_GUI pos_GUI;

  public POS() {
    // testing purposes, do not use this constructor, delete before submission
    addListeners();
    this.pos_GUI = new POS_GUI(paymentListener, productListener);
    this.transaction = new Transaction();
  }

  public POS(Catalog catalog, File transactions) {
    addListeners();
    this.pos_GUI = new POS_GUI(paymentListener, productListener);
    this.transaction = new Transaction();
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

    for (int index = 0; index < receipts.size(); index++) {
      System.out.println(receipts.get(index));
      System.out.println();
    }
  }

  @Override
  public void update(Observable listener, Object object) {
      if (listener instanceof PaymentListener) {
        processPayment();

      } else if (listener instanceof ProductListener) {
        addItem();
        pos_GUI.displayItemAdded();
      }
  }

  private void addItem(){
    String upc = pos_GUI.getUPCcode();
    int quantity = pos_GUI.getQuantity().intValue();
    transaction.addPurchasedItem(new SalesLineItem(upc, quantity));
  }

  private void processPayment(){
    String name = pos_GUI.getName();
    String date = pos_GUI.getDate();
    transaction.setCustomer(new Customer(name, date ));
    transaction.setPaymentType(pos_GUI.getPaymentType());
    transaction.setAmountTendered(pos_GUI.getAmountTendered());

  }





}