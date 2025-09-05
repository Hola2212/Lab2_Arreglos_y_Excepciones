import java.util.ArrayList;
public class Tablero{
    private ArrayList<String> caracteres = new ArrayList<>();
    public Tablero(){
        for (int i = 33; i < 127; i++) {
            caracteres.add(Character.toString(i));
        }
    }
}