package Default;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MainSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[] arr = null;
        menu(arr);
        sc.close();
    }

    public static void menu(float[] arr) {
        Scanner sc = new Scanner(System.in);

        System.out.println("+----------Menu--------+");
        System.out.println("|   1.Input            |");
        System.out.println("|   2.Output           |");
        System.out.println("|   3.Bubble sort      |");
        System.out.println("|   4.Selection sort   |");
        System.out.println("|   5.Insertion sort   |");
        System.out.println("|   6.Search > value   |");
        System.out.println("|   7.Search = value   |");
        System.out.println("|   8.Algo timer       |");
        System.out.println("|   0.Exit             |");
        System.out.println("+---------------------.+");
        System.out.print("Choice: ");
        int input = sc.nextInt();
        sc.nextLine();

        switch(input) {
            case 1 -> input(arr);
            case 2 -> output();
            case 3 -> bubbleSort(arr);
            case 4 -> selectSort(arr);
            case 5 -> insertSort(arr);
            case 6 -> searchGreatterVal(arr);
            case 7 -> searchEqualVal(arr);
            case 8 -> showAlgoTimer();
        }
        if (input == 0) {
            System.out.println("---See you next time!---");
            System.exit(0);
        } else {
            sc.nextLine();
            menu(arr);
        }
        sc.close();
    }

    public static void input(float[] arr) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input number of elements: ");
        int n = sc.nextInt();

        float[] numbers = new float[n];
        System.out.println("Input elements: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextFloat();
        }

        arr = Arrays.copyOf(numbers, numbers.length);

        try {
            Algo.writeFile("INPUT.TXT",arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public static void output() {
        try {
            float[] array = null;
            System.out.println("Read from file");
            System.out.print("Array a: ");
            array = Algo.readFile("INPUT.TXT");
            System.out.print(Arrays.toString(array));
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static void bubbleSort(float[] arr) {
        try {
            arr = Algo.readFile("INPUT.TXT");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Algo.bubbleSort(arr, "OUTPUT1.TXT");
    }

    public static void selectSort(float[] arr) {
        try {
            arr = Algo.readFile("INPUT.TXT");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Algo.selectionSort(arr, "OUTPUT2.TXT");
    }

    public static void insertSort(float[] arr) {
        try {
            arr = Algo.readFile("INPUT.TXT");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Algo.insertionSort(arr, "OUTPUT3.TXT");
    }

    public static void searchGreatterVal(float[] arr) {
        Scanner sc = new Scanner(System.in);
        try {
            arr = Algo.readFile("INPUT.TXT");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Linear Search");
        System.out.print("Input value: ");
        float value = sc.nextFloat();
        sc.nextLine();
        Algo.search(arr, value, "OUTPUT4.TXT");
    }

    public static void searchEqualVal(float[] arr) {
        Scanner sc = new Scanner(System.in);
        try {
            arr = Algo.readFile("INPUT.TXT");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Binary Search");
        System.out.print("Input value: ");
        float value = sc.nextFloat();
        sc.nextLine();

        String string = "Input value: " + value + "\n";
        int answer = Algo.binarySearch(arr, 0, arr.length-1, value);
        if (answer!= -1) {
            System.out.println("Indext of fist element: " + answer);
            string = string.concat("Indext of fist element: " + answer);
        } else {
            System.out.println("No found!");
            string = string.concat("No found!");
        }
        try {
            Algo.writeFile("OUTPUT5.TXT", string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void showAlgoTimer() {
        long[] des = new long[3];
        long[] as = new long[3];
        long[] rd = new long[3];
        float[] arr = null;

        try {
            arr = Algo.readFile("DESCENDINGARRAY.TXT");
        } catch (IOException e) {
            e.printStackTrace();
        }
        des[0] = AlgoTimer.bubbleSort(arr);
        des[1] = AlgoTimer.selectionSort(arr);
        des[2] = AlgoTimer.insertionSort(arr);

        try {
            arr = Algo.readFile("ASCENDINGARRAY.TXT");
        } catch (IOException e) {
            e.printStackTrace();
        }
        as[0] = AlgoTimer.bubbleSort(arr);
        as[1] = AlgoTimer.selectionSort(arr);
        as[2] = AlgoTimer.insertionSort(arr);

        try {
            arr = Algo.readFile("RANDOMARRAY.TXT");
        } catch (IOException e) {
            e.printStackTrace();
        }
        rd[0] = AlgoTimer.bubbleSort(arr);
        rd[1] = AlgoTimer.selectionSort(arr);
        rd[2] = AlgoTimer.insertionSort(arr);

        System.out.println("---------------------Algorithm Timer Report------------------");
        System.out.println("----------------------BubbleSort---SelectSort---InsertSort---");
        System.out.println("Descending array:        " + des[0] + "            " + des[1] + "             " + des[2]);
        System.out.println("Ascending array:         " + as[0] + "            " + as[1] + "             " + as[2]);
        System.out.println("Random array:            " + rd[0] + "            " + rd[1] + "             " + rd[2]);
    }
}
