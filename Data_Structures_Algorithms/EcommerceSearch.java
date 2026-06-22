package Data_Structures_Algorithms;

import java.util.Arrays;

class Product implements Comparable<Product> {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class EcommerceSearch {
    
    public static Product linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == targetId) {
                return products[i];
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].productId == targetId) {
                return products[mid];
            }

            if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] inventory = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(101, "Mechanical Keyboard", "Electronics"),
            new Product(109, "Desk Mat", "Accessories"),
            new Product(103, "Monitor Stand", "Furniture"),
            new Product(107, "USB-C Hub", "Electronics")
        };

        Product resultLinear = linearSearch(inventory, 103);
        System.out.println("Linear Search Result: " + resultLinear);

        Arrays.sort(inventory);

        Product resultBinary = binarySearch(inventory, 107);
        System.out.println("Binary Search Result: " + resultBinary);
    }
}