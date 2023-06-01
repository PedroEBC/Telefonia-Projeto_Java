import java.util.GregorianCalendar;

public class PrePago extends Assinante {

    private int numRecargas;
    private float creditos;
    private Recarga[] recargas;
    
    public PrePago(long cpf, String nome,int numero) {
    	 super(cpf, nome, numero);
         this.numRecargas = 0;
         this.creditos = 0.0f;
         this.recargas = new Recarga[5];
   }
