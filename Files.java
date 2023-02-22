import java.io.File;
import java.io.IOException;

public class Files
{
    void createFile()
    {
        try {
            File myObj = new File("Cafe Items Name & Price.txt");
            File myObj2 = new File("Temp Cafe Items Name & Price.txt");
            File myObj3 = new File("Invoice.txt");
            File myObj4 = new File("Admin.txt");
            myObj.createNewFile();
            myObj2.createNewFile();
            myObj3.createNewFile();
            myObj4.createNewFile();
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void fileUpdate()
    {
        File newObj = new File("Cafe Items Name & Price.txt");
        File newObj2 = new File("Temp Cafe Items Name & Price.txt");
        newObj.delete();
        newObj2.renameTo(new File("Cafe Items Name & Price.txt"));
    }
}
