// Merge Sort Class
public class QuickSort
{
    private long movements = 0L;
    private long comparisons = 0L;


    public void quickSort(int[] list)
    {
        quickSort(list, 0, list.length - 1);
    }

    private void quickSort(int[] list, int first, int last)
    {
        if (last > first)
        {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /**
     * Partition the array list[first..last]
     */
    private int partition(int[] list, int first, int last)
    {
        int pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low)
        {
            // Search forward from left
            comparisons++;
            while (low <= high && list[low] <= pivot)
                low++;

            // Search backward from right
            while (low <= high && list[high] > pivot)
                high--;

            // Swap two elements in the list
            if (high > low)
            {
                int temp = list[high];
                movements++;
                list[high] = list[low];
                movements++;
                list[low] = temp;
            }
        }
        comparisons++;
        while (high > first && list[high] >= pivot)
            high--;

        comparisons++;
        // Swap pivot with list[high]
        if (pivot > list[high])
        {
            movements++;
            list[first] = list[high];
            movements++;
            list[high] = pivot;
            return high;
        } else
        {
            return first;
        }
    }

    public long getMovements()
    {
        return movements;
    }

    public long getComparisons()
    {
        return comparisons;
    }
}

