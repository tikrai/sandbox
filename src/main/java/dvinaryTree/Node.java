package dvinaryTree;

import java.util.ArrayList;

public class Node<K extends Comparable<K>, V> implements Comparable<Node<K, V>> {
  private K key;
  private V value;
  private Node<K, V> smaller;
  private Node<K, V> bigger;

  public Node(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public Node<K, V> put(Node<K, V> node) {
    if (node.compareTo(this) > 0) {
      if (bigger == null) {
        bigger = node;
        return null;
      } else {
        return bigger.put(node);
      }
    }
    if (node.compareTo(this) < 0) {
      if (smaller == null) {
        smaller = node;
        return null;
      } else {
        return smaller.put(node);
      }
    }
    Node<K, V> returnNode = new Node<>(key, value);
    value = node.value;
    return returnNode;
  }

  public V get(K key) {
    if (key.compareTo(this.key) > 0) {
      if (bigger == null) {
        return null;
      }
      return bigger.get(key);
    }
    if (key.compareTo(this.key) < 0) {
      if (smaller == null) {
        return null;
      }
      return smaller.get(key);
    }
    return value;
  }

  public V getValue() {
    return value;
  }

//  public K getKey() {
//    return key;
//  }

  @Override
  public int compareTo(Node<K, V> o) {
    return key.compareTo(o.key);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (smaller != null) {
      sb.append(smaller).append(", ");
    }
    sb.append(key).append("=").append(value);
    if (bigger != null) {
      sb.append(", ").append(bigger);
    }
    return sb.toString();
  }
}
