package br.com.mariojp.solid.ocp;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/**
 * DiscountCalculator agora segue OCP:
 * - Aberta para extensão: novas DiscountPolicy podem ser adicionadas
 * - Fechada para modificação: não há mais switch/if em CustomerType
 */
public class DiscountCalculator {

    private final Map<CustomerType, DiscountPolicy> policies;

    public DiscountCalculator() {
        this(defaultPolicies());
    }

    public DiscountCalculator(Map<CustomerType, DiscountPolicy> policies) {
        this.policies = new EnumMap<>(CustomerType.class);
        if (policies != null) {
            this.policies.putAll(policies);
        }
    }

    public double apply(double amount, CustomerType type) {
        Objects.requireNonNull(type, "CustomerType must not be null");
        DiscountPolicy policy = policies.get(type);
        if (policy == null) {
            return amount; // sem desconto
        }
        return policy.apply(amount);
    }

    private static Map<CustomerType, DiscountPolicy> defaultPolicies() {
        Map<CustomerType, DiscountPolicy> map = new EnumMap<>(CustomerType.class);
        map.put(CustomerType.REGULAR, new RegularPolicy());
        map.put(CustomerType.PREMIUM, new PremiumPolicy());
        map.put(CustomerType.PARTNER, new PartnerPolicy());
        return map;
    }
}
