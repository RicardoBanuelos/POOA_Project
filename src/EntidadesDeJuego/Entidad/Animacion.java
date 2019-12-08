/*
* SEPARA Y CORRE 1.0
* JUEGO DESARROLLADO EN INTELLIJ IDEA PARA FOMENTAR EL RECOGER Y SEPARAR
RESIDUOS DE UNA MA
* AUTORES: BAÑUELOS DE LA TORRE RICARDO, LEYVA AYALA GENESIS MARIA,
LUNA MARTINEZ LUIS ALEJANDRO, RODRIGUEZ MUNOZ JOSE LUIS
* CORREO ELECTRONICO: {ricardo.banuelos, genesis.leyva, a1252765, lrodriguez99}@uabc.edu.mx
* UNIVERSIDAD AUTÓNOMA DEL ESTADO DE BAJA CALIFORNIA
* http://www.uabc.mx
*/

package EntidadesDeJuego.Entidad;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Animacion {

    private int speed;
    private int frames;

    private int index = 0;
    private int count = 0;

    private BufferedImage[] images;
    private BufferedImage currentImg;

    public Animacion(int speed, BufferedImage... args){
        this.speed = speed;
        this.images = new BufferedImage[args.length];
        for(int i = 0; i < args.length; i++)
            images[i] = args[i];
        frames = args.length;
    }

    public void runAnimation(){
        index++;
        if(index > speed) {
            index = 0;
            nextFrame();
        }
    }

    private void nextFrame(){
        for(int i = 0; i < frames; i++){
            if(count == i)
                currentImg = images[i];
        }
        count++;
        if(count > frames)
            count = 0;
    }

    public void drawAnimation(Graphics g, int x, int y){
        g.drawImage(currentImg,x,y,null);
    }

    public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY){
        g.drawImage(currentImg,x,y,scaleX,scaleY,null);
    }
}
