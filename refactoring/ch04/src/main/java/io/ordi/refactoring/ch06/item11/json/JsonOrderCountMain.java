package io.ordi.refactoring.ch06.item11.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonOrderCountMain {

    public static void main(String[] args) {
        try {
            System.out.println(run(args));
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }

    public static long run(String[] args) throws IOException {
        return countOrders(parseCommandLine(args));
    }

    private static CommandLine parseCommandLine(String[] args) {
        if (args.length == 0)
            throw new RuntimeException("파일명을 입력하세요.");
        CommandLine result = new CommandLine();
        result.setOnlyCountReady(Stream.of(args).anyMatch("-r"::equals));
        result.setFilename(args[args.length - 1]);
        return result;
    }



    private static long countOrders(CommandLine commandLine) throws IOException {
        File input = Paths.get(commandLine.getFilename()).toFile();
        ObjectMapper mapper = new ObjectMapper();
        Order[] orders = mapper.readValue(input, Order[].class);

        if (commandLine.isOnlyCountReady()) {
            return Stream.of(orders)
                    .filter(o -> "ready".equals(o.getStatus()))
                    .count();
        } else {
            return orders.length;
        }
    }
}
