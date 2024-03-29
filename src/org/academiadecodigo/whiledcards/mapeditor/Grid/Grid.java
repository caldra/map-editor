package org.academiadecodigo.whiledcards.mapeditor.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class Grid {
    private int cols;
    private int rows;
    private int width;
    private int cellSize;
    private static int PADDING = 10;
    private Cell[][] cells;

    public Grid(int cols, int rows, int cellSize){
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
        width = cols*cellSize+PADDING;
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

    public int getWidth(){
        return width;
    }

    public int translateRows(int row){
        return row*cellSize+PADDING;
    }

    public void change(int col, int row, Color color)
    {
        cells[col][row].edit(color);
    }
}
