package Lab2;

public class SimpleSort {
    int[] a;
    int n;

    public SimpleSort(int[] a, int n){
        this.a = a;
        this.n = n;
    }

    public void selectSort() {
        int len = a.length;
        int minIndex;
        int minVal;
        int tmpIndex;
        int tmp;
        for (int i = 0; i <= len-2; i++) {
            minIndex = i;
            minVal = a[minIndex];
            tmpIndex = minIndex;
            for (int j = i+1; j <= len-1; j++) {
                if (a[j]<minVal) {
                    minVal = a[j];
                    tmpIndex = j;
                }
            }
            //swap(minIndex,tmpIndex)
            tmp = a[minIndex];
            a[minIndex] = a[tmpIndex];
            a[tmpIndex] = tmp;
        }
    }

    public void insertSort() {
        int j;
        int x;
        for (int i = 1; i < n; i++) {
            if(a[i] >= a[i-1]) continue;
            else {
                j = i;
                x = a[i];
                while (a[j] > a[j-1] && j>0) {
                    a[j-1] = a[j];
                    j--;
                }
                a[j] = x;
            }
        }
    }

    public int search(int val) {
        for (int i = 0; i < n; i++) {
            if (a[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public String display() {
        String answer = "";
        for (int i : a) {
            answer += i + " ";
        }
        return answer;
    }
}
