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
  ArrayList<String> receipts;
  POS_GUI pos_GUI;

  public POS() {
    // testing purposes, do not use this constructor, delete before submission
    addListeners();
    this.pos_GUI = new POS_GUI(paymentListener, productListener);
  }

  public POS(Catalog catalog, File transactions) {
    addListeners();
    this.pos_GUI = new POS_GUI(paymentListener, productListener);
  }

  private void addListeners() {
    // TODO: add listeners for each point of interest
    this.paymentListener = new PaymentListener();
    this.paymentListener.addObserver(this);
    this.productListener = new ProductListener();
    this.productListener.addObserver(this);

  }

  public void buildReceipts() {
    receipts = transactionManager.getReceipts();

    for (int index = 0; index < receipts.size(); index++) {
      System.out.println(receipts.get(index));
      System.out.println();
    }
  }

  @Override
  public void update(Observable listener, Object object) {
    if (listener instanceof PaymentListener) {
      // 1 check if fields are valid

      // 2 YES then print then clear

      // 3 NO then do nothing, or pop up box

      System.out.println("payment event received from GUI");
      System.out.println(pos_GUI.getPaymentType());
      System.out.println(pos_GUI.getAmountTendered());
      // panel functions to get values for customer submission
      // System.out.println(pos_GUI.)
    } else if (listener instanceof ProductListener) {
      System.out.println(pos_GUI.getUPCcode());
      System.out.println(pos_GUI.getQuantity());
    }
  }

}
