public class Controlador {
    private final Consola consolita;
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablerito;
    public Controlador(){
        this.consolita = new Consola();
    }
    public void jugar(){
        this.jugador1 = new Jugador(consolita.pedirNombre(1));
        this.jugador2 = new Jugador(consolita.pedirNombre(2));
    }
    public void turno(){
        
    }
    public void ronda(){
        
    }
    public void ganadorRonda(){
        int puntosJug1 = jugador1.getPuntos();
        int puntosJug2 = jugador2.getPuntos();
        if (puntosJug1 > puntosJug2){
            consolita.mensajeGanadorRonda(jugador1.getNombre(), puntosJug1);
        }
        else if (puntosJug1 < puntosJug2) {
            consolita.mensajeGanadorRonda(jugador2.getNombre(), puntosJug2);
        }
        else{
            consolita.mensajeEmpateRonda(puntosJug1);
        }
    }
    public void ganadorTotal(){
        int partidasJug1 = jugador1.getPartidasGanadas();
        int partidasJug2 = jugador2.getPartidasGanadas();
        if (partidasJug1 > partidasJug2){
            consolita.mensajeGanadorRonda(jugador1.getNombre(), partidasJug1);
        }
        else if (partidasJug1 < partidasJug2) {
            consolita.mensajeGanadorRonda(jugador2.getNombre(), partidasJug2);
        }
        else{
            consolita.mensajeEmpateRonda(partidasJug1);
        }
    }

}
