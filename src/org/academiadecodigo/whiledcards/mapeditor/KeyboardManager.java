package org.academiadecodigo.whiledcards.mapeditor;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.whiledcards.mapeditor.Grid.Cursor;
import org.academiadecodigo.whiledcards.mapeditor.Grid.Menu;

public class KeyboardManager implements KeyboardHandler {

    private Cursor cursor;
    private MapEditor map;
    private Menu menu;

    public KeyboardManager(Cursor cursor, MapEditor map, Menu menu){
        this.cursor = cursor;
        this.map = map;
        this.menu = menu;
        assembleKeyboard();
    }


    public void assembleKeyboard() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);

        eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_RIGHT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);

        eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_UP);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);

        eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_DOWN);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);

        eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_SPACE);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);

        KeyboardEvent eventSave = new KeyboardEvent();
        eventSave.setKey(KeyboardEvent.KEY_S);
        eventSave.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventSave);

        eventSave = new KeyboardEvent();
        eventSave.setKey(KeyboardEvent.KEY_L);
        eventSave.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventSave);

        eventSave = new KeyboardEvent();
        eventSave.setKey(KeyboardEvent.KEY_SPACE);
        eventSave.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventSave);

        eventSave = new KeyboardEvent();
        eventSave.setKey(KeyboardEvent.KEY_C);
        eventSave.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventSave);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            cursor.moveLeft();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            cursor.moveRight();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            cursor.moveUp();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            cursor.moveDown();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            map.save();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_L) {
            map.load();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_C) {
            menu.changeColor();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            map.getGrid().change(cursor.getCol(),cursor.getRow(),menu.getCurrentColor());
        }
    }
}
