package org.academiadecodigo.whiledcards.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.whiledcards.mapeditor.Grid.Cell;
import org.academiadecodigo.whiledcards.mapeditor.Grid.Grid;

import java.io.*;

public class MapEditorSaver {
    private String notDrawn = "0 ";
    private String drawn = "1 ";
    private Cell[][] cells;

     public void save(String data){
        try {

            FileWriter output = new FileWriter("resources/save.txt");
            BufferedWriter buffer = new BufferedWriter(output);
            buffer.write(data);
            buffer.flush();
            output.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void load(Grid grid){
         cells = grid.getCells();
         try {
             FileReader input = new FileReader("resources/save.txt");
             BufferedReader buffer2 = new BufferedReader(input);


             for(int i = 0; i < grid.getCols(); i++){
                 String line = buffer2.readLine();
                 String[] data = line.split(" ");
                for(int j =0; j < grid.getRows(); j++){
                        if(data[j].contains("1")){
                            cells[j][i].edit(Color.BLACK);
                        }else{
                            cells[j][i].delete();
                        }
                }
            }


            input.close();
         }catch (FileNotFoundException e){
             e.printStackTrace();
         }catch (IOException e){
             e.printStackTrace();
         }
    }


}
