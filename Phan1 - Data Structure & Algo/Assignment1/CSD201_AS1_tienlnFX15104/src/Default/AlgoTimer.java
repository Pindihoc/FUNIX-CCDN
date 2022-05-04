package Default;

public class AlgoTimer {
    /**
    * Sorting the input array arr using Bubble Sort algorithm.
    * @param arr Input array using for sorting
    * @return Returning a timer (in mili-second) after using the Bubble Sort algorithm
    */
    public static long bubbleSort(float[] arr) {
        long timer = 0;
        final long startTime = System.nanoTime();
        int i;
        boolean swapable;
        float c;

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
        } while (swapable);

        final long endTime = System.nanoTime();
        timer = endTime - startTime;
        
        return timer;
    }

    /**
    * Sorting the input array arr using Selection Sort algorithm.
    * @param arr Input array using for sorting
    * @return Returning a timer (in mili-second) after using the Selection Sort algorithm
    */

    public static long selectionSort(float[] arr) {
        long timer = 0;
        final long startTime = System.nanoTime();

        int len = arr.length;
        int minIndex;
        float minVal;
        int tmpIndex;
        float tmp;

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
        }

        final long endTime = System.nanoTime();
        timer = endTime - startTime;

        return timer;
    }

    /**
    * Sorting the input array arr using Insertion Sort algorithm.
    * @param arr Input array using for searching
    * @return Returning a timer (in mili-second) after using the Insertion Sort algorithm
    */

    public static long insertionSort(float[] arr) {
        long timer = 0;
        final long startTime = System.nanoTime();

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

        final long endTime = System.nanoTime();
        timer = endTime - startTime;

        return timer;
    }
}