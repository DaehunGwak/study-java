package io.ordi.refactoring.ch04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Producer {

    private final String name;
    @Setter private Province province;
    @Setter private int cost;
    private int production;

    public Producer(String name, int cost, int production) {
        this.name = name;
        this.cost = cost;
        this.production = production;
    }

    public void setProduction(int production) {
        this.province.setTotalProduction(production - this.production);
        this.production = production;
    }
}
