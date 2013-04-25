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

public class OwnerSalary extends JFrame {
    //Creating the options of owners to pick from
    private String[] owners = { 
        "Reece Witherspoon",
        "Forrest Gump",
        "Harrison Ford",
        "Anakin Skywalker"
    };

    //Creating the Swing objects
    private JTextField salaryTitle = new JTextField ("Salary to change to : ");
    private JTextField ownerName = new JTextField ("Owner's name to change : ");
    private JButton button = new JButton("Enter Choice");
    private SpinnerModel ownerSalary = new SpinnerNumberModel(0,0,999999999,1);
    private JSpinner spinner = new JSpinner(ownerSalary);
    private JTextField choice = new JTextField(25);
    private JComboBox comboBox = new JComboBox();
    private String str = "";
       

    //Creating window with objects
    public OwnerSalary() {
        //Putting in list of owners
        for(int i = 0; i < owners.length; i++)
            comboBox.addItem(owners[i]);
    
        //Putting the values selected in combo box into the string
        comboBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                str = ("Changing " 
                                + (((JComboBox)e.getSource()).getSelectedItem()) 
                                + "'s salary to: ");
            }
        });

        //Collecting data from the text box
        spinner.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent e ) {
                JSpinner spinner = ( JSpinner ) e.getSource();
                SpinnerModel ownerSalary = spinner.getModel();
                str += (ownerSalary.getValue());
                choice.setText(str);
                System.out.println(ownerSalary.getValue());
            }
        } );

        //When button is pressed, information is stored and window closes
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                dispose();
                System.out.println(str);
                setFrame(new ZooWindow(), 325, 600);
                System.out.println("You updated the owner's Salary");
            }
        });
  
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //Adding components
        add(ownerName);
        add(comboBox);
        add(salaryTitle);
        add(spinner);
        add(choice);
        add(button);    
    }
  
    public static void main(String[] args) {
        setFrame(new OwnerSalary(), 350, 300);
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