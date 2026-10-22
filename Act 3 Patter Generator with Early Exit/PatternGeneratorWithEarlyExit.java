/**
 *
 * @author ADMIN
 */
public class PatternGeneratorWithEarlyExitWeek4 {
    public static void main(String[] args) {
        
        int size = 10;

        for (int a = 1; a <= size; a++) {

            for (int b = 1; b <= a; b++) {

                if (b == 9) {
                    break; // stops the inner loop when j reaches 9.
                }

                if (b == 7) {
                    continue; // skips printing the number 7.
                }

                System.out.print("^ ");
            }
            
            System.out.println();
        }    
    }
    
}
