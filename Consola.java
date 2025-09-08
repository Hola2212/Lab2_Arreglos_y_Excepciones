import java.io.PrintStream;
import java.util.Scanner;

public class Consola{
    private final Scanner sc;
    private final PrintStream Imp;
    public Consola(){
        this.sc = new Scanner(System.in);
        this.Imp = System.out;
    }
    public void mensajeBienvenida(int alto, int ancho, int totales){
        Imp.println("==== Memoria ====");
        Imp.printf("Tablero %d X %d.\n",alto,ancho);
        Imp.println("Filas A-"+(char)('A' + (alto-1)) + " y columnas 1-" + ancho + ".");
        Imp.printf("Hay %d parejas totales.\n",totales);
    }
    public void imprimirTablero(Tablero t){
        int alto = t.getAltura();
        int ancho = t.getAncho();
        Imp.print("  ");
        for (int c = 1; c <= ancho; c++){
            Imp.print(c+" ");
        }
        Imp.println("");
        for (int r = 0; r < alto; r++) {
            Imp.print((char)('A' + r) + " ");
            for (int c = 0; c < ancho; c++) {
                Imp.print(t.getCelda(r, c) + " ");
            }
            Imp.println("");
        }
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
    public String mensajeDeTurno(String nombre){
        Imp.println("Es el turno de "+ nombre + ". Seleccione uno de los comandos:");
        Imp.println("\tCOORDENADAS\n\tREVELAR para mostrar el tablero\n\tSALIR para reiniciar el juego.");
        String resp = "";
        while(resp.equals("")){
            resp = sc.nextLine();
        }
        return resp;
    }
    public String mensajeDeCoordenadas(){
        Imp.println("Ingrese la coordenada. Ejemplo (A1)");
        String coordenada = "";
        while (coordenada.equals("")){
            coordenada = sc.nextLine();
        }
        return coordenada;
    }
    public boolean volverAJugar(){
        Imp.println("¿Desea volver a jugar? (Y/N)");
        String respuesta = "";
        while (!"Y".equals(respuesta) && !"N".equals(respuesta)){
            Imp.println("Debe escribir (Y) o (N).");
            respuesta = sc.nextLine();
        }
        if("Y".equals(respuesta)) { return true;}
        else{ return false;}
    }
    public void mensajeSalida(){
        Imp.println("Gracias por haber jugado \\(◦'⌣'◦)/");
    }
}