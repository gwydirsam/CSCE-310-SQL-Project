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

public class WorkerHire extends JFrame {

    //Creating the positions of workers to pick from
    private String[] positions = { 
        "Owner",
        "Trainer",
        "Trash Person",
        "Trainer"
    };

    //Creating the zoos of workers to pick from
    private String[] zoos = { 
        "Tyler Zoo",
        "San Diego",
        "Dallas Zoo",
        "Cameron Zoo"
    };

    //Creating the shifts of workers to pick from
    private String[] shifts = { 
        "morning",
        "evening",
        "day",
        "swing"
    };

    //Creating the animals of workers to pick from
    private String[] animals = { 
        "african wild dog", "red wolf", "mexican wolf", "coyote", "swift fox", "sun bear", "black bear ", "north american river otter", "black-footed ferret ", "ringtail ", "jaguar ", "african lion", "sumatran tiger", "bengal tiger (white)", "indochinese tiger", "cheetah", "cougar", "bobcat (lynx)", "ocelot ", "coati", "meerkat", "orangutan", "mandrill baboon", "spider monkey", "frilled lizard", "spiny-tailed lizard", "knight anole", "texas horned lizard", "rhinoceros iguana", "green iguana", "cuban false chameleon", "parsons chameleon", "panther chameleon", "oustalet\'s chameleon", "standing\'s day gecko", "madagascar day gecko", "solomon island skink", "henkel\'s leaftail gecko", "giant leaf-tailed gecko", "blue-tongued skink", "shingleback skink", "american alligator", "dwarf caiman", "philippine crocodile", "crowned eagle", "northern harrier", "bateleur eagle", "bald eagle ", "harpy eagle", "japanese mountain hawk eagle", "redtailed hawk", "aplomado falcon", "flightless steamer duck", "laughing gull", "brown pelican", "black-necked swan", "black swan", "giant millipede", "giant tropical roach", "deep sea isopod", "jungle nymph walking stick", "desert hairy scorpion", "texas tarantula", "mexican tiger rat snake", "blood python ", "california king snake", "black milk snake", "louisiana pine snake", "longnosed snake", "gray-banded king snake", "texas lyre snake", "pancake tortoise", "fly river turtle", "hawksbill sea turtle ", "spotted pond turtle ", "central american river turtle", "matamata turtle"
    };

    //Creating the Swing objects
    private JTextField workerNam = new JTextField ("Type worker's name: ");
    private JTextField position = new JTextField ("Position to change to: ");
    private JTextField zooNam = new JTextField ("Zoo name: ");
    private JTextField shift = new JTextField ("Shift: ");
    private JTextField animal = new JTextField ("Animals working with: ");
    private SpinnerModel workerName = new SpinnerListModel();
    private JSpinner spinner = new JSpinner(workerName);
    private JComboBox zoosBox = new JComboBox();
    private JComboBox positionBox = new JComboBox();
    private JComboBox animalsBox = new JComboBox();
    private JComboBox shiftsBox = new JComboBox();
    private JButton button = new JButton("Enter Worker");
    private JTextField choice = new JTextField(25);
    private String str = "";
       

    //Creating window with objects
    public WorkerHire() {
        //Putting in list of zoos
        for(int i = 0; i < zoos.length; i++)
            zoosBox.addItem(zoos[i]);

        //Putting in list of positions
        for(int i = 0; i < positions.length; i++)
            positionBox.addItem(positions[i]);

        //Putting in list of animals
        for(int i = 0; i < animals.length; i++)
            animalsBox.addItem(animals[i]);

        //Putting in list of shifts
        for(int i = 0; i < shifts.length; i++)
            shiftsBox.addItem(shifts[i]);
    
        //Putting the values selected in worker box into the string
        zoosBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                str = ("Adding " 
                                + (((JComboBox)e.getSource()).getSelectedItem()));
            }
        });

        //Putting the values selected in position box into the string
        positionBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                str += (" " + (((JComboBox)e.getSource()).getSelectedItem()));
                choice.setText(str);
            }
        });

        //Putting the values selected in animal box into the string
        animalsBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                str += (" " + (((JComboBox)e.getSource()).getSelectedItem()));
            }
        });

        //Putting the values selected in shift box into the string
        shiftsBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                str += (" " + (((JComboBox)e.getSource()).getSelectedItem()));
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
                System.out.println("You hired a new worker");
            }
        });
  
        setLayout(new FlowLayout(FlowLayout.LEFT));

        //Adding components
        add(workerNam);
        add(spinner);
        add(zooNam);
        add(zoosBox);
        add(animal);
        add(animalsBox);
        add(shift);
        add(shiftsBox);
        add(position);
        add(positionBox);
        add(choice);
        add(button);    
    }
  
    public static void main(String[] args) {
        setFrame(new WorkerHire(), 350, 300);
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