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

package Externo.InputUsuario;

import ComponentesDeJuego.Juego;
import ComponentesDeJuego.Controlador;
import ComponentesDeJuego.Hud;
import ComponentesDeJuego.Nivel;
import Externo.Archivos.Sonido.Audio;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Teclado extends KeyAdapter {

    private Controlador handler;
    private Nivel level;
    private Audio audio;

    public Teclado(Controlador handler, Nivel level, Audio audio) {
        this.handler = handler;
        this.level = level;
        this.audio = audio;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if(Juego.estado == Juego.ESTADO.Menu){
            if(key == KeyEvent.VK_ESCAPE) System.exit(1);
        }

        else if(Juego.estado == Juego.ESTADO.LeaderBoards){
            if(key == KeyEvent.VK_ESCAPE) {
                Juego.estado = Juego.ESTADO.Menu;
            }
        }

        else if(Juego.estado == Juego.ESTADO.Juego){
            if(key == KeyEvent.VK_ESCAPE) {
                Juego.estado = Juego.ESTADO.Menu;
                Hud.resetJuego();
                handler.object.clear();
                level.resetNivel();
                level.audio.clip.close();
                audio.clip.start();
            }
        }

        else if(Juego.estado == Juego.ESTADO.GameOver || Juego.estado == Juego.ESTADO.Win){
            if(key == KeyEvent.VK_ENTER)
                Juego.estado = Juego.ESTADO.Menu;
                audio.clip.close();
                audio.playSonidoBG("src/res/sonido/Background/bensound-scifi.wav");
        }
    }
}
