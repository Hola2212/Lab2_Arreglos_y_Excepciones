import java.io.PrintStream;
import java.util.Scanner;

public class Consola{
    private final Scanner sc;
    private final PrintStream Imp;
    public Consola(){
        this.sc = new Scanner(System.in);
        this.Imp = System.out;
    }
    public String pedirNombre(int jugador){
        Imp.println("Ingrese el nombre del jugador " + jugador);
        String nombre = "";
        while (nombre.equals("")){
            nombre = sc.nextLine();
        }
        return nombre;
    }
    public void mensajeGanadorRonda(String nombre, int puntos){
        Imp.println("El jugador " + nombre + " ha ganado la ronda con " + puntos + " puntos.");
    }
    public void mensajeEmpateRonda(int puntos){
        Imp.println("En esta ronda, ambos jugadores han empatado con " + puntos + " puntos.");
    }
    public void mensajeGanadorTotal(String nombre, int partidas){
        Imp.println("El jugador " + nombre + " ha ganado la partida con " + partidas + " rondas ganadas.");
    }
    public void mensajeEmpateTotal(int partidas){
        Imp.println("En esta partida, ambos jugadores han empatado con " + partidas + " rondas ganadas.");
    }
    public int mensajePedirAltura(){
        Imp.println("Ingrese la altura del tablero. (Debe ser un entero positivo par)");
        int altura = 1;
        while (altura%2 == 1){
            altura = sc.nextInt();
        }
        return altura;
    }
    public int mensajePedirAncho(){
        Imp.println("Ingrese el ancho del tablero. (Debe ser un entero positivo par)");
        int ancho = 1;
        while (ancho%2 == 1){
            ancho = sc.nextInt();
        }
        return ancho;
    }
}