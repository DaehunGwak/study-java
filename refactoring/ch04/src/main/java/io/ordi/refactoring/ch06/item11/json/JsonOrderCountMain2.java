package io.ordi.refactoring.ch06.item11.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 예시: 첫 번째 단계에 변환기(transform) 사용하기
 */
public class JsonOrderCountMain2 {

    public static void main(String[] args) {
        try {
            System.out.println(run(args));
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }

    public static long run(String[] args) throws IOException {
        CommandLine commandLine = new CommandLine(args);
        return countOrders(commandLine, args);
    }


    private static long countOrders(CommandLine commandLine, String[] args) throws IOException {
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
