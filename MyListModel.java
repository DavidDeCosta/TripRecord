import javax.swing.DefaultListModel;
import javax.swing.*;
import java.io.*;

public class MyListModel extends DefaultListModel<TripRecord>
{

    //======================================DATA MEMBERS ========================================================

//    DefaultListModel<TripRecord> tripRecordList;         //stores the names of the people who went on the trip
    JList<String> displayList;                           // displays their names
    JScrollPane tripScrollPane;
    String name;
    int numberOfTripRecords;                             // keeping track of the number of names added


    //=======================================Constructor ==========================================================
    MyListModel()
    {
            

//      tripRecordList = new DefaultListModel<TripRecord>();
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
