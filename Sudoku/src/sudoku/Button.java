/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
//import javax.swing.JTextField;

/**
 *
 * @author jason.cai
 */

public class Button extends JButton{
   int number;
   int displayValue;
   boolean isGiven;     
   
   public Button(int column,int row) {
       Dimension dmnsn = new Dimension(90,90);
       this.setPreferredSize(dmnsn);     
       this.setBackground(new java.awt.Color(234, 232, 255));
       
       Font font1 = new Font("SansSerif", Font.BOLD, 40);       
       this.setFont(font1); 
       this.setForeground(new java.awt.Color(84, 65, 255));
       // finds what number should go in each button   
       number = Sudoku.numbers[row][column];
       
       // finds whether or not the number is given or not
       isGiven = Sudoku.numberGiven[row][column];
       
       if (isGiven) {
        displayValue = number;
        this.setText(Integer.toString(displayValue));
      }
   } 
   // Sets the display value of the button
   public void setDisplay(int userValue){
       if (userValue != -1 && this.isGiven == false) {
        if (displayValue != userValue) {
            displayValue = userValue;
            this.setForeground(new java.awt.Color(205, 128, 255));
            this.setText(Integer.toString(displayValue));            
        } else {
            displayValue = -1;
            this.setText("");
        }

       }
   }
   

   
}





      // MIGHT HAVE REMEMBERED MRS STUSIAK SAYING TO USE TEXT FIELD BUT I DON'T REMEMBER IF WE ACTUALLY SHOULD
//       Dimension dmnsn = new Dimension(100,100);
//       this.setPreferredSize(dmnsn);
//       this.setBackground(Color.white);


//      
//       JTextField textField = new JTextField(10);
//       Font font1 = new Font("SansSerif", Font.BOLD, 20);       
//       textField.setFont(font1); 
//       textField.setHorizontalAlignment(JTextField.CENTER);
//       textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//
//
//      
//      
//       int number = Sudoku.numbers[row][column];
//
//       boolean isGiven = Sudoku.numberGiven[row][column];
//       
//        if (isGiven) {
//          this.setText(Integer.toString(number));
//        } else {
//          this.add(textField);
//        }


//       Dimension dmnsn = new Dimension(100,100);
//       this.setPreferredSize(dmnsn);     
//       this.setBackground(Color.white);
//       
//       Font font1 = new Font("SansSerif", Font.BOLD, 40);       
//       this.setFont(font1); 
//       // finds what number should go in each button   
//       number = Sudoku.numbers[row][column];
//       // finds whether or not the number is given or not
//       isGiven = Sudoku.numberGiven[row][column];
//       
//       if (isGiven) {
//        this.setText(Integer.toString(number));
//      }