import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserStock
{
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

            System.out.println("\nPS: 5% VAT applicable. Price of different item size may vary.\n");

            newReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return count;
    }

    double stockSelect(int num)
    {
        int count = 0, sizeInt, quantity = 0;
        String itemName = null, size;
        double itemPrice = 0;
        int itemStock = 0;

        Scanner sc = new Scanner(System.in);

        Item i = null;

        try
        {
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
                if(count == num)
                {
                    System.out.println("Selected Item: "+itemName);
                    break;
                }
            }

            System.out.println("\nWhat Size would you like?");
            System.out.println("1. Small");
            System.out.println("2. Medium");
            System.out.println("3. Large");
            System.out.print("Enter (1-3): ");

            sizeInt = sc.nextInt();

            if(sizeInt == 1)
            {
                size = "Small";

            }
            else if (sizeInt == 2)
            {
                size = "Medium";
            }
            else if (sizeInt == 3)
            {
                size = "Large";
            }
            else
            {
                size = null;
            }

            while(true)
            {
                System.out.println("\nHow many would you like? (Available: "+itemStock+")");
                System.out.print("Enter Amount: ");

                quantity = sc.nextInt();
                if(quantity<=itemStock)
                {
                    stockUpdate(num, quantity);
                    break;
                }

                System.out.println("Amount Exceeds the stock.");
            }

            i = new Item(quantity, itemPrice, itemName, size);

            newReader.close();

        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        double priceOfItem = i.totalPrice();

        System.out.println("\nPrice of "+quantity+" "+itemName+" "+priceOfItem);
        Invoice in = new Invoice(itemName, quantity, priceOfItem);
        in.invoice();

        return priceOfItem;
    }

    void stockUpdate(int index, int stock)
    {
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

                if(count==index)
                {
                    itemStock = itemStock - stock;
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
