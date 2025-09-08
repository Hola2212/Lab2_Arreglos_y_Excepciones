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
        inicioPartida();
    }
    public void inicioPartida(){
        int ancho = consolita.mensajePedirAncho();
        int alto = consolita.mensajePedirAltura();
        tablerito = new Tablero(alto, ancho);
        consolita.mensajeBienvenida(alto, ancho, tablerito.getParejasDisponibles());
        consolita.imprimirTablero(tablerito);
        ronda(alto,ancho);
    }
    public void ronda(int alto, int ancho){
        boolean comprobarTurno = true;
        String nombre = "";
        boolean comprobacionSalida = true;
        boolean comprobacionRendir = true;
        while(tablerito.getParejasDisponibles() > tablerito.getParejasEncontradas() && comprobacionSalida && comprobacionRendir){
            if (comprobarTurno){
                nombre = jugador1.getNombre();
                String respuesta = consolita.mensajeDeTurno(nombre);
                switch (respuesta) {
                case "REVELAR" -> {
                    jugador2.setPartidasGanadas();
                    consolita.mensajeGanadorRonda(jugador2.getNombre(), jugador2.getPuntos());
                    for (int i = 0; i < alto; i++) {
                        for (int e = 0; ancho < 5; e++) {
                            tablerito.revelarCarta(i,e);
                        }
                    }
                    consolita.imprimirTablero(tablerito);
                    comprobacionRendir = false;
                }
                case "SALIR" -> {
                    ganadorTotal();
                    consolita.mensajeSalida();
                }
                default -> {
                    boolean comprobacionCarta1 = true;
                    String simbCarta1 = "";
                    String simbCarta2 = "";
                    int coordenada1_1 = 0;
                    int coordenada2_1 = 0;
                    int coordenada1_2 = 0;
                    int coordenada2_2 = 0;
                    while (comprobacionCarta1){
                        String coordenadas_1 = consolita.mensajeDeCoordenadas();
                        try {
                            coordenada1_1 = Character.getNumericValue((coordenadas_1.charAt(0)));
                            coordenada2_1 = ((coordenadas_1.charAt(1)) - '1');
                            if (tablerito.comprobarEstadoRevelar(coordenada1_1, coordenada2_1)){
                                comprobacionCarta1 = false;
                                tablerito.revelarCarta(coordenada1_1, coordenada2_1);
                            }
                        } catch (Exception e) {
                        }
                    }
                    simbCarta1 = tablerito.getSimboloCelda(coordenada1_1, coordenada2_1);
                    consolita.imprimirTablero(tablerito);
                    boolean comprobacionCarta2 = true;
                    while (comprobacionCarta2){
                        String coordenadas_2 = consolita.mensajeDeCoordenadas();
                        try {
                            coordenada1_2 = Character.getNumericValue((coordenadas_2.charAt(0)));
                            coordenada2_2 = ((coordenadas_2.charAt(1)) - '1');
                            if (tablerito.comprobarEstadoRevelar(coordenada1_2, coordenada2_2)){
                                comprobacionCarta2 = false;
                                tablerito.revelarCarta(coordenada1_2, coordenada2_2);
                            }
                        } catch (Exception e) {
                        }
                    }
                    consolita.imprimirTablero(tablerito);
                    simbCarta2 = tablerito.getSimboloCelda(coordenada1_2, coordenada2_2);
                    if (simbCarta1.equals(simbCarta2)){
                        tablerito.establecerEmparejado(coordenada1_2, coordenada2_2);
                        tablerito.establecerEmparejado(coordenada1_1, coordenada2_1);
                        tablerito.setParejasEncontradas();
                        jugador1.setPuntos();
                    }
                    else{
                        tablerito.esconderCarta(coordenada1_1, coordenada2_1);
                        tablerito.esconderCarta(coordenada1_2, coordenada2_2);
                    }
                }}
            }
            else{
                nombre = jugador2.getNombre();
                String respuesta = consolita.mensajeDeTurno(nombre);
                switch (respuesta) {
                case "REVELAR" -> {
                    jugador1.setPartidasGanadas();
                    consolita.mensajeGanadorRonda(jugador1.getNombre(), jugador1.getPuntos());
                    for (int i = 0; i < alto; i++) {
                        for (int e = 0; ancho < 5; e++) {
                            tablerito.revelarCarta(i,e);
                        }
                    }
                    consolita.imprimirTablero(tablerito);
                    comprobacionRendir = false;
                }
                case "SALIR" -> {
                    ganadorTotal();
                    consolita.mensajeSalida();
                }
                default -> {
                    boolean comprobacionCarta1 = true;
                    String simbCarta1 = "";
                    String simbCarta2 = "";
                    int coordenada1_1 = 0;
                    int coordenada2_1 = 0;
                    int coordenada1_2 = 0;
                    int coordenada2_2 = 0;
                    while (comprobacionCarta1){
                        String coordenadas_1 = consolita.mensajeDeCoordenadas();
                        try {
                            coordenada1_1 = Character.getNumericValue((coordenadas_1.charAt(0)));
                            coordenada2_1 = ((coordenadas_1.charAt(1)) - '1');
                            if (tablerito.comprobarEstadoRevelar(coordenada1_1, coordenada2_1)){
                                comprobacionCarta1 = false;
                                tablerito.revelarCarta(coordenada1_1, coordenada2_1);
                            }
                        } catch (Exception e) {
                        }
                    }
                    simbCarta1 = tablerito.getSimboloCelda(coordenada1_1, coordenada2_1);
                    consolita.imprimirTablero(tablerito);
                    boolean comprobacionCarta2 = true;
                    while (comprobacionCarta2){
                        String coordenadas_2 = consolita.mensajeDeCoordenadas();
                        try {
                            coordenada1_2 = Character.getNumericValue((coordenadas_2.charAt(0)));
                            coordenada2_2 = ((coordenadas_2.charAt(1)) - '1');
                            if (tablerito.comprobarEstadoRevelar(coordenada1_2, coordenada2_2)){
                                comprobacionCarta2 = false;
                                tablerito.revelarCarta(coordenada1_2, coordenada2_2);
                            }
                        } catch (Exception e) {
                        }
                    }
                    consolita.imprimirTablero(tablerito);
                    simbCarta2 = tablerito.getSimboloCelda(coordenada1_2, coordenada2_2);
                    if (simbCarta1.equals(simbCarta2)){
                        tablerito.establecerEmparejado(coordenada1_2, coordenada2_2);
                        tablerito.establecerEmparejado(coordenada1_1, coordenada2_1);
                        tablerito.setParejasEncontradas();
                        jugador2.setPuntos();
                    }
                    else{
                        tablerito.esconderCarta(coordenada1_1, coordenada2_1);
                        tablerito.esconderCarta(coordenada1_2, coordenada2_2);
                    }
                }}
            }
        }
        if (!comprobacionRendir){
            if(consolita.volverAJugar()){
                inicioPartida();
            }
        }
        else if(!comprobacionSalida){}
        else{
            ganadorRonda();
            if(consolita.volverAJugar()){
                inicioPartida();
            }
            else{
                ganadorTotal();
            }
        }
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
