import java.util.ArrayList;
public class Tablero{
    private ArrayList<String> caracteres = new ArrayList<>();
    private Carta[][] casillas;
    private int alto;
    private int ancho;
    private int parejasDisponibles;
    private int parejasEncontradas;
    public Tablero(int alto, int ancho){
        for (int i = 33; i < 127; i++) {
            caracteres.add(Character.toString(i));
        }
        this.casillas = new Carta[alto][ancho];
        this.alto = alto;
        this.ancho = ancho;
        this.parejasEncontradas = 0;
        this.parejasDisponibles = alto*ancho/2;
        asignacionCaracteres();
    }
    public void asignacionCaracteres(){
        for (int i = 0; i < parejasDisponibles; i++) {
            boolean controlador1 = true;
            boolean controlador2 = true;
            while(controlador1){
                int coordenada1 = (int)((Math.random() * (alto)));
                int coordenada2 = (int)((Math.random() * (ancho)));
                if((casillas[coordenada1][coordenada2] == null)) {
                    casillas[coordenada1][coordenada2] = new Carta();
                    casillas[coordenada1][coordenada2].setSimbolo(caracteres.get(i));
                    controlador1 = false;
                } else {
                    if (casillas[coordenada1][coordenada2].getSimbol().equals("")){
                        casillas[coordenada1][coordenada2].setSimbolo(caracteres.get(i));
                        controlador1 = false;
                    }
                }
            }
            while(controlador2){
                int coordenada1 = (int)((Math.random() * (alto)));
                int coordenada2 = (int)((Math.random() * (ancho)));
                if((casillas[coordenada1][coordenada2] == null)) {
                    casillas[coordenada1][coordenada2] = new Carta();
                    casillas[coordenada1][coordenada2].setSimbolo(caracteres.get(i));
                    controlador2 = false;
                } else {
                    if (casillas[coordenada1][coordenada2].getSimbol().equals("")){
                        casillas[coordenada1][coordenada2].setSimbolo(caracteres.get(i));
                        controlador2 = false;
                    }
                }
            }
        }
    }
    public int getAltura(){
        return this.alto;
    }
    public int getAncho(){
        return this.ancho;
    }
    public int getParejasDisponibles(){
        return this.parejasDisponibles;
    }
    public int getParejasEncontradas(){
        return this.parejasEncontradas;
    }
    public void setParejasEncontradas(){
        this.parejasEncontradas = parejasEncontradas + 1;
    }
    public String getCelda(int r, int c){
        System.out.println(r + "," +c);
        return casillas[r][c].toString();
    }
    public String getSimboloCelda(int r, int c){
        return casillas[r][c].getSimbol();
    }
    public boolean comprobarEstadoRevelar(int r, int c){
        return !(casillas[r][c].getEmparejado() || casillas[r][c].getRevelado());
    }
    public void revelarCarta(int r, int c){
        casillas[r][c].setRevelado();
    }
    public void esconderCarta(int r, int c){
        casillas[r][c].setRevelado();
    }
    public void establecerEmparejado(int r, int c){
        casillas[r][c].setEmparejado();
    }
}