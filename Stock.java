import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Stock
{
    void ask()
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            while(true)
            {
                stockAvailable();

                System.out.println("\nWhat would you like to do?");
                System.out.println("\t1. Add a new item.");
                System.out.println("\t2. Add existing stock.");
                System.out.println("\t3. Update Price.");
                System.out.println("\t4. Remove an item.");
                System.out.println("\t5. Return to Admin Page.");

                System.out.print("Enter any integers between (1-5): ");

                int choice = sc.nextInt();

                Files f = new Files();

                if(choice == 1)
                {
                    addItem();
                }
                else if(choice == 2)
                {
                    addStock();
                    f.fileUpdate();
                }
                else if(choice == 3)
                {
                    newPrice();
                    f.fileUpdate();
                }
                else if(choice == 4)
                {
                    itemDelete();
                    f.fileUpdate();
                }
                else if(choice == 5)
                {
                    break;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Input Mismatch, Enter Integers Only.");
            ask();
        }
    }

    int stockAvailable()
    {
        int count = 0;
        String itemName;
        double itemPrice;
        int itemStock;

        try
        {
            System.out.println("\n\t\t\t\tAvailable in Cafe:\n");
            File newObj = new File("Cafe Items Name & Price.txt");
            Scanner newReader = new Scanner(newObj);
            while (newReader.hasNext())
            {
                itemName = newReader.nextLine();
                itemPrice = newReader.nextDouble();
                newReader.nextLine();
                itemStock = newReader.nextInt();
                newReader.nextLine();

                count++;
                System.out.println(count+ ". " +itemName+ " ----- " +itemPrice+ " ----- Available (" +itemStock+ ")");
            }

            newReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return count;
    }

    void addItem()
    {
        int i=0, stock;
        double price;
        String item;

        Scanner sc = new Scanner(System.in);

        try
        {
            FileWriter newWriter = new FileWriter("Cafe Items Name & Price.txt", true);

            System.out.print("How many Items would you like to add: ");
            int itemAmount = sc.nextInt();

            while(i<itemAmount)
            {
                System.out.print("Enter Item Name: ");
                sc.nextLine();
                item = sc.nextLine();

                System.out.print("Enter Item Price: ");
                price = sc.nextDouble();

                System.out.print("Enter Item Stock: ");
                stock = sc.nextInt();

                newWriter.write(item+ "\n" +price+ "\n" +stock+ "\n");

                i++;
            }

            newWriter.close();
            System.out.println("\nSuccessfully wrote item details to the file.\n");
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void addStock()
    {

        stockAvailable();

        Scanner sc = new Scanner(System.in);

        System.out.println("\nWhat would you like to add?");
        int i = sc.nextInt();
        System.out.println("How many would you like to add?");
        int j = sc.nextInt();


        try
        {
            FileWriter newWriter = new FileWriter("Temp Cafe Items Name & Price.txt");
            File newObj = new File("Cafe Items Name & Price.txt");
            Scanner newReader = new Scanner(newObj);

            String itemName;
            double itemPrice;
            int itemStock = 0, count = 1;

            while (newReader.hasNext())
            {
                itemName = newReader.nextLine();
                itemPrice = newReader.nextDouble();
                newReader.nextLine();
                itemStock = newReader.nextInt();
                newReader.nextLine();

                if(count==i)
                {
                    itemStock = itemStock + j;
                }

                newWriter.write(itemName+ "\n" +itemPrice+ "\n" +itemStock+ "\n");

                count++;

            }

            newReader.close();
            newWriter.close();

        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void newPrice()
    {
        stockAvailable();

        Scanner sc = new Scanner(System.in);

        System.out.println("What item's price would you like to change?");
        int i = sc.nextInt();
        System.out.println("What is the new price?");
        int j = sc.nextInt();


        try
        {
            FileWriter newWriter = new FileWriter("Temp Cafe Items Name & Price.txt");
            File newObj = new File("Cafe Items Name & Price.txt");
            Scanner newReader = new Scanner(newObj);

            String itemName;
            double itemPrice;
            int itemStock = 0, count = 1;

            while (newReader.hasNext())
            {
                itemName = newReader.nextLine();
                itemPrice = newReader.nextDouble();
                newReader.nextLine();
                itemStock = newReader.nextInt();
                newReader.nextLine();

                if(count==i)
                {
                    itemPrice = j;
                }

                newWriter.write(itemName+ "\n" +itemPrice+ "\n" +itemStock+ "\n");

                count++;

            }

            newReader.close();
            newWriter.close();

        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void itemDelete()
    {
        stockAvailable();

        Scanner sc = new Scanner(System.in);

        System.out.println("What item would you like to Remove?");
        int j = sc.nextInt();

        String itemName;
        double itemPrice;
        int itemStock = 0, count = 1;


        try
        {
            FileWriter newWriter = new FileWriter("Temp Cafe Items Name & Price.txt");
            File newObj = new File("Cafe Items Name & Price.txt");
            Scanner newReader = new Scanner(newObj);

            while (newReader.hasNext())
            {
                itemName = newReader.nextLine();
                itemPrice = newReader.nextDouble();
                newReader.nextLine();
                itemStock = newReader.nextInt();
                newReader.nextLine();

                if(count==j)
                {
                    count++;
                    continue;
                }

                newWriter.write(itemName+ "\n" +itemPrice+ "\n" +itemStock+ "\n");
                count++;
            }

            newReader.close();
            newWriter.close();

        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
