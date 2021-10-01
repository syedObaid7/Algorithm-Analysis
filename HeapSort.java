import java.util.ArrayList;

// HeapSort Class
public class HeapSort
{
    /**
     * Heap sort method
     */

    private long movements = 0L;
    private long comparisons = 0L;

    private ArrayList<Integer> list = new java.util.ArrayList<Integer>();

    public <E extends Comparable<E>> void heapSort(int[] list)
    {
        // Create a Heap of integers


        // Add elements to the heap
        for (int e : list) add(e);

        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = (int) remove();
    }

    private void Heap(int[] list)
    {
        for (int j : list) add(j);
    }

    /**
     * Add a new object into the heap
     */
    private void add(int n)
    {
        list.add(n); // Append to the heap
        int currentIndex = list.size() - 1; // The index of the last node

        while (currentIndex > 0)
        {
            int parentIndex = (currentIndex - 1) / 2;
            // Swap if the current object is greater than its parent
            if (list.get(currentIndex).compareTo(
                    list.get(parentIndex)) > 0)
            {
                Integer temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else
                break; // The tree is a heap now

            currentIndex = parentIndex;
        }
    }

    /**
     * Remove the root from the heap
     */
    private Integer remove()
    {
        if (list.size() == 0) return null;

        Integer removedObject = list.get(0);
        movements++;

        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size())
        {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the maximum between two children
            if (leftChildIndex >= list.size()) break; // The tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size())
            {
                comparisons++;
                if (list.get(maxIndex).compareTo(
                        list.get(rightChildIndex)) < 0)
                {
                    maxIndex = rightChildIndex;
                }
            }
            comparisons++;

            // Swap if the current node is less than the maximum
            if (list.get(currentIndex).compareTo(
                    list.get(maxIndex)) < 0)
            {
                Integer temp = list.get(maxIndex);
                movements++;
                list.set(maxIndex, list.get(currentIndex));
                movements++;
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else
                break; // The tree is a heap
        }

        return removedObject;
    }

    /**
     * Get the number of nodes in the tree
     */
    private int getSize()
    {
        return list.size();
    }

    public long getComparisons()
    {
        return comparisons;
    }

    public long getMovements()
    {
        return movements;
    }

}
