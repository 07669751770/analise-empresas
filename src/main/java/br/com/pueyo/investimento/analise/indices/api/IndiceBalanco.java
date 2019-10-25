package br.com.pueyo.investimento.analise.indices.api;

import java.util.function.Function;

import br.com.pueyo.investimento.analise.modelo.balanco.BalancoPatrimonial;

public interface IndiceBalanco <T extends BalancoPatrimonial, R> {
    
    public String nome();
    public Function<T, R> formula();
    

}
