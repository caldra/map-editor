package org.academiadecodigo.whiledcards.mapeditor;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        Cell[] cells = new Cell[grid.getCols()*grid.getRows()];
        int start = 0;
        for(int i = 0; i < grid.getCols() ; i++){
            for(int j =0; j < grid.getRows(); j++){
                cells[start] = new Cell(i,j,grid);
                start++;
            }
        }
    }
}
