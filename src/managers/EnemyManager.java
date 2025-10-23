package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enemies.Enemy;
import helpz.LoadSave;
import main.java.Jogo;
import scenes.Playing;
import static helpz.Constants.Direction.*;
import static helpz.Constants.Tiles.*;

public class EnemyManager  {

    private Playing playing;
    private BufferedImage[] enemyImgs;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private float speed = 0.5f;

    public EnemyManager(Playing playing){
        this.playing=playing;
        enemyImgs = new BufferedImage[4];
        addEnemy(3 * 32,9 * 32);
        loadEnemyImgs();

    }

    private void loadEnemyImgs() {
        BufferedImage atlas = LoadSave.getSpriteAtlas(); 
       enemyImgs[0]=atlas.getSubimage(0,0,32,32); 
       enemyImgs[1]=atlas.getSubimage(32,0,32,32);
       enemyImgs[2]=atlas.getSubimage(2 * 32,0,32,32);
       enemyImgs[3]=atlas.getSubimage(3 * 32,0,32,32);
    }

    // Arquivo: managers/EnemyManager.java

public void update(){
    for (Enemy e : enemies){
        // 1. Você tem a lógica de verificação (isNextTileRoad)
        if(isNextTileRoad(e)){
            // 2. Você precisa das velocidades baseadas na direção
            float xSpeed = getSpeedandWidht(e.getLastDir());
            float ySpeed = getSpeedandHeight(e.getLastDir());


        }
    } 
}

    private boolean isNextTileRoad(Enemy e) {
        int newX = (int)(e.getX() + getSpeedandWidht(e.getLastDir()));
        int newY = (int)(e.getY() + getSpeedandHeight(e.getLastDir()));

        if(getTileType(newX, newY) == ROADS_TILE){
            //Continuar na mesma direção
            e.move(speed, e.getLastDir());
        }else if(isAtEnd(e)){
            //Chegou ao fim do caminho 
        }else{
            setNewDirectionAndMove(e);
        }

        

        return false;
        
    }

    private void setNewDirectionAndMove(Enemy e) {
        int dir = e.getLastDir();

        int xCord = (int)(e.getX() / 32);
        int yCord = (int)(e.getY() / 32);

        fixEnemyoffsetTile(e, dir, xCord, yCord);

        if(dir == LEFT || dir == RIGHT){
            //Tentar cima e baixo
            int newY = (int)(e.getY() + getSpeedandHeight(UP));
            if(getTileType((int)e.getX(), newY) == ROADS_TILE){
                e.move(speed, UP);
            }else{
                e.move(speed, DOWN);
            }
            
        //Tentar todas as direções possíveis exceto a última
        } else{
            int newX = (int)(e.getX() + getSpeedandWidht(RIGHT));
            if(getTileType(newX, (int)e.getY()) == ROADS_TILE){
                e.move(speed, RIGHT);
            }else{
                e.move(speed, LEFT);
            }
        }
            
    }

    private void fixEnemyoffsetTile(Enemy e, int dir, int xCord, int yCord) {
        switch(dir){
//            case LEFT:
//                if(xCord > 0){
//                    xCord--;
//                }
//                break;
//            case UP:
//                if(yCord > 0){
//                    yCord--;
//                }
//                break;
            case RIGHT:
                if(xCord < 19){
                    xCord++;
                }
                break;
            case DOWN:
                if(yCord < 19){
                    yCord++;
                }
                break;
        }

        e.setPos(xCord * 32, yCord * 32);
    }

    private boolean isAtEnd(Enemy e) {
        return false;
    }

    private int getTileType(int x, int y){
        return playing.getTileType(x, y);
}
    private float getSpeedandHeight(int dir) {
        if (dir == UP){
            return -speed;
        }else if (dir == DOWN){
            return speed + 32;
        }

        return 0;
    }

    private float getSpeedandWidht(int dir) {
        if (dir == LEFT){
            return -speed;
        }else if (dir == RIGHT){
            return speed + 32;
        }

        return 0;
    }

    public void addEnemy(int x, int y){
        enemies.add(new Enemy(x,y,0,0));
    }

    public void draw(Graphics g){

        for(Enemy e : enemies){
            drawEnemy(e,g);
        }
        

    }

    private void drawEnemy(Enemy e, Graphics g){
        g.drawImage(enemyImgs[0], (int)e.getX(), (int)e.getY(), null);

    }



}
