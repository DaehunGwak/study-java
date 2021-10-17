package io.ordi.refactoring.ch06.item11.json;


import java.util.Arrays;

public class CommandLine {

    private String[] args;

    public CommandLine(String[] args) {
        this.args = args;
        if (args.length == 0)
            throw new RuntimeException("파일명을 입력하세요.");
    }

    public String getFilename() {
        return args[args.length - 1];
    }

    public boolean isOnlyCountReady() {
        return Arrays.asList(args).contains("-r");
    }
}
