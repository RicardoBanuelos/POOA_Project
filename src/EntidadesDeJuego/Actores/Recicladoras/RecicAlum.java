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

package EntidadesDeJuego.Actores.Recicladoras;

import Externo.Archivos.Imagenes.Imagenes;
import EntidadesDeJuego.Entidad.ActorDeJuego;

import java.awt.*;
import EntidadesDeJuego.Entidad.ID;

public class RecicAlum extends ActorDeJuego {

    public RecicAlum(float x, float y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Imagenes.recicAlum,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, 200, 128);
    }
}
