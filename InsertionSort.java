// Insertion Sort Class
public class InsertionSort
{
    private long movements = 0L;
    private long comparisons = 0L;

    public void insertionSort(int[] list)
    {
        for (int i = 1; i < list.length; i++)
        {
            /** Insert list[i] into a sorted sublist list[0..i-1] so that
             * list[0..i] is sorted */

            int currentElement = list[i];

            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--)
            {
                list[k + 1] = list[k];
                movements++;
                comparisons++;
            }

            // Insert the current element into list[k + 1]
            list[k + 1] = currentElement;
            comparisons++;
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
