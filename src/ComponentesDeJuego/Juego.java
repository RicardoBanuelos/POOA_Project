package ComponentesDeJuego;

import Externo.Archivos.Sonido.AudioPlayer;
import Externo.Archivos.Imagenes.SetterDeImagenes;
import Externo.Archivos.Jugador.Leaderboards;
import Externo.Archivos.Sonido.Sonido;
import Externo.InputUsuario.TecladoJugador;
import Externo.InputUsuario.Teclado;
import Externo.InputUsuario.Mouse;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Juego extends Canvas implements Runnable {

    //private static Toolkit tk = Toolkit.getDefaultToolkit();
    //public static final int WIDTH = ((int)tk.getScreenSize().getWidth());
    //public static final int HEIGHT = ((int)tk.getScreenSize().getHeight());
    public static final int ANCHO = 1024;
    public static final int ALTURA = 600;
    private Thread thread;
    private boolean corriendo = false;
    public static boolean capturaJugador;

    // Partes del juego
    private Controlador controlador;
    private Leaderboards lb;
    private Menu menu;
    private Hud hud;
    private Nivel nivel;
    private Camara camara;
    private TecladoJugador mj;
    private Teclado teclado;
    private Mouse mouse;
    private Sonido sonidoMenu = new Sonido("res/sonido/Menu.wav");

    // Estados que controlan el juego
    public enum ESTADO {
        Menu(),
        Juego(),
        LeaderBoards(),
        GameOver()
    }

    // Estado inicial
    public static ESTADO estado = ESTADO.Menu;

    // Constructor del juego
    public Juego(){
        init();
        new Pantalla(ANCHO, ALTURA,"Game",this);
        start();
    }

    // Inicizizador de las partes del juego
    private void init(){
        SetterDeImagenes.cargaImagenes();
        controlador = new Controlador();
        lb = new Leaderboards();
        menu = new Menu(lb);
        hud = new Hud();
        nivel = new Nivel(controlador);
        camara = new Camara(0,0, controlador);
        mj = new TecladoJugador();
        teclado = new Teclado(controlador, nivel);
        mouse = new Mouse(lb);
        this.addKeyListener(mj);
        this.addMouseListener(mouse);
        this.addKeyListener(teclado);
        lb.leer();
    }

    // Inicializa hilo
    private synchronized void start(){
        thread = new Thread(this);
        thread.start();
        corriendo = true;
    }

    // Detiene hilo
    private synchronized void stop(){
        try{
            thread.join();
            corriendo = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // Ciclo del juego
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double ammountOfTicks = 60.0;
        double ns = 1000000000 / ammountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(corriendo) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if(corriendo)
                render();

            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    // Método que maneja la logica del juego
    private void tick(){

        if(estado == ESTADO.Menu){
            sonidoMenu.play();
        }
        else if(estado == ESTADO.Juego) {
            // Cambia a game over si se muere el jugador
            if(Hud.vida == 0){
                estado = ESTADO.GameOver;
            }
            // Corre las variables de los componentes del juego
            nivel.tick();
            controlador.tick();
            hud.tick();
            camara.tick();
        }
        else if(estado == ESTADO.GameOver){
            // Agrega jugador al arreglo, lo escribe y reinicia el juego
            if(capturaJugador) {
                lb.addRankedPlayer();
                lb.escribre();
                Hud.resetJuego();
                nivel.resetNivel();
                controlador.object.clear();
            }
            capturaJugador = false;
        }
    }

    // Método que pinta el juego
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D)g;

        // Pinta menú
        if(estado == ESTADO.Menu || estado == ESTADO.LeaderBoards) {
            menu.render(g);
        }
        // Pinta hud, nivel y actores
        else if(estado == ESTADO.Juego){
            g.setColor(Color.black);
            g.fillRect(0,0, ANCHO, ALTURA);
            // g2d nos hace movernos con el jugador
            g2d.translate(-camara.getX(),-camara.getY());
            nivel.render(g);
            controlador.render(g);
            g2d.translate(camara.getX(), camara.getY());
            // Pinta hud
            hud.render(g);
        }
        else if(estado == ESTADO.GameOver ) {
            // Estado para cuando el jugador está muerto
            g.drawImage(SetterDeImagenes.gameoverBG,0,0,null);
        }

        g.dispose();
        bs.show();
    }

    // Método para limitar una variable a un valor minimo y maximo
    public static float clamp(float var, float min, float max){
        if(var >= max)
            return (var = max);
        else if(var <= min)
            return (var = min);
        else return var;
    }


    public static void main(String[] args) {
        new Juego();
    }
}
