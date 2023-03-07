package task2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task2 {

    private static void BubbleSort(int[] numbers, Logger logger){

        int temp = 0;
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    count++;
                    String stringCounter = Integer.toString(count);
                    String arr = Arrays.toString(numbers);
                    logger.info("(" + stringCounter + ")" + " Iteration " + arr 
                    + " change from (" + numbers[j] + ") to (" + numbers[j+1] + ")");
                }
            }
        }

    }

    private static int[] FillArr(int[] arr, Random rnd){
        for (int i = 0; i < arr.length; i++)
            arr[i] = rnd.nextInt(1, 10);
        return arr;
    }

    public static void main(String[] args) throws SecurityException, IOException {

        System.out.println("\033[H\033[2J");

        Logger logger = Logger.getLogger(Task2.class.getName());
        SimpleFormatter sf = new SimpleFormatter();
        FileHandler fh = new FileHandler("task2/BubbleSortLogs.txt");
        fh.setFormatter(sf);
        logger.addHandler(fh);

        Random rnd = new Random();

        int[] numbers = new int [10];

        FillArr(numbers, rnd);
        BubbleSort(numbers, logger);

    }
}
