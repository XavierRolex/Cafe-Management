import java.util.Scanner;
import java.io.*;

public class Welcome
{
    void welcome()
    {
        System.out.println("==================================================================");
        System.out.println("\t\t**********************************");
        System.out.println("\t\t             Welcome");
        System.out.println("\t\t                To");
        System.out.println("\t\t       North South University");
        System.out.println("\t\t            Online Cafe");
        System.out.println("\t\t**********************************");
        System.out.println("==================================================================\n");

        Files fs = new Files();
        fs.createFile();
    }

    void loop()
    {
        try
        {
            int choice;
            Scanner sc = new Scanner(System.in);

            while(true)
            {
                System.out.println("Would you Like to go to,");
                System.out.println("\t1. Admin Page.");
                System.out.println("\t2. User Page.");
                System.out.println("\t3. Exit.");
                System.out.print("Enter any integers between (1-3): ");

                choice = sc.nextInt();

                if(choice == 1)
                {
                    adminPage();
                }
                else if(choice == 2)
                {
                    userPage();
                }
                else if(choice == 3)
                {
                    break;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Input Mismatch, Enter Integers Only.");
            loop();
        }
    }

    void adminPage()
    {
        try
        {

            int choice;
            Scanner sc = new Scanner(System.in);

            while(true)
            {
                System.out.println("\nWhat would you Like to do,");
                System.out.println("\t1. Create Account.");
                System.out.println("\t2. Admin Login.");
                System.out.println("\t3. Return.");
                System.out.print("Enter any integers between (1-3): ");

                choice = sc.nextInt();

                if(choice == 1)
                {
                    AdminCr cr = new AdminCr();
                    cr.setMasterKey("MasterPass504");
                    cr.create();
                }
                else if(choice == 2)
                {
                    AdminLogin lg = new AdminLogin();
                    lg.login();
                }
                else if(choice == 3)
                {
                    break;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Input Mismatch, Enter Integers Only.");
            adminPage();
        }
    }

    void userPage()
    {
        int i;
        double price;
        try
        {
            Scanner sc = new Scanner(System.in);
            UserStock us = new UserStock();
            Files f = new Files();

            while(true)
            {
                i = us.stockAvailable();
                System.out.println("Enter (1-"+i+"), Enter a character to exit.");
                System.out.print("Your choice: ");

                int choice = sc.nextInt();

                price = us.stockSelect(choice);
                total = total + price;
                f.fileUpdate();

            }
        }
        catch(Exception e)
        {
            System.out.println("Successfully Exited\n");
            Invoice invo = new Invoice();
            System.out.println("\t\t\t\tINVOICE\n");
            invo.invoiceRead();
            System.out.println("\nTotal Price to pay: "+total+"\n");
        }
    }

    static double total = 0;
}
