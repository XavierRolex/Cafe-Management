public abstract class ItemOutline
{
    private int amount;
    private double price;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemOutline()
    {

    }

    public ItemOutline(int amount, double price) {
        this.amount = amount;
        this.price = price;
    }

    public abstract double totalPrice();

}