package br.com.mariojp.solid.ocp;

public class RegularPolicy implements DiscountPolicy {
    @Override
    public double apply(double amount) {
        return amount * 0.95;
    }
}
