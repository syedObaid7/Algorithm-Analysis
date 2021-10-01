/*
 * Name: Syed Obaid Quadri
 * Date: 2/24/2021
 * Class: SE 3345.502
 * Description: This program is GUI that will calculate the number of comparisons and movements a specific
 *              sorting algorithm will make. It can implement 6 different types.
 */

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        // Driver code to run GUI
        JFrame frame = new JFrame("Analysis");
        frame.setContentPane(new Analysis().Analysis);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
