import java.util.List;
import java.io.IOException;
public class Monitor implements Runnable {
    private List<Descarga> listaDescargas;
    public Monitor(List<Descarga> listaDescargas){
        this.listaDescargas = listaDescargas;
    }

    @Override
    public void run (){
        while(true){
            int activas = 0;
            for(Descarga d : listaDescargas){
                if(d.isAlive()){
                    activas++;
                }
            }
            if(activas > 0){
                System.out.println("[Monitor] Descargas en curso: " + activas);
            } else {
                System.out.println("[Monitor] No queda ninguna descarga en curso");
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                System.err.println("ERROR");
            }
        }
    }
}
