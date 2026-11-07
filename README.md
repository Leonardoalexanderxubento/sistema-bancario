# 🏦 Sistema Bancário

Sistema bancário simples em Java, executado pelo terminal. Projeto feito para praticar os conceitos de Programação Orientada a Objetos (POO).

## Funcionalidades

- Criar várias contas
- Depositar
- Sacar (com verificação de saldo)
- Transferir entre contas
- Ver extrato com todas as movimentações
- Validação de entradas (números inválidos, valores negativos, opções fora da lista)

## Tecnologias

- Java 21
- VS Code com Extension Pack for Java

## Conceitos praticados

- Classes e objetos
- Encapsulamento (atributos `private` e métodos `get`)
- Construtores
- Listas com `ArrayList`
- Laços (`while`, `for`)
- Leitura do teclado com `Scanner`
- Tratamento de erros com `try/catch`

## Estrutura

```
sistema-bancario/
├── src/
│   ├── App.java     # menu e interação com o usuário
│   └── Conta.java   # regras da conta (saldo, depósito, saque, extrato)
└── README.md
```

## Como executar

1. Tenha o **JDK 17 ou superior** instalado.
2. Clone o repositório:
   ```bash
   git clone https://github.com/Leonardoalexanderxubento/sistema-bancario.git
   ```
3. Entre na pasta `src` e compile:
   ```bash
   cd sistema-bancario/src
   javac App.java Conta.java
   ```
4. Execute:
   ```bash
   java App
   ```

## Exemplo de uso

```
1 - Criar conta
2 - Depositar
3 - Sacar
4 - Transferir
5 - Extrato
0 - Sair
Opção: 1
Nome do titular: Maria
Conta criada!
```




