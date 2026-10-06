import java.util.List;

public class Instalador implements Runnable{
    private List<Descarga> descargas;
    public Instalador(List<Descarga> descargas){
        this.descargas = descargas;
    }
    @Override
    public void run(){
        try {
            for (Descarga d : descargas) {
                if (d.getName().equals("Descarga-meditacion.mp4")) {
                    d.join();
                } else if (d.getName().equals(" Descarga-mantras.mp3")) {
                    d.join();
                }
            }
        } catch (InterruptedException e) {
            System.err.println("error");
        }
        System.out.println("[Instalador] Meditación y mantras listos: instalando...");
            try {
                Thread.sleep(500);
                System.out.println("[Instalador] Instalación terminada");
            }catch (InterruptedException e){
                System.err.println("Error");
            }
    }
        }

