import java.io.*;
import java.util.Scanner;

public class Invoice
{
    private String name;
    private int amount;
    private double price;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public Invoice(String name, int amount, double price)
    {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Invoice()
    {

    }

    void invoice()
    {

        try
        {
            FileWriter newWriter = new FileWriter("Invoice.txt", true);

            newWriter.write(getName()+ "\n" +getAmount()+ "\n" +getPrice()+ "\n");

            newWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    void invoiceRead()
    {
        int count = 0;
        String itemName;
        double itemPrice;
        int itemStock;

        try
        {
            File newObj = new File("Invoice.txt");
            Scanner newReader = new Scanner(newObj);
            while (newReader.hasNext())
            {
                itemName = newReader.nextLine();

                itemStock = newReader.nextInt();
                newReader.nextLine();

                itemPrice = newReader.nextDouble();
                newReader.nextLine();

                count++;
                System.out.println(count+ ". " +itemName+ " ----- " +itemStock+ " ----- " +itemPrice);
            }

            newReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void invoiceClear()
    {
        try
        {
            File myObj1 = new File("Invoice.txt");
            myObj1.delete();
            File myObj2 = new File("Invoice.txt");
            myObj2.createNewFile();
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}