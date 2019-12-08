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
import ComponentesDeJuego.Controlador;
import EntidadesDeJuego.Entidad.ActorDeJuego;
import EntidadesDeJuego.Entidad.ID;

import java.awt.*;

public class Jefe extends ActorDeJuego {

    private Controlador controlador;
    private ActorDeJuego jugador;
    private float distancia;
    private Animacion caminaDerecha;
    private Animacion caminaIzquierda;

    public Jefe(float x, float y, ID id, Controlador controlador) {
        super(x, y, id);
        this.controlador = controlador;
        encuentraJugador();
        caminaDerecha = new Animacion(10,Imagenes.jefe[3],Imagenes.jefe[4],Imagenes.jefe[5]);
        caminaIzquierda = new Animacion(10,Imagenes.jefe[9],Imagenes.jefe[10],Imagenes.jefe[11]);
    }

    private void encuentraJugador(){
        for(int i = 0; i < controlador.object.size(); i++){
            if(controlador.object.get(i).getID() == ID.Jugador)
                jugador = controlador.object.get(i);
        }
    }

    @Override
    public void tick() {
        float diffX, diffY;
        //algoritmo para saber hacia donde esta el jugador
        if(jugador !=null) {
            diffX = x - jugador.getX();
            diffY = y - jugador.getY();
            distancia = (float) Math.sqrt((x - jugador.getX()) * (x - jugador.getX()) + (y - jugador.getY()) * (y - jugador.getY()));

            //if para saber si el jugador esta cerca o no
            if(distancia < 750){
                velX = (float) ((-1.0/ distancia)*diffX);
                velY = (float) ((-1.0/ distancia)*diffY);
                if(velX<0)
                    velX-=1.2;
                else
                    velX+=1.2;
                if(velY<0)
                    velY-=1.2;
                else
                    velY+=1.2;
                x += velX;
                y += velY;
            }
        }
        else
            encuentraJugador();
        caminaDerecha.runAnimation();
        caminaIzquierda.runAnimation();
    }

    @Override
    public void render(Graphics g) {
        if(distancia > 750){
            g.drawImage(Imagenes.jefe[7],(int)x,(int)y,null);
        }
        else if(velX > 0)
            caminaDerecha.drawAnimation(g,(int)x,(int)y);
        else
            caminaIzquierda.drawAnimation(g,(int)x,(int)y);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, 120,160);
    }
}
