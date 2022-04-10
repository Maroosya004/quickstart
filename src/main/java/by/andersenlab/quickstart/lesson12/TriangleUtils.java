package by.andersenlab.quickstart.lesson12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleUtils {

    private static final Logger logger = LoggerFactory.getLogger(TriangleUtils.class);

    private TriangleUtils() {
    }

    public static double triangleSquare(Triangle triangle) {
        if (triangle == null) {
            logger.error("Triangle can not be null!");
            throw new IllegalArgumentException("Triangle can not be null!");
        }
        if (triangle.getA() <= 0 || triangle.getB() <= 0 || triangle.getC() <= 0) {
            logger.error("Triangle's side can not be negative!");
            throw new IllegalArgumentException("Triangle's side can not be negative!");
        }
        int a = triangle.getA();
        int b = triangle.getB();
        int c = triangle.getC();
        double p = (a + b + c) / 2.0;
        double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        logger.info("Triangle sides: {}, {}, {}, The square of triangle equals: {}", a, b, c, result);
        return result;
    }
}
