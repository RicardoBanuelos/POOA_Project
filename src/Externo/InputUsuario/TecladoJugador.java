package Externo.InputUsuario;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TecladoJugador extends KeyAdapter {

    public static boolean[] teclas = new boolean[4];

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