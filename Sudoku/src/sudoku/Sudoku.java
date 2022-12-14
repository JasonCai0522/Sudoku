package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Sudoku extends JFrame{
    static int ROWS = 3;
    static int COLUMNS = 3;
  
    static int[][] numbers ={{8,4,2,9,5,6,3,1,7},
                            {5,9,1,8,3,7,6,4,2},
                            {6,7,3,2,4,1,8,5,9},
                            {4,8,6,1,7,3,9,2,5},
                            {3,1,7,5,2,9,4,8,6},
                            {9,2,5,6,8,4,7,3,1},
                            {2,5,4,7,6,8,1,9,3},
                            {7,3,9,4,1,5,2,6,8},
                            {1,6,8,3,9,2,5,7,4}
                            };
    
    static boolean[][] numberGiven = {{false,false,true,false,true,true,false,true,false},
                                      {true,true,false,false,false,true,false,false,false},
                                      {false,false,false,false,true,false,false,false,true},
                                      {false,true,true,true,true,false,false,false,false},
                                      {false,false,true,false,false,false,true,false,false},
                                      {false,false,false,false,true,true,true,true,false},
                                      {true,false,false,false,true,false,false,false,false},
                                      {false,false,false,true,false,false,false,true,true},
                                      {false,true,false,true,true,false,true,false,false}
                            };
    
    Button[][] buttonGrid = new Button[9][9];
    
   int userInput = -1;
   
    public Sudoku() {
        super("Sudoku");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        GridLayout lm = new GridLayout(ROWS, COLUMNS);
        GridLayout numPadlm = new GridLayout(9,1);
        
        JPanel holderPanel = new JPanel(lm);
        JPanel padPanel = new JPanel(numPadlm);
        Border blackLine = BorderFactory.createLineBorder(Color.black,1);
        
        // this border looks sorta weird, might get rid of it later
        Border whiteLine = BorderFactory.createLineBorder(Color.black,5);
        holderPanel.setBorder(whiteLine);
        
        userInput = 61;
        
        for (int i = 1; i < 10; i ++){
                    TileClickHandler tch = new TileClickHandler(this);                  
                    padButton b = new padButton(i);
                    b.addActionListener(tch); 
                    padPanel.add(b); 
        }
        this.add(padPanel, BorderLayout.EAST);
        
        for (int i = 0; i < ROWS; i ++){
          for (int j = 0; j < COLUMNS; j ++){
              // contains each 3x3 box of numbers
              JPanel numberPanel = new JPanel(lm);
              numberPanel.setBorder(blackLine);
              for (int k = 0; k < ROWS; k ++){
                for (int l = 0; l < COLUMNS; l ++){
                    // Finding the number
                    int buttonColumn = 3*j + l;
                    int buttonRow =  3*i + k;
                    
                    TileClickHandler tch = new TileClickHandler(this);                  
                    Button b = new Button(buttonColumn, buttonRow);
                    b.addActionListener(tch); 
                    numberPanel.add(b); 
                    // Adds the buttons to an array so we can access them later
                    buttonGrid[buttonColumn][buttonRow] = b;
                }
              }
              holderPanel.add(numberPanel, BorderLayout.NORTH);
             
          }
        }
        this.add(holderPanel);
        this.pack();
    }
    
    // getter method, check if this is necessary later
    public int getInput() {
        return userInput;
    }
    
    public void changeValue(Button tile) {
        tile.setDisplay(userInput);
    }
    
    public static void main(String[] args) {
        Sudoku game = new Sudoku();
    }
    
}
