package org.academiadecodigo.whiledcards.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
    private int cols;
    private int rows;
    private int cellSize;
    private Rectangle grid;
    private static int PADDING;

    public Grid(){
        cols = 70;
        rows = 70;
        cellSize = 10;
        PADDING = 10;
        grid = new Rectangle(PADDING,PADDING,cols*cellSize,rows*cellSize);
        show();
    }


    private void show(){
        grid.draw();
    }

    public int getCols(){
        return cols;
    }

    public int getRows(){
        return rows;
    }

    public int getCellSize(){
        return cellSize;
    }

    public int translateCols(int col){
        return col*cellSize+PADDING;
    }

    public int translateRows(int row){
        return row*cellSize+PADDING;
    }
}
