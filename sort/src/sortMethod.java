import java.util.Arrays;

public class sortMethod {
    //select which method should be used
    public static String mainSort(int methodType, int[] inputArray, int low, int high){
        if(methodType == 0) {
            javaSort(inputArray);
            return "Arrays.sort()";
        }
        else if(methodType == 1) {
            bubbleSort(inputArray);
            return "bubble Sort";
        }
        else if(methodType == 2){
            selectionSort(inputArray);
            return "Selection sort";
        }
        else if(methodType == 3){
            quickSort(inputArray,low,high);
            return "quicksort";
        }
        else if(methodType == 4){
            insertionSort(inputArray);
            return "insertion sort";
        }
        else if(methodType == 5){
            mergeSort(inputArray,low,high);
            return "merge sort";
        }
        return "";
    }
    //using Arrays.sort() method
    private static void javaSort(int[] inputArray){
        Arrays.sort(inputArray);
    }
    //bubble sort
    private static void bubbleSort(int[] inputArray){
        int n = inputArray.length;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n - i - 1; j ++){
                if(inputArray[j + 1] < inputArray[j])
                {
                    int tmp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = tmp;

                }
            }
        }
    }

    private static void selectionSort(int[] inputArray){
        int n = inputArray.length;
        for(int i = 0; i < n - 1; i ++){
            int smallIndex = i;
            for(int j = i + 1; j < n; j++){
                if(inputArray[j] < inputArray[smallIndex])
                {
                    smallIndex = j;
                }
            }
            int tmp = inputArray[smallIndex];
            inputArray[smallIndex] = inputArray[i];
            inputArray[i] = tmp;
        }
    }
    private static void insertionSort(int[] inputArray){
        int n = inputArray.length;
        for(int i = 1; i < n; i++){
            int j = i;
            while(j - 1 >= 0 && inputArray[j] < inputArray[j - 1]){
                int tmp = inputArray[j - 1];
                inputArray[j - 1] = inputArray[j];
                inputArray[j] = tmp;
                j--;
            }
        }
    }
    // code of quickSort and mergeSort are written based on code on Zybooks CSC172 data structure and algorithm
    private static void quickSort(int[] inputArray, int low, int high){
        if( low >= high) return;
        int middle = partition(inputArray, low, high);
        quickSort(inputArray,low,middle);
        quickSort(inputArray, middle + 1, high);
        return;
    }
    private static int partition(int[] inputArray, int low, int high){
        if(low >= high) return high;
        int middle = (low + high)/2;
        int pivot = inputArray[middle];
        boolean done = false;
        while(!done) {
            while( inputArray[low] < pivot) low++;
            while(inputArray[high] > pivot) high--;
            if( low >= high) done = true;
            else {
                int tmp = inputArray[low];
                inputArray[low] = inputArray[high];
                inputArray[high] = tmp;
            }
        }
        return high;
    }
    private static void mergeSort(int[] inputArray, int low, int high){
        int midPoint = (low + high) / 2;
        if(low < high){
            mergeSort(inputArray,low,midPoint);
            mergeSort(inputArray,midPoint + 1, high);
            merge(inputArray,low, midPoint,high);
        }
    }
    private static void merge(int[] inputArray, int low, int middle, int high){
        int mergeSize = high - low;
        int leftStart = low, rightStart = middle + 1, tmppos = 0;
        int[] tmpArray = new int[mergeSize + 1];
        while(leftStart <= middle && rightStart <= high){
            if( inputArray[leftStart] < inputArray[rightStart]){
                tmpArray[tmppos] = inputArray[leftStart];
                leftStart ++;
            }
            else {
                tmpArray[tmppos] = inputArray[rightStart];
                rightStart ++;
            }
            tmppos++;
        }
        while(leftStart <= middle)
        {
            tmpArray[tmppos] = inputArray[leftStart];
            leftStart++;
            tmppos++;
        }
        while(rightStart <= high)
        {
            tmpArray[tmppos] = inputArray[rightStart];
            rightStart++;
            tmppos++;
        }
        for(int i = 0; i <= mergeSize; i++)
        {
            inputArray[i + low] = tmpArray[i];
        }
    }


    public static void main(String[] args) {
        //test case
        int[] test = {20,1,25,2,3,7,9,43,66,98,78};
        int n = test.length;
        mergeSort(test,0,n-1);
        arrayGen.printArray(test);
    }
}
