import javax.swing.*;
import java.awt.event.*;

public class AnonymousListenerDemo extends JFrame {
  public AnonymousListenerDemo() {
    // Create four buttons
    JButton jbtNew = new JButton("New");
    JButton jbtOpen = new JButton("Open");
    JPanel panel = new JPanel();

    panel.add(jbtNew);
    panel.add(jbtOpen);
    add(panel);
       // Create and register anonymous inner class listener
    jbtNew.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        System.out.println("Process New");
      }
    });

    jbtOpen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Process Open");
      }
    });
}

  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new AnonymousListenerDemo();
    frame.setTitle("AnonymousListenerDemo");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
