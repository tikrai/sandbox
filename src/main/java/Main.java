import dvinaryTree.DvinaryTree;

import java.util.Map;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    DvinaryTree<String, Integer> tree = new DvinaryTree<>();
    System.out.println(tree.put("vienas", 1));
    System.out.println(tree.put("du", 2));
    System.out.println(tree.put("trys", 3));
    System.out.println(tree.put("keturi", 41));
    System.out.println(tree.put("keturi", 42));
    System.out.println(tree.put("keturi", 43));
    System.out.println(tree.put("penki", 5));
    System.out.println(tree.put("sesi", 6));
    System.out.println(tree.put("septyni", 7));
    System.out.println(tree.put("astuoni", 8));
    System.out.println(tree.put("devyni", 9));
    System.out.println(tree.size());
    System.out.println(tree);

    Map<String, Integer> map = new TreeMap<>();
    map.put("vienas", 1);
    map.put("du", 2);
    map.put("trys", 3);
    map.put("keturi", 41);
    map.put("keturi", 42);
    map.put("keturi", 43);
    map.put("penki", 5);
    map.put("sesi", 6);
    map.put("septyni", 7);
    map.put("astuoni", 8);
    map.put("devyni", 9);
    System.out.println(map);
    System.out.println(map.get(new Integer(9)));
  }
}
