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
 * This is the Pad Button. 
 * Pad Buttons allow users use to choose their inputted
 * number
 * @author jason.cai
 */
public class padButton extends JButton{
    
    private int value;

    /**
     * Pad Button constructor. Takes in the number
     * that the padbutton repersents. Also adjusts
     * the size and color of the button
     * @param number The number that the padbutton repersents
     */
    public padButton(int number){
       Dimension dmnsn = new Dimension(90,92);
       this.setPreferredSize(dmnsn);     
       this.setBackground(new java.awt.Color(220, 220, 255));
       
       Font font1 = new Font("Times New Roman", Font.BOLD, 40);       
       this.setFont(font1); 
       this.value = number;

       this.setText(Integer.toString(number));
    }
    
    /**
     * Changes the color of a pad button
     * if it is selected.
     */
    public void selected() {
        this.setBackground(new java.awt.Color(190, 190, 255));
    }
    
    /**
     * Resets the color of a pad button
     * after it has been deselected.
     */
    public void resetColor() {
       this.setBackground(new java.awt.Color(220, 220, 255));
    }

       /**
     * Getter method. Allows other files to
     * get the value the pad button repersents
     * @return The value the pad button repersents
     */

    public int getValue() {
        return value;
    }
}



