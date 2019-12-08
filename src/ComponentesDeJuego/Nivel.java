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

import EntidadesDeJuego.Actores.Enemigos.EnemigoAgresivo;
import EntidadesDeJuego.Actores.Enemigos.EnemigoRapido;
import EntidadesDeJuego.Actores.Enemigos.Jefe;
import EntidadesDeJuego.Actores.Portal.Portal;
import Externo.Archivos.Imagenes.Imagenes;
import EntidadesDeJuego.Actores.Enemigos.EnemigoBasico;
import EntidadesDeJuego.Actores.Jugador.Jugador;
import EntidadesDeJuego.Actores.Recicladoras.RecicAlum;
import EntidadesDeJuego.Actores.Recicladoras.RecicCarton;
import EntidadesDeJuego.Actores.Recicladoras.RecicOrganic;
import EntidadesDeJuego.Actores.Recicladoras.RecicPlastico;
import EntidadesDeJuego.Actores.TiposBasura.Aluminio;
import EntidadesDeJuego.Actores.TiposBasura.Carton;
import EntidadesDeJuego.Actores.TiposBasura.Organico;
import EntidadesDeJuego.Actores.TiposBasura.Plastico;
import EntidadesDeJuego.Entidad.ID;
import Externo.Archivos.Sonido.Audio;

import java.awt.*;
import java.util.Random;

public class Nivel {

    private Controlador controlador;
    private boolean[] portal = new boolean[6];
    private boolean[] nivel = new boolean[6];
    public Audio audio;
    private Audio aparecePortal;
    private Random r;

    Nivel(Controlador handler) {
        this.controlador = handler;
        for(int i = 0; i < 6; i++) {
            portal[i] = true;
            nivel[i] = true;
        }
        audio = new Audio();
        aparecePortal = new Audio();
        r = new Random();
    }

    // Resetea booleandos para que objetos puedan volver a aparecer
    public void resetNivel() {
        for(int i = 0; i < 6; i++) {
            portal[i] = true;
            nivel[i] = true;
        }
    }

    // Se encarga de aparecer el portal
    private void abrePortales() {
        if(Hud.basuraEntregada == 4 && Hud.nivel == 1 && portal[0]) {
            aparecePortal.playSonido("res/sonido/tp.wav");
            portal[0] = false;
            controlador.agregaObject(new Portal(1562,2000, ID.Portal));
        }

        else if(Hud.basuraEntregada == 12 && Hud.nivel == 2 && portal[1]) {
            aparecePortal.playSonido("res/sonido/tp.wav");
            portal[1] = false;
            controlador.agregaObject(new Portal(1562,2000, ID.Portal));
        }
        else if(Hud.basuraEntregada == 20 && Hud.nivel == 3 && portal[2]) {
            aparecePortal.playSonido("res/sonido/tp.wav");
            portal[2] = false;
            controlador.agregaObject(new Portal(1562,2000, ID.Portal));
        }
        else if(Hud.basuraEntregada == 32 && Hud.nivel == 4 && portal[3]) {
            aparecePortal.playSonido("res/sonido/tp.wav");
            portal[3] = false;
            controlador.agregaObject(new Portal(1562,2000, ID.Portal));
        }
        else if(Hud.basuraEntregada == 44 && Hud.nivel == 5 && portal[4]) {
            aparecePortal.playSonido("res/sonido/tp.wav");
            portal[4] = false;
            controlador.agregaObject(new Portal(1562,2000, ID.Portal));
        }
        else if(Hud.basuraEntregada == 60 && Hud.nivel == 6 && portal[5]) {
            aparecePortal.playSonido("res/sonido/tp.wav");
            portal[5] = false;
            controlador.agregaObject(new Portal(1562,2000, ID.Portal));
        }
    }

    // Agrega los objetos correspondientes a cada nivel
    public void tick() {
        abrePortales();
        // Nivel 1
        if(Hud.nivel == 1 && nivel[0]) {
            audio.playSonidoBG("src/res/sonido/Niveles/bensound-theduel.wav");
            nivel[0] = false;
            // Recicladoras
            controlador.agregaObject(new RecicAlum(1000,2000, ID.RecicladoraAluminio));
            controlador.agregaObject(new RecicPlastico(1300,2000, ID.RecicladoraPlastico));
            controlador.agregaObject(new RecicOrganic(1700,2000, ID.RecicladoraOrganica));
            controlador.agregaObject(new RecicCarton(2000,2000, ID.RecicladoraCarton));
            // Basura
            controlador.agregaObject(new Plastico(1000,1200, ID.Plastico));
            controlador.agregaObject(new Aluminio(1250,1200, ID.Aluminio));
            controlador.agregaObject(new Organico(1750,1200, ID.BasuraOrganica));
            controlador.agregaObject(new Carton(2000,1200, ID.Carton));
            // Enemigos
            controlador.agregaObject(new EnemigoBasico(1000,1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000,1000, ID.EnemigoBasico, controlador));
            // Jugador
            controlador.agregaObject(new Jugador(1500, 1900, ID.Jugador, controlador));
        }
        // Nivel 2
        else if(Hud.nivel == 2 && nivel[1]) {
            nivel[1] = false;
            // Limpia nivel pasado
            controlador.object.clear();
            // Recicladoras
            controlador.agregaObject(new RecicAlum(1000,2000, ID.RecicladoraAluminio));
            controlador.agregaObject(new RecicPlastico(1300,2000, ID.RecicladoraPlastico));
            controlador.agregaObject(new RecicOrganic(1700,2000, ID.RecicladoraOrganica));
            controlador.agregaObject(new RecicCarton(2000,2000, ID.RecicladoraCarton));
            // Basura
            for(int i = 0; i < 2; i ++){
                controlador.agregaObject(new Plastico(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.Plastico));
                controlador.agregaObject(new Aluminio(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.Aluminio));
                controlador.agregaObject(new Organico(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.BasuraOrganica));
                controlador.agregaObject(new Carton(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Carton));
            }
            // Enemigos
            controlador.agregaObject(new EnemigoBasico(1000,1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000,1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1000,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1500,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000,2250, ID.EnemigoBasico, controlador));
            // Jugador
            controlador.agregaObject(new Jugador(1500, 1900, ID.Jugador, controlador));
        }
        // Nivel 3
        else if(Hud.nivel == 3 && nivel[2]) {
            audio.clip.close();
            audio.playSonidoBG("src/res/sonido/Niveles/bensound-epic.wav");
            nivel[2] = false;
            // Limpia nivel pasado
            controlador.object.clear();
            // Recicladoras
            controlador.agregaObject(new RecicAlum(1000,2000, ID.RecicladoraAluminio));
            controlador.agregaObject(new RecicPlastico(1300,2000, ID.RecicladoraPlastico));
            controlador.agregaObject(new RecicOrganic(1700,2000, ID.RecicladoraOrganica));
            controlador.agregaObject(new RecicCarton(2000,2000, ID.RecicladoraCarton));
            // Basura
            for(int i = 0; i < 2; i ++){
                controlador.agregaObject(new Plastico(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.Plastico));
                controlador.agregaObject(new Aluminio(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.Aluminio));
                controlador.agregaObject(new Organico(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.BasuraOrganica));
                controlador.agregaObject(new Carton(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.Carton));
            }
            // Enemigos
            controlador.agregaObject(new EnemigoBasico(1000,1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000,1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1000,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1500,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1500,1700, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoRapido(500,500,ID.EnemigoRapido,controlador));
            controlador.agregaObject(new EnemigoRapido(2500,2500,ID.EnemigoRapido,controlador));
            // Jugador
            controlador.agregaObject(new Jugador(1500, 1900, ID.Jugador, controlador));
        }

        // Nivel 4
        else if(Hud.nivel == 4 && nivel[3]) {
            nivel[3] = false;
            // Limpia nivel pasado
            controlador.object.clear();
            // Recicladoras
            controlador.agregaObject(new RecicAlum(1000, 2000, ID.RecicladoraAluminio));
            controlador.agregaObject(new RecicPlastico(1300, 2000, ID.RecicladoraPlastico));
            controlador.agregaObject(new RecicOrganic(1700, 2000, ID.RecicladoraOrganica));
            controlador.agregaObject(new RecicCarton(2000, 2000, ID.RecicladoraCarton));
            // Basura
            for(int i = 0; i < 3; i ++){
                controlador.agregaObject(new Plastico(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.Plastico));
                controlador.agregaObject(new Aluminio(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.Aluminio));
                controlador.agregaObject(new Organico(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.BasuraOrganica));
                controlador.agregaObject(new Carton(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.Carton));
            }
            // Enemigos
            controlador.agregaObject(new EnemigoBasico(1000,1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1500,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000,1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1000,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1500,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoRapido(500,500,ID.EnemigoRapido,controlador));
            controlador.agregaObject(new EnemigoRapido(2500,2500,ID.EnemigoRapido,controlador));
            controlador.agregaObject(new EnemigoRapido(2500,2500,ID.EnemigoRapido,controlador));
            controlador.agregaObject(new EnemigoAgresivo(2500,2500,ID.EnemigoAgresivo,controlador));
            // Jugador
            controlador.agregaObject(new Jugador(1500, 1900, ID.Jugador, controlador));
        }

        // Nivel 5
        else if(Hud.nivel == 5 && nivel[4]) {
            audio.clip.stop();
            audio.playSonidoBG("src/res/sonido/Niveles/bensound-evolution.wav");
            nivel[4] = false;
            // Limpia nivel pasado
            controlador.object.clear();
            // Recicladoras
            controlador.agregaObject(new RecicAlum(1000, 2000, ID.RecicladoraAluminio));
            controlador.agregaObject(new RecicPlastico(1300, 2000, ID.RecicladoraPlastico));
            controlador.agregaObject(new RecicOrganic(1700, 2000, ID.RecicladoraOrganica));
            controlador.agregaObject(new RecicCarton(2000, 2000, ID.RecicladoraCarton));
            // Basura
            for(int i = 0; i < 3; i++) {
                controlador.agregaObject(new Plastico(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.Plastico));
                controlador.agregaObject(new Aluminio(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.Aluminio));
                controlador.agregaObject(new Organico(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.BasuraOrganica));
                controlador.agregaObject(new Carton(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.Carton));
            }
            // Enemigos
            controlador.agregaObject(new EnemigoBasico(1000,1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1500,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoRapido(500,500,ID.EnemigoRapido,controlador));
            controlador.agregaObject(new EnemigoRapido(1100,2100,ID.EnemigoRapido,controlador));
            controlador.agregaObject(new EnemigoAgresivo(2500,2500,ID.EnemigoAgresivo,controlador));
            controlador.agregaObject(new EnemigoAgresivo(2000,2000,ID.EnemigoAgresivo,controlador));
            controlador.agregaObject(new Jefe(1500,2200,ID.Jefe,controlador));
            // Jugador
            controlador.agregaObject(new Jugador(1500, 1900, ID.Jugador, controlador));
        }

        // Nivel 6
        else if(Hud.nivel == 6 && nivel[5]) {
            nivel[5] = false;
            // Limpia nivel pasado
            controlador.object.clear();
            // Recicladoras
            controlador.agregaObject(new RecicAlum(1000, 2000, ID.RecicladoraAluminio));
            controlador.agregaObject(new RecicPlastico(1300, 2000, ID.RecicladoraPlastico));
            controlador.agregaObject(new RecicOrganic(1700, 2000, ID.RecicladoraOrganica));
            controlador.agregaObject(new RecicCarton(2000, 2000, ID.RecicladoraCarton));
            // Basura
            for(int i = 0; i < 4; i++) {
                controlador.agregaObject(new Plastico(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.Plastico));
                controlador.agregaObject(new Aluminio(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.Aluminio));
                controlador.agregaObject(new Organico(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.BasuraOrganica));
                controlador.agregaObject(new Carton(510 + r.nextInt(1480), 510 + r.nextInt(1100), ID.Carton));
            }
            // Enemigos
            controlador.agregaObject(new EnemigoRapido(800,1800,ID.EnemigoRapido,controlador));
            controlador.agregaObject(new EnemigoRapido(500,500,ID.EnemigoRapido,controlador));
            controlador.agregaObject(new EnemigoRapido(2500,2500,ID.EnemigoRapido,controlador));
            controlador.agregaObject(new EnemigoRapido(500,2500,ID.EnemigoRapido,controlador));
            controlador.agregaObject(new EnemigoRapido(1200,2200,ID.EnemigoRapido,controlador));
            controlador.agregaObject(new EnemigoAgresivo(2500,2500,ID.EnemigoAgresivo,controlador));
            controlador.agregaObject(new EnemigoAgresivo(2500,2500,ID.EnemigoAgresivo,controlador));
            controlador.agregaObject(new EnemigoAgresivo(200,600,ID.EnemigoAgresivo,controlador));
            controlador.agregaObject(new Jefe(1500,2200,ID.Jefe,controlador));
            // Carga otro jefe cuando se recolecte la mitad de basura del nivel 6
            if(Hud.basuraEntregada == 52) {

                controlador.agregaObject(new Jefe(1500,1500,ID.Jefe,controlador));
            }
            // Jugador
            controlador.agregaObject(new Jugador(1500, 1900, ID.Jugador, controlador));
        }
    }

    // Pinta el fondo correspondiente de cada nivel
    public void render(Graphics g){
        if(Hud.nivel == 1) {

            g.drawImage(Imagenes.nivel1,0, Juego.ANCHO /8,null);
        }
        else if(Hud.nivel == 2) {

            g.drawImage(Imagenes.nivel2,0, Juego.ANCHO /8,null);
        }
        else if(Hud.nivel == 3) {

            g.drawImage(Imagenes.nivel3,0, Juego.ANCHO /8,null);
        }
        else if(Hud.nivel == 4) {

            g.drawImage(Imagenes.nivel4,0, Juego.ANCHO /8,null);
        }
        else if(Hud.nivel == 5) {

            g.drawImage(Imagenes.nivel5,0, Juego.ANCHO /8,null);
        }
        else if(Hud.nivel == 6) {

            g.drawImage(Imagenes.nivel6,0, Juego.ANCHO /8,null);
        }
    }
}
