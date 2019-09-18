import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.deepEquals;
import static junit.framework.TestCase.assertTrue;

public class NeoTest {


    private Neo neo;
    private int[][] test1 = new int[][]{
            {1, 2, 3},
            {7, 8, 9}
    };

    private int[][] test2 = new int[][]{
            {1, 3},
            {4, 6},
            {7, 9}
    };

    private int[][] test3 = new int[][]{
            {1, 2, 3},
            {4, 5, 6}
    };

    private int[][] test4 = new int[][]{
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
    };

    @Before
    public void init() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        neo = new Neo(3, 3, matrix);
    }


    @Test
    public void removeRowTest() {
        neo.removeRow(2);
        assertTrue(deepEquals(neo.getMatrix(), test1));
    }

    @Test
    public void removeColumnTest() {
        neo.removeColumn(2);
        assertTrue(deepEquals(neo.getMatrix(), test2));
    }

    @Test
    public void extractSubMatrixTest() {
        neo.extractSubMatrix(1, 2, 1, 3);
        assertTrue(deepEquals(neo.getMatrix(), test3));
    }

    @Test
    public void transponeTest() {
        neo.transpone();
        assertTrue(deepEquals(neo.getMatrix(), test4));
    }
}
