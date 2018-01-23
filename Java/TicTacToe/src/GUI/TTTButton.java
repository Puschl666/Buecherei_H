/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JButton;

/**
 *
 * @author pusch
 */
public class TTTButton extends JButton{
    private int col;
    private int row;
    
    public TTTButton(int col, int row){
        super();
        
        this.col=col;
        this.row=row;
    }


    public int getCol() {
        return col;
    }


    public int getRow() {
        return row;
    }
}
