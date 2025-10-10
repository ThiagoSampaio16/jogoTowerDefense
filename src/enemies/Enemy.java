package enemies;

import java.awt.Rectangle;
import static helpz.Constants.Direction.*;

public class Enemy {

    private float x,y;
    private Rectangle bounds;
    private int health;
    private int ID;
    private int enemyType;
    private int lastDir;

    public Enemy(float x, float y, int ID, int enemyType) {
        this.x=x;
        this.y=y;
        this.ID=ID;
        this.enemyType=enemyType;

        bounds =  new Rectangle((int)x,(int)y,32,32); 
        lastDir = RIGHT; 
    }

    public void move(float dx, float dy){ // Renomeei para dx, dy (Delta X, Delta Y) para clareza
    this.x += dx; // Adiciona o deslocamento X à posição atual X
    this.y += dy; // Adiciona o deslocamento Y à posição atual Y
    
    // Opcional, mas recomendado: Atualize também o Rectangle bounds
    this.bounds.x = (int)this.x;
    this.bounds.y = (int)this.y;
}


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public int getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(int enemyType) {
        this.enemyType = enemyType;
    }

    public int getLastDir(){
        return lastDir;
    }
    
}
