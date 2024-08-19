import java.util.Scanner;

public class ValueStorer {  
    private static final int NUM_VALUES = 3;  
    private static byte[] byteValues = new byte[NUM_VALUES];  
    private static short[] shortValues = new short[NUM_VALUES];  
  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
  
        for (int i = 0; i < NUM_VALUES; i++) {  
            int intValue = getValueFromUser(i + 1, scanner);  
            storeValue(intValue, i, scanner);  
        }  
  
        scanner.close();  
    }  
  
    private static int getValueFromUser(int index, Scanner scanner) {  
        System.out.println("Enter a value (" + index + "/" + NUM_VALUES + "): ");  
        return scanner.nextInt();  
    }  
  
    private static void storeValue(int intValue, int index, Scanner scanner) {  
        String range = getRange(intValue);  
        switch (range) {  
            case "BYTE":  
                byteValues[index] = (byte) intValue;  
                System.out.println("Value " + intValue + " stored in byte array.");  
                break;  
            case "SHORT":  
                shortValues[index] = (short) intValue;  
                System.out.println("Value " + intValue + " stored in short array.");  
                break;  
            default:  
                System.out.println("Out of range. Please re-enter the value.");  
                storeValue(getValueFromUser(index + 1, scanner), index, scanner);  
                break;  
        }  
    }  
  
    private static String getRange(int value) {  
        return (value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE) ? "BYTE" : 
               (value >= Short.MIN_VALUE && value <= Short.MAX_VALUE) ? "SHORT" : 
               "OUT_OF_RANGE";
    }  
}
