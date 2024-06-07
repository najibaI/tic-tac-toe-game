/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
File Name:	TicTac
Programmer:	Najiba Imam
Date:		July 14, 2021
Description:	This program simulates a customized Tic Tac Toe game.

 */

/**
 *
 * @author najib
 */

// Import the neccessary libraries needed for the application.
import java.awt.*;
import javax.swing.*;

public class TicTac extends JFrame {
    TicTacEvent tictac = new TicTacEvent(this); // joins the two programs to work with each other
    JPanel row1 = new JPanel();  // creates the outline box
    JButton[ ][ ] boxes = new JButton [3][3];  // creates nine buttons in a 2D array that is 3 x 3
    JButton play = new JButton ("Play");  // creates a play button
    JButton reset = new JButton ("Reset"); // creates a reset button 
    
    JTextField kittenScore = new JTextField();  // creates text field which would display the number of kitten wins
    JTextField puppyScore = new JTextField();  // creates a text field which would display the number of puppy wins
    JTextField tieCount = new JTextField(); // creates a text field which would display the number of ties
    
    JOptionPane win = new JOptionPane("Winner");  // creates a panel which determines & displays the winner
    ImageIcon cardback = new ImageIcon("cardback.jpg ");  // creates the image icon for the back card

    public TicTac() {  // creates the method to draw the game board
        super ("Tic Tac Toe");  // creates the outer frame with the title
        setSize (650,650);  // sets the size of the outer frame
        getContentPane().setBackground(new Color(203, 195, 227));  // sets the background colour to light purple
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // sets the program to quit the running application 
        FlowLayout layout = new FlowLayout(); // arranges components from left to right, centering components
                                            // horizontally with a five pixel gap between them
        setLayout(layout);  
        
        int name = 0;  // initialize the integer name to 0
        String newname;  // create String; adds remaining components to the GridLayout

        GridLayout layout1 = new GridLayout(5, 4, 11, 11);  // arranges the components in a rectangular grid, 
                                                           // where all cells are of equal size
                                                           
        row1.setLayout(layout1); // sets the row to layout 1

        // These outer & inner loops create and add the buttons to the GridLayout's first three rows
        for (int x = 0; x <= 2; x++){  
            for (int y = 0; y <= 2; y++){
                name += 1;  // name = name + 1
                newname = Integer.toString(name);  // convert the integer name to a String
                boxes[x][y] = new JButton(newname);  // inserts the numbers displayed on the buttons
                boxes[x][y].setIcon(cardback);  // sets the cardback icon to the boxes
                row1.add(boxes[x][y]);  // adds the buttons to the rows and columns
                boxes[x][y].setEnabled(false);  // disables the boxes from being clicked
            }
        }
        
        // Add the remaining components (i.e. the text fields, buttons) to the GridLayout
        row1.add(kittenScore);  
        row1.add(play);
        row1.add(puppyScore); 
        row1.add(tieCount); 
        row1.add(reset); 
        add(row1);  // adds the GridLayout to the FlowLayout

        play.addActionListener(tictac);  // makes the program ready to handle mouse clicks
        reset.addActionListener(tictac);  // makes the program ready to handle mouse clicks when it restarts
            for (int x=0; x<=2; x++){
                for (int y=0; y<=2; y++){
                    boxes[x][y].addActionListener(tictac);
                }
            }

        setVisible(true);  // shows the FlowLayout on the screen
    }

    public static void main(String[] arguments){
        TicTac frame = new TicTac();  // runs the screen layout class
    }
}
