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

public class WorkerPosition extends JFrame {
    //Creating the options of workers to pick from
    private String[] workers = { 
        "Reece Witherspoon",
        "Forrest Gump",
        "Harrison Ford",
        "Anakin Skywalker"
    };

    private String[] positions = { 
        "Owner",
        "Trainer",
        "Trash Person",
        "Trainer",
        "Back"
    };

    //Creating the Swing objects
    private JTextField position = new JTextField ("Position to change to : ");
    private JTextField workerName = new JTextField ("Worker's name to change : ");
    private JButton button = new JButton("Enter Choice");
    private JTextField choice = new JTextField(25);
    private JComboBox workerBox = new JComboBox();
    private JComboBox positionBox = new JComboBox();
    private String str = "";
       

    //Creating window with objects
    public WorkerPosition() {
        //Putting in list of workers
        for(int i = 0; i < workers.length; i++)
            workerBox.addItem(workers[i]);

        //Putting in list of positions
        for(int i = 0; i < positions.length; i++)
            positionBox.addItem(positions[i]);
    
        //Putting the values selected in worker box into the string
        workerBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                str = ("Changing " 
                                + (((JComboBox)e.getSource()).getSelectedItem()) 
                                + "'s position to: ");
            }
        });

        //Putting the values selected in position box into the string
        positionBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                str += (" " + (((JComboBox)e.getSource()).getSelectedItem()));
                choice.setText(str);
            }
        });

        //When button is pressed, information is stored and window closes
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                dispose();
                setFrame(new ZooWindow(), 325, 600);
                System.out.println(str);
                System.out.println("You updated the worker's position");
            }
        });
  
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //Adding components
        add(workerName);
        add(workerBox);
        add(position);
        add(positionBox);
        add(choice);
        add(button);    
    }
  
    public static void main(String[] args) {
        setFrame(new WorkerPosition(), 350, 300);
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