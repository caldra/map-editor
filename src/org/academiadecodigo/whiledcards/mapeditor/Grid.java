package org.academiadecodigo.whiledcards.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
    private int cols;
    private int rows;
    private int cellSize;
    private Rectangle grid;
    private static int PADDING;

    public Grid(){
        cols = 30;
        rows = 30;
        cellSize = 20;
        PADDING = 10;
        //grid = new Rectangle(PADDING,PADDING,cols*cellSize,rows*cellSize);
        //show();
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
        int realCol = col*cellSize+PADDING;
        return realCol;
    }

    public int translateRows(int row){
        return row*cellSize+PADDING;
    }
}
