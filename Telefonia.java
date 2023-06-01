import java.util.Scanner;


public class Telefonia {
    private PrePago[] prePago;
    private int numPrePago;
    private PosPago[] posPago;
    private int numPosPago;

    public Telefonia() {
        prePago = new PrePago[3];
        numPrePago = 0;
        posPago = new PosPago[3];
    }
    
    
    
    public void cadastrarAssinante() {
        Scanner s = new Scanner(System.in);
        System.out.println("Escolha o tipo de Assinatura desejado: \n1. Pré-Pago \n2. Pós-Pago");
        int tipoAssinatura = s.nextInt();

        if (tipoAssinatura == 1) {
            if (numPrePago >= prePago.length) {
                System.out.println("Não há mais espaço para cadastrar assinantes pré-pagos.");
                return;
            }
            System.out.println("Digite as informações do assinante.");
            System.out.print("Nome: ");
            String nome = s.next();

            System.out.print("CPF: ");
            long cpf = s.nextLong();

            System.out.print("Número de telefone: ");
            int numero = s.nextInt();

            PrePago novoPrePago = new PrePago(cpf, nome, numero);

            prePago[numPrePago] = novoPrePago;

            numPrePago++;

            System.out.println("Assinante pré-pago cadastrado com sucesso!.\n");

        } else if (tipoAssinatura == 2) {
            if (numPosPago >= posPago.length) {
                System.out.println("\nNão há mais espaço para cadastrar assinantes pós-pagos.");
                return;
            }
            System.out.println("\nDigite as informações do assinante.");
            System.out.print("Nome: ");
            String nome = s.next();

            System.out.print("CPF: ");
            long cpf = s.nextLong();

            System.out.print("Número de telefone: ");
            int numero = s.nextInt();

            System.out.print("Valor da assinatura: ");
            float assinatura = s.nextFloat();
            PosPago novoPosPago = new PosPago(cpf, nome, numero, assinatura);

            posPago[numPosPago] = novoPosPago;

            numPosPago++;

            System.out.println("\nAssinante pós-pago cadastrado com sucesso!.");
        } else {
            System.out.println("\nOpção inválida.");
        }
    }
    
    
      public void listarAssinantes() {
    	
    	if (numPrePago == 0 && numPosPago ==0) {
    		
    		System.out.println(" \nERRO!! NÃO HÁ ASSINANTES CADASTRADOS!");
    		
    	} else {
    		
    		
    		 System.out.println("Buscando...");
    	        System.out.println("\nAssinantes pré-pagos:");
    	        for (int i = 0; i < numPrePago; i++) {
    	      
    	        System.out.println(prePago[i].toString());
    	        System.out.println(prePago[i].getCPF());
    	        	
    	        }

    	        System.out.println("\nAssinantes pós-pagos:");
    	        for (int i = 0; i < numPosPago; i++) {
    	        	
    	        	System.out.println(posPago[i].toString());
    	        	System.out.println(posPago[i].getCPF());
    	        }
    	        
    		
    	}
    	public void fazerChamada() {


         Scanner scanner = new Scanner(System.in);
         System.out.println("\nDigite o tipo de assinante \n1 - Pré-pago  \n2 - Pós-pago:");
         int tipoAssinante = scanner.nextInt();

         System.out.println("Digite o CPF do assinante:");
         long cpf = scanner.nextLong();

         if (tipoAssinante == 1) {
             PrePago assinante = localizarPrePago(cpf);
             if (assinante != null) {
                 System.out.println("Digite a duração da chamada:");
                 int duracao = scanner.nextInt();

                 System.out.println("\nDigite a data da chamada (formato: dia/mês/ano):");
                 String dataStr = scanner.next();

                 int dia = Integer.parseInt(dataStr.substring(0, 2));
                 int mes = Integer.parseInt(dataStr.substring(3, 5));
                 int ano = Integer.parseInt(dataStr.substring(6));

                 GregorianCalendar data = new GregorianCalendar(ano, mes - 1, dia);
                 assinante.fazerChamada(data, duracao);
             } else {
                 System.out.println("\nAssinante pré-pago não encontrado.");
             }
         } else if (tipoAssinante == 2) {
             PosPago assinante = localizarPosPago(cpf);
             if (assinante != null) {
                 System.out.println("Digite a duração da chamada:");
                 int duracao = scanner.nextInt();

                 System.out.println("Digite a data da chamada (formato: dia/mês/ano):");
                 String dataStr = scanner.next();

                 int dia = Integer.parseInt(dataStr.substring(0, 2));
                 int mes = Integer.parseInt(dataStr.substring(3, 5));
                 int ano = Integer.parseInt(dataStr.substring(6));


                 GregorianCalendar data = new GregorianCalendar(ano, mes - 1, dia);

                 assinante.fazerChamada(data, duracao);
             } else {
                 System.out.println("\nAssinante pós-pago não encontrado.");
             }
         } else {
             System.out.println("\nOpção inválida. Tipo de assinante não reconhecido.");
         }

      }
       
    	
    
    
    
    
}
