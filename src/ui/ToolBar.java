package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.Graphics;

import static main.java.GameStates.MENU;
import static main.java.GameStates.*;

import java.awt.Color;
import java.awt.image.BufferedImage;

import objects.Tile;
import scenes.Editing;

public class ToolBar extends Bar{
    private Editing editing;
    private MyButton bMenu, bSave;

    
    private Tile selectedTile;

    //private ArrayList<MyButton> tileButtons = new ArrayList<>();

    private Map<MyButton, ArrayList<Tile>> map = new HashMap<MyButton, ArrayList<Tile>>();

    private MyButton bGrass, bWater, bRoad1, bRoad2, bRoadCurved1, bRoadCurved2, bRoadCurved3, bRoadCurved4;


    public ToolBar(int x, int y, int width, int height, Editing editing){
        super(x, y, width, height);
        this.editing = editing;

        initButtons();

    }

    
    private void initButtons() {
        bMenu = new MyButton("Menu", 2, 642, 100, 30);
        bSave = new MyButton("Save", 2, 674, 100, 30);

        int w=50;
        int h=50;
        int xStart=110;
        int yStart=650;
        int xOffset= (int) (w * 1.1f);
        int i=0;

        bGrass = new MyButton("Grass", xStart, yStart, w, h, i++);
        bWater = new MyButton("Water", xStart + xOffset, yStart, w, h, i++);

        initMapButton(bRoad1, editing.getJogo().getTileManager().road1, xStart, yStart, xOffset, w, h, i++);
        initMapButton(bRoad2, editing.getJogo().getTileManager().road2, xStart, yStart, xOffset, w, h, i++);
        initMapButton(bRoadCurved1, editing.getJogo().getTileManager().roadcurved1, xStart, yStart, xOffset, w, h, i++);
        initMapButton(bRoadCurved2, editing.getJogo().getTileManager().roadcurved2, xStart, yStart, xOffset, w, h, i++);
        initMapButton(bRoadCurved3, editing.getJogo().getTileManager().roadcurved3, xStart, yStart, xOffset, w, h, i++);
        initMapButton(bRoadCurved4, editing.getJogo().getTileManager().roadcurved4, xStart, yStart, xOffset, w, h, i++);


    }

    private void initMapButton(MyButton b, ArrayList<Tile> list, int x, int y, int xoff, int w, int h, int id){

        b = new MyButton("", x + xoff * id, y, w, h, id);
        map.put(b, list);

    }

    private void saveLevel() {
        editing.saveLevel();
    }

    public void draw(java.awt.Graphics g) {

        //background
        g.setColor(new Color(220, 123, 15));
        g.fillRect(x, y, width, height);

        //buttons
        drawButtons(g);
    }

        public void drawButtons(Graphics g) {
        bMenu.draw(g);
        bSave.draw(g);

        drawNormalButton(g, bGrass);
        drawNormalButton(g, bWater);
        drawSelectedTile(g);
        drawMapButtons(g);


    }

    private void drawNormalButton(Graphics g, MyButton b) {
        g.drawImage(getButtImg(b.getId()), b.x, b.y,b.width,b.height,null);
        drawButtonsFeedBack(g, b);
        

    }


    private void drawMapButtons(Graphics g) {
        for(Map.Entry<MyButton, ArrayList<Tile>> entry : map.entrySet()){
            MyButton b = entry.getKey();
            BufferedImage img = entry.getValue().get(0).getSprite();

            g.drawImage(img, b.x, b.y, b.width, b.height, null);

            drawButtonsFeedBack(g, b);
        }
    }

    private void drawButtonsFeedBack(Graphics g, MyButton b){
        //mouse por cima
        if(b.isMouseOver()){
            g.setColor(Color.white);
        }else{
            g.setColor(Color.BLACK);
        }
        //borda
        g.drawRect(b.x, b.y, b.width, b.height);
        //mouse pressionado
        if(b.isMousePressed()){
            g.drawRect(b.x + 1, b.y + 1, b.width - 2, b.height - 2);
            g.drawRect(b.x + 2, b.y + 2, b.width - 4, b.height - 4);
        }
    }


    private void drawSelectedTile(Graphics g){
        if(selectedTile != null){
            g.drawImage(selectedTile.getSprite(), 550, 650, 50, 50, null);
            g.setColor(Color.BLACK);
            g.drawRect(550, 650, 50, 50);
        }
    }

    public void mouseClicked(int x, int y) {
        if (bMenu.getBounds().contains(x, y)) {
            SetGameState(MENU);
        }
        else if (bSave.getBounds().contains(x, y)) {
            saveLevel();
        }
        else if (bWater.getBounds().contains(x, y)){
            selectedTile = editing.getJogo().getTileManager().getTile(bWater.getId());
            editing.setSelectedTile(selectedTile);
            return;
        }else if (bGrass.getBounds().contains(x, y)){
            selectedTile = editing.getJogo().getTileManager().getTile(bGrass.getId());
            editing.setSelectedTile(selectedTile);
            return;
        }
        else {
            for (MyButton b : map.keySet()){
                if( b.getBounds().contains(x, y)){
                    selectedTile = map.get(b).get(0);
                    editing.setSelectedTile(selectedTile);
                    return;
                }
            }
        }
        
    }

    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);
        bSave.setMouseOver(false);
        bWater.setMouseOver(false);
        bGrass.setMouseOver(false);
        for (MyButton b : map.keySet()){
            b.setMouseOver(false);    
        }

        if (bMenu.getBounds().contains(x, y)) {
            bMenu.setMouseOver(true);
        }
        else if (bSave.getBounds().contains(x, y)) {
            bSave.setMouseOver(true);
        }
        else if (bWater.getBounds().contains(x, y)) {
            bWater.setMouseOver(true);
        }
        else if (bGrass.getBounds().contains(x, y)) {
            bGrass.setMouseOver(true);
        } else{
            for (MyButton b : map.keySet()){
                if( b.getBounds().contains(x, y)){
                    b.setMouseOver(true);
                    return;
                }
            }
        }
        
    }

    public BufferedImage getButtImg(int id) {
        return editing.getJogo().getTileManager().getSprite(id);
        
    }

    public void mousePressed(int x, int y) {
        if (bMenu.getBounds().contains(x, y)) {
            bMenu.setMousePressed(true);
        }
        else if (bSave.getBounds().contains(x, y)){
            bSave.setMousePressed(true);
        }
        else if (bWater.getBounds().contains(x, y)){
            bWater.setMousePressed(true);
        }
        else if (bGrass.getBounds().contains(x, y)){
            bGrass.setMousePressed(true);
        }
            
        else{
        for (MyButton b : map.keySet()){
                if( b.getBounds().contains(x, y)){
                    b.setMousePressed(true);
                    return;
                }
            }
        }
    }


    public void mouseReleased(int x, int y) {
        bMenu.resetBooleans();
        bSave.resetBooleans();
        bGrass.resetBooleans();
        bWater.resetBooleans();
        for (MyButton b : map.keySet()){
            b.resetBooleans();
        }
        
    }

}
