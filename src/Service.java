import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service {
    public List<String> fileToListString(String filePath) {
        List<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (br.ready()) {
                list.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Integer> fileToListInteger(String filePath) {
        List<String> originalInput = fileToListString(filePath);
        List<Integer> integerList = new ArrayList<>();

        for (String s : originalInput) {
            integerList.add(Integer.parseInt(s));
        }

        return integerList;
    }
}
