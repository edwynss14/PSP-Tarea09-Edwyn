import java.io.IOException;
import java.util.Random;
//Creamos la clase descarga que con ella heredamos de la clase extends, esto permite el uso de hilos
public class Descarga extends Thread{
    private int tiempoTotal;
    private String nombreArchivo;
    int bloquems;
    //Aquí el constructor asigna el nombre al hilo y genera aleatoriamente la duración de ms de cada bloque de descarga
    public  Descarga(String nombreArchivo){
        super("Descarga-" + nombreArchivo);
        Random rd = new Random();
        bloquems = rd.nextInt(100, 501);
        this.nombreArchivo = nombreArchivo;
    }
    public int getTiempoTotal(){
        return this.tiempoTotal; //Devuelve el tiempo total de la descarga
    }

    @Override
    // Método prinicipal del hilo que ejecuta el bucle de la descarga
    // en 10 bloques del (10% al 100%) es decir hace las iteracciones, para ello es necesario el bucle
    public void run(){
        int suma = 0;
        for(int i = 1; i <= 10; i++){
            try{
                System.out.println("[" + nombreArchivo + "] " + (i*10) + "%");
                suma += bloquems;

                Thread.sleep(bloquems);
            } catch (InterruptedException e){
                System.err.println("ERROR");
            }
        }
        this.tiempoTotal = suma;
    }

}


