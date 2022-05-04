package Lab2;
public class App {
    public static void main(String[] args){
        int n=7;
        int[] a = {5,7,11,3,9,2,6};
        int val = 11;

        SimpleSort obj = new SimpleSort(a, n);
        obj.selectSort();
        System.out.println("1. selectSort(): " + obj.display());
        obj.insertSort();
        System.out.println("2. insertSort(): " + obj.display());
        System.out.println("Search(" + val + "): " + obj.search(val));
    }
}
