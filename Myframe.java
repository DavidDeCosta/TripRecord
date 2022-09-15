import javax.swing.*;                           //for JButton
import javax.swing.event.*;                    //for ChangeListener
import java.awt.event.*;                       // for ActionListener
import java.io.*;
import java.awt.*;                             // for Dimension and Toolkit

public class Myframe extends JFrame
                        implements ActionListener, ListSelectionListener
{
    //=======================================DATA MEMBERS =====================================================

    Dimension screenSize;
    Toolkit toolkit;
    MyListModel justAListModel;
    TripRecord record;

    JMenuBar menuBar;
    JMenu theMenuOnTheBar;
    JMenuItem loadFromMenu;
    JMenuItem saveFromMenu;
    JMenuItem addFromMenu;
    JMenuItem deleteFromMenu;
    JMenuItem saveAsFromMenu;

    JPanel southPanel;
    JPanel centerPanel;

    JButton load;
    JButton save;
    JButton saveAs;
    JButton add;
    JButton delete;
    JButton sort;
    JButton exit;

    JTextField inputTextField;

    String userName;

    JFileChooser theFileChooser;

    



    //======================================CONSTRUCTOR =======================================================
    Myframe()
    {
        toolkit = Toolkit.getDefaultToolkit();                      // used to help get the users screen size
        screenSize = toolkit.getScreenSize();                       //get the users screen size
        setSize(screenSize.width/3, screenSize.height/3);           // makes JFrame 1/3 the users screensize
        setLocationRelativeTo(null);                             // window is placed in the center of screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            //when close frame the program stops
        setTitle("Project 2 Trip Record");

        addComponents();

        setVisible(true);
    }

    void addComponents()
    {
        
        //======================= setting up the JList to view //===================================================
        justAListModel = new MyListModel();
        add(justAListModel.tripScrollPane, BorderLayout.WEST);


        //======================= setting up south Panel for buttons //===============================================
        southPanel = new JPanel();
        southPanel.setBackground(Color.GRAY);
        southPanel.setPreferredSize(new Dimension(100,30));
        add(southPanel, BorderLayout.SOUTH);

        load = new JButton("load");
        southPanel.add(load);

        save = new JButton("save");
        southPanel.add(save);

        saveAs = new JButton("saveAs");
        southPanel.add(saveAs);
        saveAs.addActionListener(this);

        add = new JButton("add");
        add.addActionListener(this);
        southPanel.add(add);

        delete = new JButton("delete");
        southPanel.add(delete);

        sort = new JButton("sort");
        southPanel.add(sort);

        exit = new JButton("exit");
        exit.addActionListener(this);
        southPanel.add(exit);


        //===================================setting up the JMenu Bar  //============================================
        menuBar = new JMenuBar();
        add(menuBar,BorderLayout.NORTH);
        

        theMenuOnTheBar = new JMenu("File");
        menuBar.add(theMenuOnTheBar);

        loadFromMenu = new JMenuItem("load");
        theMenuOnTheBar.add(loadFromMenu);

        saveFromMenu = new JMenuItem("save");
        theMenuOnTheBar.add(saveFromMenu);

        deleteFromMenu = new JMenuItem("delete");
        theMenuOnTheBar.add(deleteFromMenu);

        addFromMenu = new JMenuItem("add");
        theMenuOnTheBar.add(addFromMenu);
        addFromMenu.addActionListener(this);

        saveAsFromMenu = new JMenuItem("saveAs");
        theMenuOnTheBar.add(saveAsFromMenu);
        saveAsFromMenu.addActionListener(this);


        //=======================================setting up Input Text Field //================================
        
/*        inputTextField = new JTextField(30);
        centerPanel = new JPanel();
        centerPanel.setBackground(Color.GRAY);
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.add(inputTextField);
 */
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        
        if(e.getActionCommand().equals("exit"))
        {
            this.dispose();
        }
        else if(e.getActionCommand().equals("add"))
        {

            userName = JOptionPane.showInputDialog("Enter a name");  //userName will hold the response from the user
            record = new TripRecord(userName);
            justAListModel.addElement(record);

        }
        else if(e.getActionCommand().equals("saveAs"))
        {
            int savedOrNot;
            theFileChooser = new JFileChooser();
            savedOrNot = theFileChooser.showSaveDialog(null);        // if returns 0 they saved file if 1 they exited

        
        }
        else if(e.getActionCommand().equals("save"))
        {

        }
        else if(e.getActionCommand().equals("remove"))
        {

        }
        else if(e.getActionCommand().equals("load"))
        {

        }
        
    }



    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        
    }

}
