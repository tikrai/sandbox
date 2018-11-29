package dvinaryTree;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DvinaryTree<K extends Comparable<K>, V> implements Map<K, V> {
  private Node<K, V> top;
  private int size;

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return top == null;
  }

  @Override
  public boolean containsKey(Object key) {
    if (top == null) {
      return false;
    }
    try {
      return top.get((K) key) != null;
    } catch (ClassCastException e) {
      return false;
    }
  }

  @Override //todo
  public boolean containsValue(Object value) {
    return false;
  }

  @Override
  public V get(Object key) {
    if (top == null) {
      return null;
    }
    return top.get((K) key);
  }

  @Override
  public V put(K key, V value) {
    Node<K, V> newNode = new Node<>(key, value);
    if (top == null) {
      top = newNode;
      size++;
      return null;
    } else {
      Node<K, V> previousValue = top.put(newNode);
      if (previousValue == null) {
        size++;
        return null;
      } else {
        return previousValue.getValue();
      }
    }
  }

  @Override //todo
  public V remove(Object key) {
    return null;
  }

  @Override //todo
  public void putAll(Map<? extends K, ? extends V> m) {

  }

  @Override //todo
  public void clear() {

  }

  @Override //todo
  public Set<K> keySet() {
    return null;
  }

  @Override //todo
  public Collection<V> values() {
    return null;
  }

  @Override //todo
  public Set<Entry<K, V>> entrySet() {
    return null;
  }

  @Override
  public String toString() {
    return "{" + top + "}";
  }
}
