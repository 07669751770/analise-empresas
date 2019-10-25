package br.com.pueyo.investimento.analise.modelo.balanco.api;

import java.util.Optional;

import br.com.pueyo.investimento.analise.modelo.constantes.ItemBalancoEnum;

public interface BuscaItemBalancoAware {

    public Optional<ItemBalanco> buscaItem(ItemBalancoEnum item);
    
}
