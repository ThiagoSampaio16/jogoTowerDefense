package managers;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpz.LoadSave;
import objects.Tile;
import static helpz.Constants.Tiles.*;

public class TileManager {

    public Tile GRASS, WATER, ROAD1, ROAD2, ROADCURVED1, ROADCURVED2, ROADCURVED3, ROADCURVED4;
    public BufferedImage atlas;
    public ArrayList<Tile> tiles = new ArrayList<>();

    public ArrayList<Tile> road1 = new ArrayList<>();
    public ArrayList<Tile> road2 = new ArrayList<>();
    public ArrayList<Tile> roadcurved1 = new ArrayList<>();
    public ArrayList<Tile> roadcurved2 = new ArrayList<>();
    public ArrayList<Tile> roadcurved3 = new ArrayList<>();
    public ArrayList<Tile> roadcurved4 = new ArrayList<>();

    public TileManager() {

        loadAtlas();
        createTiles();

    }

    private void createTiles(){

        int id = 0;
        tiles.add(GRASS = new Tile(getSprite(9, 2),id++, GRASS_TILE));
        tiles.add(WATER = new Tile(getSprite(6, 2),id++, WATER_TILE));
        road1.add(ROAD1 = new Tile(getSprite(9, 1),id++, ROADS_TILE));
        road2.add(ROAD2 = new Tile(getSprite(9, 0),id++, ROADS_TILE));
        roadcurved1.add(ROADCURVED1 = new Tile(getSprite(7, 1),id++, ROADS_TILE));
        roadcurved2.add(ROADCURVED2 = new Tile(getSprite(8, 1),id++, ROADS_TILE));
        roadcurved3.add(ROADCURVED3 = new Tile(getSprite(8, 2),id++, ROADS_TILE));
        roadcurved4.add(ROADCURVED4 = new Tile(getSprite(7, 2),id++, ROADS_TILE));

        tiles.addAll(road1);
        tiles.addAll(road2);
        tiles.addAll(roadcurved1);
        tiles.addAll(roadcurved2);
        tiles.addAll(roadcurved3);
        tiles.addAll(roadcurved4);
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

    public ArrayList<Tile> getRoad1() {
        return road1;
    }

    public ArrayList<Tile> getRoad2() {
        return road2;
    }

    public ArrayList<Tile> getRoadcurved1() {
        return roadcurved1;
    }

    public ArrayList<Tile> getRoadcurved2() {
        return roadcurved2;
    }

    public ArrayList<Tile> getRoadcurved3() {
        return roadcurved3;
    }

    public ArrayList<Tile> getRoadcurved4() {
        return roadcurved4;
    }
}

