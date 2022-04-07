import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Collection<Person> persons = new ArrayList<>();
        generatePerson(persons);

//      1. Найти количество несовершеннолетних (т.е. людей младше 18 лет).
        Stream<Person> stream = persons.stream();
        int count = (int) stream
                .filter(x -> x.getAge() < 18)
                .count();
//        System.out.println("1. Количество несовершеннолетних: " + count);

//      2. Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
        Stream<Person> stream1 = persons.stream();
        List<String> list = stream1
                .filter(x -> x.getSex() == Sex.MAN)
                .filter(x -> x.getAge() >= 18 && x.getAge() < 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
//        System.out.println("2. Фамилии призывников: \n" + list);

//      3.  Получить отсортированный по фамилии список потенциально работоспособных людей с высшим образованием в выборке
//      (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).
        Stream<Person> stream2 = persons.stream();
        List<String> list1 = stream2
                .filter(x -> x.getEducation() == Education.HIGHER)
                .filter(x -> (x.getSex() == Sex.MAN && x.getAge() >= 18 && x.getAge() < 65)
                        || (x.getSex() == Sex.WOMAN && x.getAge() >= 18 && x.getAge() < 60))
                .sorted(Comparator.comparing(Person::getFamily))
                .map(Person::getFamily)
                .collect(Collectors.toList());
//        System.out.println("3. Список потенциально работоспособных людей с высшим образованием:\n" + list1);
    }

    public static void generatePerson(Collection<Person> persons) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
    }
}
