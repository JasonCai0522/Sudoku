/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jason.cai
 */
public class TileClickHandler implements ActionListener{

    Sudoku game;
    
    public TileClickHandler(Sudoku game) {
        this.game = game;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() instanceof Button) {
            Button button = (Button)ae.getSource();
            game.changeValue(button);
            game.checkWin();
        } else {
            padButton button = (padButton)ae.getSource();
            game.userInput = button.value;     
        } 


        
    }
    
}
