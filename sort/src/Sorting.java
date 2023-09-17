/******************************************************************************
 *  Compilation:  javac Sorting.java
 *  Execution:    java Sorting input.txt AlgorithmUsed
 *  Dependencies: StdOut.java In.java Stopwatch.java
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program to play with various sorting algorithms. 
 *
 *
 *  Example run:
 *  
 *  % java Sorting 2Kints.txt  2
 *
 ******************************************************************************/
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Sorting {
 /**
     * 
     * Sorts the numbers present in the file based on the algorithm provided.
     * 0 = Arrays.sort() (Java Default)
     * 1 = Bubble Sort
     * 2 = Selection Sort 
     * 3 = Insertion Sort 
     * 4 = Mergesort
     * 5 = Quicksort
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws Exception {
        In in = new In(args[0]);
        int typeMethod = Integer.parseInt(args[1]);
		  // Storing file input in an array
        // TODO: Generate 3 other arrays, b, c, d where
        // b contains sorted integers from a (You can use Java Arrays.sort() method)
        // c contains all integers stored in reverse order 
        // (you can have your own O(n) solution to get c from b
        // d contains almost sorted array 
        //(You can copy b to a and then perform (0.1 * d.length)  many swaps to acheive this.
        int[] a = in.readAllInts();
        int[] b = a;
        Arrays.sort(b);
        int[] c = arrayGen.reverseGen(b);
        int[] d = arrayGen.nearlySortedGen(b);
        //TODO:
        // Read the second argument and based on input select the sorting algorithm
        //  * 0 = Arrays.sort() (Java Default)
        //  * 1 = Bubble Sort
        //  * 2 = Selection Sort 
        //  * 3 = Insertion Sort 
        //  * 4 = Mergesort
        //  * 5 = Quicksort
        //  Perform sorting on a,b,c,d. Pring runtime for each case along with timestamp and record those. 
        // For runtime and priting, you can use the same code from Lab 4 as follows:
        // TODO: For each array, a, b, c, d:
        // TODO: Perform Sorting and store the result in an array
        String algorithmName;
        Stopwatch timer1 = new Stopwatch();
        algorithmName = sortMethod.mainSort(typeMethod,a,0,a.length-1);
        double time1 = timer1.elapsedTimeMillis();
        // time for array b
        Stopwatch timer2 = new Stopwatch();
        algorithmName = sortMethod.mainSort(typeMethod,b,0,b.length-1);
        double time2 = timer2.elapsedTimeMillis();
        //time for array c
        Stopwatch timer3 = new Stopwatch();
        algorithmName = sortMethod.mainSort(typeMethod,c,0,c.length-1);
        double time3 = timer3.elapsedTimeMillis();
        //time for array d
        Stopwatch timer4 = new Stopwatch();
        algorithmName = sortMethod.mainSort(typeMethod,b,0,b.length-1);
        double time4 = timer4.elapsedTimeMillis();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
          //TODO: Replace with your own netid
        String netID = "bzhang44";
          //TODO: Replace with the algorithm used 
        String algorithmUsed = algorithmName;
          //TODO: Replace with the  array used 
        String arrayUseda = "a", arrayUsedb = "b", arrayUsedc = "c", arrayUsedd = "d";
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUseda, time1, timeStamp, netID, args[0]);
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsedb, time2, timeStamp, netID, args[0]);
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsedc, time3, timeStamp, netID, args[0]);
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsedd, time4, timeStamp, netID, args[0]);
        //fileGen is used to output array as text file
        fileGen.addFile(a,"a.txt");
        fileGen.addFile(b,"b.txt");
        fileGen.addFile(c,"c.txt");
        fileGen.addFile(d,"d.txt");
        // Write the resultant array to a file (Each time you run a program 4 output files should be generated. (one for each a,b,c, and d)
  } 
} 


