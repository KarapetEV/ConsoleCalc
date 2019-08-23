public class RomanNum {
    private int x;

    public RomanNum(int x) {
        this.x = x;
        System.out.println(arabToRoman(this.x));
    }

    public static String arabToRoman(int x) {
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