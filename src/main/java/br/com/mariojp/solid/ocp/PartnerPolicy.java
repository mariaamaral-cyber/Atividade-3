package br.com.mariojp.solid.ocp;

public class PartnerPolicy implements DiscountPolicy {
    @Override
    public double apply(double amount) {
        return amount * 0.88; // 12% desconto
    }
}
