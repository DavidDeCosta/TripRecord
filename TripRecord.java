import java.io.*;
import javax.swing.JOptionPane;

public class TripRecord {

//========================================Data Members //=================================================
    String name;

//========================================Constructors //===================================================
    TripRecord()
    {

    }
    TripRecord(String name)
    {
        this.name = name;
    }

    TripRecord(DataInputStream dis)
    {
        try 
        {
            this.name = dis.readUTF();
        } 
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(null, "Could not read name");
        }
    }

//=========================================Methods //===================================================

    void store(DataOutputStream dos)
    {
        try {
            dos.writeUTF(name);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }


     @Override 
    public String toString() 
    { 
        return name; 
    }

}
