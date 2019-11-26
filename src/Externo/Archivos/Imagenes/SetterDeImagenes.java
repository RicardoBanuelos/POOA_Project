package Externo.Archivos.Imagenes;

import Externo.Archivos.Imagenes.BufferedImageLoader;
import Externo.Archivos.Imagenes.SpriteSheet;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class SetterDeImagenes {

    // Cargador de imágenes
    private static BufferedImageLoader BIL = new BufferedImageLoader();
    // Imágenes completas
    public static BufferedImage menuBG = null;
    public static BufferedImage leaderboardsBG = null;
    public static BufferedImage gameoverBG = null;
    public static BufferedImage nivel1 = null;
    public static BufferedImage nivel2 = null;
    public static BufferedImage nivel3 = null;
    public static BufferedImage nivel4 = null;
    public static BufferedImage nivel5 = null;
    public static BufferedImage nivel6 = null;
    private static BufferedImage jugadorSheet = null;
    private static BufferedImage enemigoBSheet = null;
    private static BufferedImage enemigoRSheet = null;
    private static BufferedImage jefeSheet = null;
    private static BufferedImage basuraSheet = null;
    private static BufferedImage recicladoraSheet = null;
    // Imágenes recortadas
    public static BufferedImage[] jugador = new BufferedImage[4];
    public static BufferedImage[] enemigoBasico = new BufferedImage[2];
    public static BufferedImage[] enemigoRapido = new BufferedImage[2];
    public static BufferedImage organico = null;
    public static BufferedImage aluminio = null;
    public static BufferedImage plastico = null;
    public static BufferedImage carton = null;
    public static BufferedImage recicOrganic = null;
    public static BufferedImage recicAlum = null;
    public static BufferedImage recicPlastic = null;
    public static BufferedImage recicCarton = null;
    public static BufferedImage[] jefe = new BufferedImage[3];

    public static void cargaImagenes() {
        cargaFondo();
        cargaBasura();
        cargaEnemigos();
        cargaJugador();
    }

    private static void cargaFondo(){
        try {
            // Carga imágenes completas
            menuBG = BIL.loadImage("res/menuBG.png");
            leaderboardsBG = BIL.loadImage("res/leaderboardsbg.png");
            gameoverBG = BIL.loadImage("res/gameoverBG.png");
            nivel1 = BIL.loadImage("res/nivel1.png");
            nivel2 = BIL.loadImage("res/nivel1.png");
            nivel3 = BIL.loadImage("res/nivel1.png");
            nivel4 = BIL.loadImage("res/nivel1.png");
            nivel5 = BIL.loadImage("res/nivel1.png");
            nivel6 = BIL.loadImage("res/nivel1.png");
        }catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static void cargaBasura(){
        try {
            // Carga imágenes completas
            basuraSheet = BIL.loadImage("res/Basura.png");
            recicladoraSheet = BIL.loadImage("res/Recicladoras.png");
        }catch (IOException e) {

            e.printStackTrace();
        }
        // Inicializa los recortadores
        SpriteSheet tSheet = new SpriteSheet(basuraSheet);
        SpriteSheet rsheet = new SpriteSheet(recicladoraSheet);
        // Imágenes recortadas
        organico = tSheet.grabImage(1,1,32,32);
        aluminio = tSheet.grabImage(2,1,32,32);
        plastico = tSheet.grabImage(3,1,32,32);
        carton = tSheet.grabImage(4,1,32,32);
        recicOrganic = rsheet.grabImage(1,1,96,64);
        recicAlum = rsheet.grabImage(2,1,96,64);
        recicPlastic = rsheet.grabImage(3,1,96,64);
        recicCarton = rsheet.grabImage(4,1,96,64);
    }

    private static void cargaEnemigos(){
        try {
            // Carga imágenes completas
            enemigoBSheet = BIL.loadImage("res/enemigoAZUL.png");
            enemigoRSheet = BIL.loadImage("res/enemigoROJO.png");
            jefeSheet = BIL.loadImage("res/Jefe.png");
        }catch (IOException e) {

            e.printStackTrace();
        }
        // Inicializa los recortadores
        SpriteSheet eSheet = new SpriteSheet(enemigoBSheet);
        // Imágenes recortadas
        enemigoBasico[0] = eSheet.grabImage(2,4,48,64);
        enemigoBasico[1] = eSheet.grabImage(2,2,48,64);

        eSheet = new SpriteSheet(enemigoRSheet);

        enemigoRapido[0] = eSheet.grabImage(2,4,48,64);
        enemigoRapido[1] = eSheet.grabImage(2,2,48,64);

        SpriteSheet JSheet = new SpriteSheet(jefeSheet);

        jefe[0] = JSheet.grabImage(2,4,96,128);
        jefe[1] = JSheet.grabImage(2,2,96,128);
    }

    private static void cargaJugador(){
        try{
            jugadorSheet = BIL.loadImage("res/jugador.png");
        }catch (IOException e){
            e.printStackTrace();
        }

        SpriteSheet jSheet = new SpriteSheet(jugadorSheet);
        for(int i = 0; i < 4; i++)
            jugador[i] = jSheet.grabImage(i+1,1,32,64);
    }
}