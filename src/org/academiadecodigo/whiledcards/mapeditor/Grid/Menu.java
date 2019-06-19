package org.academiadecodigo.whiledcards.mapeditor.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Menu {
    private Rectangle colorCell;
    private static int PADDINGTOP = 650;
    private static int PADDINGRIGTH = 300;
    private int currentColor;
    private Color[] colorArr = {Color.BLACK,
            Color.MAGENTA,
            Color.CYAN
    };

    public Menu(){
        colorCell = new Rectangle(PADDINGTOP, PADDINGRIGTH, 20,20);
        currentColor = 0;
        colorCell.setColor(colorArr[currentColor]);
        colorCell.fill();
    }


    public void changeColor(){
        if (currentColor == (colorArr.length-1)){
            currentColor = -1;
        }
        currentColor++;
        colorCell.setColor(colorArr[currentColor]);
    }

    public Color getCurrentColor(){
        return colorArr[currentColor];
    }

}
