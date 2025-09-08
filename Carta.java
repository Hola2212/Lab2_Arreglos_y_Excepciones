public class Carta{
    private String simbolo;
    private boolean revelado;
    private boolean emparejado;
    public Carta(){     //Creacion de la carta con valores de vacío.
        this.simbolo = "";
        this.revelado = false;
        this.emparejado = false;
    }
    public String getSimbol(){  //Regresa el identificador de la carta
        return this.simbolo;
    }
    public boolean getRevelado(){       //Regresa estado de volteado de la carta
        return this.revelado;
    }
    public boolean getEmparejado(){     //Regresa estado de volteado de la carta
        return this.emparejado;
    }
    public void setSimbolo(String simbolo){     //Modifica el identificador de la carta
        this.simbolo = simbolo;
    }
    public void setRevelado(){          //Modifica estado de volteado de la carta
        this.revelado = !this.revelado;
    }
    public void setEmparejado(){        //Modifica estado de volteado de la carta
        this.emparejado = true;
    }
    public String toString(){           //Modifica el toString default para mostrar en tablero
        if (!this.revelado){
            return "■";
        } else {
            return this.simbolo;
        }
    }
}