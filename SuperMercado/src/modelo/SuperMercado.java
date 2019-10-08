/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Administrador
 */
public class SuperMercado {
    private Integer codigo;
    private Double valor_bolsa;
    private Integer nr_funcionarios;
    private LocalDate fundacao;
    private String razao_social;
    private String nome_fantasia;

    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Double getValor_bolsa() {
        return valor_bolsa;
    }

    public void setValor_bolsa(Double valor_bolsa) {
        this.valor_bolsa = valor_bolsa;
    }

    public Integer getNr_funcionarios() {
        return nr_funcionarios;
    }

    public void setNr_funcionarios(Integer nr_funcionarios) {
        this.nr_funcionarios = nr_funcionarios;
    }

    public LocalDate getFundacao() {
        return fundacao;
    }

    public void setFundacao(LocalDate fundacao) {
        this.fundacao = fundacao;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    @Override
    public String toString() {
        return nome_fantasia;
    }
}
