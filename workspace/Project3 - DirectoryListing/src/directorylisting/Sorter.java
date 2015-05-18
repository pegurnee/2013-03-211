package directorylisting;

public class Sorter {
    public static void main(String[] args) {
        int[] theArr = {
                8, 6, 3, 1, 7, 34, 2
        };
        for (int i : theArr) {
            System.out.print(i + " ");
        }
        selectionSort(theArr);

        System.out.println();

        for (int i : theArr) {
            System.out.print(i + " ");
        }

    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int iLittle = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[iLittle]) {
                    iLittle = j;
                }
            }

            if (iLittle != i) {
                int temp = arr[i];
                arr[i] = arr[iLittle];
                arr[iLittle] = temp;
            }
        }
    }

    private static void bubbleSort(int[] arr) {
        boolean flag = false;
        while (!flag) {
            int temp;
            flag = true;
            for (int i = 1; i < arr.length; i++) {
                for (int j = 0; j < arr.length - i; j++) {
                    if (arr[i - 1] > arr[i]) {
                        temp = arr[i - 1];
                        arr[i - 1] = arr[i];
                        arr[i] = temp;
                        flag = false;
                    }
                }
            }
        }
    }

    private static void gnomeSort(int[] arr) {

    }
}
