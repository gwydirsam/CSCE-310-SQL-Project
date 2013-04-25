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

public class Incident extends JFrame {

    //Creating the Swing objects
    private JTextField worker = new JTextField ("ID of worker who died: ");
    private JTextField animal = new JTextField ("ID of animal who killed: ");
    private JButton button = new JButton("Report Incident");
    private SpinnerModel workerID = new SpinnerNumberModel(0,0,99,1);
    private JSpinner wID = new JSpinner(workerID);
    private SpinnerModel animalID = new SpinnerNumberModel(0,0,999,1);
    private JSpinner aID = new JSpinner(animalID);
    private JTextField choice = new JTextField(25);
    private String str = "Worker killed: ";


    //Creating window with objects
    public Incident() {

        //Collecting data from the text box
        wID.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent e ) {
                JSpinner wID = ( JSpinner ) e.getSource();
                SpinnerModel Incident = wID.getModel();
                str += (Incident.getValue());
                System.out.println(Incident.getValue());
            }
        } );

        aID.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent e ) {
                JSpinner aID = ( JSpinner ) e.getSource();
                SpinnerModel Incident = aID.getModel();
                str += ("Animal who killed: " + (Incident.getValue()));
                choice.setText(str);
                System.out.println(Incident.getValue());
            }
        } );

        //When button is pressed, information is stored and window closes
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                dispose();
                setFrame(new ZooWindow(), 325, 600);
                System.out.println(str);
                System.out.println("You reported the incident");
            }
        });

        setLayout(new FlowLayout(FlowLayout.LEFT));

        // public static String status(){
            // return temp;
        // };

        //Adding components
        add(worker);
        add(wID);
        add(animal);
        add(aID);
        add(choice);
        add(button);
    }

    public static void main(String[] args) {
        setFrame(new Incident(), 350, 300);
    }


    //public static String status(){
    //return temp;
    //}

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
