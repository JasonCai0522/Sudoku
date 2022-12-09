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



/**
 *
 * @author jason.cai
 */

public class Button extends JButton{
         
   public Button(int column,int row) {
       
       Dimension dmnsn = new Dimension(100,100);
       this.setPreferredSize(dmnsn);     
       this.setBackground(Color.white);
       
       Font font1 = new Font("SansSerif", Font.BOLD, 40);       
       this.setFont(font1); 
          
       int number = Sudoku.numbers[row][column];
       boolean given = Sudoku.numberGiven[row][column];
       
       if (given) {
        this.setText(Integer.toString(number));
        }
   }    
}



// MIGHT HAVE REMEMBERED MRS STUSIAK SAYING TO USE TEXT FIELD BUT I DON'T REMEMBER IF WE ACTUALLY SHOULD
//   public Button(int column,int row) {
//
//
//       Dimension dmnsn = new Dimension(100,100);
//       this.setPreferredSize(dmnsn);
//       this.setBackground(Color.white);
//       
//       JTextField textField = new JTextField(10);
//       Font font1 = new Font("SansSerif", Font.BOLD, 20);       
//       textField.setFont(font1); 
//       textField.setHorizontalAlignment(JTextField.CENTER);
//       textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//       textField.setEditable(false);
//
//       
//       
//       int number = Sudoku.numbers[row][column];
//       textField.setText(Integer.toString(number));
//       this.add(textField);