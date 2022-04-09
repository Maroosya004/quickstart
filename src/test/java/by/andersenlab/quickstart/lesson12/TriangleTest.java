package by.andersenlab.quickstart.lesson12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    public void given_correctResult_calculation_shows_noError() {
        Triangle triangle = new Triangle(4, 6, 7);
        double result = TriangleUtils.triangleSquare(triangle);
        Assertions.assertEquals(11.97, result, 0.01);
    }

    @Test
    public void given_null_when_calculation_throws_illegalArgumentException() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> TriangleUtils.triangleSquare(null)
        );
    }

    @Test
    public void given_negativeValueOfTriangle_when_calculation_throws_illegalArgumentException() {
        Triangle triangle = new Triangle(4, 6, -7);
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> TriangleUtils.triangleSquare(triangle)
        );
    }
}
