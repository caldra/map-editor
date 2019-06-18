package org.academiadecodigo.whiledcards.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
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
        cell.setColor(Color.BLACK);
        show();
    }

    public void show(){
        cell.draw();
    }


    public void edit(){
        if (drawn){
            delete();
        }else {
            paint();
        }
    }

    private void paint(){
        cell.fill();
        drawn = true;
    }

    private void delete(){
        cell.delete();
        cell.draw();
        drawn = false;
    }

}
