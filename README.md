# Telefonia-Projeto_Java

## Sobre o Projeto
Este projeto é um sistema de gerenciamento de telefonia, desenvolvido em Java, com foco na organização e gerenciamento de chamadas telefônicas. Ele implementa funcionalidades para lidar com assinantes, chamadas, recargas e diferenciação entre planos pré-pagos e pós-pagos.

## Estrutura do Projeto
O projeto é composto pelos seguintes arquivos principais:

- **Assinante.java**: Classe responsável por representar um assinante genérico.
- **Chamada.java**: Classe que modela uma chamada telefônica, com informações como duração e data.
- **PosPago.java**: Extensão da classe Assinante, representando clientes com planos pós-pagos.
- **PrePago.java**: Extensão da classe Assinante, representando clientes com planos pré-pagos.
- **Recarga.java**: Classe que gerencia as recargas realizadas pelos clientes pré-pagos.
- **Telefonia.java**: Classe principal que integra as funcionalidades do sistema.

## Funcionalidades Principais
- Cadastro de assinantes com opções de planos pré-pagos e pós-pagos.
- Registro de chamadas realizadas pelos assinantes.
- Gerenciamento de recargas para clientes pré-pagos.
- Consulta de dados dos assinantes e histórico de chamadas.

## Como Executar
1. Certifique-se de ter o [JDK](https://www.oracle.com/java/technologies/javase-downloads.html) instalado.
2. Faça o download ou clone este repositório.
   ```bash
   git clone <url-do-repositorio>
   ```
3. Compile os arquivos `.java` usando o seguinte comando no terminal:
   ```bash
   javac *.java
   ```
4. Execute a classe principal `Telefonia`:
   ```bash
   java Telefonia
   ```
