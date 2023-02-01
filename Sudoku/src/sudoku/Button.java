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
 * This is the Button. Users interacts 
 * with this on the actual
 * Sudoku
 * @author jason.cai
 */
public class Button extends JButton{

    private int trueValue;

    private boolean isGiven;     
   
    private int displayValue;

    /**
     * Constructor for the button class. 
     * Takes in the correct value of the button
     * and whether or not it is given. Also
     * adjusts the dimensions, color, and font
     * @param Value The true value of the tile
     * @param isGiven Whether or not the tile is given to the player
     */
   public Button(int trueValue, boolean isGiven) {
       Dimension dmnsn = new Dimension(90,90);
       this.setPreferredSize(dmnsn);     
       this.setBackground(new java.awt.Color(234, 232, 255));
       
       Font font1 = new Font("SansSerif", Font.BOLD, 40);       
       this.setFont(font1); 
       this.setForeground(new java.awt.Color(84, 65, 255));

       this.isGiven = isGiven;
       this.trueValue = trueValue;
       
       if (isGiven) {
        displayValue = trueValue;
        this.setText(Integer.toString(displayValue));
      }
   } 
   
    /**
     * Getter method. Allows other files to
     * get the true value of a button
     * @return The true value of a button
     */
   public int getTrueValue() {
    return trueValue;
   }

    /**
     * Getter method. Allows other files to
     * get the display value of a button
     * @return The display value of a button
     */
   public int getDisplayValue() {
    return displayValue;
   }

    /**
     * Getter method. Allows other files to
     * get whether or not a button was given
     * @return Whether or not a button was given
     */
    public boolean getIsGiven() {
        return isGiven;
       }

    /** 
     * Setter Method. Allows other files to 
     * set the display value
     * @param newVal The new display value.
     */

   public void setDisplayValue(int newVal) {
    displayValue = newVal;
   }  
}


