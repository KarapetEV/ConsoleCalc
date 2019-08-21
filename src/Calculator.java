import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Calculator {
    final static Map<Integer, String> nums = new HashMap<>();

    //Заполняем множество парами арабских и соответствующих римских цифр
    static {
        String[] romanNums = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        for (int i = 0; i < 10; i++) {
            nums.put(i, romanNums[i]);
        }
    }

    public static void main(String[] args) throws IOException, InputException {
        //Ввод строки в консоль, далее разбивка в массив строк
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] inputArr = input.split("\\s");

        //Проверка на правильность ввода:
        //при правильном вводе массив состоит из 3х элементов (2 числа и знак арифметической операции);
        //далее проверка на одинаковые числа (только арабские или только римские)
        if (inputArr.length != 3) {
            throw new InputException("Неверный ввод!");
        } else {
            run(inputArr);
        }
    }

    public static void run(String[] line) throws InputException {
        try {
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[2]);

            if (nums.containsKey(x) && nums.containsKey(y) && line[1].length() == 1) {
                ArabicOperation arabicOperation = new ArabicOperation();
                arabicOperation.exec(x, line[1].charAt(0), y);
            } else {
                throw new InputException("Неверный ввод!");
            }
        } catch (Exception e) {
            if (nums.containsValue(line[0]) && nums.containsValue(line[2]) && line[1].length() == 1) {
                RomanOperation romanOperation = new RomanOperation();
                romanOperation.exec(line[0], line[1].charAt(0), line[0]);
            } else {
                throw new InputException("Неверный ввод!");
            }
        }
    }
}