import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> accesos;
    private HashMap<String, Integer> paginasWeb;
    private HashMap<String, Integer> direccionesIp;

    public AnalizadorAccesosAServidor() 
    {
        accesos = new ArrayList<>();
        paginasWeb = new HashMap<>();
        direccionesIp = new HashMap<>();
    }

    public void analizarArchivoDeLog(String archivo)
    {
        accesos.clear();
        File archivoALeer = new File(archivo);
        try {
            Scanner sc = new Scanner(archivoALeer);
            while (sc.hasNextLine()) {
                String lineaLeida = sc.nextLine();
                Acceso accesoActual = new Acceso(lineaLeida);
                accesos.add(accesoActual);
            }
            sc.close();
        }
        catch (Exception e) {
            System.out.println("Ocurrio algun error al leer el archivo.");
        }
    }

    public int obtenerHoraMasAccesos() 
    {
        int valorADevolver = -1;

        if (!accesos.isEmpty()) {
            int[] accesosPorHora = new int[24];

            for (Acceso accesoActual : accesos) {
                int horaAccesoActual = accesoActual.getHora();
                accesosPorHora[horaAccesoActual] = accesosPorHora[horaAccesoActual] + 1;
            }

            int numeroDeAccesosMasAlto = accesosPorHora[0];
            int horaDeAccesosMasAlto = 0;
            for (int i = 0; i < accesosPorHora.length; i++) {
                if (accesosPorHora[i] >= numeroDeAccesosMasAlto) {
                    numeroDeAccesosMasAlto = accesosPorHora[i];
                    horaDeAccesosMasAlto = i;
                }
            }

            valorADevolver = horaDeAccesosMasAlto;                      
        }

        return valorADevolver;
    }

    public String paginaWebMasSolicitada() 
    {
        paginasWeb.clear();
        String textoAMostrar = null;
        int posicionPagina = -1;
        for(Acceso accesoActual : accesos){
            if(!paginasWeb.containsKey(accesoActual.getPaginaWeb())){
                paginasWeb.put(accesoActual.getPaginaWeb(), 0);
            }
        }
        for(Acceso nuevoAcceso : accesos){
            paginasWeb.put(nuevoAcceso.getPaginaWeb(), paginasWeb.get(nuevoAcceso.getPaginaWeb()) + 1);
        }
        for(String paginaBuscada : paginasWeb.keySet()){
            if(paginaBuscada != null && paginasWeb.get(paginaBuscada) > posicionPagina){
                posicionPagina = paginasWeb.get(paginaBuscada);
                textoAMostrar = paginaBuscada;
            }
        }
        
        return textoAMostrar;
    }

    public String clienteConMasAccesosExitosos()
    {
        direccionesIp.clear();
        String direccionAMostrar = null;
        int posicionDireccion = -1;
        for(Acceso accesoActual : accesos){
            if(!direccionesIp.containsKey(accesoActual.getDireccionIp())){
                direccionesIp.put(accesoActual.getDireccionIp(), 0);
            }
        }
        for(Acceso nuevoAcceso : accesos){
            direccionesIp.put(nuevoAcceso.getDireccionIp(),  direccionesIp.get(nuevoAcceso.getDireccionIp()) + 1);
        }
        for(String direccionBuscada : direccionesIp.keySet()){
            if(direccionBuscada != null && direccionesIp.get(direccionBuscada) > posicionDireccion){
                posicionDireccion = direccionesIp.get(direccionBuscada);
                direccionAMostrar = direccionBuscada;
            }
        }
        return direccionAMostrar;
    }
}
