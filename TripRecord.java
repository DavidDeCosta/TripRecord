import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

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
