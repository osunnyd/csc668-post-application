package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Jarek

public class CenterPanel extends JPanel {

  private static final long serialVersionUID = 1L;
  protected JTextArea textArea;
  protected JLabel infoLabel;
  protected JLabel totalLabel;
  int totalDue;

  public CenterPanel() {
    setDefaults();
    addPanels();
  }

  public void setDefaults(){
    setPreferredSize(new Dimension(400, 800));
    setBorder(BorderFactory.createTitledBorder("Invoice"));
    setLayout(new BorderLayout(10, 10));
    //    
    infoLabel = new JLabel("Item                                                                    QTY                     UNIT_PRICE                     EXTENDED_PRICE");
    totalDue = 0;
    totalLabel = new JLabel("                                                                                                                                                TOTAL        $" + String.valueOf(totalDue));

    textArea = new JTextArea(5, 20);
    String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \n Etiam consectetur tellus ac purus tincidunt convallis. \n Nulla dapibus mi ipsum, in vulputate ante condimentum et. Curabitur vel elit nec tortor rutrum pellentesque at ut sapien. \n Vestibulum at nunc vel tortor dapibus cursus ut at felis. Nunc nisl neque, dapibus nec sapien ac, congue ultricies tortor. \n  Mauris eu lacinia mi. Vivamus \neuismod consequat scelerisque. Ut id quam accumsan, condimentum eros eget, porttitor arcu. Cras augue nunc, varius id ligula eget, cursus vestibulum sem. \n Suspendisse mollis, purus quis elementum ullamcorper, purus lorem efficitur lectus, id mollis nulla purus eu arcu. Aliquam erat volutpat. \n Donec accumsan in mi vitae mollis. Proin scelerisque urna ac tellus dapibus, vestibulum accumsan sapien \n laoreet. Phasellus risus velit, finibus id nisl tincidunt, sollicitudin placerat orci. Fusce ac tempor nunc. Quisque vel mauris condimentum, viverra lacus non, venenatis felis. \n Aenean auctor mollis neque, sed dignissim ex aliquam quis. Aliquam iaculis massa et velit ornare, id tincidunt nisl tristique. \n Nullam ultricies leo luctus dignissim placerat. Duis suscipit consectetur sem, a condimentum magna fringilla at. Quisque sit amet mi neque. Mauris vitae cursus arcu. Donec scelerisque tincidunt suscipit. Fusce vel consectetur \n augue. Phasellus hendrerit sem vel nisl suscipit finibus. Donec aliquet quam ac tristique eleifend. Cras feugiat, odio eu volutpat \n volutpat, mi odio hendrerit erat, feugiat scelerisque elit tortornon sapien. Mauris finibus fermentum risus non gravida. Phasellus turpis nisi, cursus in dignissim in, congue eu ligula. Vivamus sit amet libero eu enim eleifend vulputate. Donec sed velit tristique, \nsagittis diam ut, scelerisque sapien. Aenean auctor cursus suscipit. Pellentesque pharetra ipsum id mauris ornare elementum. \nNulla vulputate libero id mi tincidunt, rutrum elementum dolor pharetra. Etiam nec mollis ante. Mauris sed vulputate tortor. Quisque sed dignissim tellus, \n non egestas ex. Suspendisse quis tellus quis ex mollis rutrum. Mauris ac rutrum mauris, a euismod nunc. \n Suspendisse placerat ex in justo laoreet porttitor. In eu cursus mauris. \n Morbi in accumsan tortor. Sed vel libero mauris. Duis velit ex, finibus a iaculis non, iaculis quis ipsum. Vivamus vel nisi eu nisi fermentum tristique et ac metus. \n Curabitur dapibus massa lectus, at aliquet risus finibus sed. \n Curabitur at ante blandit, facilisis justo vitae, malesuada odio. \n Curabitur ullamcorper ultrices libero id auctor. Cras dapibus imperdiet facilisis. Sed posuere ligula vel ante pharetra, id scelerisque augue cursus. Nulla rutrum nibh lacus, eu pharetra lacus lacinia a. Etiam ornare enim id sollicitudin imperdiet. Ut vel magna purus. Suspendisse malesuada tincidunt dui id mollis. Pellentesque feugiat mi ipsum, vitae iaculis enim egestas vitae.";
    textArea.append(text);
    textArea.setEditable(false);
  }

  public void addPanels(){
    JScrollPane scrollPane = new JScrollPane(textArea);
    add(scrollPane, BorderLayout.CENTER);
    add(infoLabel, BorderLayout.NORTH);
    add(totalLabel, BorderLayout.PAGE_END);
  }
}