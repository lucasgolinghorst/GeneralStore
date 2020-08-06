package generalstore;

public class Product {

    private String type;

    public Product(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        if (type.equalsIgnoreCase("chips"))
            return 1.0;
        if (type.equalsIgnoreCase("hot dog"))
            return 2.0;
        if (type.equalsIgnoreCase("burger"))
            return 3.0;
        return 1.50;
    }
}
