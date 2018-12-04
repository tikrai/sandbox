package dvinaryTree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DvinaryTreeTest {

  DvinaryTree<String, Integer> tree;

  @Before
  public void setup() {
    tree = new DvinaryTree<>();
  }

  @Test
  public void size() {
    tree.put("trys", 3);
    tree.put("trys", null);
    tree.put("trys", null);
    tree.put("trys", null);
    tree.put("trys", 41);
    assertEquals(1, tree.size());
  }

  @Test
  public void put() {
    Integer i1 = tree.put("trys", 3);
    Integer i2 = tree.put("trys", 4);
    assertNull(i1);
    assertEquals(Integer.valueOf(3), i2);
  }

  @Test
  public void isEmpty() {
    assertTrue(tree.isEmpty());
    tree.put("trys", 3);
    assertFalse(tree.isEmpty());
  }

  @Test
  public void get() {
    tree.put("vienas", 1);
    tree.put("du", 2);
    tree.put("trys", 3);
    tree.put("keturi", 4);
    tree.put("penki", 5);
    tree.put("sesi", 6);
    tree.put("septyni", 7);
    tree.put("astuoni", 8);
    tree.put("devyni", 9);
    assertEquals(Integer.valueOf(1), tree.get("vienas"));
    assertEquals(Integer.valueOf(2), tree.get("du"));
    assertEquals(Integer.valueOf(3), tree.get("trys"));
    assertEquals(Integer.valueOf(4), tree.get("keturi"));
    assertEquals(Integer.valueOf(5), tree.get("penki"));
    assertEquals(Integer.valueOf(6), tree.get("sesi"));
    assertEquals(Integer.valueOf(7), tree.get("septyni"));
    assertEquals(Integer.valueOf(8), tree.get("astuoni"));
    assertEquals(Integer.valueOf(9), tree.get("devyni"));
    assertNull(tree.get("desimt"));
  }

  @Test(expected = ClassCastException.class)
  public void getFailsIfKeyWrongOnNonEmptyMap() {
    tree.put("vienas", 1);
    tree.get(Integer.valueOf(9));
  }

  @Test
  public void getFailsIfKeyWrongOnEmptyMap() {
    assertNull(tree.get(Integer.valueOf(9)));
  }

  @Test
  public void containsKey() {
    tree.put("vienas", 1);
    tree.put("du", 2);
    assertTrue(tree.containsKey("du"));
    assertFalse(tree.containsKey("devyni"));
    assertFalse(tree.containsKey(Integer.valueOf(9)));
  }
}