package sudoku;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Sudoku extends JFrame{
    static int ROWS = 3;
    static int COLUMNS = 3;
    
    public Sudoku() {
        super("Sudoku");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        GridLayout lm = new GridLayout(ROWS,COLUMNS);


        for (int i = 0; i < ROWS; i ++){
          for (int j = 0; j < COLUMNS; j ++){
              // contains each 3x3 box of numbers
              JPanel numberPanel = new JPanel(lm);
              System.out.println("In ");
              for (int k = 0; k < ROWS; k ++){
                for (int l = 0; l < COLUMNS; l ++){
                    Button b = new Button();
                    numberPanel.add(b);
                }
              }
              this.add(numberPanel);
             
          }
        }
        this.pack();
    }
    
    
    public static void main(String[] args) {
        Sudoku game = new Sudoku();
    }
    
}

//public class TicTacToe extends JFrame{
//    // Tic Tac Toe object "is a" JFrame Object
//    Button[][] buttonGrid;
//    static int ROWS = 3;
//    static int COLUMNS = 3;
//    
//    public TicTacToe() {
//        // JFrame frame = new JFrame("Tic Tac Toe");
//        super("Tic Tac Toe");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
//        
//        GridLayout lm = new GridLayout(ROWS,COLUMNS);
//        JPanel buttonPanel = new JPanel(lm);
//        buttonGrid = new Button[ROWS][COLUMNS];
//        for (int i = 0; i < ROWS; i ++){
//          for (int j = 0; j < COLUMNS; j ++){
//              Button b = new Button();
//              buttonGrid[i][j] = b;
//              buttonPanel.add(b);
//          }
//        }
//        
//        this.add(buttonPanel);
//        this.pack();
//    }
//    
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        TicTacToe game = new TicTacToe();
//    }
//    
//}
