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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TecladoJugador extends KeyAdapter {

    public static boolean[] teclas = new boolean[4];

    public static void parche(){
        for(int i = 0; i < teclas.length; i++)
            teclas[i] = false;
    }

    public void keyPressed(KeyEvent e){
        int tecla = e.getKeyCode();

        if(tecla == KeyEvent.VK_D || tecla == KeyEvent.VK_RIGHT)
            teclas[0] = true;
        if(tecla == KeyEvent.VK_A || tecla == KeyEvent.VK_LEFT)
            teclas[1] = true;
        if(tecla == KeyEvent.VK_W || tecla == KeyEvent.VK_UP)
            teclas[2] = true;
        if(tecla == KeyEvent.VK_S || tecla == KeyEvent.VK_DOWN)
            teclas[3] = true;
    }

    public void keyReleased(KeyEvent e){
        int tecla = e.getKeyCode();

        if(tecla == KeyEvent.VK_D || tecla == KeyEvent.VK_RIGHT)
            teclas[0] = false;
        if(tecla == KeyEvent.VK_A || tecla == KeyEvent.VK_LEFT)
            teclas[1] = false;
        if(tecla == KeyEvent.VK_W || tecla == KeyEvent.VK_UP)
            teclas[2] = false;
        if(tecla == KeyEvent.VK_S || tecla == KeyEvent.VK_DOWN)
            teclas[3] = false;
    }
}
