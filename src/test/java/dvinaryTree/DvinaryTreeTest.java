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
    assertEquals(new Integer(3), i2);
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
    assertEquals(new Integer(1), tree.get("vienas"));
    assertEquals(new Integer(2), tree.get("du"));
    assertEquals(new Integer(3), tree.get("trys"));
    assertEquals(new Integer(4), tree.get("keturi"));
    assertEquals(new Integer(5), tree.get("penki"));
    assertEquals(new Integer(6), tree.get("sesi"));
    assertEquals(new Integer(7), tree.get("septyni"));
    assertEquals(new Integer(8), tree.get("astuoni"));
    assertEquals(new Integer(9), tree.get("devyni"));
    assertNull(tree.get("desimt"));
  }

  @Test(expected = ClassCastException.class)
  public void getFailsIfKeyWrongOnNonEmptyMap() {
    tree.put("vienas", 1);
    tree.get(new Integer(9));
  }

  @Test
  public void getFailsIfKeyWrongOnEmptyMap() {
    assertNull(tree.get(new Integer(9)));
  }

  @Test
  public void containsKey() {
    tree.put("vienas", 1);
    tree.put("du", 2);
    assertTrue(tree.containsKey("du"));
    assertFalse(tree.containsKey("devyni"));
    assertFalse(tree.containsKey(new Integer(9)));
  }
}