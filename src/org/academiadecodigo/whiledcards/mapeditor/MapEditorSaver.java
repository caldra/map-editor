package org.academiadecodigo.whiledcards.mapeditor;

import java.io.*;

public class MapEditorSaver {
    private String notDrawn = "0\n";
    private String drawn = "1\n";
    private Cell[][] cells;

     public void save(Grid grid){
         cells = grid.getCells();
        try {

            FileWriter output = new FileWriter("resources/save.txt");
            BufferedWriter buffer = new BufferedWriter(output);
            for(int i = 0; i < grid.getCols(); i++){
                for(int j =0; j < grid.getRows(); j++){
                    if(!cells[i][j].getDrawn()){
                    buffer.write(notDrawn);
                    }else{
                        buffer.write(drawn);
                    }
                }
            }
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
                for(int j =0; j < grid.getRows(); j++){
                    String drawnStatus = buffer2.readLine();
                        if(drawnStatus.contains("1")){
                            cells[i][j].edit();
                        }else{
                            cells[i][j].delete();
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
