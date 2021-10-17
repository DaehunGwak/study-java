package io.ordi.refactoring.ch06.item11.json;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class CommandLine {

    private String[] args;

    public String getFilename() {
        return args[args.length - 1];
    }
}
