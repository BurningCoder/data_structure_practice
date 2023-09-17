import java.util.Vector;

public class arrayGen {
    public static void printArray(int[] inputArray){
        for(int i = 0; i < inputArray.length; i++){
            System.out.print(inputArray[i]+",");
        }
        System.out.println();
    }
    // take in array a and generate a reverse order of a
    public static int[] reverseGen(int[] a) {
        int n = a.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = a[n - 1 - i];
        }
        return ans;
    }
    // take in sorted array a and generate a nearly sorted array of a
    public static int[] nearlySortedGen(int[] a){
        int[] ans = a;
        Vector<Integer> x = new Vector<Integer>();
        x.add(-1);
        int n = a.length;
        int t = n, cnt = 0;
        while( t != 0)
        {
            t /= 10;
            cnt++;
        }
        for(int i = 0; i < cnt; i ++){
            Integer index = (int)(Math.random()*n);

            if(!x.contains(index) || !x.contains(n - 1 - index)){
                x.add(index);
                x.add(n - 1 - index);
                int tmp = ans[index];
                ans[index] = ans[n - 1 -index];
                ans[n - 1 - index] = tmp;
            }
            else{
                i --;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4,5,6,7,8,9,10,11};
        printArray(nearlySortedGen(test));
    }
}
