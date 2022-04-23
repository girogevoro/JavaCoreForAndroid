package lesson5;

import java.util.Random;
import java.util.Scanner;

public class TicTakToe {
    static int sizeMap;
    static int sizeWin;
    static int[][] map;
    static final int ID_EMPTY = 0;
    static final int ID_HUMAN = 1;
    static final int ID_AI = 2;

    static final int MIN_SIZE_MAP = 3;

    static final char[] DOT_FIELD = {'•', 'x', '0'};

    static int last_move_row;
    static int last_move_col;
    static int countFillMap;
    static int maxFillMap;

    static  int countDigitsInSizeMap;

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        startNewGame();
    }

    public static void startNewGame() {
        do {
            input();
            initMap();
            playGame();
        } while (isContinue());
        exitGame();
    }

    private static void exitGame() {
        scanner.close();
        System.out.println("Игра закончена. До завтра.");
    }

    private static void playGame() {
        do {

            moveHuman();
            printMap();
            if (checkEnd(ID_HUMAN)) {
                break;
            }
            moveAI();
            printMap();
            if (checkEnd(ID_AI)) {
                break;
            }
        } while (true);

    }

    private static boolean isContinue() {
        System.out.println("Начать заного? y\\n");
        return switch (scanner.next()) {
            case "y", "Y", "н", "Н", "yes", "да", "+" -> true;
            default -> false;
        };
    }

    private static boolean checkEnd(int id) {
        if (isDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        if (isWin(ID_HUMAN)) {
            System.out.println("Победа!");
            return true;
        }
        if (isWin(ID_AI)) {
            System.out.println("Увы вы проиграли");
            return true;
        }
        return false;
    }

    private static boolean isWin(int id) {
        return isWinHorizontally(id) || isWinVertically(id) || isWinDiagonally1(id) || isWinDiagonally2(id);
    }

    private static boolean isWinHorizontally(int id) {
        int n = 0;
        for (int i = 0; i < sizeMap; i++) {
            if (map[last_move_row][i] == id) {
                n++;
                if (n == sizeWin) {
                    return true;
                }
            } else {
                n = 0;
            }
        }
        return false;
    }

    private static boolean isWinVertically(int id) {
        int n = 0;
        for (int i = 0; i < sizeMap; i++) {
            if (map[i][last_move_col] == id) {
                n++;
                if (n == sizeWin) {
                    return true;
                }
            } else {
                n = 0;
            }
        }
        return false;
    }

    private static boolean isWinDiagonally1(int id) {
        int beginRow, beginCol;
        int delta = last_move_row - last_move_col;
        int n = 0;
        if (delta > 0) {
            beginCol = 0;
            beginRow = delta;
        } else {
            beginRow = 0;
            beginCol = Math.abs(delta);
        }

        for (int i = beginRow, j = beginCol; i < sizeMap && j < sizeMap; i++, j++) {
            if (map[i][j] == id) {
                n++;
                if (n == sizeWin) {
                    return true;
                }
            } else {
                n = 0;
            }
        }
        return false;
    }

    private static boolean isWinDiagonally2(int id) {
        int beginRow, endCol;
        int maxCol = sizeMap - 1;
        int delta = (maxCol - last_move_col) - last_move_row;
        int n = 0;
        if (delta > 0) {
            beginRow = 0;
            endCol = maxCol - delta;
        } else {
            endCol = maxCol;
            beginRow = Math.abs(delta);
        }
        for (int i = beginRow, j = endCol; i < sizeMap && j >= 0; i++, j--) {
            if (map[i][j] == id) {
                n++;
                if (n == sizeWin) {
                    return true;
                }
            } else {
                n = 0;
            }
        }
        return false;
    }

    private static boolean isDraw() {
        return countFillMap >= maxFillMap;
    }

    private static void moveAI() {
        System.out.println("Ход ИИ");
        do {
            last_move_row = random.nextInt(sizeMap);
            last_move_col = random.nextInt(sizeMap);
        } while (!isCellFree());
        putMap(ID_AI);
    }

    private static void moveHuman() {

        while (true) {
            System.out.println("Ход человека");
            System.out.println("Введите строку");
            last_move_row = inputNumber() - 1;
            System.out.println("Введите столбец");
            last_move_col = inputNumber() - 1;
            if (isCellFree()) {
                putMap(ID_HUMAN);
                break;
            }
            System.out.println("#Ячейка уже занята или не существует\n");
        }


    }

    private static int inputNumber() {

        while (true){
            if(scanner.hasNextInt()){
                return scanner.nextInt();
            }
            scanner.next();
            System.out.println("#Введите число");
        }
    }

    private static void putMap(int id) {
        map[last_move_row][last_move_col] = id;
        countFillMap++;
    }

    private static boolean isCellFree() {
        if (last_move_row < 0 || last_move_row >= sizeMap || last_move_col < 0 || last_move_col >= sizeMap) {
            return false;
        }
        return map[last_move_row][last_move_col] == ID_EMPTY;
    }

    private static void input() {
        System.out.println("Начало новый игры");
        System.out.println("Введите размер поля");
        do {
            sizeMap = inputNumber();
            if(sizeMap >= MIN_SIZE_MAP){
                break;
            }
            System.out.println("#Размер поля должно быть не меньше 3");
        } while (true);

        countDigitsInSizeMap = getCountDigits(sizeMap);

        sizeWin = getWinningStreak(sizeMap);
        System.out.printf("Начало новой игры\nРазмер поля %d \nДлина победной серии %d\n\n\n", sizeMap, sizeWin);


    }

    private static int getCountDigits(int number) {
        return (int)Math.ceil(Math.log10(number + 0.5));
    }

    private static void initMap() {
        countFillMap = 0;
        maxFillMap = sizeMap * sizeMap;
        map = new int[sizeMap][sizeMap];
        for (int i = 0; i < sizeMap; i++) {
            for (int j = 0; j < sizeMap; j++) {
                map[i][j] = ID_EMPTY;
            }
        }

    }

    private static void printMap() {
        String screenMap = putScreenHeader();
        screenMap = putScreenBody(screenMap);
        System.out.println(screenMap);
    }

    private static String putScreenHeader() {
        StringBuilder headerLine = new StringBuilder();
        headerLine.append(getFormat(""));
        for (int i = 0; i < sizeMap; i++) {
            headerLine.append(" ").append(getFormat(String.valueOf(i + 1)));
        }
        headerLine.append("\n");
        return headerLine.toString();

    }

    private static String putScreenBody(String screen) {
        StringBuilder screenBuilder = new StringBuilder(screen);
        for (int i = 0; i < sizeMap; i++) {
            screenBuilder.append(getScreenLine(i));
        }
        return screenBuilder.toString();
    }

    private static String getFormat(String str) {
        return String.format("%" + countDigitsInSizeMap + "s", str);
    }

    private static String getScreenLine(int i) {
        StringBuilder line = new StringBuilder();
        line.append(getFormat(String.valueOf(i + 1)));
        for (int j = 0; j < sizeMap; j++) {
            line.append(" ").append(getFormat(String.valueOf(DOT_FIELD[map[i][j]])));
        }
        line.append("\n");
        return line.toString();
    }

    private static int getWinningStreak(int sizeMap) {
        if (sizeMap < 6) {
            return 3;
        } else if (sizeMap < 11) {
            return 4;
        } else {
            return 5;
        }
    }
}
