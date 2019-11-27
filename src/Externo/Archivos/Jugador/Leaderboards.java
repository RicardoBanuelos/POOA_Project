package Externo.Archivos.Jugador;

import ComponentesDeJuego.Hud;
import Externo.Archivos.Jugador.JugadorRankeado;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Leaderboards {

    //lista de scores de jugadores previos
    public ArrayList<JugadorRankeado> lista = new ArrayList<>();

    //metodo para agregar jugador a la lista, pide nombre antes de agregarlo
    public void addRankedPlayer(){
        String nombre;
        nombre = JOptionPane.showInputDialog("Tu puntaje fue: "+ Hud.puntaje+"\nEscribe tu nombre!");
        lista.add(new JugadorRankeado(nombre));
        ordenamiento();
    }

    //escribe la lista en un archivo
    public void escribre() {
        try {
            FileOutputStream fos = new FileOutputStream("leaderboards.dat");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(lista);
            bos.flush();

            oos.close();
            bos.close();
            fos.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //lee la lista de un archivo
    public void leer(){
        try{
            FileInputStream fis = new FileInputStream("leaderboards.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            lista = (ArrayList<JugadorRankeado>) ois.readObject();

            ois.close();
            fis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void ordenamiento(){
        int j;
        JugadorRankeado llave;
        for (int i = 1; i < lista.size(); i++) {
                llave = lista.get(i);
                j = i - 1;
                while (j >= 0 && llave.getScore() > lista.get(j).getScore()) {
                    lista.set(j + 1, lista.get(j));
                    j--;
                }
                lista.set(j + 1, llave);
        }
    }
}
