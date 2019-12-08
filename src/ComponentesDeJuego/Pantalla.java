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

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

class Pantalla extends Canvas{

    //la pantalla de nuestro juego
    Pantalla(int width, int height, String title, Juego game) {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
    }
}
