public class Controlador {
    private final Consola consolita;
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablerito;
    public Controlador(){       //Inicializador donde se instancia el uso de consola (Interaccion con persona)
        this.consolita = new Consola();
    }
    public void jugar(){        //Se inicia el juego, estableciendo jugadores y comenzando el juego
        this.jugador1 = new Jugador(consolita.pedirNombre(1));
        this.jugador2 = new Jugador(consolita.pedirNombre(2));
        inicioPartida();
    }
    public void inicioPartida(){        //Inicializador de cada ronda
        boolean paridad = false;        //Se resetean los valor del tablero para iniciar una nueva ronda
        jugador1.resetPuntos();
        jugador2.resetPuntos();
        int ancho = 0;
        int alto = 0;
        while (!paridad){
            ancho = consolita.mensajePedirAncho();
            alto = consolita.mensajePedirAltura();
            if (alto*ancho % 2 == 0){
                paridad = true;
            }
        }
        tablerito = new Tablero(alto, ancho);       //Comienza ronda
        consolita.mensajeBienvenida(alto, ancho, tablerito.getParejasDisponibles());
        consolita.imprimirTablero(tablerito);
        ronda(alto,ancho);
    }
    public void ronda(int alto, int ancho){         //Logica detras de cada ronda del juego. Se puede simplificar, ya que se recicla mucho codigo.
        boolean comprobarTurno = true;
        String nombre = "";
        boolean comprobacionSalida = true;
        boolean comprobacionRendir = true;
        while(tablerito.getParejasDisponibles() > tablerito.getParejasEncontradas() && comprobacionSalida && comprobacionRendir){       //Comprobacion para continuar con la ronda
            if (comprobarTurno){        //Controlador turno de jugador
                comprobarTurno = false;     //Logica turno de jugador 1
                nombre = jugador1.getNombre();
                consolita.imprimirTablero(tablerito);
                String respuesta = consolita.mensajeDeTurno(nombre);        //Se obtiene la accion a realizar
                switch (respuesta) {
                case "REVELAR" -> {
                    jugador2.setPartidasGanadas();      //El jugador que lo selecciona se rinde, dandole el punto al rival y mostrando el tablero.
                    consolita.mensajeGanadorRonda(jugador2.getNombre(), jugador2.getPuntos());
                    for (int i = 0; i < alto; i++) {
                        for (int e = 0; e < ancho; e++) {
                            tablerito.revelarCarta(i,e);
                        }
                    }
                    consolita.imprimirTablero(tablerito);
                    comprobacionRendir = false;
                }
                case "SALIR" -> {       //Se muestra el tablero y se termina el juego (sin contar el ultimo tablero). Se muestra al ganador.
                    consolita.imprimirTablero(tablerito);
                    ganadorTotal();
                    consolita.mensajeSalida();
                }
                default -> {
                    boolean comprobacionCarta1 = true;      //Analisis de para revelar cartas
                    String simbCarta1 = "";
                    String simbCarta2 = "";
                    int coordenada1_1 = 0;
                    int coordenada2_1 = 0;
                    int coordenada1_2 = 0;
                    int coordenada2_2 = 0;
                    while (comprobacionCarta1){
                        String coordenadas_1 = consolita.mensajeDeCoordenadas();        //Se obtienen las coordenadas de la primer carta hasta que sea posible revelar algo.
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
                    simbCarta1 = tablerito.getSimboloCelda(coordenada1_1, coordenada2_1);       //Se obtiene el simbolo de la carta.
                    consolita.imprimirTablero(tablerito);               //Se muestra el tablero actualizado temporal.
                    boolean comprobacionCarta2 = true;              //Se repite el proceso para la segunda carta.
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
                    consolita.imprimirTablero(tablerito);           //Se muestra el tablero temporal y se obtiene el simbolo de la segunda carta.
                    simbCarta2 = tablerito.getSimboloCelda(coordenada1_2, coordenada2_2);
                    if (simbCarta1.equals(simbCarta2)){         //Si los simbolos son iguales, se genera una pareja y se otorga un punto.
                        tablerito.establecerEmparejado(coordenada1_2, coordenada2_2);
                        tablerito.establecerEmparejado(coordenada1_1, coordenada2_1);
                        tablerito.setParejasEncontradas();
                        jugador1.setPuntos();
                    }
                    else{               //Si los simbolos no son iguales, se vuelven a esconder las cartas.
                        tablerito.esconderCarta(coordenada1_1, coordenada2_1);
                        tablerito.esconderCarta(coordenada1_2, coordenada2_2);
                    }
                }}
            }
            else{           //Logica turno de jugador 2. Misma que para jugador 1, aunque con los efectos de puntos y nombres cambiados.
                comprobarTurno = true;
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
        if (!comprobacionRendir){           //Accion final si el jugador se rindió
            if(consolita.volverAJugar()){
                inicioPartida();
            }
        }
        else if(!comprobacionSalida){}
        else{           //Accion final sisi el juego terminó al encontrar todas las parejas
            ganadorRonda();
            if(consolita.volverAJugar()){
                inicioPartida();
            }
            else{
                ganadorTotal();
            }
        }
    }
    public void ganadorRonda(){         //Se analiza al ganador de la ronda (o empate) al comparar los puntos obtenidos en la ronda por cada jugador.
        int puntosJug1 = jugador1.getPuntos();
        int puntosJug2 = jugador2.getPuntos();
        if (puntosJug1 > puntosJug2){
            consolita.mensajeGanadorRonda(jugador1.getNombre(), puntosJug1);
            jugador1.setPartidasGanadas();
        }
        else if (puntosJug1 < puntosJug2) {
            consolita.mensajeGanadorRonda(jugador2.getNombre(), puntosJug2);
            jugador2.setPartidasGanadas();
        }
        else{
            consolita.mensajeEmpateRonda(puntosJug1);
        }
    }
    public void ganadorTotal(){         //Se analiza al ganador total (o empate) al comparar las partidas que gano cada jugador.
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