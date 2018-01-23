/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTL;

/**
 *
 * @author pusch
 */
public class Player {
    private String name;
    private String symbol;
    private int value;
    
    public Player(String name, String symbol, int value){
        this.name=name;
        this.symbol=symbol;
        this.value=value;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }
}
