import javax.swing.*;
import java.util.Random;

public class Analysis
{
    public JPanel Analysis;
    private JButton mergeSortButton;
    private JButton insertionSortButton;
    private JButton quickSortButton;
    private JButton selectionSortButton;
    private JButton heapSortButton;
    private JButton radixSortButton;
    private JTextField SortChoice;
    private JRadioButton InOrderRadio;
    private JRadioButton ReverseOrderRadio;
    private JRadioButton RandomOrderRadio;
    private JRadioButton AlmostOrderRadio;
    private JTextField MovementField;
    private JTextField TimeField;
    private JTextField CompareField;
    private JTextField SortField;
    private JTextField DatatypeField;
    private JTextField NumberField;
    private JSlider SizeSlider;
    private JTextField SizeField;
    private JButton CreateButton;
    private JTextField TimeComField;
    private JButton bubbleSortButton;
    int[] arr;

    public Analysis()
    {
        // instructions pop-up before GUI is shown
        JOptionPane.showMessageDialog(null, "Please follow the following steps to correctly use " +
                "this application. Please note that everything must be done in said order.\n1. Select a sort type from " +
                "the left. \n2. Select a list property\n3. Slide the slider to choose an array size" +
                "\n4. Press create list to see the Experimental results.\nView tooltips for more information.");

        // GUI tool-tip
        Analysis.setToolTipText("<html> Please follow the following steps to correctly use " +
                "this application. Please note that everything must be done in said order.<br>1. Select a sort type from " +
                "the left. <br>2. Select a list property<br>3. Slide the slider to choose an array size" +
                "<br>4. Press create list to see the Experimental results.<br>View tooltips for more information. </html>");

        // Sets the value of the text-box next to the slider
        SizeSlider.addChangeListener(e -> SizeField.setText(String.valueOf(SizeSlider.getValue())));

        // Shows sort information when the sort button is pressed, also triggers flag to force user to select one
        insertionSortButton.addActionListener(e ->
        {
            SortChoice.setText(insertionSortButton.getText());
            JOptionPane.showMessageDialog(null, "Insertion sort is a simple sorting algorithm" +
                    " that works similar to the way you sort playing cards in your hands. The array is virtually " +
                    "split into a sorted and an unsorted part.\nValues from the unsorted part are picked and placed " +
                    "at the correct position in the sorted part. Time complexity is O(n*2). ");

        });

        selectionSortButton.addActionListener(e ->
        {
            SortChoice.setText(selectionSortButton.getText());
            JOptionPane.showMessageDialog(null, "The selection sort algorithm sorts an array " +
                    "by repeatedly finding the minimum element (considering ascending order) from unsorted part and " +
                    "putting it at the beginning. Time complexity is O(n2) as there are two nested loops.");

        });

        quickSortButton.addActionListener(e ->
        {
            SortChoice.setText(quickSortButton.getText());
            JOptionPane.showMessageDialog(null, "QuickSort is a Divide and Conquer algorithm. " +
                    "It picks an element as pivot and partitions the given array around the picked pivot. " +
                    "QuickSort algorithm has the complexity of O(n log n).");

        });

        mergeSortButton.addActionListener(e ->
        {
            SortChoice.setText(mergeSortButton.getText());
            JOptionPane.showMessageDialog(null, "Merge Sort is a Divide and Conquer algorithm. " +
                    "It divides the input array into two halves, calls itself for the two halves, and then merges " +
                    "the two sorted halves. Merge Sort is a recursive algorithm\nand time complexity can be expressed " +
                    "as following recurrence relation. T(n) = 2T(n/2) + θ(n)");

        });

        heapSortButton.addActionListener(e ->
        {
            SortChoice.setText(heapSortButton.getText());
            JOptionPane.showMessageDialog(null, "Heap sort is a comparison based sorting" +
                    " technique based on Binary Heap data structure. It is similar to selection sort where we first " +
                    "find the maximum element and place the maximum element at the end.\n We repeat the same process " +
                    "for the remaining elements. Time complexity of heapify is O(Logn). Time complexity of " +
                    "createAndBuildHeap() is O(n) and overall time complexity of Heap Sort is O(nLogn).");

        });

        radixSortButton.addActionListener(e ->
        {
            SortChoice.setText(radixSortButton.getText());
            JOptionPane.showMessageDialog(null, "The idea of Radix Sort is to do digit by " +
                    "digit sort starting from least significant digit to most significant digit. Radix sort uses " +
                    "counting sort as a subroutine to sort. The time complexity is O(kn).");

        });

        bubbleSortButton.addActionListener(e ->
        {
            SortChoice.setText(bubbleSortButton.getText());
            JOptionPane.showMessageDialog(null, "Bubble Sort is the simplest sorting " +
                    "algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order." +
                    " Time complexity is O(n*n)");

        });

        // "Create the list" button will run when flag == true
        CreateButton.addActionListener(e ->
        {

            // Displays list size
            NumberField.setText(String.valueOf(SizeField.getText()));

            // Displays sort type
            SortField.setText(SortChoice.getText());

            // Displays array property
            DatatypeField.setText(getSelectedRadio());

            // Create list function
            getArr();

            // Call sort function and pass list
            Sort(arr);

        });

    }

    // Returns String value of the selected radio button
    private String getSelectedRadio()
    {
        if (InOrderRadio.isSelected())
        {
            return InOrderRadio.getText();
        } else if (AlmostOrderRadio.isSelected())
        {
            return AlmostOrderRadio.getText();
        } else if (ReverseOrderRadio.isSelected())
        {
            return ReverseOrderRadio.getText();
        } else
        {
            return RandomOrderRadio.getText();
        }
    }

    // Create list based on list property
    private void getArr()
    {
        // Create array of '0'
        Random rand = new Random();
        arr = new int[Integer.parseInt(SizeField.getText())];

        // InOrder creates a list in ascending order
        if (InOrderRadio.isSelected())
        {
            for (int i = 0; i < arr.length; i++)
            {
                arr[i] = i;
            }

            // AlmostOrder creates a list which is 50% sorted and 50% unsorted
        } else if (AlmostOrderRadio.isSelected())
        {
            for (int i = 0; i < arr.length / 2; i++)
            {
                arr[i] = i;
            }

            for (int i = arr.length / 2; i < arr.length; i++)
            {
                arr[i] = rand.nextInt(arr.length);
            }

            // ReverseOrder creates list in descending order
        } else if (ReverseOrderRadio.isSelected())
        {
            for (int i = arr.length, j = 0; i > 0; i--, j++)
            {
                arr[j] = i;
            }

            // RandomOrder creates 100% unsorted list
        } else
        {
            for (int i = 0; i < arr.length; i++)
            {
                arr[i] = rand.nextInt(arr.length);
            }
        }
    }

    // This function will run the selected algorithm and also fill in the remaining text-boxes. It uses a switch
    // statement to check what algorithm to use.
    private void Sort(int[] list)
    {
        switch (SortField.getText())
        {
            case "Insertion Sort":
            {
                InsertionSort insertionSort = new InsertionSort();

                long startTime = System.currentTimeMillis();

                insertionSort.insertionSort(list);

                long endTime = System.currentTimeMillis();

                CompareField.setText(String.valueOf(insertionSort.getComparisons()));
                MovementField.setText(String.valueOf(insertionSort.getMovements()));
                TimeField.setText((endTime - startTime + " milliseconds"));
                TimeComField.setText("O(n*2)");

                break;
            }
            case "Selection Sort":
            {
                SelectionSort selectionSort = new SelectionSort();

                long startTime = System.currentTimeMillis();

                selectionSort.selectionSort(list);

                long endTime = System.currentTimeMillis();

                CompareField.setText(String.valueOf(selectionSort.getComparisons()));
                MovementField.setText(String.valueOf(selectionSort.getMovements()));
                TimeField.setText((endTime - startTime + " milliseconds"));
                TimeComField.setText("O(n2)");

                break;
            }
            case "Quick Sort":
            {
                QuickSort quickSort = new QuickSort();

                long startTime = System.currentTimeMillis();

                quickSort.quickSort(list);

                long endTime = System.currentTimeMillis();

                CompareField.setText(String.valueOf(quickSort.getComparisons()));
                MovementField.setText(String.valueOf(quickSort.getMovements()));
                TimeField.setText((endTime - startTime + " milliseconds"));
                TimeComField.setText("O(n log n)");

                break;
            }
            case "Merge Sort":
            {
                MergeSort mergeSort = new MergeSort();

                long startTime = System.currentTimeMillis();

                mergeSort.mergeSort(list);

                long endTime = System.currentTimeMillis();

                CompareField.setText(String.valueOf(mergeSort.getComparisons()));
                MovementField.setText(String.valueOf(mergeSort.getMovements()));
                TimeField.setText((endTime - startTime + " milliseconds"));
                TimeComField.setText("T(n) = 2T(n/2) + θ(n)");

                break;
            }
            case "Heap Sort":
            {
                HeapSort heapSort = new HeapSort();

                long startTime = System.currentTimeMillis();

                heapSort.heapSort(list);

                long endTime = System.currentTimeMillis();

                CompareField.setText(String.valueOf(heapSort.getComparisons()));
                MovementField.setText(String.valueOf(heapSort.getMovements()));
                TimeField.setText((endTime - startTime + " milliseconds"));
                TimeComField.setText("O(nLogn)");

                break;
            }
            case "Radix Sort":
            {
                RadixSort radixSort = new RadixSort();

                long startTime = System.currentTimeMillis();

                radixSort.radixSort(list, Integer.parseInt(SizeField.getText()));

                long endTime = System.currentTimeMillis();

                CompareField.setText("Radix Sort has 0 comparisons");
                MovementField.setText(String.valueOf(radixSort.getMovements()));
                TimeField.setText((endTime - startTime + " milliseconds"));
                TimeComField.setText("O(kn)");

                break;
            }

            case "Bubble Sort":
            {
                BubbleSort bubbleSort = new BubbleSort();

                long startTime = System.currentTimeMillis();

                bubbleSort.bubbleSort(list);

                long endTime = System.currentTimeMillis();

                CompareField.setText(String.valueOf(bubbleSort.getComparisons()));
                MovementField.setText(String.valueOf(bubbleSort.getMovements()));
                TimeField.setText((endTime - startTime + " milliseconds"));
                TimeComField.setText("O(n*n)");

                break;
            }
        }
    }
}
