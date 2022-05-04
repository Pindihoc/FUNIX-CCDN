package LabOne;

public class Bubble {
    int n;
    int[] arr;

    public Bubble(int n, int[] arr) {
        this.n = n;
        this.arr = arr;
    }

    public void bubbleSort() {
        int i;
        boolean swapable;
        int c;
        int x = 0;
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
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();
            if(x==0) {
                System.out.println();
                x++;
            }
        } while (swapable);
    }
}
