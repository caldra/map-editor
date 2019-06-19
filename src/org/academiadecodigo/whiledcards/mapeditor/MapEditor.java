package org.academiadecodigo.whiledcards.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.whiledcards.mapeditor.Grid.Cell;
import org.academiadecodigo.whiledcards.mapeditor.Grid.Cursor;
import org.academiadecodigo.whiledcards.mapeditor.Grid.Grid;
import org.academiadecodigo.whiledcards.mapeditor.Grid.Menu;

public class MapEditor {

    private Grid grid;
    private Cursor cursor;
    private MapEditorSaver mapSaver;
    private KeyboardManager keyboardManager;
    private Color newColor;
    // TODO finish menu Grid
    private Menu menu;

    public MapEditor(){
        grid = new Grid(30, 30,20);
        cursor = new Cursor(grid);
        //TODO finish menu Gid
        menu = new Menu();
        mapSaver = new MapEditorSaver();
        keyboardManager = new KeyboardManager(cursor, this, menu);
    }

    public Grid getGrid(){
        return grid;
    }

    public void save(){
        Cell[][] cells = grid.getCells();
        String saveData = "";

        for(int i = 0; i < grid.getCols(); i++){
                for(int j =0; j < grid.getRows(); j++){
                    if(!cells[j][i].getDrawn()){
                        saveData = saveData + "0 ";
                    }else{
                        saveData = saveData + "1 ";
                    }
                }
                saveData = saveData+"\n";
            }
        mapSaver.save(saveData);
    }

    public void load(){
        mapSaver.load(grid);
    }

    public void changeColor(Color color){
        newColor = color;
    }
}
