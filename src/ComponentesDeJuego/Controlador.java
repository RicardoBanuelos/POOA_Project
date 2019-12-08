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

import EntidadesDeJuego.Entidad.ActorDeJuego;

import java.awt.Graphics;
import java.util.ArrayList;

public class Controlador {

    //arreglo con los objetos del juego
    public ArrayList<ActorDeJuego> object = new ArrayList<ActorDeJuego>();

    //corre las variables de los actores
    public void tick() {
        for(int i = 0; i < object.size(); i++) {

            ActorDeJuego tempObject = object.get(i);
            tempObject.tick();
        }
    }

    //pinta a los actores
    public void render(Graphics g) {
        for(int i = 0; i < object.size(); i++) {
            ActorDeJuego tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    void agregaObject(ActorDeJuego object) {
        this.object.add(object);
    }

    public void quitarObject(ActorDeJuego object) {
        this.object.remove(object);
    }

}