package Default;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Algo {
    /**
    * Writing the array read from input array arr to file
    * @param fileName The file name of file to write value
    * @param arr      The input float array
    * @throws IOException
    */
    public static void writeFile(String fileName, float[] arr) throws IOException {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(fileName);
            String string = Arrays.toString(arr);
            byte[] byteArr = string.getBytes();
            out.write(byteArr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
    * Writing the array read from input array arr to file
    * @param fileName The file name of file to write value
    * @param string      The input string
    * @throws IOException
    */
    public static void writeFile(String fileName, String string) throws IOException {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(fileName);
            byte[] byteArr = string.getBytes();
            out.write(byteArr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
    * Reading the file then input to the array arr
    * @param fileName The file name of file to read
    * @return Returning a array read from the file
    * @throws IOException
    */
    public static float[] readFile(String fileName) throws IOException {
        FileInputStream in = null;
        float[] arr = null;
        int c;
        String string = "";
        try {
            in = new FileInputStream(fileName);
            while ((c = in.read()) != -1) {
                string += (char)c;
            }
            string = string.substring(1,string.length()-1);
            String[] s = string.split(","); // \\s stand for white-space
            int len = s.length;
            float[] a = new float[len];
            for (int i = 0; i < len; i++) {
                a[i] = Float.parseFloat(s[i]);
            }
            arr = a;
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (in!= null) {
                in.close();
            }
        }

        return arr;
    }

    /**
    * Sorting the input array arr using Bubble Sort algorithm.
    * @param arr Input array using for sorting
    * @return Returning a sorted array by using the Bubble Sort algorithm
    */

    public static float[] bubbleSort(float[] arr, String fileName) {
        int i;
        boolean swapable;
        float c;
        String string = "Bubble sort \n";
        System.out.print(string);

        do {
            swapable = false;
            for (i = 0; i < arr.length-1; i++) {
                if (arr[i] > arr[i+1]) {
                    c = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = c;
                    swapable = true;
                }
            }

            System.out.println(Arrays.toString(arr));
            string = string.concat(Arrays.toString(arr)).concat("\n");
        } while (swapable);

        try {
            Algo.writeFile(fileName, string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arr;
    }

    /**
    * Sorting the input array arr using Selection Sort algorithm.
    * @param arr Input array using for sorting
    * @return Returning a sorted array by using the Selection Sort algorithm
    */

    public static float[] selectionSort(float[] arr, String fileName) {
        int len = arr.length;
        int minIndex;
        float minVal;
        int tmpIndex;
        float tmp;

        String string = "Selection sort \n";
        System.out.print(string);

        for (int i = 0; i <= len-2; i++) {
            minIndex = i;
            minVal = arr[minIndex];
            tmpIndex = minIndex;
            for (int j = i+1; j <= len-1; j++) {
                if (arr[j]<minVal) {
                    minVal = arr[j];
                    tmpIndex = j;
                }
            }
            //swap(minIndex,tmpIndex)
            tmp = arr[minIndex];
            arr[minIndex] = arr[tmpIndex];
            arr[tmpIndex] = tmp;

            System.out.println(Arrays.toString(arr));
            string = string.concat(Arrays.toString(arr)).concat("\n");
        }

        try {
            Algo.writeFile(fileName, string);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arr;
    }

    /**
    * Sorting the input array arr using Insertion Sort algorithm.
    * @param arr Input array using for searching
    * @return Returning a sorted array by using the Insertion Sort algorithm
    */

    public static float[] insertionSort(float[] arr, String fileName) {
        int n = arr.length;
        int j;
        float x;

        String string = "Insertion sort \n";
        System.out.print(string);

        for (int i = 1; i < n; i++) {
            if(arr[i] >= arr[i-1]) continue;
            else { //i=4
                j = i;
                x = arr[i];
                while (j>0 && x < arr[j-1]) {
                    arr[j] = arr[j-1];
                    j--;
                }
                arr[j] = x;
            }

            System.out.println(Arrays.toString(arr));
            string = string.concat(Arrays.toString(arr)).concat("\n");
        }

        try {
            Algo.writeFile(fileName, string);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arr;
    }

    /**
    * Searching the indices of elements in array [arr] greater than value. Printing
    * and writing all indices to the console screen and file OUTPUT4.TXT separated by space.
    * @param arr   Input array using for searching
    * @param value The value for searching
    */

    public static void search(float[] arr, float value, String fileName) {
        int n = arr.length;
        String string="Input Value: " +value + "\nIndexs thats match: -";
        System.out.print("Indexs thats match: ");
        for (int i = 0; i < n; i++) {
            if (arr[i] > value) {
                System.out.print(i + " ");
                string += "; " + i;
            }
        }
        System.out.println();

        try {
            Algo.writeFile(fileName, string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * Searching by using the Binary Search algorithm. Returning the first index of
    * value if it is present in array arr, otherwise, return -1. The index also
    * written to file OUTPUT5.TXT and shown on the console screen.
    * @param arr   Input array using for searching
    * @param left  The left index
    * @param right The right index
    * @param value The value for searching
    * @return The index of the element if found, otherwise, return -1
    */

    public static int binarySearch(float[] arr, int left, int right, float value) {
        //array sorting
        int n = arr.length;
        int j;
        float x;
        for (int i = 1; i < n; i++) {
            if(arr[i] >= arr[i-1]) continue;
            else { //i=4
                j = i;
                x = arr[i];
                while (j>0 && x < arr[j-1]) {
                    arr[j] = arr[j-1];
                    j--;
                }
                arr[j] = x;
            }
        }
        //binary searching
        int i = (left + right)/2;
        do {
            if (arr[i] == value) {
                return i;
            } else if (arr[i] < value) {
                left = i;
                i = (left + right)/2;
            }
            else { // here arr[i] > value
                right = i;
                i = (left + right)/2;
            }
        } while (right-left!=1);
        if (arr[left] == value) {
            return left;
        } else if (arr[right] == value) {
            return right;
        }
        return -1;
    }
}