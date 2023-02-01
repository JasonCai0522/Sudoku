package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the Tile Click Handler. It handles what happens when buttons are clicked on
 * @author jason.cai
 */
public class TileClickHandler implements ActionListener{

    private Sudoku game;
    
    private static padButton lastSelected;

    private static boolean firstMove = true; 
    
    public TileClickHandler(Sudoku game) {
        this.game = game;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() instanceof Button) {
            Button button = (Button)ae.getSource();
            game.setDisplay(game.getUserInput(), button);
            game.checkWin();
        
        } else {
         
            padButton button = (padButton)ae.getSource();

            if (firstMove == true) {
                button.selected();
                lastSelected = button;
                firstMove = false;
         
            } else {              
                lastSelected.resetColor();
                button.selected();
                lastSelected = button;
            }
            game.setUserInput(button.getValue());
        }  
    }

}
