package org.academiadecodigo.whiledcards.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.*;

public class Cursor{
    private Grid grid;
    private int col;
    private int row;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle cursor;


    public Cursor(Grid grid){
        col = 0;
        row = 0;
        this.grid = grid;
        cursor = new Rectangle(grid.translateCols(col), grid.translateRows(row), grid.getCellSize(), grid.getCellSize());
        cursor.setColor(Color.BLUE);
        cursor.fill();
    }

    public void move(){

    }
}
