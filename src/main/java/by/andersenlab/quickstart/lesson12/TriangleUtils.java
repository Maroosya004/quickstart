package by.andersenlab.quickstart.lesson12;

public class TriangleUtils {

    private TriangleUtils() {
    }

    public static double triangleSquare(Triangle triangle) {
        if (triangle == null) {
            throw new IllegalArgumentException("Triangle can not be null!");
        }
        if (triangle.getA() <= 0 || triangle.getB() <= 0 || triangle.getC() <= 0) {
            throw new IllegalArgumentException("Triangle's side can not be negative!");
        }
        int a = triangle.getA();
        int b = triangle.getB();
        int c = triangle.getC();
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
