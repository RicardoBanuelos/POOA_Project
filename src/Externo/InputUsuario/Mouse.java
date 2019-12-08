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

import Externo.Archivos.Jugador.Leaderboards;
import ComponentesDeJuego.Juego;
import Externo.Archivos.Sonido.Audio;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

    private Leaderboards lb;
    private Audio audio;

    public Mouse(Leaderboards lb, Audio audio){
        this.lb = lb;
        this.audio = audio;
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(Juego.estado == Juego.ESTADO.Menu) {
            //boton de play
            if (mouseOver(mx, my, Juego.ANCHO / 2 - (int)(Juego.ANCHO/7.47), Juego.ALTURA / 3 - (int)(Juego.ALTURA/10.9), (int) (Juego.ANCHO/4.35), (int)(Juego.ALTURA/7.32))) {
                //cambia a juego y activa la captura de jugador
                Juego.estado = Juego.ESTADO.Juego;
                Juego.capturaJugador = true;
                audio.clip.stop();
            //boton de leaderboards
            } else if (mouseOver(mx, my, Juego.ANCHO / 2 - (int)(Juego.ANCHO/4.01), Juego.ALTURA / 2 - Juego.ALTURA / 12,  (int) (Juego.ANCHO/2.17), (int)(Juego.ALTURA/7.31))) {
                //carga el arreglo
                //lb.leer();
                //lb.ordenamiento();
                Juego.estado = Juego.ESTADO.LeaderBoards;
            //boton de exit
            } else if (mouseOver(mx, my, Juego.ANCHO / 2 - (int)(Juego.ANCHO/7.47), (int) (Juego.ALTURA / 1.5) - (int) (Juego.ALTURA / 14.28), (int) (Juego.ANCHO/4.35), (int)(Juego.ALTURA/7.32))) {
                System.exit(1);
            }
        }
    }

    //metodo que nos dice si el click del mouse fue sobre una posicion que deseamos
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if(mx > x && mx < x + width) {
            if(my > y && my < y + height) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
