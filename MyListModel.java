import javax.swing.DefaultListModel;
import javax.swing.*;
import java.io.*;

public class MyListModel extends DefaultListModel<TripRecord>
{

    //======================================DATA MEMBERS ========================================================

    JList<String> displayList;                           // displays their names
    JScrollPane tripScrollPane;

    String name;
    int numberOfTripRecords;                             // keeping track of the number of names added



    //=======================================Constructor ==========================================================
    MyListModel()
    {
        displayList = new JList<String>();
        tripScrollPane = new JScrollPane(displayList);
        
    }

    void Store(DataOutputStream dos)
    {
        try {
            dos.writeUTF(name);
            
        } catch (IOException e) {
            System.out.println("Error, could not write the name. ");
        }
    }

    @Override public String toString() 
    { 
        return name; 
    }

}
