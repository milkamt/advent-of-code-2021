import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 {

    public static void main(String[] args) {
        Service service = new Service();
        List<String> input = service.fileToListString("src/input/input_3_1.txt");

        /* --- part 1 --- */
        System.out.println(getPowerConsumption(input));

        /* --- part 2 --- */
        int oxygenGeneratorRating = getRating(input, true);
        int co2ScrubberRating = getRating(input, false);

        System.out.println(oxygenGeneratorRating * co2ScrubberRating);
    }

    static int getPowerConsumption(List<String> input) {
        List<char[]> inputLines = new ArrayList<>();
        for (String s : input) {
            inputLines.add(s.toCharArray());
        }

        List<Integer> gama = new ArrayList<>(), epsilon = new ArrayList<>();

        for (int i = 0; i < inputLines.get(0).length; i++) {
            int zero = 0, one = 0;
            for (int j = 0; j < inputLines.size(); j++) {
                switch (inputLines.get(j)[i]) {
                    case '0' -> zero++;
                    case '1' -> one++;
                }
            }
            if (zero > one) {
                gama.add(0);
                epsilon.add(1);
            } else {
                gama.add(1);
                epsilon.add(0);
            }
        }

        String gamaDecimal = gama.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));

        String epsilonDecimal = epsilon.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));

        int gamaResult = Integer.parseInt(gamaDecimal,2);
        int epsilonResult = Integer.parseInt(epsilonDecimal,2);

        return gamaResult * epsilonResult;
    }

    static int getRating(List<String> input, boolean oxygen) {
        int column = 0;
        char keep;

        while (input.size() > 1) {
            int one = 0, zero = 0;

            for (String line : input) {
                char[] lineChars = line.toCharArray();
                char s = lineChars[column];

                switch (s) {
                    case '0' -> zero++;
                    case '1' -> one++;
                }
            }

            if (oxygen) {
                if (one > zero || one == zero) {
                    keep = '1';
                } else {
                    keep = '0';
                }
            } else {
                if (one > zero || one == zero) {
                    keep = '0';
                } else {
                    keep = '1';
                }
            }

            List<String> keepList = new ArrayList<>();

            for (String line : input) {
                char[] lineChars = line.toCharArray();
                char value = lineChars[column];

                if (value == keep) {
                    keepList.add(line);
                }
            }
            input = keepList;
            column++;
        }

        return new BigInteger(input.get(0),2).intValue();
    }
}
