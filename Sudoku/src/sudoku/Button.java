/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;



/**
 *
 * @author jason.cai
 */
public class Button extends JButton{
    int[][] numbers ={{8,4,2,9,5,6,3,1,7},
                     {5,9,1,8,3,7,6,4,2},
                     {6,7,3,2,4,1,8,5,9},
                     {4,8,6,1,7,3,9,2,5},
                     {3,1,7,5,2,9,4,8,6},
                     {9,2,5,6,8,4,7,3,1},
                     {2,5,4,7,6,8,1,9,3},
                     {7,3,9,4,1,5,2,6,8},
                     {1,6,8,3,9,2,5,7,4}
                    };              
    
   public Button(int column,int row) {
       JTextField textField = new JTextField(20);
       Dimension dmnsn = new Dimension(100,100);
       this.setPreferredSize(dmnsn);
       int number = numbers[row][column];
       this.setText(Integer.toString(number));

       
       
   }
    
    
}
