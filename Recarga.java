import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Recarga {
    private GregorianCalendar data;
    private float valor;

    public Recarga(GregorianCalendar data, float valor){
        this.data = data;
        this.valor = valor;
    }

    public GregorianCalendar getData(){
        return data;
    }

    public float getValor(){
        return valor;
    }

    public String toString(){
        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        String dataGerada = df.format(data.getTime());
        return "Data: " + dataGerada + "\nValor: R$" + valor;
    }
    
}