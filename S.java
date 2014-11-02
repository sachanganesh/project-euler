class S {

    /*
    * Binary search algorithm.
    * Returns index of target value in array; returns -1 if not present in list
    */
    public static int binarySearch(int[] list, int target, boolean ascending) {
        int i = list.length / 2;
        while (i >= 0 && i <= list.length - 1) {
            if (list[i] == target)
                return i;
            else if (ascending && list[i] > target)
                i /= 2;
            else if (!ascending && list[i] > target)
                i *= 1.5;
            else if (ascending && list[i] < target)
                i *= 1.5;
            else
                i /= 2;
        }
        return -1;
    }

    /*
    * Selection sort algorithm.
    */
    public static void selectionSort(int[] list, boolean ascending) {
        for (int n = list.length, k = 0, temp; n > 1; n--, k = 0) {
            for (int i = 0; i < n; i++)
                if (list[i] > list[k])
                    k = i;
            temp = list[k];
            list[k] = list[n - 1];
            list[n - 1] = temp;
        }
    }

    /*
    * Insertion sort algorithm.
    */
    public static void insertionSort(int[] list, boolean ascending) {
    }

}
