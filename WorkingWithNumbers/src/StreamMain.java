import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {

    public void main(List<Integer> intList) {

        Stream<Integer> stream = intList.stream();

        List<Integer> newIntList = stream
                .filter(x -> x > 0)
                .filter(x -> x % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(newIntList);
    }
}
