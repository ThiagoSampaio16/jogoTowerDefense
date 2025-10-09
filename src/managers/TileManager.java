package managers;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpz.LoadSave;
import objects.Tile;

public class TileManager {

    public Tile GRASS, WATER, ROAD1, ROAD2;
    public BufferedImage atlas;
    public ArrayList<Tile> tiles = new ArrayList<>();

    public TileManager() {

        loadAtlas();
        createTiles();

    }

    private void createTiles(){

        int id = 0;
        tiles.add(GRASS = new Tile(getSprite(9, 2),id++,"grass"));
        tiles.add(WATER = new Tile(getSprite(6, 2),id++,"water"));
        tiles.add(ROAD1 = new Tile(getSprite(8, 0),id++,"road1"));
        tiles.add(ROAD2 = new Tile(getSprite(9, 0),id++,"road2"));
        //PRECISO DESCOBRIR AS VERDADEIRAS POSSIÇÕES DOS SPRITES NO ATLAS
    }

    private void loadAtlas(){

        atlas = LoadSave.getSpriteAtlas();
    }

    public Tile getTile(int id){
        return tiles.get(id);
    }

    public BufferedImage getSprite(int id){
        return tiles.get(id).getSprite();
    }

    private BufferedImage getSprite(int xCord, int yCord){
        return atlas.getSubimage(xCord*32, yCord*32, 32, 32);    
    }
}
