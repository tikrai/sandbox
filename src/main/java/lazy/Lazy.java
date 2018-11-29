package lazy;

import java.util.function.Supplier;

public class Lazy {
  public static void main(String[] args) {
    System.out.println(eagerMatch(compute("bb"), compute("aa")));
    System.out.println(lazyMatch(() -> compute("bb"), () -> compute("aa")));
  }

  private static boolean compute(String str) {
    System.out.print("executing... "); // expensive computation here
    return str.contains("a");
  }
  private static String computes(String str) {
    System.out.print("executing... "); // expensive computation here
    return str.contains("a") ? "yes" : "no";
  }

  private static String eagerMatch(boolean b1, boolean b2) {
    return b1 && b2 ? "match" : "incompatible!";
  }

  private static String lazyMatch(Supplier<Boolean> a, Supplier<Boolean> b) {
    return a.get() && b.get() ? "match" : "incompatible!";
  }
}
