package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CenterPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public CenterPanel() {
        setPreferredSize(new Dimension(400, 800));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BorderLayout(10, 10));
        JLabel label = new JLabel("center panel");
        add(label, BorderLayout.LINE_START);
    }

}