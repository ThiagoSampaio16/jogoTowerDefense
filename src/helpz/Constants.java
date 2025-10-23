package helpz;

public class Constants {

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
    }

    public static class Tiles{
    public static final int WATER_TILE = 0;
    public static final int GRASS_TILE = 1;
    public static final int ROADS_TILE = 2;
    }

}
