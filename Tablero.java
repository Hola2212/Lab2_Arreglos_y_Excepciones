import java.util.ArrayList;
public class Tablero{
    private ArrayList<int[]> coordenadas = new ArrayList<>();       //Simplificar la creacion de las casillas. Se puede modificar para eliminarlo.
    private ArrayList<String> caracteres = new ArrayList<>();       //Variables a utilizar
    private Carta[][] casillas;
    private int alto;
    private int ancho;
    private int parejasDisponibles;
    private int parejasEncontradas;
    public Tablero(int alto, int ancho){                //Inicializador del tablero. Recibe dimensiones.
        for (int i = 33; i < 127; i++) {                //Se establecen todos los caracteres.
            caracteres.add(Character.toString(i));
        }
        this.casillas = new Carta[alto][ancho];
        for (int i = 0; i < alto; i++) {
            for (int e = 0; e < ancho; e++) {
                this.casillas[i][e] = new Carta();      //Ceracion de las casillas son simbolo ""
                int[] coordenadaTemp = {i,e};
                this.coordenadas.add(coordenadaTemp);
            }
        }
        this.alto = alto;
        this.ancho = ancho;
        this.parejasEncontradas = 0;
        this.parejasDisponibles = alto*ancho/2;
        for (int i = 0; i < parejasDisponibles; i++) {          //Asignacion de caracteres en las cartas
            int posCoord1 = (int)((Math.random() * (coordenadas.size())));
            int[] coordenadas1 = coordenadas.get(posCoord1);
            coordenadas.remove(posCoord1);
            int posCoord2 = (int)((Math.random() * (coordenadas.size())));
            int[] coordenadas2 = coordenadas.get(posCoord2);
            coordenadas.remove(posCoord2);
            casillas[coordenadas1[0]][coordenadas1[1]].setSimbolo(caracteres.get(i));
            casillas[coordenadas2[0]][coordenadas2[1]].setSimbolo(caracteres.get(i));
        }
    }
    public int getAltura(){         //Obtener altura del tablero
        return this.alto;
    }
    public int getAncho(){          //Obtener ancho del tablero
        return this.ancho;
    }
    public int getParejasDisponibles(){         //Obtener parejas totales en el juego
        return this.parejasDisponibles;
    }
    public int getParejasEncontradas(){         //Obtener parejas ya encontradas
        return this.parejasEncontradas;
    }
    public void setParejasEncontradas(){        //Modificar parejas encontradas (nueva pareja formada)
        this.parejasEncontradas = parejasEncontradas + 1;
    }
    public String getCelda(int r, int c){       //Obtiene el simbolo de la carta. (depende de condiciones de clase Carta)
        return casillas[r][c].toString();
    }
    public String getSimboloCelda(int r, int c){        //Obtiene el simbolo de una carta especifica.
        return casillas[r][c].getSimbol();
    }
    public boolean comprobarEstadoRevelar(int r, int c){        //Comprueba si se puede coltear la carta indicada.
        return !(casillas[r][c].getEmparejado() || casillas[r][c].getRevelado());
    }
    public void revelarCarta(int r, int c){         //Cambia el valor de revelado, para poder verla.
        casillas[r][c].setRevelado();
    }
    public void esconderCarta(int r, int c){        //Cambia el valor de revelado, para ya no poder verla.
        casillas[r][c].setRevelado();
    }
    public void establecerEmparejado(int r, int c){     //Cambiar el valor de emparejado (se encontro la pareja).
        casillas[r][c].setEmparejado();
    }
}