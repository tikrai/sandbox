import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HelloWorld {

  public static void main(String[] args) {
    System.out.println("Hello World");
    Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 1));
    Set<Integer> b = Stream.of(1, 2, 3, 1).collect(Collectors.toSet());
    Set<Integer> c = Set.of(1, 2, 3);
    System.out.println(a);
    System.out.println(b);
    System.out.println(a);
  }
}
