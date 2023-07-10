import java.util.Random;

public class Exercise3 {
    /*
     *Реализовать алгоритм пирамидальной сортировки (HeapSort)
     */

    public static void main(String[] args) {
        int[] array = randomArray(10, 1, 10);
        int n = array.length;
        printArray(array);

        HeapSort object = new HeapSort();
        object.sort(array);

        System.out.println("Sorted array is");
        printArray(array);
    }

    static void printArray(int[] array)
    {
        int n = array.length;
        for (int j : array) System.out.print(j + " ");
        System.out.println();
    }

    static int[] randomArray(int size, int min, int max){
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i <size ; i++) {
            array[i] = random.nextInt(min, max+1);
        }
        return array;
    }

}
