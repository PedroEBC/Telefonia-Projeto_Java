import java.util.GregorianCalendar;

public class PosPago extends Assinante {
    private float assinatura;

    public PosPago(long cpf, String nome, int numero, float assinatura) {
        super(cpf, nome, numero);
        this.assinatura = assinatura;
    }

     public void fazerChamada(GregorianCalendar  data,  int  duracao) {
    	if (numChamadas < chamadas.length){
    		Chamada novaChamada = new Chamada(data, duracao);
    		chamadas[numChamadas] = novaChamada;
    		numChamadas++;
    		System.out.println("\nChamada realizada com sucesso");
    	}
    	else {
    		System.out.println("\nVoce não tem mais chamadas");
    	}
    }
