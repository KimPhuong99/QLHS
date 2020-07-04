/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyhocsinh;

/*
 * FlowLayoutDemo.java is a 1.4 application that requires no other files.
 */

/*
 * BoxLayoutDemo.java is a 1.4 application that requires no other files.
 */

import java.awt.Component;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * BorderLayoutDemo.java is a 1.4 application that requires no other files.
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * FlowLayoutDemo.java is a 1.4 application that requires no other files.
 */

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.ComponentOrientation;

public class FlowLayoutDemo {
    public static boolean RIGHT_TO_LEFT = false;

    public static void addComponents(Container contentPane) {
        if (RIGHT_TO_LEFT) {
            contentPane.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);
        }
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new JButton("Button 1"));
        contentPane.add(new JButton("Button 2"));
        contentPane.add(new JButton("Button 3"));
        contentPane.add(new JButton("Long-Named Button 4"));
        contentPane.add(new JButton("5"));
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        //JFrames decorated by the Java look and feel
        //can't get smaller than their minimum size.
        //We specify a skinnier minimum size than the
        //content pane will cause the frame to request,
        //so that you can see what happens when you
        //drag the window so that it's narrower than a
        //single row.
        JFrame frame = new JFrame("FlowLayoutDemo") {
            public Dimension getMinimumSize() {
                Dimension prefSize = getPreferredSize();
                return new Dimension(100, prefSize.height);
            }
        };
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponents(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        //javax.swing.SwingUtilities.invokeLater(new Runnable() {
        //    public void run() {
                createAndShowGUI();
        //    }
        //});
    }
}
