package br.com.fiap.models;

public class ContaEspecial extends ContaComum {
    public String sacarValor(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
            return "Saldo efetuado com sucesso";
        } else if (this.saldo+limite >=valor){
            this.saldo -= valor;
            this.limite += saldo;
            return "Saque efetuado com sucesso utilizando o limite";

        }
        else {
            return "Saque não efetuado, saldo insuficiente";
        }
    }



}
