package helpz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {


    public static BufferedImage getSpriteAtlas(){
        BufferedImage img = null;
        try {
            // 1ª tentativa: dentro dos recursos do classpath
            InputStream is = LoadSave.class.getClassLoader().getResourceAsStream("Sprites_do_jogo_Larissa.png");
            if (is != null) {
                img = ImageIO.read(is);
                System.out.println("Imagem carregada do classpath!");
                return img;
            }

            // 2ª tentativa: caminho direto (VS Code)
            File file = new File("src/main/resources/Sprites_do_jogo_Larissa.png");
            if (file.exists()) {
                img = ImageIO.read(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

}
