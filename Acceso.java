import java.util.Scanner;
public class Acceso
{
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    private String[] accesos;
    private Scanner sc;
    
    public Acceso(String lineaAcceso)
    {
        sc = new Scanner(lineaAcceso);
        String lineaLeida = sc.nextLine();               
        accesos = lineaLeida.split(" ");
        ano = Integer.parseInt(accesos[0]);
        mes = Integer.parseInt(accesos[1]);
        dia = Integer.parseInt(accesos[2]);
        hora = Integer.parseInt(accesos[3]);
        minutos = Integer.parseInt(accesos[4]);
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
}