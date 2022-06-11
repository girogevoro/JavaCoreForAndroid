package lesson14;

public class ClassMain {

    public void shiftArray(int[] arrInt, int shift) {
        shift %= arrInt.length;
        int buf;

        if (shift < 0) {
            shift = arrInt.length + shift;
        }

        for (int i = 0; i < shift; i++) {
            buf = arrInt[arrInt.length - 1];
            for (int j = arrInt.length - 1; j > 0; j--) {
                arrInt[j] = arrInt[j - 1];
            }
            arrInt[0] = buf;
        }
    }

    public int sumArray4x4(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            String[] strings = arr[i];
            if (strings.length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < strings.length; j++) {
                String string = strings[j];
                try {
                    sum += Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("[%d:%d]", i, j), string);
                }
            }
        }
        return sum;
    }
}
