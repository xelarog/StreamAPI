import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> newIntList = new ArrayList<>();

        for (Integer number : intList) {
            if (number > 0 && number % 2 == 0)
                newIntList.add(number);
        }

        Comparator<Integer> comparator = Integer::compareTo;
        newIntList.sort(comparator);
        System.out.println(newIntList);

        StreamMain streamMain = new StreamMain();
        streamMain.main(intList);
    }
}
