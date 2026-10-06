import java.util.List;

public class GestorDescargas {
    public static void main(String[] args){
        System.out.println("Iniciando...");

        Descarga desc1 = new Descarga("meditacion.mp4");
        Descarga desc2 = new Descarga("musica.mp3");
        Descarga desc3 = new Descarga("cuarzo.png");
        Descarga desc4 = new Descarga("mantras.mp3");

        List<Descarga> listaDescargas = List.of(desc1, desc2, desc3, desc4);
        Monitor monitor = new Monitor(listaDescargas);
        Thread hiloMonitor = new Thread(monitor);
        List<Descarga> listaInstalador = List.of(desc1, desc4);
        Instalador instalador = new Instalador(listaInstalador);
        Thread hiloInstalador = new Thread(instalador);

        long tiempoI = System.currentTimeMillis();
        try {
            desc1.start();
            desc2.start();
            desc3.start();
            desc4.start();
            hiloInstalador.start();
            hiloMonitor.start();

            desc1.join(3000);
            if(desc1.isAlive()){
                System.out.println("[Main] meditacion.mp4 sigue en segundo plano");
            }
            desc2.join();
            desc3.join();
            desc4.join();

            hiloMonitor.join();

            hiloInstalador.join();

        } catch (InterruptedException e){
            System.out.println("La descarga fue interrumpida");
        }

        long tiempoF = System.currentTimeMillis();
        long tiempoR = tiempoF - tiempoI;
        int msAcumulados = desc1.getTiempoTotal() + desc2.getTiempoTotal() + desc3.getTiempoTotal() + desc4.getTiempoTotal();

        System.out.println("[" + desc1.getName() + "] completada en: " + desc1.getTiempoTotal() + "ms");
        System.out.println("[" + desc2.getName() + "] completada en: " + desc2.getTiempoTotal() + "ms");
        System.out.println("[" + desc3.getName() + "] completada en: " + desc3.getTiempoTotal() + "ms");
        System.out.println("[" + desc4.getName() + "] completada en: " + desc4.getTiempoTotal() + "ms");
        System.out.println("Tiempo real: " + tiempoR + "ms");
        System.out.println("El total de ms de los archivos es: " + msAcumulados);

    }
}