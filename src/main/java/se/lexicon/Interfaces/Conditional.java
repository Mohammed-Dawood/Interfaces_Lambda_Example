package se.lexicon.Interfaces;

import se.lexicon.model.Product;

@FunctionalInterface
public interface Conditional {
    boolean test(Product p);
}
