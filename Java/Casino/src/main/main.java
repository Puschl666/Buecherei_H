package main;

import main_menu.main_menu;

/**
 *
 * @author pusch
 */
public class main {
    public static void main(String[] args) {
         main_menu optionFrame = new main_menu();
         optionFrame.setLocation(500,300);
         optionFrame.setSize(800,500);
         optionFrame.setVisible(true);
    }
}