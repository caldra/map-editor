package org.academiadecodigo.whiledcards.mapeditor;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Map implements KeyboardHandler{

    private Grid grid;
    private Cursor cursor;

    public Map(){
        Grid grid = new Grid();
        Cursor cursor = new Cursor(grid);
        cursor.assembleKeyboard();
        assembleKeyboard();
    }

    public void assembleKeyboard(){
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent eventSave = new KeyboardEvent();
        eventSave.setKey(KeyboardEvent.KEY_S);
        eventSave.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventSave);
    }

    public void save(){
        try {
            FileOutputStream output = new FileOutputStream("save");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            System.out.println("saved");
        }
    }
}
