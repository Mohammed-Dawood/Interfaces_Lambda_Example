package se.lexicon.Interfaces;

import se.lexicon.model.Product;

@FunctionalInterface
public interface Action {
    void execute(Product p);
}
