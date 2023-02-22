import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminLogin
{
    private String name, password;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public AdminLogin()
    {

    }

    void login()
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            int choice;

            System.out.print("\nEnter Email: ");
            setName(sc.nextLine());
            System.out.print("Enter Password: ");
            setPassword(sc.nextLine());

            System.out.println("\nEnter 1 to login or any other integer to go back.");
            System.out.print("Your Choice: ");

            choice = sc.nextInt();

            if(choice == 1)
            {
                loginFile();
            }

        }
        catch (Exception e)
        {
            System.out.println("Input Mismatch, Enter Integers Only.");
            login();
        }
    }

    void loginFile()
    {
        String User, Password;
        int flag = 0;
        try
        {
            File newObj = new File("Admin.txt");
            Scanner newReader = new Scanner(newObj);
            while (newReader.hasNext())
            {
                User = newReader.nextLine();

                Password = newReader.nextLine();

                if((User.equals(getName()))&&(Password.equals(getPassword())))
                {
                    flag = 1;
                }
            }
            newReader.close();
            if(flag==0)
            {
                System.out.println("\nAdmin not Found");
                System.out.println("PLease, try Again.");
            }
            else
            {
                System.out.println("\nSuccessfully Logged In\n");
                Stock s = new Stock();
                s.ask();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
