package io.ordi.refactoring.ch04;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Province {

    private final String name;
    private final List<Producer> producers;
    @Setter private int totalProduction = 0;
    @Setter private int demand;
    @Setter private int price;

    public Province(String name, List<Producer> producers, int demand, int price) {
        this.name = name;
        this.producers = producers;
        this.demand = demand;
        this.price = price;
        this.producers.forEach(producer -> {
            producer.setProvince(this);
            this.totalProduction += producer.getProduction();
        });
    }

    public void addProducer(Producer producer) {
        this.producers.add(producer);
        this.totalProduction += producer.getProduction();
    }

    public long getProfit() {
        return this.getDemandValue() - this.getDemandCost();
    }

    private long getDemandValue() {
        return this.getSatisfiedDemand() * this.getPrice();
    }

    private long getSatisfiedDemand() {
        return Math.min(this.getDemand(), this.getTotalProduction());
    }

    private long getDemandCost() {
        long remainingDemand = this.getDemand();
        long result = 0;

        this.getProducers().sort((p1, p2) -> p1.getCost() - p2.getCost());

        for (Producer producer : this.getProducers()) {
            long contribution = Math.min(remainingDemand, producer.getProduction());
            remainingDemand -= contribution;
            result += contribution * producer.getCost();
        }

        return result;
    }
}
