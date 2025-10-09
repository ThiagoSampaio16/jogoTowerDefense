package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;

import scenes.Playing;
import objects.Tile;
import ui.MyButton;
import static main.java.GameStates.*;


public class BottomBar {

    private int x, y, width, height;
    private MyButton bMenu;
    private Playing playing;

    private ArrayList<MyButton> tileButtons = new ArrayList<>();

    public BottomBar(int x, int y, int width, int height, Playing playing) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.playing = playing;

        initButtons();
    }

    private void initButtons() {
        bMenu = new MyButton("Menu", 2, 642, 100, 30);

        int w=50;
        int h=50;
        int xStart=110;
        int yStart=650;
        int xOffset= (int) (w * 1.1f);
        
        int i=0;
        for (Tile tile : playing.getTileManager().tiles) {
            tileButtons.add(new MyButton(tile.getName(), xStart + xOffset * i , yStart , w, h, i));
            i++;
        }
        
    }

    public void drawButtons(Graphics g) {
        bMenu.draw(g);

        drawTileButtons(g);


    }

    private void drawTileButtons(Graphics g) {
        for (MyButton b : tileButtons) {
            g.drawImage(getButtImg(b.getId()), b.x, b.y,b.width,b.height,null);
        }
        
    }

    public BufferedImage getButtImg(int id) {
        return playing.getTileManager().getSprite(id);
        
    }

    public void draw(java.awt.Graphics g) {

        //background
        g.setColor(new Color(220, 123, 15));
        g.fillRect(x, y, width, height);

        //buttons
        drawButtons(g);
    }

    
    public void mouseClicked(int x, int y) {
        if (bMenu.getBounds().contains(x, y)) {
            SetGameState(MENU);}
        
    }

    
    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);
        if (bMenu.getBounds().contains(x, y)) {
            bMenu.setMouseOver(true);
        }
        
    }

    
    public void mousePressed(int x, int y) {
        if (bMenu.getBounds().contains(x, y)) {
            bMenu.setMousePressed(true);
            
        }
    }

    
    public void mouseReleased(int x, int y) {
        bMenu.resetBooleans();
        
    }

    public void mouseDragged(int x, int y) {
        // TODO Auto-generated method stub
        
    }


} 
