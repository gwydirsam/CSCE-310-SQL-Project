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
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 
public class ZooWindow extends JFrame {
    //Creating the options of owners to pick from
    private String[] actions = { 
        "Update Owners Salary",
        "Insert new animal",
        "Insert new Worker",
        "Update Worker to owner or different position",
        "Report Incident",
        "Exit"
    };


    //Creating the Swing objects
    private JButton button = new JButton("Enter Choice");
    private JTextField choice = new JTextField(25);
    private JComboBox comboBox = new JComboBox();
    private String str = "";

    //Creating window with objects
    public ZooWindow() {
        //Putting in list of actions
        for(int i = 0; i < actions.length; i++)
            comboBox.addItem(actions[i]);
    
        //Putting the values selected in combo box into thactionse string
        comboBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                choice.setText("" + ((JComboBox)e.getSource()).getSelectedItem());
                str = choice.getText();
                System.out.println(str);
            }
        });

        //When button is pressed, information is stored and window closes
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                String temp = str;
                //System.out.println(temp.equals(actions[3]));
                if (temp.equals(actions[0]))
                    setFrame(new OwnerSalary(), 325, 600);
                else if(temp.equals(actions[1]))
                    setFrame(new AddAnimal(), 325, 600);
                else if(temp.equals(actions[2]))
                    setFrame(new WorkerHire(), 325, 600);
                else if(temp.equals(actions[3]))
                    setFrame(new WorkerPosition(), 325, 600);
                else if(temp.equals(actions[4]))
                    setFrame(new Incident(), 325, 600);
                else if(temp.equals(actions[5]))
                    setVisible(false);
                System.out.println(str);
                System.out.println("You clicked out of Original Choices");
            }
        });

        setLayout(new FlowLayout(FlowLayout.CENTER));

        //Adding components
        add(choice);
        add(comboBox);
        add(button);  
    }
  
    public static void main(String[] args) {
        setFrame(new ZooWindow(), 325, 600);
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