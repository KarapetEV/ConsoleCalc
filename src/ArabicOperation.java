public class ArabicOperation {


    public void exec(int x, char sym, int y) throws ArithmeticException, InputException {

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
        System.out.println(result);
    }
}
