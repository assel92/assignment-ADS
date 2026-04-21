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
    public void generateRandomArray(int size){
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = (int) (Math.random()*100);
        }
    }
}
