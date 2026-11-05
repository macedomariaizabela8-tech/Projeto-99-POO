package com.app99.model;

import com.app99.interfaces.Atendivel;

public class Motorista extends Usuario implements Atendivel {
    private String cnh;
    private String placaVeiculo;
    private String modeloVeiculo;
    private boolean disponivel;

    public Motorista(String id, String nome, String email, String telefone, String cnh, String placaVeiculo, String modeloVeiculo) {
        super(id, nome, email, telefone);
        this.cnh = cnh;
        this.placaVeiculo = placaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.disponivel = true;
    }

    @Override
    public boolean aceitarSolicitacao(String idSolicitacao) {
        if (disponivel) {
            this.disponivel = false;
            System.out.println("Motorista " + getNome() + " aceitou a corrida " + idSolicitacao);
            return true;
        }
        return false;
    }

    @Override
    public boolean concluirAtendimento(String idSolicitacao) {
        this.disponivel = true;
        System.out.println("Motorista " + getNome() + " concluiu a corrida " + idSolicitacao);
        return true;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}