package Java_Eight_Fundamentals;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Example_Method_Ref {
    public static int add(int n){
        return 1+n;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);

       int min= list.stream().map(n->Example_Method_Ref.add(n)).min(Comparator.naturalOrder())
               .orElse(0);

        System.out.println(min);

        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));

        List<String> phones = people.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        phones.forEach(System.out::println);
    }
}
