/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;


import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author jason.cai
 */
public class padButton extends JButton{
    
    int value;

    
    public padButton(int number){
       Dimension dmnsn = new Dimension(90,92);
       this.setPreferredSize(dmnsn);     
       this.setBackground(new java.awt.Color(220, 220, 255));
       
       Font font1 = new Font("Times New Roman", Font.BOLD, 40);       
       this.setFont(font1); 
       value = number;

       this.setText(Integer.toString(number));
    }
    
    // Might want to have the padButtons stay lit
    public void selected() {
        this.setBackground(new java.awt.Color(190, 190, 255));
    }
    
    public void resetColor() {
       this.setBackground(new java.awt.Color(220, 220, 255));
    }
}



