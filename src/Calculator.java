import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Calculator {
    final static Map<Integer, String> nums = new HashMap<>();

    //Заполняем множество парами арабских и соответствующих римских цифр
    static {
        String[] romanNums = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        for (int i = 0; i < 10; i++) {
            nums.put(i, romanNums[i]);
        }
    }

    public static void main(String[] args) throws IOException, InputException {
        //Ввод строки в консоль, далее разбивка в массив строк
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] inputArr = input.trim().split("\\s");

        //Проверка на правильность ввода:
        //при правильном вводе массив состоит из 3х элементов (2 числа и знак арифметической операции);
        //далее проверка на одинаковые числа (только арабские или только римские)
        if (inputArr.length != 3) {
            throw new InputException("Неверный ввод строки!");
        } else {
            run(inputArr);
        }
    }

    public static void run(String[] line) throws InputException {
        //проверка на правильный ввод арифметического знака (не более 1 символа)
        if (line[1].length() != 1) {
            throw new InputException("Неверный ввод арифметического знака!");
        } else {
            //проверка, введено число или строка (если число, то это арабские цифры, если нет - римские)
            try {
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[2]);
                //проверка на принадлежность к заданному диапазону арабских чисел (от 0 до 9)
                if (nums.containsKey(x) && nums.containsKey(y)) {
                    //создание экземпляра класса операций с арабскими цифрами и выполнение операции
                    ArabicOperation arabicOperation = new ArabicOperation();
                    arabicOperation.exec(x, line[1].charAt(0), y);
                } else {
                    throw new InputException("Неверный ввод чисел!");
                }
            } catch (NumberFormatException e) {
                //проверка на принадлежность к заданному диапазону римских чисел (от I до IX)
                if (nums.containsValue(line[0]) && nums.containsValue(line[2])) {
                    //создание экземпляра класса операций с римскими цифрами и выполнение операции
                    RomanOperation romanOperation = new RomanOperation();
                    romanOperation.exec(line[0], line[1].charAt(0), line[2]);
                } else {
                    throw new InputException("Неверный ввод чисел!");
                }
            }
        }
    }
}
