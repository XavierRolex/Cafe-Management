import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class AdminCr
{
    private String email, password;
    private String masterKey;

    public String getMasterKey() {
        return masterKey;
    }

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public AdminCr()
    {

    }

    public AdminCr(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    void create()
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            String master;

            System.out.print("\nEnter Master Key: ");
            master = sc.nextLine();
            if(getMasterKey().equals(master))
            {
                int choice;

                System.out.print("\nEnter Email: ");
                setEmail(sc.nextLine());
                System.out.print("Enter Password: ");
                setPassword(sc.nextLine());

                System.out.println("\nEnter 1 to Confirm account creation or any other integer to go back.");
                System.out.print("Your Choice: ");

                choice = sc.nextInt();

                if(choice == 1)
                {
                    checkMail();
                }

            }
            else
            {
                System.out.println("Incorrect Master Key");
            }
        }
        catch (Exception e)
        {
            System.out.println("Input Mismatch, Enter Integers Only.");
            create();
        }
    }

    void checkMail()
    {
        try
        {
            String emailAddress, password;
            boolean flag = true;

            File myObj = new File("Admin.txt");
            Scanner newReader = new Scanner(myObj);

            while(newReader.hasNext())
            {
                emailAddress = newReader.nextLine();
                password = newReader.nextLine();

                if(getEmail().equals(emailAddress))
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                createFile();
            }
            else
            {
                System.out.println("Account already exists.");
            }

        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    void createFile()
    {
        try
        {
            FileWriter newWriter = new FileWriter("Admin.txt", true);

            newWriter.write(getEmail()+"\n"+getPassword()+"\n");

            newWriter.close();

            System.out.println("Account successfully Created, You Can Login now");

        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
