// Bubble Sort Class
public class BubbleSort
{
    private long movements = 0L;
    private long comparisons = 0L;

    public void bubbleSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
            {
                comparisons++;

                if (arr[j] > arr[j + 1])
                {
                    // swap arr[j+1] and arr[j] 
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    movements++;
                }
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