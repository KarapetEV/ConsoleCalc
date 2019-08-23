import java.util.Map;

public class RomanOperation {

    public void exec(String s1, char sym, String s2) throws InputException {
        int x = 0;
        int y = 0;
        for (Map.Entry<Integer,String> el: Calculator.nums.entrySet()) {
            if (el.getValue().equals(s1))
                x = el.getKey();
            if (el.getValue().equals(s2))
                y = el.getKey();
        }

        int result = 0;
        switch (sym) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                try {
                    result = x / y;
                    break;
                } catch (ArithmeticException e) {
                    throw new ArithmeticException("Ошибка! Деление на ноль!");
                }
            default:
                throw new InputException("Неверный ввод арифметического знака!");
        }

        System.out.println(arabToRoman(result));
    }

    public String arabToRoman(int x) {
        String num = "";

        if (x != 0) {
            while (x >= 50) {
                num += "L";
                x -= 50;
            }
            while (x >= 40) {
                num += "XL";
                x -= 40;
            }
            while (x >= 10) {
                num += "X";
                x -= 10;
            }
            while (x >= 9) {
                num += "IX";
                x -= 9;
            }
            while (x >= 5) {
                num += "V";
                x -= 5;
            }
            while (x >= 4) {
                num += "IV";
                x -= 4;
            }
            while (x >= 1) {
                num += "I";
                x -= 1;
            }
        } else {
            num = "0";
        }
        return num;
    }
}
