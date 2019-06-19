package org.academiadecodigo.whiledcards.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    private boolean drawn;
    private Rectangle cell;

    public Cell(int col, int row, Grid grid){
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

    public void delete(){
        cell.delete();
        cell.draw();
        drawn = false;
    }

    public boolean getDrawn(){
        return drawn;
    }

}