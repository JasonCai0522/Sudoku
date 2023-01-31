package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
   
   JLabel message = new JLabel();

    
   Font font1 = new Font("Verdana", Font.BOLD, 50);     
    
    public Sudoku() {
        super("Sudoku");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // Creating layouts
        GridLayout gridlm = new GridLayout(ROWS, COLUMNS);
        GridLayout numPadlm = new GridLayout(3,3);
        
        // Creating Panels
        JPanel holderPanel = new JPanel();
        JPanel gridPanel = new JPanel(gridlm);        
        JPanel padPanel = new JPanel();
        JPanel numberPadPanel = new JPanel(numPadlm);
        


        // Setting background color
        holderPanel.setBackground(new java.awt.Color(239, 224, 255));


        // Creating Borders and setting borders
        Border blackLine = BorderFactory.createLineBorder(Color.black,1);
        Border thickBlackLine = BorderFactory.createLineBorder(Color.black,3);
        holderPanel.setBorder(thickBlackLine);
        numberPadPanel.setBorder(thickBlackLine);
        gridPanel.setBorder(thickBlackLine);
        
        // Creating and adjusting the title 
        JPanel title = new JPanel();
        message = new JLabel("SUDOKU");
        message.setFont(font1);
        title.add(message);
        title.setBackground(new java.awt.Color(190, 210, 255));
        title.setBorder(BorderFactory.createMatteBorder(3, 3, 0, 3, Color.BLACK));


        // Adds all the buttons to the padbutton jpanel
        for (int i = 1; i < 10; i ++){
                    // Creats a tile click handler
                    TileClickHandler tch = new TileClickHandler(this);                  
                    
                    // Creates the padbutton
                    padButton b = new padButton(i);
                    b.addActionListener(tch); 
                    
                    // Adds the button to the number pad panel 
                    numberPadPanel.add(b); 
        }
        
        
        // The rows for the 3x3 boxes
        for (int i = 0; i < ROWS; i ++){
            // the columns in the 3x3 boxes
            for (int j = 0; j < COLUMNS; j ++){
              // contains each 3x3 box of numbers
              JPanel numberPanel = new JPanel(gridlm);
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
                    buttonGrid[buttonRow][buttonColumn] = b;
                }
              }
              gridPanel.add(numberPanel);    
          }
        }
        
        // Adds all the panels to the frame
        padPanel.add(numberPadPanel, BorderLayout.CENTER);
        holderPanel.add(gridPanel,BorderLayout.CENTER);
        holderPanel.add(padPanel, BorderLayout.EAST);     
        this.add(holderPanel);   
        this.add(title, BorderLayout.NORTH);
        this.pack();
        
    }
    
    // Gets the inputs from other files
    public int getUserInput() {
        return userInput;
    }

    public void setUserInput(Button tile) {
        tile.setDisplay(userInput);
    }
    
    public void setButtonValue(Button tile) {
        tile.setDisplay(userInput);
    }


    public void checkWin() {
        boolean win = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                if (buttonGrid[i][j].displayValue != numbers[i][j]){
                    win = false;
                    i = 10;
                    j = 10;
                }
            }

        }
        
        if (win == true) {
            message.setText("You Win");
            message.setForeground(new java.awt.Color(121, 0, 255));
        }
    }

    public static void main(String[] args) {
        Sudoku game = new Sudoku();
    }
    
}
