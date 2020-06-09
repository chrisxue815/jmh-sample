package bench;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.ThreadLocalRandom;

@State(Scope.Benchmark)
public class SampleBenchmark {

    private int a;
    private int b;

    @Setup(Level.Iteration)
    public void setup() {
        a = ThreadLocalRandom.current().nextInt();
        b = ThreadLocalRandom.current().nextInt();
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 2)
    public int bitwiseAnd() {
        return a & b;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 2)
    public int modulus() {
        return a % b;
    }
}
