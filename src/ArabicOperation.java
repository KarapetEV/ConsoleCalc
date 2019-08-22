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
                try {
                    result = x / y;
                    break;
                } catch (ArithmeticException e) {
                    throw new ArithmeticException("Ошибка! Деление на ноль!");
                }
            default:
                throw new InputException("Неверный ввод арифметического знака!");
        }
        System.out.println(result);
    }
}
