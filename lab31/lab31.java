package Lab3.lab31;

class ProductItem {
    private String name;
    private double price;

    public ProductItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    public void Show() {
        System.out.println("Товар: " + name + ", Ціна: " + price + " грн");
    }
}

class Toy extends ProductItem {
    private int targetAge;

    public Toy(String name, double price, int targetAge) {
        super(name, price);
        this.targetAge = targetAge;
    }

    
    public void Show() {
        System.out.println("Іграшка: " + getName() + ", Ціна: " + getPrice() + " грн, Вікова категорія: " + targetAge + "+ років");
    }
}

class FoodProduct extends ProductItem {
    private int expirationDays;

    public FoodProduct(String name, double price, int expirationDays) {
        super(name, price);
        this.expirationDays = expirationDays;
    }

    public int getExpirationDays() { return expirationDays; }

    public void Show() {
        System.out.println("Продукт: " + getName() + ", Ціна: " + getPrice() + " грн, Термін придатності: " + expirationDays + " днів");
    }
}

class DairyProduct extends FoodProduct {
    private double fatPercentage;

    public DairyProduct(String name, double price, int expirationDays, double fatPercentage) {
        super(name, price, expirationDays);
        this.fatPercentage = fatPercentage;
    }

    public void Show() {
        System.out.println("Молочний продукт: " + getName() + ", Ціна: " + getPrice() + " грн, Термін: " + getExpirationDays() + " днів, Жирність: " + fatPercentage + "%");
    }
}

public class lab31 {
    public static void main(String[] args) {
        ProductItem[] items = new ProductItem[4];
        
        items[0] = new ProductItem("Ноутбук", 25000);
        items[1] = new Toy("Конструктор LEGO", 1200, 6);
        items[2] = new FoodProduct("Хліб", 25, 5);
        items[3] = new DairyProduct("Молоко", 38, 10, 2.5);

        System.out.println(" Список товарів:");
        for (ProductItem item : items) {
            item.Show();
        }
    }
}