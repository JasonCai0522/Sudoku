package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
/**
 * Generates a playable game of Sudoku 
 * 
 * @since Jan. 31 2023 
 * @author Jason Cai
 */
public class Sudoku extends JFrame{
    
    private static int ROWS = 3;
    private static int COLUMNS = 3;
 
    
    private static int[][] numbers = {{8,4,2,9,5,6,3,1,7},
                                     {5,9,1,8,3,7,6,4,2},
                                     {6,7,3,2,4,1,8,5,9},
                                     {4,8,6,1,7,3,9,2,5},
                                     {3,1,7,5,2,9,4,8,6},
                                     {9,2,5,6,8,4,7,3,1},
                                     {2,5,4,7,6,8,1,9,3},
                                     {7,3,9,4,1,5,2,6,8},
                                     {1,6,8,3,9,2,5,7,4}};
    

    private static boolean[][] numberGiven = {{false,false,true,false,true,true,false,true,false},
                            {true,true,false,false,false,true,false,false,false},
                            {false,false,false,false,true,false,false,false,true},
                            {false,true,true,true,true,false,false,false,false},
                            {false,false,true,false,false,false,true,false,false},
                            {false,false,false,false,true,true,true,true,false},
                            {true,false,false,false,true,false,false,false,false},
                            {false,false,false,true,false,false,false,true,true},
                            {false,true,false,true,true,false,true,false,false}
                  };                            
    
    private Button[][] buttonGrid = new Button[9][9];
    
    private int userInput = -1;
   
    private JLabel message = new JLabel();

    private boolean win;
    
    /**
     * Sudoku Contstructer. This creates the GUI, including
     * the grid, buttons, and labels.
     */
    public Sudoku() {
        super("Sudoku");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // Creating layouts
        GridLayout gridlm = new GridLayout(ROWS, COLUMNS);
        GridLayout numPadlm = new GridLayout(3,3);
        BorderLayout padlm = new BorderLayout();
        

        // Creating Panels
        JPanel holderPanel = new JPanel();
        JPanel gridPanel = new JPanel(gridlm);        
        JPanel padPanel = new JPanel(padlm);
        JPanel numberPadPanel = new JPanel(numPadlm);
        
        // Creating the title and message
        JPanel title = new JPanel();
        Font font1 = new Font("Verdana", Font.BOLD, 50);   
        message = new JLabel("SUDOKU"); 
        message.setFont(font1);
        title.add(message);


        // Setting background color
        holderPanel.setBackground(new java.awt.Color(239, 224, 255));
        padPanel.setBackground(new java.awt.Color(239, 224, 255));
        gridPanel.setBackground(new java.awt.Color(239, 224, 255));
        title.setBackground(new java.awt.Color(190, 210, 255));

        
        // Creating Borders
        Border blackLine = BorderFactory.createLineBorder(Color.black,4);
        Border thickBlackLine = BorderFactory.createLineBorder(Color.black,5);
        Border thinBlackLine = BorderFactory.createLineBorder(Color.black,2);

        // Setting Borders
        padPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 20, 0, 10),blackLine));
        gridPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(20, 10, 10, 0),thickBlackLine));
        numberPadPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
        title.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.BLACK));

     
        // Creates a tile click handler for all the buttons
        TileClickHandler tch = new TileClickHandler(this); 

        // Adds all the buttons to the padbutton jpanel
        for (int i = 1; i < 10; i ++){                    
                    // Creates the padbutton
                    padButton b = new padButton(i);
                    b.addActionListener(tch); 
                    
                    // Adds the button to the number pad panel 
                    numberPadPanel.add(b); 
        }
        
        // Creating and Adjusting a delete button
        padButton deleteButton = new padButton(-1);
        deleteButton.setPreferredSize(new Dimension(90,80));
        deleteButton.addActionListener(tch);
        deleteButton.setText("Delete");

        // The rows for the 3x3 boxes
        for (int i = 0; i < ROWS; i ++){
            // the columns in the 3x3 boxes
            for (int j = 0; j < COLUMNS; j ++){
              // contains each 3x3 box of numbers
              JPanel numberPanel = new JPanel(gridlm);
              numberPanel.setBorder(thinBlackLine);
              
              for (int k = 0; k < ROWS; k ++){
                
                for (int l = 0; l < COLUMNS; l ++){
                    // Finding the number
                    int buttonColumn = 3*j + l;
                    int buttonRow =  3*i + k; 
                   
                    // Creates the button
                    Button b = new Button(numbers[buttonRow][buttonColumn], numberGiven[buttonRow][buttonColumn]);
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
        padPanel.add(numberPadPanel, BorderLayout.NORTH);
        padPanel.add(deleteButton);
        holderPanel.add(gridPanel,BorderLayout.CENTER);
        holderPanel.add(padPanel, BorderLayout.EAST);     
        this.add(holderPanel);   
        this.add(title, BorderLayout.NORTH);
        this.pack();
    }

    /**
     * Sets the number currently 
     * being shown on a choosen button. 
     * Also adjusts the color and 
     * size.
     * @param userValue The value the user wants to set as the button display
     * @param b The button the user wants to change
     */
    public void setDisplay(int userValue, Button b){
        if (b.getIsGiven() == false && win == false) {
         if (userValue != -1) {
             b.setDisplayValue(userValue);
             b.setForeground(new java.awt.Color(140, 0, 186));
             b.setText(Integer.toString(b.getDisplayValue()));            
         } else {
             b.setDisplayValue(-1);
             b.setText("");
         }
        }
    }    

    /**
     * Checks if the Sudoku game
     * has been solved. If the game has
     * been solved, will display a message.
     */
    public void checkWin() {
        win = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                if (buttonGrid[i][j].getDisplayValue() != buttonGrid[i][j].getTrueValue()){
                    win = false;
                    // Breaks out of the loop, find a better way later
                    i = 10;
                    j = 10;
                }
            }
        }
        
        if (win == true) {
            message.setText("You Win");
            message.setForeground(Color.BLACK);
            for (Button[] list:buttonGrid) {
                for(Button b:list) {
                    b.setForeground(Color.BLACK);
                    b.setBackground(Color.WHITE);
                }
            }

        }
    }

    
    /**
     * Getter method. Allows other files to
     * get the user input
     * @return The user's input
     */
    public int getUserInput() {
        return userInput;
    }

    /**
     * Getter method. Allows other files to
     * get whether or not the player has won
     * @return Whether or not the player has won
     */
    public boolean getWin() {
        return win;
    }

    /** 
     * Setter Method. Allows other files to 
     * set the value of User Input
     * @param newUserInput The Value User Input is set to.
     */
    public void setUserInput(int newUserInput) {
        userInput = newUserInput;
    }

    /**
    * Main method. Runs the Sudoku game.
    * @param args Unused
    */
    public static void main(String[] args) {
        Sudoku game = new Sudoku();
    }
    
}
