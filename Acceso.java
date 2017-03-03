import java.util.Scanner;
public class Acceso
{
    private String ano;
    private int mes;
    private int dia;
    private int hora;
    private String minutos;
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
        ano = accesos[1];
        mes = Integer.parseInt(accesos[2]);
        dia = Integer.parseInt(accesos[3]);
        hora = Integer.parseInt(accesos[4]);
        minutos = accesos[5];
        paginaWeb = accesos[6];
        codigoHttp = Integer.parseInt(accesos[7]);
    }
    
    public String getDireccionIp()
    {
        return direccionIp;
    }
    
    public String getAno() 
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
    
    public String getMinutos()
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