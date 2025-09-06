public class Jugador{
    private String nombre;
    private int puntos;
    private int partidasGanadas;
    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntos = 0;
        this.partidasGanadas = 0;
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getPuntos(){
        return this.puntos;
    }
    public int getPartidasGanadas(){
        return this.partidasGanadas;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPuntos(){
        this.puntos = this.puntos + 1;
    }
    public void setPartidasGanadas(){
        this.partidasGanadas = this.partidasGanadas + 1;
    }
}