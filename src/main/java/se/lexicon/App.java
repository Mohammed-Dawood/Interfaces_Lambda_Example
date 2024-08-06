package se.lexicon;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;

import se.lexicon.model.Product;
import se.lexicon.Interfaces.Action;
import se.lexicon.Interfaces.Conditional;

public class App {
    public static void process(List<Product> products, Conditional condition, Action action) {
        for (Product product : products) {
            if (condition.test(product)) {
                action.execute(product);
            }
        }
    }

    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Iphone x", 1000.00, 1));
        productList.add(new Product("Surface Book 3", 2000.00, 20));
        productList.add(new Product("Iphone 6s", 100.00, 0));
        productList.add(new Product("Iphone 8", 150.00, 5));
        productList.add(new Product("Best", 120.00, 0));

        // Print out all Products that have stock value of 0.
        Action action = (p) -> System.out.println(p.toString());
        Conditional conditional = (p) -> p.getStock() == 0;
        process(
                productList, conditional, action
        );

        System.out.println("---------------------------------------------");

        // Print out the productName of all the Products that starts with B.
        Action action1 = p -> System.out.println(p);
        Conditional conditional1 = (p) -> p.getProductName().startsWith("B");
        process(
                productList, conditional1, action1
        );

        System.out.println("---------------------------------------------");

        // Print out all Products that have price above 100 AND lower than 150
        Action action2 = (p) -> System.out.println(p);
        Conditional conditional2 = (p) -> p.getPrice() > 100 && p.getPrice() < 150;
        process(
                productList, conditional2, action2
        );

        System.out.println("---------------------------------------------");

        // Increase the price of all Products that have a stock value of less than 10 AND above 0 by 50 %
        Action action3 = (p) -> {
            p.setPrice(p.getPrice() * 0.5);
            System.out.println(p);
        };
        Conditional conditional3 = (p) -> p.getStock() < 10 && p.getStock() > 0;
        process(
                productList, conditional3, action3
        );
    }
}
