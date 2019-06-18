package org.academiadecodigo.whiledcards.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Cursor implements KeyboardHandler {
    private Grid grid;
    private int col;
    private int row;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle cursor;


    public Cursor(Grid grid) {
        col = 0;
        row = 0;
        this.grid = grid;
        cursor = new Rectangle(grid.translateCols(col), grid.translateRows(row), grid.getCellSize(), grid.getCellSize());
        cursor.setColor(Color.BLUE);
        cursor.fill();
    }

    private void moveUp() {
        if (row == 0) {
            row = 0;
            return;
        }
        row--;
        cursor.translate(0, -grid.getCellSize());
        cursor.fill();
    }

    private void moveDown() {
        if (row == grid.getRows() - 1) {
            row = grid.getRows() - 1;
            return;
        }
        row++;
        cursor.translate(0, grid.getCellSize());
        cursor.fill();
    }

    private void moveLeft() {
        if (col == 0) {
            col = 0;
            return;
        }
        col--;
        cursor.translate(-grid.getCellSize(), 0);
        cursor.fill();
    }

    private void moveRight() {
        if (col == grid.getCols() - 1) {
            col = grid.getCols() - 1;
            return;
        }
        col++;
        cursor.translate(grid.getCellSize(), 0);
        cursor.fill();
    }

    private void paint() {
        grid.change(col, row);
    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            moveLeft();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            moveRight();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            moveUp();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            moveDown();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            paint();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

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

    }
}
