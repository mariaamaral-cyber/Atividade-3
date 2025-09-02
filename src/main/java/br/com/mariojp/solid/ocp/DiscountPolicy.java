package br.com.mariojp.solid.ocp;

@FunctionalInterface
public interface DiscountPolicy {
    double apply(double amount);
}
