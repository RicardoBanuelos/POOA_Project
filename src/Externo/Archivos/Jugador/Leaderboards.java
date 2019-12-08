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
            FileOutputStream fos = new FileOutputStream("src/res/leaderboards.dat");
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
            FileInputStream fis = new FileInputStream("src/res/leaderboards.dat");
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
        if(lista.size() > 10) {
            for (int i = 1; i < 10; i++) {
                llave = lista.get(i);
                j = i - 1;
                while (j >= 0 && llave.getScore() > lista.get(j).getScore()) {
                    lista.set(j + 1, lista.get(j));
                    j--;
                }
                lista.set(j + 1, llave);
            }
        }
        else{
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
}
