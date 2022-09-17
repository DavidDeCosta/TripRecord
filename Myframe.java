import javax.swing.*;                           //for JButton
import javax.swing.event.*;                    //for ChangeListener

import org.w3c.dom.events.MouseEvent;

import java.awt.event.*;                       // for ActionListener
import java.io.File;
import java.awt.*;                             // for Dimension and Toolkit

public class Myframe extends JFrame
                        implements ActionListener, ListSelectionListener, MouseListener
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
    JMenuItem clear;

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

    JList<String> displayList;                           // displays their names
    JScrollPane tripScrollPane;



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
        displayList = new JList(justAListModel);
        tripScrollPane = new JScrollPane(displayList);
        add(tripScrollPane, BorderLayout.CENTER);
        
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
        add.setToolTipText("alt+a , add name");
        add.setMnemonic('A');                //press alt + a to add
        southPanel.add(add);

        delete = new JButton("delete");
        delete.addActionListener(this);
        delete.setToolTipText("alt + d, to delete");
        delete.setMnemonic('d');             //press alt + d to delete
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
        deleteFromMenu.addActionListener(this);
        theMenuOnTheBar.add(deleteFromMenu);

        addFromMenu = new JMenuItem("add");
        theMenuOnTheBar.add(addFromMenu);
        addFromMenu.addActionListener(this);

        saveAsFromMenu = new JMenuItem("saveAs");
        theMenuOnTheBar.add(saveAsFromMenu);
        saveAsFromMenu.addActionListener(this);

        clear = new JMenuItem("clear");
        theMenuOnTheBar.add(clear);
        clear.addActionListener(this);

 
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        
        if(e.getActionCommand().equals("exit"))
        {
            this.dispose();
        }
        else if(e.getActionCommand().equals("add"))
        {
            handleAdd();
        }
        else if(e.getActionCommand().equals("saveAs"))
        {
            handleSaveAs();
        }
        else if(e.getActionCommand().equals("save"))
        {

        }
        else if(e.getActionCommand().equals("delete"))
        {
            handleDelete();
        }
        else if(e.getActionCommand().equals("load"))
        {

        }
        else if(e.getActionCommand().equals("clear"))
        {
            justAListModel.clear();
            justAListModel.numberOfTripRecords = 0;                    //sets the list to empty
        }
        
    }


    void handleAdd()
    {
        userName = JOptionPane.showInputDialog("Enter a name");  //userName will hold the response from the user
        record = new TripRecord(userName);
        justAListModel.addElement(record);
        justAListModel.numberOfTripRecords += 1;
        System.out.println("There are " + justAListModel.numberOfTripRecords + " record in the list");
    }

    void handleDelete()
    {
        int index;
        index = displayList.getSelectedIndex();
        if(index != -1)
        {
        justAListModel.remove(index);
        justAListModel.numberOfTripRecords -= 1;
        System.out.println("There are " + justAListModel.numberOfTripRecords + " record in the list");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "select something to remove");
        }
    }

    void handleSaveAs()
    {
        String theFileSaveName;
        int savedOrNot;
        theFileChooser = new JFileChooser(new File("."));   //opens current working directory
        savedOrNot = theFileChooser.showSaveDialog(null);     // if returns 0 they saved file if 1 they exited

        if(theFileChooser.getSelectedFile().exists())
        {
            int n = JOptionPane.showConfirmDialog(this,
                        "Do You Want to Overwrite File?",
                        "Confirm Overwrite",
                        JOptionPane.YES_NO_OPTION);{

                if (n == JOptionPane.YES_OPTION){
                        theFileChooser.approveSelection();
                    }
                else
                    theFileChooser.approveSelection();
            }
        }
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        
    }


    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        
        
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        
        
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        
        
    }

}
