// Selection Sort Class
public class SelectionSort
{
    private long movements = 0L;
    private long comparisons = 0L;

    public long getMovements()
    {
        return movements;
    }

    public long getComparisons()
    {
        return comparisons;
    }

    public void selectionSort(int[] list)
    {
        for (int i = 0; i < list.length - 1; i++)
        {
            // Find the minimum in the list[i..list.length - 1]

            int currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++)
            {
                comparisons++;
                if (currentMin > list[j])
                {

                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i)
            {
                movements++;
                list[currentMinIndex] = list[i];
                movements++;
                list[i] = currentMin;
            }
        }
    }
}
