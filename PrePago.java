import java.util.GregorianCalendar;

public class PrePago extends Assinante {

    private int numRecargas;
    private float creditos;
    private Recarga[] recargas;
    
    public PrePago(long cpf, String nome,int numero) {
    	 super(cpf, nome, numero);
         this.numRecargas = 0;
         this.creditos = 0.0f;
         this.recargas = new Recarga[3];
   }
    
    public float fazerChamada(GregorianCalendar data, int duracao) {
    	if (numChamadas < chamadas.length) {
    		if (creditos >= 1.45*duracao) {
    			Chamada novaChamada = new Chamada(data, duracao);
        		chamadas[numChamadas] = novaChamada;
        		
        		numChamadas++;
        		
        		float creditoGasto = (float) (duracao*1.45);
        		
        		creditos = creditos - creditoGasto;{
        	    System.out.println("Chamada realizada com sucesso");
        		}
    		
    		}else {
        			
        			 System.out.println("Impossivel relizar chamada");
        			}
        		}
        		return duracao;
        		
        	}
    
   
    
    public void recarregar(GregorianCalendar data, float valor) {
    	if (numRecargas < recargas.length) {
            
    	 Recarga recarga = new Recarga(data, valor);
    		recargas[numRecargas] = recarga;
            numRecargas++;
            creditos += valor;
           
            System.out.println("Recarga registrada com sucesso");
        }
    	else {
            System.out.println("Não é possível realizar mais recargas, limite alcançado.");
    	}
    }
    	
    	
    	public void imprimirFatura (int mes) {
        	System.out.println("FATURA");
        	System.out.println("Dados:");
        	System.out.println("CPF:" + getCPF());
        	
        	System.out.println("Chamadas feitas no mês " + mes + ":");
            float totalChamadas = 0;
			for (int i = 0; i < numChamadas; i++) {
                Chamada chamada = chamadas[i];
                if (chamada.getData().get(GregorianCalendar.MONTH) + 1 == mes) {
                    System.out.println("Data: " + chamada.getData().getTime());
                    System.out.println("Duração: " + chamada.getDuracao() + " minutos");
                    double custoChamada = chamada.getDuracao() * 1.45; // Custo por minuto
                    totalChamadas += custoChamada;
                    System.out.println("Custo: R$" + custoChamada);
                }
            }
            
            System.out.println("Recargas feitas no mês:");
            float totalRecargas = 0.0f;
            for (int i = 0; i < numRecargas; i++) {
                Recarga recarga = recargas[i];
                if (recarga.getData().get(GregorianCalendar.MONTH) + 1 == mes) {
                    System.out.println("Data da recarga: " + recarga.getData().getTime());
                    System.out.println("Valor da recarga: R$" + recarga.getValor());
                    double custoRecarga = recarga.getValor();
                    totalRecargas += custoRecarga;
                    System.out.println("Custo recarga: " + custoRecarga);
                    
                }
            }
            
  
            float valorTotal = totalChamadas + totalRecargas;
            System.out.println("Valor total das ligações:R$" + totalChamadas);
            System.out.println("Valor total das recargas:R$" + totalRecargas);
            System.out.println("Créditos disponíveis:R$" + creditos);
    	}
    }
