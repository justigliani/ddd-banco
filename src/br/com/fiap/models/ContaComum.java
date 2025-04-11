package br.com.fiap.models;

import br.com.fiap.enums.SituacaoEnum;

import java.time.LocalDate;
import java.util.Random;

public class ContaComum {
    protected Long nroConta;
    protected LocalDate dtAbertura;
    protected LocalDate dtEncerramento;
    protected SituacaoEnum situacao;
    protected int senha;
    protected double saldo;
    protected Cliente cliente;
    //protected compartilha os atributos com os filhos

    public Long abrirConta(int senha){
        this.senha = senha;
        Random random = new Random(); //p instanciar use qualquer nome
        this.nroConta = random.nextLong(1000); //será gerado um numero aleatorio de 0 a 1000
        this.senha = senha;
        this.situacao = SituacaoEnum.ATIVA;
        this.dtAbertura = LocalDate.now();
        this.saldo = 100;
        return  nroConta;
    }

    public boolean validarSenha(int senha){
        if(this.senha == senha) //==senha armazenada{
            return true;
        else
            return false;
    }

    public String sacarValor(double valor){
        if(this.saldo>= valor){
            this.saldo -= valor;
            return "Saque efetuado com sucesso";
        }
        else {
            return "Saldo não efetuado, saldo insuficiente";
        }
    }

    public void depositarValor(double valor, Long nroConta){
        if(nroConta == this.nroConta){
            this.saldo += valor;
        }
    }

    public String encerrarConta(Long nroConta){
        if(nroConta == this.nroConta){
            this.saldo = 0;
            this.situacao = SituacaoEnum.INATIVA;
            return "Conta encerrada";
        }
        return "Conta inválida";
    }
}
