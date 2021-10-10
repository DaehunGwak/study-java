package io.ordi.refactoring.ch06.item01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    private String customer;
    private LocalDate dueDate;
    private List<Order> orders = new ArrayList<>();

}
