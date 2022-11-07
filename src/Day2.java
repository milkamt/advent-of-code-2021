import model.Day2Model;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static void main(String[] args) {
        Service service = new Service();
        List<String> input = service.fileToListString("src/input/input_2_1.txt");

        System.out.println(firstPart(getDay2List(input)));
        System.out.println(secondPart(getDay2List(input)));
    }

    static int firstPart(List<Day2Model> instructions) {
        int horizontal = 0, depth = 0;
        for (Day2Model in : instructions) {
            switch (in.getDirection()) {
                case "forward" -> horizontal += in.getValue();
                case "down" -> depth += in.getValue();
                case "up" -> depth -= in.getValue();
            }
        }
        return horizontal * depth;
    }

    static int secondPart(List<Day2Model> instructions) {
        int horizontal = 0, depth = 0, aim=0;
        for (Day2Model in : instructions) {
            switch (in.getDirection()) {
                case "forward" -> {
                    horizontal += in.getValue();
                    depth += (aim * in.getValue());
                }
                case "down" -> aim += in.getValue();
                case "up" -> aim -= in.getValue();
            }
        }
        return horizontal * depth;
    }

    static List<Day2Model> getDay2List(List<String> input) {
        List<Day2Model> instructions = new ArrayList<>();
        for (String line : input) {
            String[] split = line.split("\\s");
            instructions.add(new Day2Model(
                    split[0],
                    Integer.parseInt(split[1])));
        }
        return instructions;
    }
}
