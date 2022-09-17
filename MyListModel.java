import javax.swing.DefaultListModel;
import javax.swing.*;
import java.io.*;

public class MyListModel extends DefaultListModel<TripRecord>
{

    //======================================DATA MEMBERS ========================================================

    String nameOfFile;                                        //store the name of the file?
    int numberOfTripRecords = 0;                             // keeping track of the number of names added

    //=======================================Constructors ==========================================================
    MyListModel()
    {  
        
    }

    MyListModel(DataInputStream dis)
    {

    }

//==========================================Methods // ============================================================


    void Store(DataOutputStream dos)
    {
        try {
            dos.writeUTF(nameOfFile);
            
        } catch (IOException e) {
            System.out.println("Error, could not write the name. ");
        }
    }

    

}
