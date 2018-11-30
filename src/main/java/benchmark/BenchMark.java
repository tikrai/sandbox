package benchmark;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;

/**
 * @author Satalia Team.
 */
public class BenchMark {

  public static void main(String[] args) throws Exception {
    org.openjdk.jmh.Main.main(args);
  }

  @Benchmark
  @Fork(value = 1, warmups = 0)
  public void newHashset() {
    Set<String> stringSet1 = new HashSet<>(Arrays.asList(
        "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a0",  
        "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b0",  
        "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c0",  
        "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d0",  
        "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "e0",  
        "f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f0",  
        "g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8", "g9", "g0",  
        "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h0"
    ));
  }

  @Benchmark
  @Fork(value = 1, warmups = 0)
  public void streamToSet() {
    Set<String> stringSet2 = Stream.of(
        "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a0",
        "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b0",
        "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c0",
        "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d0",
        "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "e0",
        "f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f0",
        "g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8", "g9", "g0",
        "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h0"
    ).collect(Collectors.toSet());
  }
}

//  Benchmark               Mode  Cnt       Score       Error  Units
//  BenchMark.newHashset   thrpt  200  845559.859 ± 19692.896  ops/s
//  BenchMark.streamToSet  thrpt  200  611906.182 ± 12426.586  ops/s

