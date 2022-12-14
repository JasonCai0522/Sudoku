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
public class padButton extends JButton{
    
    public padButton(int number){
       Dimension dmnsn = new Dimension(100,100);
       this.setPreferredSize(dmnsn);     
       this.setBackground(Color.white);
       
       Font font1 = new Font("SansSerif", Font.BOLD, 40);       
       this.setFont(font1); 
       
       this.setText(Integer.toString(number));
    }
}
