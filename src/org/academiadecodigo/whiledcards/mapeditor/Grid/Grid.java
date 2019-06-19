package org.academiadecodigo.whiledcards.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
    private int cols;
    private int rows;
    private static int cellSize;
    private static int PADDING;
    private Cell[][] cells;

    public Grid(){
        cols = 30;
        rows = 30;
        cellSize = 20;
        PADDING = 10;
        constructGrid();
    }


    private void constructGrid(){

        cells = new Cell[cols][];

        for(int n = 0; n<cells.length; n++){
            cells[n] = new Cell[rows];
        }

        for(int i = 0; i < cols ; i++){
            for(int j =0; j < rows; j++){
                cells[i][j] = new Cell(i,j,this);
            }
        }
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

    public Cell[][] getCells() {
        return cells;
    }

    public int translateRows(int row){
        return row*cellSize+PADDING;
    }

    public void change(int col, int row){
        cells[col][row].edit();
    }
}
