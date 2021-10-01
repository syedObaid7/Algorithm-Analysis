import java.util.Arrays;

// Radix Sort Class
public class RadixSort
{
    private long movements = 0L;

    private int getMax(int[] arr, int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    private void countSort(int[] arr, int n, int exp)
    {
        int[] output = new int[n];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        // Change count[i] so that it contains actual position of this digit in output[]
        for (i = 1; i < 10; i++)
        {
            movements++;
            count[i] += count[i - 1]; // Build the output array
        }
        for (i = n - 1; i >= 0; i--)
        {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (i = 0; i < n; i++)
        {
            movements++;
            arr[i] = output[i];
        }
    }

    public void radixSort(int[] arr, int n)
    { // Find the maximum number to know number of digits
        int m = getMax(arr, n);
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    public long getMovements()
    {
        return movements;
    }
}


