public class Item extends ItemOutline
{

    private String name, size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Item()
    {

    }

    public Item(int amount, double price, String name, String size) {
        super(amount, price);
        this.name = name;
        this.size = size;
        if(size.equals("Small"))
        {
            setPrice(getPrice());
        }
        else if(size.equals("Medium"))
        {
            setPrice(getPrice()*1.25);
        }
        else if(size.equals("Large"))
        {
            setPrice(getPrice()*1.45);
        }

    }


    @Override
    public double totalPrice()
    {
        double total;

        total = (getAmount()*getPrice());
        double vat = total*(5.0/100);
        total = total + vat;

        return total;
    }
}
