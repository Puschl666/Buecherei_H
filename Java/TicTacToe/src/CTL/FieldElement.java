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
public class FieldElement {
    private int value;
    private String symbol;
    private boolean enabled;
    
    public FieldElement(){
        value=0;
        symbol="";
        enabled=true;
    }
    public void setFieldPosition(Player player){
        value=player.getValue();
        symbol=player.getSymbol();
        enabled=false;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }
}
