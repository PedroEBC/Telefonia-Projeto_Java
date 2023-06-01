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
    
}
