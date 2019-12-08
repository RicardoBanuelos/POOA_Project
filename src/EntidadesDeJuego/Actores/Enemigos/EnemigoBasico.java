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

package EntidadesDeJuego.Actores.Enemigos;

import EntidadesDeJuego.Entidad.Animacion;
import Externo.Archivos.Imagenes.Imagenes;
import EntidadesDeJuego.Entidad.ActorDeJuego;
import ComponentesDeJuego.Controlador;
import EntidadesDeJuego.Entidad.ID;

import java.awt.*;

public class EnemigoBasico extends ActorDeJuego {

    private Controlador controlador;
    private ActorDeJuego jugador;
    private float distancia;
    private Animacion caminaDerecha;
    private Animacion caminaIzquierda;

    //constructor del enemigo basico
    public EnemigoBasico(int x, int y, ID id, Controlador controlador) {
        super(x, y, id);
        this.controlador = controlador;
        encuentraJugador();
        caminaDerecha = new Animacion(10,Imagenes.enemigoBasico[3],Imagenes.enemigoBasico[4],Imagenes.enemigoBasico[5]);
        caminaIzquierda = new Animacion(10,Imagenes.enemigoBasico[9],Imagenes.enemigoBasico[10],Imagenes.enemigoBasico[11]);
    }

    //busca el jugador para poder seguirlo
    private void encuentraJugador(){
        for(int i = 0; i < controlador.object.size(); i++){
            if(controlador.object.get(i).getID() == ID.Jugador)
                jugador = controlador.object.get(i);
        }
    }

    //logica de nuestro enemigo basico
    @Override
    public void tick() {
        float diffX, diffY;
        //algoritmo para saber hacia donde esta el jugador
        if(jugador != null) {
            diffX = x - jugador.getX();
            diffY = y - jugador.getY();
            distancia = (float) Math.sqrt((x - jugador.getX()) * (x - jugador.getX()) + (y - jugador.getY()) * (y - jugador.getY()));

            //if para saber si el jugador esta cerca o no
            //si no esta cerca no lo sigue
            if(distancia < 300){
                velX = (float) ((-1.0/ distancia)*diffX);
                velY = (float) ((-1.0/ distancia)*diffY);
                if(velX<0)
                    velX-=0.8;
                else //si se mueve en x, agregar velocidad positiva
                    velX+=0.8;
                if(velY<0) // si se mueve en -y, agregar velocidad negativa
                    velY-=0.8;
                else //si se mueve en y, agregar velocidad positiva
                    velY+=0.8;
                x += velX;
                y += velY;
            }
        }
        else
            //en caso de no haber encontrado jugador lo vuelve a buscar
            encuentraJugador();
        caminaDerecha.runAnimation();
        caminaIzquierda.runAnimation();
    }

    @Override
    //pinta imagen del enemigo
    public void render(Graphics g) {
        if(distancia > 300){
            g.drawImage(Imagenes.enemigoBasico[7],(int)x,(int)y,null);
        }
        else if(velX > 0)
            caminaDerecha.drawAnimation(g,(int)x,(int)y);
        else
            caminaIzquierda.drawAnimation(g,(int)x,(int)y);
    }

    //retorna un rectangulo del tamano de la imagen para la colision con el jugador
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, 48,64);
    }
}
