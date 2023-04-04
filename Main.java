import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入目标尺寸
        System.out.print("Enter target grid size: ");
        int targetGridSize = scanner.nextInt();


        System.out.print("Enter lower limit of width: ");
        int lowerWidth = scanner.nextInt();
        System.out.print("Enter upper limit of width: ");
        int upperWidth = scanner.nextInt();
        System.out.print("Enter lower limit of height: ");
        int lowerHeight = scanner.nextInt();
        System.out.print("Enter upper limit of height: ");
        int upperHeight = scanner.nextInt();
        System.out.print("Enter lower limit of length: ");
        int lowerLength = scanner.nextInt();
        System.out.print("Enter upper limit of length: ");
        int upperLength = scanner.nextInt();

        // 找出所有符合的体积
        List<Integer> volumes = new ArrayList<>();
        for (int width = lowerWidth; width <= upperWidth; width++) {
            for (int height = lowerHeight; height <= upperHeight; height++) {
                for (int length = lowerLength; length <= upperLength; length++) {
                    int grid = (width + height)*2 + length;
                    if (grid == targetGridSize) {
                        int volume = width * height * length;
                        volumes.add(volume);
                    }
                }
            }
        }

        // 找最小值,然后比较
        int minVolume = Integer.MAX_VALUE;
        int minWidth = 0;
        int minHeight = 0;
        int minLength = 0;
        for (int width = lowerWidth; width <= upperWidth; width++) {
            for (int height = lowerHeight; height <= upperHeight; height++) {
                for (int length = lowerLength; length <= upperLength; length++) {
                    int volume = width * height * length;
                    if (volumes.contains(volume) && volume < minVolume) {
                        minVolume = volume;
                        minWidth = width;
                        minHeight = height;
                        minLength = length;
                    }
                }
            }
        }

        // 打印
        System.out.println("Minimum Volume: " + minVolume);
        System.out.println("Width: " + minWidth);
        System.out.println("Height: " + minHeight);
        System.out.println("Length: " + minLength);

        scanner.close();
    }

}