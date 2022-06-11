package lesson14;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ClassMainTest {

    private static ClassMain classMain;

    @BeforeAll
    static void initAll() {
        System.out.println("Test ClassMain start");
        classMain = new ClassMain();
    }

    @AfterAll
    static void end() {
        System.out.println("Test ClassMain Finish");
    }

    @Test
    void shiftArray() {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        classMain.shiftArray(arr1, 1);
        Assertions.assertArrayEquals(arr2, arr1);

        arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        arr2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        classMain.shiftArray(arr1, arr1.length);
        Assertions.assertArrayEquals(arr2, arr1);

        arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        arr2 = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
        classMain.shiftArray(arr1, -2);
        Assertions.assertArrayEquals(arr2, arr1);
    }

    @DisplayName("Параметризованный тест сдвига")
    @ParameterizedTest
    @MethodSource("arrayData")
    void shiftArrayParameter(int[] expected, int[] actual, int shift) {
        classMain.shiftArray(actual, shift);
        Assertions.assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> arrayData() {
        return Stream.of(
                Arguments.arguments(new int[]{7867, 68, 63, 42, 45, 565, 766, -76, 6787},
                        new int[]{45, 565, 766, -76, 6787, 7867, 68, 63, 42},
                        4),
                Arguments.arguments(new int[]{1},
                        new int[]{1},
                        149),
                Arguments.arguments(new int[]{3, 1, 2},
                        new int[]{1, 2, 3},
                        10)
        );
    }

    @Test
    void sumArray4x4Throws() {
        Assertions.assertThrows(MyArraySizeException.class, () -> classMain.sumArray4x4(new String[4][5]));
        Assertions.assertThrows(MyArraySizeException.class, () -> classMain.sumArray4x4(new String[3][4]));
        var arr1 = new String[][]{
                {"1", "2", "3", "4"},
                {"1"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};
        Assertions.assertThrows(MyArraySizeException.class, () -> classMain.sumArray4x4(arr1));
        var arr2 = new String[][]{
                {"1", "2", "3", "abc4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};
        Assertions.assertThrows(MyArrayDataException.class, () -> classMain.sumArray4x4(arr2));
    }

    @Test
    void sumArray4x4() {
        var strings = new String[][]{
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}};
        Assertions.assertDoesNotThrow(() -> Assertions.assertEquals(16, classMain.sumArray4x4(strings)));
    }
}