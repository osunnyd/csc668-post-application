package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class POS_GUI extends JFrame {

    private static final long serialVersionUID = 1L;

    public POS_GUI() {
        setDefaults();
        addPanels();
        setVisible(true);
    }

    private void setDefaults() {
        setTitle("POS");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = getContentPane();
        setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));

    }

    private void addPanels() {
        TopPanel topPanel = new TopPanel();
        CenterPanel centerPanel = new CenterPanel();
        BottomPanel bottomPanel = new BottomPanel();
        add(topPanel);
        add(centerPanel);
        add(bottomPanel);

    }

}