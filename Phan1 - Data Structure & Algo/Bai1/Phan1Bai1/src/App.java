public class App {
    public static void main(String[] args) {
        // code to execute
        System.out.println("hello");
    }

    public static int euclidAlgo(int m, int n) {
        if (m < n) return -1;
        int r;
        do {
            r = m % n;
            m = n;
            n = r;
        }
        while(r!= 0);
        // right here m->n
        return m;
    }

    public static void bubbleSort(int[] arr) {
        int i;
        boolean swapable;
        int c;
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
    }

    public static void selectionSort(int[] arr) { //simple selection sort
        int len = arr.length;
        int minIndex;
        int minVal;
        int tmpIndex;
        int tmp;
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
    }
}
