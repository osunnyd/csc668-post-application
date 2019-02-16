package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BottomPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public BottomPanel() {
        setPreferredSize(new Dimension(200, 800));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BorderLayout(10, 10));
        JLabel label = new JLabel("bottom panel");
        add(label, BorderLayout.LINE_START);

    }

}