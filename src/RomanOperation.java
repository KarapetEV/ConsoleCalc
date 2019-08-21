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
                if (y == 0) {
                    throw new ArithmeticException("Ошибка! Деление на ноль!");
                } else {
                    result = x / y;
                    break;
                }
            default:
                throw new InputException("Неверный ввод!");
        }
        for (Map.Entry<Integer,String> el: Calculator.nums.entrySet()) {
            if (el.getKey() == result)
                System.out.println(el.getValue());
        }
    }
}