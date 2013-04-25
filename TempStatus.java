import java.awt.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;

public class TempStatus extends JFrame {

    //Creating the Swing objects
    private JTextField worker = new JTextField ("You just completed the following: ");
    private JButton button = new JButton("Cancel");
    private JTextField choice = new JTextField(25);
       

    //Creating window with objects
    public TempStatus() {

        String temp = "";

        //When button is pressed, information is stored and window closes
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                dispose();
                JFrame frame = new Incident();
                //String hello = (frame.status());
            }
        });
  
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //Adding components
        add(choice);
        add(button);    
    }
  
    public static void main(String[] args) {
        setFrame(new TempStatus(), 350, 300);
    }
 
    public static void setFrame(final JFrame frame, final int width, final int height) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setTitle(frame.getClass().getSimpleName());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(30,30,width, height);
                frame.setVisible(true);
            }
        });
    }
}