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

package Externo.Archivos.Jugador;

import ComponentesDeJuego.Hud;
import java.io.Serializable;

public class JugadorRankeado implements Serializable {

    private String name;
    private int score;
    private int level;
    private int recycledTrash;

    //agarramos los datos que queremos guardar del hud para mostrar en leaderboards
    //el unico dato extra es el nombre del jugador
    JugadorRankeado(String name) {
        this.name = name;
        this.score = Hud.puntaje;
        this.level = Hud.nivel;
        this.recycledTrash = Hud.basuraEntregada;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRecycledTrash() {
        return recycledTrash;
    }

    public void setRecycledTrash(int recycledTrash) {
        this.recycledTrash = recycledTrash;
    }

}
