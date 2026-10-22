import java.util.Scanner;
/**
 *
 * @author ADMIN
 */
public class SumUntilSentinelValueWeek4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        int total = 0;

        System.out.print("Enter a number (-1 to stop): ");
        num = sc.nextInt();

        while (num != -1) {
            total += num;

            System.out.print("Enter a number (-1 to stop): ");
            num = sc.nextInt();
        }

        System.out.println("Final Total: " + total);
    }
    
}
