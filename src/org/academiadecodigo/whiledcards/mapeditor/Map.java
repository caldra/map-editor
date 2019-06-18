package org.academiadecodigo.whiledcards.mapeditor;

public class Map {

    private Grid grid;
    private Cursor cursor;

    public Map(){
        Grid grid = new Grid();

        Cursor cursor = new Cursor(grid);
        cursor.assembleKeyboard();
    }

}
