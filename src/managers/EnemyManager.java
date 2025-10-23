package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enemies.Enemy;
import enemies.SlimeRoxa;
import enemies.SlimeAzul;
import enemies.SlimeVerde;
import enemies.TodasSlimesJuntas;
import helpz.LoadSave;
import objects.PathPoint;
import scenes.Playing;
import static helpz.Constants.Direction.*;
import static helpz.Constants.Tiles.*;
import static helpz.Constants.Enemies.*;

public class EnemyManager  {

    private Playing playing;
    private BufferedImage[] enemyImgs;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    //private float speed = 0.5f;
    private PathPoint start, end;

    public EnemyManager(Playing playing, PathPoint start, PathPoint end) {
        this.playing=playing;
        enemyImgs = new BufferedImage[4];
        this.start = start;
        this.end = end;
        addEnemy(SLIME_AZUL);
        addEnemy(SLIME_ROXO);
        addEnemy(SLIME_VERDE);
        addEnemy(TODAS_SLIMES_JUNTAS);


        loadEnemyImgs();

    }

    private void loadEnemyImgs() {
        BufferedImage atlas = LoadSave.getSpriteAtlas();

       for(int i = 0; i < 4; i++){
            enemyImgs[i]=atlas.getSubimage(i * 32,0,32,32);
       }
    }

    // Arquivo: managers/EnemyManager.java

public void update(){
    for (Enemy e : enemies){
        updateEnemyMove(e);
    } 
}

    private void updateEnemyMove(Enemy e) {
        if(e.getLastDir() == -1){
            setNewDirectionAndMove(e);
        }

        int newX = (int)(e.getX() + getSpeedandWidht(e.getLastDir(), e.getEnemyType()));
        int newY = (int)(e.getY() + getSpeedandHeight(e.getLastDir(), e.getEnemyType()));

        if(getTileType(newX, newY) == ROADS_TILE){
            //Continuar na mesma direção
            e.move(GetSpeed(e.getEnemyType()), e.getLastDir());
        }else if(isAtEnd(e)){
            //Chegou ao fim do caminho 
            System.out.println("Vida Perdida!");
        }else{
            setNewDirectionAndMove(e);
        }
        
    }

    private void setNewDirectionAndMove(Enemy e) {
        int dir = e.getLastDir();

        int xCord = (int)(e.getX() / 32);
        int yCord = (int)(e.getY() / 32);

        fixEnemyoffsetTile(e, dir, xCord, yCord);

        if(isAtEnd(e)){
            return;
        }

        if(dir == LEFT || dir == RIGHT){
            //Tentar cima e baixo
            int newY = (int)(e.getY() + getSpeedandHeight(UP, e.getEnemyType()));
            if(getTileType((int)e.getX(), newY) == ROADS_TILE){
                e.move(GetSpeed(e.getEnemyType()), UP);
            }else{
                e.move(GetSpeed(e.getEnemyType()), DOWN);
            }
            
        //Tentar todas as direções possíveis exceto a última
        } else{
            int newX = (int)(e.getX() + getSpeedandWidht(RIGHT, e.getEnemyType()));
            if(getTileType(newX, (int)e.getY()) == ROADS_TILE){
                e.move(GetSpeed(e.getEnemyType()), RIGHT);
            }else{
                e.move(GetSpeed(e.getEnemyType()), LEFT);
            }
        }
            
    }

    private void fixEnemyoffsetTile(Enemy e, int dir, int xCord, int yCord) {
        switch(dir){
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
        if(e.getX() == end.getxCord() * 32){
            if(e.getY() == end.getyCord() * 32){
                return true;
            }
        }
        return false;
    }

    private int getTileType(int x, int y){
        return playing.getTileType(x, y);
}
    private float getSpeedandHeight(int dir, int enemyType) {
        if (dir == UP){
            return -GetSpeed(enemyType);
        }else if (dir == DOWN){
            return GetSpeed(enemyType) + 32;
        }

        return 0;
    }

    private float getSpeedandWidht(int dir, int enemyType) {
        if (dir == LEFT){
            return -GetSpeed(enemyType);
        }else if (dir == RIGHT){
            return GetSpeed(enemyType) + 32;
        }

        return 0;
    }

    public void addEnemy(int EnemyType){
        int x = start.getxCord() * 32;
        int y = start.getyCord() * 32;
        
        switch (EnemyType) {
            case SLIME_AZUL:
                enemies.add(new SlimeAzul(x,y,0));
                break;
            case SLIME_ROXO:
                enemies.add(new SlimeRoxa(x,y,0));
                break;
            case SLIME_VERDE:
                enemies.add(new SlimeVerde(x,y,0));
                break;
            case TODAS_SLIMES_JUNTAS:
                enemies.add(new TodasSlimesJuntas(x,y,0));
                break;
        }
        
    }

    public void draw(Graphics g){

        for(Enemy e : enemies){
            drawEnemy(e,g);
        }
        

    }

    private void drawEnemy(Enemy e, Graphics g){
        g.drawImage(enemyImgs[e.getEnemyType()], (int)e.getX(), (int)e.getY(), null);

    }



}
