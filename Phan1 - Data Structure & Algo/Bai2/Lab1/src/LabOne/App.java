package LabOne;
import java.util.Scanner;
public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("n=");
        int n = sc.nextInt();

        System.out.print("a[]=");
        String s = sc.nextLine();
        if (s.equals("")) s = sc.nextLine();
        String[] ss = s.split(",");

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }

        Bubble a = new Bubble(n, arr);
        a.bubbleSort();
    }
}
