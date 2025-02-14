import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class L7Q6 {
    public static void main(String[] args) {
        List<Product> products = readProductData("product.txt");
        List<Order> orders = readOrderData("order.txt");

        for (Order order : orders) {
            for (Product product : products) {
                if (order.getProductId().equals(product.getId())) {
                    System.out.println("ProductID: " + product.getId());
                    System.out.println("ProductName: " + product.getName());
                    System.out.println("Quantity: " + order.getQuantity());
                    System.out.println("PricePerUnit: " + product.getPrice());
                    System.out.println("Total: " + (order.getQuantity() * product.getPrice()));
                    System.out.println();
                }
            }
        }
    }

    private static List<Product> readProductData(String filename) {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Product product = new Product(parts[0], parts[1], Double.parseDouble(parts[2]));
                products.add(product);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return products;
    }

    private static List<Order> readOrderData(String filename) {
        List<Order> orders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Order order = new Order(parts[0], parts[1], Integer.parseInt(parts[2]));
                orders.add(order);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return orders;
    }

    private static class Product {
        private final String id;
        private final String name;
        private final double price;

        public Product(String id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    private static class Order {
        private final String productId;
        private final int quantity;

        public Order(String orderId, String productId, int quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        public String getProductId() {
            return productId;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}
