package Stream_sum_of_squares;


import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Stream_sum_of_squares {
    public static void main(String[] args) {
        int start = 1,end =10;
        int sum = IntStream.rangeClosed(start,end).map(x->x*x).sum();
        System.out.println(sum);
        OptionalInt maxi = IntStream.rangeClosed(start,end).max();
        System.out.println(maxi);
    }
}


/* IntStream represents a sequence of primitive int elements that supports operations like:
map, filter, sum, average, reduce */

/* Imperative Approach
public class SumOfSquares {

    public static void main(String[] args) {

        int first = 1;
        int last = 5;

        int sum = 0;

        for (int i = first; i <= last; i++) {
            sum += i * i;
        }

        System.out.println(sum);
    }
}
 */