import java.util.ArrayList;
import java.util.List;

public class Range {
    private final int start;
    private final int end;
    private final int step;

    public Range(int end) {
        this(0, end, 1);
    }

    public Range(int start, int end) {
        this(start, end, 1);
    }

    public Range(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    public List<Integer> getSequence() {
        List<Integer> sequence = new ArrayList<>();

        if (step > 0) {
            for (int i = start; i < end; i += step) {
                sequence.add(i);
            }
        } else if (step < 0) {
            for (int i = start; i > end; i += step) {
                sequence.add(i);
            }
        } else {
            sequence.add(start);
        }

        return sequence;
    }

    public static void main(String[] args) {
        Range r1 = new Range(5);
        Range r2 = new Range(2, 10);
        Range r3 = new Range(15, 1, -3);

        System.out.println("Range 1: " + r1.getSequence());
        System.out.println("Range 2: " + r2.getSequence());
        System.out.println("Range 3: " + r3.getSequence());
    }
}
