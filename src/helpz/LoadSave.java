package helpz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java.util.Scanner;


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

    //txt files
    public static void CreateFile() {
    File txtfile = new File("src/main/resources/testTextFile.txt");
    try {
        // Cria o arquivo somente se ele ainda não existir
        if (!txtfile.exists()) {
            boolean created = txtfile.createNewFile();
            if (created) {
                System.out.println("Arquivo criado com sucesso!");
            } else {
                System.out.println("Não foi possível criar o arquivo.");
            }
        } else {
            System.out.println("Arquivo já existe.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static void CreateLevel(String name, int[] idArr){
        File newLevel = new File("src/main/resources/"+name+".txt");

        if (newLevel.exists()) {
            System.out.println("Level already exists.");
            return;
        }else{
            try {
                boolean created = newLevel.createNewFile();
                if (created) {
                    System.out.println("Level created successfully!");
                } else {
                    System.out.println("Could not create the level.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            WriteToFile(newLevel, idArr);

        }
    }


    private static void WriteToFile(File f, int[] idArr) {
    

    try {
        // Cria o arquivo se não existir
        if (!f.exists()) {
            f.createNewFile();
        }

        // Escreve no arquivo
        try (PrintWriter pw = new PrintWriter(f)) {
            for (int i : idArr) {
                pw.println(i);
            }
            pw.close();
            System.out.println("Texto escrito com sucesso!");
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void ReadFromFile() {
    File txtfile = new File("src/main/resources/testTextFile.txt");

    if (!txtfile.exists()) {
        System.out.println("Arquivo não encontrado.");
        return;
    }

    try (Scanner sc = new Scanner(txtfile)) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}

    

}
