package scenes;

import main.java.Jogo;
import managers.EnemyManager;
import managers.ProjectileManager;
import managers.TowerManager;
import objects.PathPoint;
import objects.Projectile;
import objects.Tower;

import static helpz.Constants.Tiles.GRASS_TILE;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enemies.Enemy;
import helpz.LoadSave;
import ui.ActionBar;


public class Playing extends GameScene implements SceneMethods{

    private int[][] lvl;
    private ActionBar actionBar;
    private int mouseX, mouseY;
    private EnemyManager enemyManager;
    private TowerManager towerManager;
    private ProjectileManager projManager;
    private PathPoint start, end;
    private Tower selectedTower;

    public Playing(Jogo jogo) {

        super(jogo);


        loadDefaultLevel();

        actionBar = new ActionBar(0, 640, 640, 160, this);

        enemyManager = new EnemyManager(this, start, end);

        towerManager = new TowerManager(this);

        projManager = new ProjectileManager(this);
        

    }

    

    private void loadDefaultLevel() {
        lvl = LoadSave.GetLevelData("new_level");
        ArrayList<PathPoint> points = LoadSave.GetLevelPathPoints("new_level");
        start = points.get(0);
        end = points.get(1);
        
    }

    public void setLevel(int [][] lvl){
        this.lvl = lvl;
    }

    public void update(){
        enemyManager.update();
        towerManager.update();
        projManager.update();
    }

    public void setSelectedTower(Tower selectedTower) {
        this.selectedTower = selectedTower;
    }

    @Override
    public void render(Graphics g) {
        drawLevel(g);
        actionBar.draw(g);
        enemyManager.draw(g);
        towerManager.draw(g);
        projManager.draw(g);

        drawSelectedTower(g);
        drawHighLighted(g);
    }

    private void drawHighLighted(Graphics g) {
        g.setColor(Color.white);
        g.drawRect(mouseX, mouseY, 32, 32);
        
    }



    private void drawSelectedTower(Graphics g) {
        if(selectedTower != null){
            g.drawImage(towerManager.getTowerImg()[selectedTower.getTowerType()], mouseX, mouseY, null);
        }
    }



    private void drawLevel(Graphics g){
        for(int y = 0; y < lvl.length; y++){
            for(int x = 0; x < lvl[y].length; x++){
                int id = lvl[y][x];
                g.drawImage(getSprite(id), x*32, y*32, null);
            }
        }
    }

    public int getTileType(int x, int y){
        int xCord = x / 32;
        int yCord = y / 32;

        if(xCord < 0 || xCord > 19){
            return 0;
        }
        if(yCord < 0 || yCord > 19){
            return 0;
        }


        int id = lvl[y/32][x/32];
        return jogo.getTileManager().getTile(id).getTileType();
    }

    private BufferedImage getSprite(int spriteID){
        return jogo.getTileManager().getSprite(spriteID);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if(y >= 640){
            actionBar.mouseClicked(x, y);
        }else{
            if(selectedTower != null){
                if(isTileGrass(mouseX, mouseY)){
                    if(getTowerAt(mouseX, mouseY) == null){
                        towerManager.addTower(selectedTower, mouseX, mouseY);
                        selectedTower = null;
                    }
                }
            }else{
                //saber se a torre existe
                Tower t = getTowerAt(mouseX, mouseY);
                actionBar.displayTower(t);
                
            }
        }
    }
    private Tower getTowerAt(int x, int y) {
        return towerManager.getTowerAt(x, y);
    }


    private boolean isTileGrass(int x, int y) {
        int id = lvl[y / 32][x / 32];
        int tileType = jogo.getTileManager().getTile(id).getTileType();

        return tileType == GRASS_TILE;
    }

    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			selectedTower = null;
		}
	}



    @Override
    public void mouseMoved(int x, int y) {
        if(y >= 640){
            actionBar.mouseMoved(x, y);
        } else{
            mouseX = (x / 32) * 32;
            mouseY = (y / 32) * 32;
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if(y >= 640){
            actionBar.mousePressed(x, y);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        
            actionBar.mouseReleased(x, y);
       
        
    }

    @Override
    public void mouseDragged(int x, int y) {
        
    }

    public TowerManager getTowerManager(){
        return towerManager;
    }

    public EnemyManager getEnemyManager(){
        return enemyManager;
    }



	public void shootEnemy(Tower t, Enemy e) {
		projManager.newProjectile(t, e);
	}



    
}
