package org.academiadecodigo.whiledcards.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    private int col;
    private int row;
    private boolean drawn;
    private Rectangle cell;
    private Grid grid;

    public Cell(int col, int row, Grid grid){
        this.col = col;
        this.row = row;
        cell = new Rectangle(grid.translateCols(col), grid.translateRows(row), grid.getCellSize(), grid.getCellSize());
        show();
    }

    public void show(){
        cell.draw();
    }
}
