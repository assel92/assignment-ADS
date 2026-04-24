public class Sorter {
    public void SelectionSort(int[] arr){
        int n = arr.length;
        for(int i =0; i<n-1; i++){
            int min = i;
            for(int j=i+1; j<n; j++){
                if(arr[j]< arr[min]){
                    min = j;
                }
            }
            int buff = arr[min];
            arr[min] = arr[i];
            arr[i] = buff;
        }
    }
    public void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public int[] generateRandomArray(int size){
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = (int) (Math.random()*100);
        }
        return arr;
    }
    public static void QuickSort(int[] arr) {
        QuickSort(arr, 0, arr.length-1);
    }
    private static void QuickSort(int[] arr, int low, int high){
        if(low<high){
            int pivot = arr[high];
            int i = low - 1;
            for (int j=low; j< high; j++){
                if (arr[j]<=pivot){
                    i++;
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j] = temp;
                }
            }
            int pivotIndex = i+1;
            int temp = arr[pivotIndex];
            arr[pivotIndex] = arr[high];
            arr[high] = temp;
            QuickSort(arr, low, pivotIndex - 1);
            QuickSort(arr, pivotIndex + 1, high);
        }
    }

}
