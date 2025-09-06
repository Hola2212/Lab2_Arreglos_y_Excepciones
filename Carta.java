public class Carta{
    private String simbolo;
    private boolean revelado;
    private boolean emparejado;
    public Carta(){
        this.simbolo = "";
        this.revelado = false;
        this.emparejado = false;
    }
    public String getSimbol(){
        return this.simbolo;
    }
    public boolean getRevelado(){
        return this.revelado;
    }
    public boolean getEmparejado(){
        return this.emparejado;
    }
    public void setSimbolo(String simbolo){
        this.simbolo = this.simbolo;
    }
    public void setRevelado(){
        this.revelado = !this.revelado;
    }
    public void setEmparejado(){
        this.emparejado = true;
    }
    public String toString(){
        if (!this.revelado){
            return "■";
        } else {
            return this.simbolo;
        }
    }
}