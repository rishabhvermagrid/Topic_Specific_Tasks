package Lambda_Functions_Map;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class LambdaFunctionMap {

    public static void main(String[] args) {

        Map<String, Function<Integer, Integer>> functionMap = new HashMap<>();

        // absolute value
        functionMap.put("abs", x -> Math.abs(x));

        // signum function
        functionMap.put("sgn", x -> {
            if (x > 0) return 1;
            else if (x < 0) return -1;
            else return 0;
        });

        // increment
        functionMap.put("increment", x -> x + 1);

        // decrement
        functionMap.put("decrement", x -> x - 1);

        // square
        functionMap.put("square", x -> x * x);


        // Testing
        int value = -5;

        System.out.println("abs: " + functionMap.get("abs").apply(value));
        System.out.println("sgn: " + functionMap.get("sgn").apply(value));
        System.out.println("increment: " + functionMap.get("increment").apply(value));
        System.out.println("decrement: " + functionMap.get("decrement").apply(value));
        System.out.println("square: " + functionMap.get("square").apply(value));
    }
}
