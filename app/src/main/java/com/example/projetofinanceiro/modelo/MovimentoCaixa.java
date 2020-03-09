package com.example.projetofinanceiro.modelo;

public class MovimentoCaixa {

    private int id;
    private Caixa caixa;
    private String conta;
    private String operacao;
    private String historico;
    private String valor;
    private int usuario;
    private String doc;


    public MovimentoCaixa() {
        this.caixa = new Caixa();
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Caixa getCaixa() {
        return caixa;
    }
    public void setCaixa(Caixa caixa ) {
        this.caixa = caixa;
    }
    public String getConta() {
        return conta;
    }
    public void setConta(String conta) { this.conta = conta;   }
    public String getOperacao() {
        return operacao;
    }
    public void setOperacao(String operacao) {
        this.operacao = ( operacao ).substring(0,1);
    }
    public String getHistorico() {
        return historico;
    }
    public void setHistorico(String historico) {
        this.historico = historico;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public int getUsuario() {
        return usuario;
    }
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    public String getDoc() {
        return doc;
    }
    public void setDoc(String doc) {
        this.doc = doc;
    }





}
