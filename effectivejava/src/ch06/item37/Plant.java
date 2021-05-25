package ch06.item37;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class Plant {
    public enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }

    private final String name;
    private final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public LifeCycle getLifeCycle() {
        return lifeCycle;
    }

    public static void main(String[] args) {
        Plant[] garden = {
                new Plant("first annual", LifeCycle.ANNUAL),
                new Plant("biiiiii", LifeCycle.BIENNIAL),
                new Plant("second annual", LifeCycle.ANNUAL)
        };

//        main_37_2_enumMap(garden);
        main_37_4_streamEnumMap(garden);
    }

    private static void main_37_2_enumMap(Plant[] garden) {
        Map<LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(LifeCycle.class);
        for (LifeCycle lc : LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }
        for (Plant p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }
        System.out.println(plantsByLifeCycle);
    }

    private static void main_37_4_streamEnumMap(Plant[] garden) {
        System.out.println(
                Arrays.stream(garden)
                        .collect(groupingBy(p -> p.getLifeCycle(),
                                () -> new EnumMap<>(LifeCycle.class),
                                toSet()))
        );
    }
}
