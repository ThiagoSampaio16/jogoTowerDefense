package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enemies.Enemy;
import helpz.LoadSave;
import scenes.Playing;
import static helpz.Constants.Direction.*;

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
            float xSpeed = getSpeedX(e.getLastDir());
            float ySpeed = getSpeedY(e.getLastDir());

            // 3. Chame o método move com a velocidade calculada
            e.move(xSpeed, ySpeed); // <--- ESTA É A LINHA QUE FALTAVA
        }
    } 
}

    private boolean isNextTileRoad(Enemy e) {
        int newX = (int)(e.getX() + getSpeedX(e.getLastDir()));
        int newY = (int)(e.getY() + getSpeedY(e.getLastDir()));

        

        return true;
        
    }

    private float getSpeedY(int dir) {
        if (dir == UP){
            return -speed;
        }else if (dir == DOWN){
            return speed;
        }

        return 0;
    }

    private float getSpeedX(int dir) {
        if (dir == LEFT){
            return -speed;
        }else if (dir == RIGHT){
            return speed;
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
