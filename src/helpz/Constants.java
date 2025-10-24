package helpz;

public class Constants {

    public static class Projectiles{
        public static final int FOGO_ABOBORA = 0;
        public static final int BOLA_GATO = 1;
        public static final int CORTE_FOICE = 2;

        public static Float GetSpeed(int type){
            switch(type){
                case FOGO_ABOBORA:
                    return 3.0f;
                case BOLA_GATO:
                    return 1.0f;
                case CORTE_FOICE:
                    return 2.0f;
            }
            return 0f;
        }
    };


    public static class Towers {
        public static final int ABOBORA = 0;
        public static final int GATO = 1;
        public static final int FOICE = 2;
        
        public static String GetName(int towerType) {
            switch (towerType) {
                case ABOBORA:
                    return "Abóbora";
                case GATO:
                    return "Gato";
                case FOICE:
                    return "Foice";
            }
            return "";
        }

        public static int GetDefaultDmg(int towerType) {
            switch (towerType) {
                case ABOBORA:
                    return 35;
                case GATO:
                    return 52;
                case FOICE:
                    return 87;
            }
            return 0;
        }

        public static float GetDefaultRange(int towerType) {
            switch (towerType) {
                case ABOBORA:
                    return 100;
                case GATO:
                    return 100;
                case FOICE:
                    return 100;
            }
            return 0;
        }

        public static float GetDefaultCooldown(int towerType) {
            switch (towerType) {
                case ABOBORA:
                    return 10;
                case GATO:
                    return 10;
                case FOICE:
                    return 10;
            }
            return 0;
        }
    }

    public static class Direction {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class Enemies {
        public static final int SLIME_AZUL = 0;
        public static final int SLIME_ROXO = 1;
        public static final int SLIME_VERDE = 2;
        public static final int TODAS_SLIMES_JUNTAS = 3;

        public static float GetSpeed(int enemyType) {
            switch (enemyType) {
                case SLIME_AZUL:
                    return 0.7f;
                case SLIME_ROXO:
                    return 1.0f;
                case SLIME_VERDE:
                    return 1.3f;
                case TODAS_SLIMES_JUNTAS:
                    return 0.3f;
            }

            return 0;
        }

        public static int GetStartHealth(int enemyType) {
            switch (enemyType) {
                case SLIME_AZUL:
                    return 200;
                case SLIME_ROXO:
                    return 150;
                case SLIME_VERDE:
                    return 100;
                case TODAS_SLIMES_JUNTAS:
                    return 500;
            }

            return 0;
        }
    }

    public static class Tiles{
    public static final int WATER_TILE = 0;
    public static final int GRASS_TILE = 1;
    public static final int ROADS_TILE = 2;
    }

}
