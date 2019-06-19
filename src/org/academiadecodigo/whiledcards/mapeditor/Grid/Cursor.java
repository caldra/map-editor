package org.academiadecodigo.whiledcards.mapeditor.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Cursor{
    private Grid grid;
    private int col;
    private int row;
    private Color paintColor;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle cursor;


    public Cursor(Grid grid) {
        col = 0;
        row = 0;
        this.grid = grid;
        cursor = new Rectangle(grid.translateCols(col), grid.translateRows(row), grid.getCellSize(), grid.getCellSize());
        cursor.setColor(Color.BLUE);
        cursor.fill();
    }

    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }

    public void setPaintColor(Color color){
        paintColor = color;
    }

    public void moveUp() {
        if (row == 0) {
            row = 0;
            return;
        }
        row--;
        cursor.translate(0, -grid.getCellSize());
        cursor.fill();
    }

    public void moveDown() {
        if (row == grid.getRows() - 1) {
            row = grid.getRows() - 1;
            return;
        }
        row++;
        cursor.translate(0, grid.getCellSize());
        cursor.fill();
    }

    public void moveLeft() {
        if (col == 0) {
            col = 0;
            return;
        }
        col--;
        cursor.translate(-grid.getCellSize(), 0);
        cursor.fill();
    }

    public void moveRight() {
        if (col == grid.getCols() - 1) {
            col = grid.getCols() - 1;
            return;
        }
        col++;
        cursor.translate(grid.getCellSize(), 0);
        cursor.fill();
    }


}
