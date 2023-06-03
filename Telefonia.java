import java.util.GregorianCalendar;
import java.text.ParseException;
import java.util.Calendar;
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
    
      
    public void cadastrarAssinante() throws ParseException {
        
       try {
           
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
           System.out.println("OPÇÃO INVALIDA. TENTE DE NOVO!.\n");
            cadastrarAssinante();
        }
           
         } catch (java.util.InputMismatchException ex) {
    	  System.out.println("\nDigite o formato correto!!\n(Numero: 976734668, CPF: 12345633789)\n\nVoltando ao menu...\n");
      }
    }

    
    
    public void listarAssinantes() {
    	if (numPrePago == 0 && numPosPago ==0) {
    		
    		System.out.println(" \nERRO!! NÃO HÁ ASSINANTES CADASTRADOS!");
    		
    	} else {
    		
    		
    		 System.out.println("Buscando...");
    	       System.out.println("\n----ASSINANTES PRÉ-PAGOS----\n");
    	        for (int i = 0; i < numPrePago; i++) {
    	      
    	        System.out.println(prePago[i].toString());
    	       System.out.println("CPF: " + prePago[i].getCPF() + "\n");
    	        	
    	        }

    	        System.out.println("\n----ASSINANTES PÓS-PAGOS----\n");
    	        for (int i = 0; i < numPosPago; i++) {
    	        	
    	        	System.out.println(posPago[i].toString());
    	        	System.out.println("CPF: " + posPago[i].getCPF() + "\n");
    	        }
    	        
    		
    	}
    	
       
    	
    }
    
    
    public void fazerChamada() throws ParseException {
        
        try {
            
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
            
            } catch (java.util.InputMismatchException ex ) {
    		
    		System.out.println("ATENÇÃO! TIPO DDO DADO INVÁLIDO\n Tente de novo...\n");
    		fazerChamada();
         
    	}
    	
      } 
    	
    
    public void fazerRecarga() {
    	Scanner s = new Scanner(System.in);
    	System.out.println("Escolha o tipo de Assinatura: \n1. Pré-Pago \n2. Pós-Pago ");
    	int tipoAssinante = s.nextInt();
    	
    	if (tipoAssinante == 1) {
    		System.out.println("Digite o CPF do assinante:");
    		long cpf = s.nextLong();
    		
    		PrePago assinantePrePago = localizarPrePago(cpf);
    		
    		
    		if (assinantePrePago != null && assinantePrePago.getCPF() == cpf) {
    			System.out.println("Assinante pré-pago encontrado com sucesso!!! \n\n");
    			System.out.println("Digite um mês: ");
    			int mes = s.nextInt();
    			
    	        GregorianCalendar data = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), mes - 1, 1);

    	        System.out.println("Digite um valor: ");
    	        float valor = s.nextFloat();

    	        assinantePrePago.recarregar(data, valor);
    			
    		} else {
    			
    			System.out.println("\nERRO!! ASSINANTE PRÉ-PAGO NÃO ENCONTRADO! ");
    		}
    		
    	
    	}
    	
    	
    }
    
   
    private PrePago localizarPrePago(long cpf) {
        for (int i = 0; i < numPrePago; i++) {
            if (prePago[i].getCPF() == cpf) {
                return prePago[i];
            }
        }
        return null; 
    }

    private PosPago localizarPosPago(long cpf) {
        for (int i = 0; i < numPosPago; i++) {
            if (posPago[i].getCPF() == cpf) {
                return posPago[i];
            }
        }
        return null; 
    }

    
    public void imprimirFaturas() {
    	Scanner s = new Scanner(System.in);
    	
    	System.out.print("Digite o mês das faturas a serem impressas: ");
    	int mes = s.nextInt();
        
        if (mes <= 12 ) {
    	
    	for (int i = 0; i < numPosPago; i++) {
            PosPago posPagoObj = posPago[i];
            posPagoObj.imprimirFatura(mes);
    	}
         
    	
    	 for (int j = 0; j < numPrePago; j++) {
             PrePago prePagoObj = prePago[j];
             prePagoObj.imprimirFatura(mes);
         }
    	
      } else {
    	  
    	  System.out.println("\nDIGITE UM MÊS VALIDO!!!");
          imprimirFaturas();
      }
    		
    		
    }
   
    
    public static void main(String[] args) throws ParseException {
    	Telefonia tel = new Telefonia();
        Scanner s = new Scanner(System.in);
        int op = 0;

        while (op != 6) {
            System.out.println("----------Sistema De Telefonia----------");
            System.out.println("\nEscolha uma das opções a seguir: ");
            System.out.println("1-Cadastrar Assinantes");
            System.out.println("2-Listar Assinantes");
            System.out.println("3-Fazer Chamada");
            System.out.println("4-Fazer Recarga");
            System.out.println("5-Imprimir Faturas");
            System.out.println("6-Sair do programa");
            op = s.nextInt();
            s.nextLine();

            switch (op) {
                case 1:
                    tel.cadastrarAssinante();
                    break;
                case 2:
                    tel.listarAssinantes();
                    break;
                case 3:
                    tel.fazerChamada();
                    break;
                case 4:
                    tel.fazerRecarga();
                    break;
                case 5:
                    tel.imprimirFaturas();
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Escolha uma das opções válidas.");
                    break;
            }
        }

        s.close();
    }
}
