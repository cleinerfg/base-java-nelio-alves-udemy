package org.example.projects.canditades;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        String csvData = """
                Alice Smith,Box 101,150
                Bob Johnson,Box 101,120
                Charlie Brown,Box 101,85
                Alice Smith,Box 102,200
                Bob Johnson,Box 102,175
                Charlie Brown,Box 102,90
                Alice Smith,Box 103,130
                Bob Johnson,Box 103,145
                Charlie Brown,Box 103,110
                Alice Smith,Box 104,180
                Bob Johnson,Box 104,160
                Charlie Brown,Box 104,95
                Alice Smith,Box 105,210
                Bob Johnson,Box 105,190
                Charlie Brown,Box 105,105
                Alice Smith,Box 106,170
                Bob Johnson,Box 106,155
                Charlie Brown,Box 106,115
                Alice Smith,Box 107,195
                Bob Johnson,Box 107,140
                """;

        Map<String, Integer> result = new HashMap<>();

        String[] lines = csvData.trim().split("\n");

        for (int i = 0; i < lines.length; i++) {
            String[] fields = lines[i].split(",");

            String candidate = fields[0].trim();
            int votes = Integer.parseInt(fields[2].trim());

            // Using an explicit lambda expression
//            result.merge(candidate, votes, (oldV, newV) -> oldV + newV);
//            result.merge(candidate, votes, (oldV, newV) -> Integer.sum(oldV, newV));

            result.merge(candidate, votes, Integer::sum);
        }

        System.out.println("Result: " + result);
    }
}