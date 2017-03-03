import java.util.Scanner;
public class Acceso
{
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    private Scanner sc;
    private String direccionIp;
    private String paginaWeb;
    private int codigoHttp;
    
    public Acceso(String lineaAcceso)
    {
        sc = new Scanner(lineaAcceso);
        String lineaLeida = sc.nextLine();               
        String[] accesos = lineaLeida.split(" ");
        direccionIp = accesos[0];
        ano = Integer.parseInt(accesos[1].substring(1,5));
        mes = Integer.parseInt(accesos[2]);
        dia = Integer.parseInt(accesos[3]);
        hora = Integer.parseInt(accesos[4]);
        minutos = Integer.parseInt(accesos[5].substring(0,2));
        paginaWeb = accesos[6];
        codigoHttp = Integer.parseInt(accesos[7]);
    }
    
    public String getDireccionIp()
    {
        return direccionIp;
    }
    
    public int getAno() 
    {
        return ano;
    }
    
    public int getMes()
    {
        return mes;
    }
    
    public int getDia()
    {
        return dia;
    }
    
    public int getHora()
    {
        return hora;
    }
    
    public int getMinutos()
    {
        return minutos;
    }
    
    public String getPaginaWeb()
    {
        return paginaWeb;
    }
    
    public int getCodigoHttp()
    {
        return codigoHttp;
    }
}