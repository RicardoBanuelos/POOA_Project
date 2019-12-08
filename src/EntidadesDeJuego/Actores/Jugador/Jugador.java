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

package EntidadesDeJuego.Actores.Jugador;

import EntidadesDeJuego.Entidad.Animacion;
import Externo.Archivos.Imagenes.Imagenes;
import ComponentesDeJuego.Juego;
import EntidadesDeJuego.Entidad.ActorDeJuego;
import ComponentesDeJuego.Controlador;
import ComponentesDeJuego.Hud;
import EntidadesDeJuego.Entidad.ID;
import Externo.Archivos.Sonido.Audio;
import Externo.InputUsuario.TecladoJugador;

import java.awt.*;

public class Jugador extends ActorDeJuego {

    private Controlador controlador;
    private int ancho = Imagenes.jugador[0].getWidth();
    private int altura = Imagenes.jugador[0].getHeight();
    private Audio audio;
    private Animacion caminaArriba;
    private Animacion caminaAbajo;
    private Animacion caminaDerecha;
    private Animacion caminaIzquierda;

    public Jugador(int x, int y, ID id, Controlador controlador) {
        super(x, y, id);
        this.controlador = controlador;
        audio = new Audio();
        caminaArriba = new Animacion(10,Imagenes.jugador[1],Imagenes.jugador[2],Imagenes.jugador[3],Imagenes.jugador[4]);
        caminaAbajo = new Animacion(10,Imagenes.jugador[5],Imagenes.jugador[6],Imagenes.jugador[7],Imagenes.jugador[8]);
        caminaDerecha = new Animacion(10,Imagenes.jugador[9],Imagenes.jugador[10],Imagenes.jugador[11],Imagenes.jugador[12]);
        caminaIzquierda = new Animacion(10,Imagenes.jugador[13],Imagenes.jugador[14],Imagenes.jugador[15],Imagenes.jugador[16]);
    }

    // Detecta colisión con enemigos
    private void colisionEnemigo() {

        for(int i = 0; i < controlador.object.size(); i++) {

            ActorDeJuego tempObject = controlador.object.get(i);

            if(tempObject.getID() == ID.EnemigoBasico || tempObject.getID() == ID.EnemigoRapido || tempObject.getID() == ID.EnemigoAgresivo) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    if(Hud.escudo >0)
                        Hud.escudo -=1;
                    else
                        Hud.vida -=1;
                    audio.playSonido("src/res/Sonido/Jugador/Dolor.wav");
                }
            }
            else if(tempObject.getID() == ID.Jefe) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    audio.playSonido("src/res/Sonido/Jugador/Dolor.wav");
                    if(Hud.escudo >0)
                        Hud.escudo -=5;
                    else
                        Hud.vida -=5;
                }
            }
        }
    }

    // Detecta colisión con basura
    private void colisionBasura() {

        for(int i = 0; i < controlador.object.size(); i++) {

            ActorDeJuego tempObject = controlador.object.get(i);

            // Condición para detectar  con uso de booleanos que no esté cargando otros tipos de basura
            if(tempObject.getID() == ID.Carton && !Hud.cargaBasura[0] && !Hud.cargaBasura[1]
            && !Hud.cargaBasura[2] && !Hud.cargaBasura[3]) {

                if(getBounds().intersects(tempObject.getBounds())) {

                    audio.playSonido("src/res/Sonido/Basura/Carton.wav");
                    controlador.quitarObject(tempObject);
                    Hud.puntaje +=10;
                    Hud.cargaBasura[0] = true;
                }
            }
            else if(tempObject.getID() == ID.Plastico && !Hud.cargaBasura[0] && !Hud.cargaBasura[1]
                    && !Hud.cargaBasura[2] && !Hud.cargaBasura[3]) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    audio.playSonido("src/res/Sonido/Basura/Plastico.wav");
                    controlador.quitarObject(tempObject);
                    Hud.puntaje +=10;
                    Hud.cargaBasura[1] = true;
                }
            }
            else if(tempObject.getID() == ID.BasuraOrganica && !Hud.cargaBasura[0] && !Hud.cargaBasura[1]
                    && !Hud.cargaBasura[2] && !Hud.cargaBasura[3]) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    audio.playSonido("src/res/Sonido/Basura/Organico.wav");
                    controlador.quitarObject(tempObject);
                    Hud.puntaje +=10;
                    Hud.cargaBasura[2] = true;
                }
            }
            else if(tempObject.getID() == ID.Aluminio && !Hud.cargaBasura[0] && !Hud.cargaBasura[1]
                    && !Hud.cargaBasura[2] && !Hud.cargaBasura[3]) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    audio.playSonido("src/res/Sonido/Basura/Metal.wav");
                    controlador.quitarObject(tempObject);
                    Hud.puntaje +=10;
                    Hud.cargaBasura[3] = true;
                }
            }
        }
    }

    private void recompensaRecicladora(ID id) {
        if(id == ID.RecicladoraCarton && Hud.cargaBasura[0]) {
            audio.playSonido("src/res/Sonido/Basura/Carton.wav");
            Hud.cargaBasura[0] = false;
            Hud.puntaje += 90;
            Hud.basuraEntregada++;
            Hud.velocidadMAX += 0.1;
        }
        else if(id == ID.RecicladoraPlastico && Hud.cargaBasura[1]) {
            audio.playSonido("src/res/Sonido/Basura/Plastico.wav");
            Hud.cargaBasura[1] = false;
            Hud.puntaje += 90;
            Hud.basuraEntregada++;
            Hud.escudo +=10;
        }
        else if(id == ID.RecicladoraOrganica && Hud.cargaBasura[2]) {
            audio.playSonido("src/res/Sonido/Basura/Organico.wav");
            Hud.cargaBasura[2] = false;
            Hud.puntaje += 90;
            Hud.basuraEntregada++;
            Hud.vida += 20;
        }
        else if(id == ID.RecicladoraAluminio && Hud.cargaBasura[3]) {
            audio.playSonido("src/res/Sonido/Basura/entregaMetal.wav");
            Hud.cargaBasura[3] = false;
            Hud.puntaje += 90;
            Hud.basuraEntregada++;
            Hud.escudo += 20;
        }
    }

    // Detecta colisión con recicladoras y valida que estemos cargando el material correcto
    private void colisionRecicladora() {

        for(int i = 0; i < controlador.object.size(); i++) {

            ActorDeJuego tempObject = controlador.object.get(i);

            if(tempObject.getID() == ID.RecicladoraOrganica || tempObject.getID() == ID.RecicladoraPlastico
            || tempObject.getID() == ID.RecicladoraCarton || tempObject.getID() == ID.RecicladoraAluminio) {
                if(getHorizontalBounds().intersects(tempObject.getBounds())) {
                    recompensaRecicladora(tempObject.getID());
                    if(velX > 0){
                        velX = 0;
                        x = tempObject.getX() - ancho;
                    }
                    else if(velX < 0) {
                        velX = 0;
                        x = tempObject.getX() + 200;
                    }
                }
                if(getVerticalBounds().intersects(tempObject.getBounds())) {
                    recompensaRecicladora(tempObject.getID());
                    if(velY > 0){
                        velY = 0;
                        y = tempObject.getY() - altura;
                    }
                    else if(velY < 0) {
                        velY = 0;
                        y = tempObject.getY() + 128;
                    }
                }
            }
        }
    }

    private void colisionPortal() {

        for(int i = 0; i < controlador.object.size(); i++) {

            ActorDeJuego tempObject = controlador.object.get(i);
            if(tempObject.getID() == ID.Portal){
                if(getBounds().intersects(tempObject.getBounds())){
                    audio.playSonido("src/res/sonido/tp.wav");
                    Hud.nivel+=1;
                    Hud.puntaje+=100;
                }
            }
        }
    }
    // Lógica del jugador
    @Override
    public void tick() {
        //movimiento
        x+=velX;
        y+=velY;

        // Clamp para limitar velocidad
        velX = Juego.clamp(velX,-Hud.velocidadMAX,Hud.velocidadMAX);
        velY = Juego.clamp(velY,-Hud.velocidadMAX,Hud.velocidadMAX);

        // Clamps para que no salga del nivel
        x = Juego.clamp(x,500, Imagenes.nivel1.getWidth()-500);
        y = Juego.clamp(y,500, Imagenes.nivel1.getHeight()-500);

        // Movimiento horizontal
        if(TecladoJugador.teclas[0])
            velX+=1;
        else if(TecladoJugador.teclas[1])
            velX-=1;
        else if(!TecladoJugador.teclas[0] && !TecladoJugador.teclas[1]){
            velX = 0;
        }
        // Movimiento vertical
        if(TecladoJugador.teclas[3])
            velY+=1;
        else if(TecladoJugador.teclas[2])
            velY-=1;
        else if(!TecladoJugador.teclas[2] && !TecladoJugador.teclas[3]){
            velY = 0;
        }

        // Detecta todas las colisiones
        colisionEnemigo();
        colisionBasura();
        colisionRecicladora();
        colisionPortal();

        //animaciones
        caminaArriba.runAnimation();
        caminaAbajo.runAnimation();
        caminaDerecha.runAnimation();
        caminaIzquierda.runAnimation();
    }

    // Pinta jugador
    @Override
    public void render(Graphics g) {

        if(velX ==0 && velY == 0)
            g.drawImage(Imagenes.jugador[0],(int)x,(int)y,null);
        else if(velY < 0)
            caminaArriba.drawAnimation(g,(int)x,(int)y);
        else if(velY > 0)
            caminaAbajo.drawAnimation(g,(int)x,(int)y);
        else if (velX > 0)
            caminaDerecha.drawAnimation(g,(int)x,(int)y);
        else
            caminaIzquierda.drawAnimation(g,(int)x,(int)y);
    }

    // Retorna tamano del jugador
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,ancho,altura);
    }

    // Rectángulo para detectar colisiones con obstáculos eje vertical
    private Rectangle getHorizontalBounds() {

        float bx = x + velX;
        float by = y;
        float bw = ancho + velX/3;
        float bh = altura;

        return new Rectangle((int)bx,(int)by,(int)bw,(int)bh);
    }

    // Rectángulo para detectar colisiones con obstáculos eje horizontal
    private Rectangle getVerticalBounds() {

        float bx = x;
        float by = y + velY;
        float bw = ancho;
        float bh = altura + velY/3;

        return new Rectangle((int)bx,(int)by,(int)bw,(int)bh);
    }
}
