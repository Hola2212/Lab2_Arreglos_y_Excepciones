public class Jugador{
    private String nombre;
    private int puntos;
    private int partidasGanadas;
    public Jugador(String nombre){              //Inicializador de la clase Jugador
        this.nombre = nombre;
        this.puntos = 0;
        this.partidasGanadas = 0;
    }
    public String getNombre(){                  //Regresa el nombre del jugador guardado 
        return this.nombre;
    }
    public int getPuntos(){                     //Regresa los puntos ganados en la ronda del jugador
        return this.puntos;
    }
    public int getPartidasGanadas(){            //Regresa las rondas ganadas en la partida del jugador
        return this.partidasGanadas;
    }
    public void setNombre(String nombre){       //Cambia el valor del nombre del jugador
        this.nombre = nombre;
    }
    public void setPuntos(){                    //Modifica los puntos de la ronda (nueva pareja)
        this.puntos = this.puntos + 1;
    }
    public void resetPuntos(){                  //Resetea los puntos de la ronda para empezar una nueva
        this.puntos = 0;
    }
    public void setPartidasGanadas(){           //Modifica las rondas de la partida (ronda ganada)
        this.partidasGanadas = this.partidasGanadas + 1;
    }
}