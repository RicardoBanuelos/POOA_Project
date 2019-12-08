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

package EntidadesDeJuego.Actores.Portal;

import EntidadesDeJuego.Entidad.ActorDeJuego;
import EntidadesDeJuego.Entidad.ID;

import java.awt.*;
import java.util.Random;

public class Portal extends ActorDeJuego {

    private Random r;

    public Portal(float x, float y, ID id) {
        super(x, y, id);
        r = new Random();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(r.nextInt(255),0,r.nextInt(255)));
        g.fillOval((int)x,(int)y,75,75);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,65,65);
    }
}
