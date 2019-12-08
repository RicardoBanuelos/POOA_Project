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

package ComponentesDeJuego;

import java.awt.*;

public class Hud {

    public static int nivel = 1;
    public static int vida = 100;
    public static int escudo = 0;
    public static float velocidadMAX = 2.5f;
    public static boolean[] cargaBasura = new boolean[4];
    public static int puntaje = 0;
    public static int basuraEntregada = 0;

    Hud(){
        //inicializa en falso porque no estamos cargando ninguna basura
        cargaBasura[0] = false;
        cargaBasura[1] = false;
        cargaBasura[2] = false;
        cargaBasura[3] = false;
    }

    //metodo para resetear todas las variables del hud
    public static void resetJuego(){
        nivel = 1;
        vida = 100;
        escudo = 0;
        velocidadMAX = 2.5f;
        cargaBasura[0] = false;
        cargaBasura[1] = false;
        cargaBasura[2] = false;
        cargaBasura[3] = false;
        puntaje = 0;
        basuraEntregada = 0;
    }

    public void tick(){
        //no permite que estas variables se pasen de sus limites
        escudo = (int) Juego.clamp(escudo, 0, 100);
        vida = (int) Juego.clamp(vida, 0, 100);
    }

    //pinta el heads up display
    public void render(Graphics g){
        //rectangulo superior donde pintamos toda la info del jugador
        g.setColor(Color.black);
        g.fillRect(0,0, Juego.ANCHO, Juego.ALTURA /8);
        g.setColor(Color.white);
        g.drawRect(0,0, Juego.ANCHO, Juego.ALTURA /8);
        //letras del hud
        g.setFont(new Font("arial",0,20));
        g.drawString("Nivel: "+ nivel, Juego.ANCHO /26, Juego.ALTURA /25);
        g.drawString("Puntaje: "+ puntaje, Juego.ANCHO /26, Juego.ALTURA /13);
        g.drawString("Basura reciclada: "+ basuraEntregada, Juego.ANCHO /26, Juego.ALTURA /9);
        //ifs para indicarnos que esta cargando el jugador
        if(cargaBasura[0]) {
            g.drawString("Cargando cartón", (int) (Juego.ANCHO / 2.5), Juego.ALTURA / 16);
        }
        else if(cargaBasura[1]) {
            g.drawString("Cargando plástico", (int) (Juego.ANCHO / 2.5), Juego.ALTURA / 16);
        }
        else if(cargaBasura[2]) {
            g.drawString("Cargando orgánico", (int) (Juego.ANCHO / 2.5), Juego.ALTURA / 16);
        }
        else if(cargaBasura[3]) {
            g.drawString("Cargando aluminio", (int) (Juego.ANCHO / 2.5), Juego.ALTURA / 16);
        }
        //texto de escudo y vida
        g.drawString("Escudo: ",(int)(Juego.ANCHO /1.28), Juego.ALTURA /24);
        g.drawString("Vida: ",(int)(Juego.ANCHO /1.28), Juego.ALTURA /12);
        //rectangulo de la vida
        g.setColor(Color.red);
        g.fillRect((int)(Juego.ANCHO /1.28)+75, Juego.ALTURA /15, 100, (int)(Juego.ALTURA /28.8));
        g.setColor(new Color(75,255,0));
        g.fillRect((int)(Juego.ANCHO /1.28)+75, Juego.ALTURA /15, vida,(int)(Juego.ALTURA /28.8));
        g.setColor(Color.black);
        g.drawRect((int)(Juego.ANCHO /1.28)+75, Juego.ALTURA /15, 100,(int)(Juego.ALTURA /28.8));
        //rectangulo del escudo
        g.setColor(Color.lightGray);
        g.fillRect((int)(Juego.ANCHO /1.28)+75, Juego.ALTURA /45, 100, (int)(Juego.ALTURA /28.8));
        g.setColor(new Color(36, 66, 255));
        g.fillRect((int)(Juego.ANCHO /1.28)+75, Juego.ALTURA /45, escudo,(int)(Juego.ALTURA /28.8));
        g.setColor(Color.black);
        g.drawRect((int)(Juego.ANCHO /1.28)+75, Juego.ALTURA /45, 100,(int)(Juego.ALTURA /28.8));
    }

}
