package br.com.pueyo.investimento.analise.modelo.balanco.api;

import br.com.pueyo.investimento.analise.modelo.constantes.ItemBalancoEnum;

public interface ItemBalanco {
    
    public ItemBalancoEnum tipo();
    public String descricao();
    public Double valorContabil();

}
