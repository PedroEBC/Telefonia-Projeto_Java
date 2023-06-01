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

     public void imprimirFatura (int mes) {
    	System.out.println("\nFATURA");
    	System.out.println("\nDados:");
    	System.out.println("CPF: " + getCPF() + "\n" + toString());
    	
    	System.out.println("\nChamadas feitas no mês " + mes + ":");
        for (int i = 0; i < numChamadas; i++) {
            Chamada chamada = chamadas[i];
            if (chamada.getData().get(GregorianCalendar.MONTH) + 1 == mes) {
                System.out.println("\nData: " + chamada.getData().getTime());
                System.out.println("Duração: " + chamada.getDuracao() + " minutos");
                double custoChamada = chamada.getDuracao() * 1.04; // Custo por minuto
                System.out.println("Custo: R$" + custoChamada);
            }
        }

        double totalFatura = assinatura;
        for (int i = 0; i < numChamadas; i++) {
            Chamada chamada = chamadas[i];
            if (chamada.getData().get(GregorianCalendar.MONTH) + 1 == mes) {
                totalFatura += chamada.getDuracao() * 1.04;
            }
        }
        System.out.println("\nValor total da fatura: R$" + totalFatura);
    	
    }
}
