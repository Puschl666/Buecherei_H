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
public class GameParameters {
    private int mode;
    private int level;
    private String name1, name2;
    
    public GameParameters(int mode, int level, String name1, String name2){
        this.mode=mode;
        this.level=level;
        this.name1=name1;
        this.name2=name2;
    }

    public int getMode() {
        return mode;
    }

    public int getLevel() {
        return level;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }
}
