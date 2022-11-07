import java.util.List;

public class Day1 {

    public static void main(String[] args) {
        Service service = new Service();

        List<Integer> input = service.fileToListInteger("src/input/input_1.txt");

        System.out.println(largerMeasurementAmount(input));
        System.out.println(threeWindowSumIncreasement(input));
    }

    static int largerMeasurementAmount(List<Integer> input) {
        int increase = 0;

        for (int i = 1; i < input.size(); i++) {
            if (input.get(i) > input.get(i-1)) {
                increase++;
            }
        }

        return increase;
    }

    static int threeWindowSumIncreasement(List<Integer> input) {
        int sum1;
        int sum2;
        int increasedSum = 0;

        for (int i = 0; i < input.size()-3; i++) {
            sum1 = input.get(i) + input.get(i + 1) + input.get(i + 2);
            sum2 = input.get(i+1) + input.get(i + 2) + input.get(i + 3);

            if(sum1 < sum2) {
                increasedSum ++;
            }
        }

        return increasedSum;
    }
}