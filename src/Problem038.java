// Project Euler problem 38
public class Problem038 {
    public static void main(String[] args) {
        // let the integer be x
        // x must begin with 9 since the example starts with a 9
        // x cannot have two, three, or five or more digits since there's no way to generate a 9-digit pandigital
        // so it must start with 9, and have four digits. n equals 2.
        
        String concatenatedProduct = "";
        for (int i = 9876; i >= 9123; i--) {
            concatenatedProduct = Integer.toString(i) + Integer.toString(2 * i);
            if (isPandigitalBase9(concatenatedProduct)) {
                break;
            }
        }
        System.out.println(concatenatedProduct);
    }
    
    // returns true if the digits are pandigital base 9, false otherwise
    public static boolean isPandigitalBase9(String digits) {
        if (digits.length() == 9) {
            if (digits.contains("1") && digits.contains("2") && digits.contains("3") && digits.contains("4") && 
                    digits.contains("5") && digits.contains("6") && digits.contains("7") && digits.contains("8") &&
                    digits.contains("9")) {
                return true;
            }
        }
        return false;
    }
}
