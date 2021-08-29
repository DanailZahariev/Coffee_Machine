import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int first = numbers[0];
        int second = numbers[1];
        int third = numbers[2];
        if (second <= first && first <= third || third <= first && first <= second) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}