import java.util.Scanner;

public class ValueStorer {  
    
    static int NUM_VALUES = 3;  
    
   static  byte[] byteValues = new byte[NUM_VALUES];  
   static  short[] shortValues = new short[NUM_VALUES];  
  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
  
        for (int i = 0; i < 3; i++) {  // Loop to ask the user for 3 values
            System.out.println("Enter a value (" + (i + 1) + "/3): ");  
            int intValue = scanner.nextInt();  
            
            String range = getRange(intValue);  
            switch (range) {  
                case "byte":  
                    
                    byteValues[i] = (byte) intValue;  
                    System.out.println("Value " + intValue + " stored in byte array.");  
                    break;  
                case "short":  
                   
                    shortValues[i] = (short) intValue;  
                    System.out.println("Value " + intValue + " stored in short array.");  
                    break;  
                default:  
                    
                    System.out.println("Out of range.");  
                    break;  
            }  
        }  
  
        scanner.close();  
    }  
  
   
    private static String getRange(int value) {  
        if (value >= -128 && value <= 127) {
            return "BYTE";
        } else if (value >= -32768 && value <= 32767) {
            return "SHORT";
        } else {
            return "OUT_OF_RANGE";
        }
    }  
}
