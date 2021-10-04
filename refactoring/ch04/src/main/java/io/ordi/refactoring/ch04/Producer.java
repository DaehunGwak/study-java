package io.ordi.refactoring.ch04;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Producer {

    private final String name;
    @Setter
    @ToString.Exclude
    private Province province;
    @Setter
    private int cost;
    private int production;

    public Producer(String name, int cost, int production) {
        this.name = name;
        this.cost = cost;
        this.production = production;
    }

    public void setProduction(int production) {
        int resultTotalProduction = this.getProvince().getTotalProduction() + production - this.production;
        this.province.setTotalProduction(resultTotalProduction);
        this.production = production;
    }
}
