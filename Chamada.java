import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Chamada {
    private GregorianCalendar data;
    private int duracao;

    public Chamada(GregorianCalendar data, int duracao) {
        this.data = data;
        this.duracao = duracao;
    }
    
    
    public GregorianCalendar getData() {
        return data;
    }

    public int getDuracao() {
        return duracao;
    }

    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dataGerada= df.format(data.getTime());
        return "Data: " + dataGerada + "\nDuração: " + duracao + " minutos";
        
    }
}