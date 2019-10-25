package br.com.pueyo.investimento.analise.modelo.balanco;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import br.com.pueyo.investimento.analise.modelo.balanco.api.AdicionaItemAware;
import br.com.pueyo.investimento.analise.modelo.balanco.api.BuscaItemBalancoAware;
import br.com.pueyo.investimento.analise.modelo.balanco.api.ItemBalanco;
import br.com.pueyo.investimento.analise.modelo.constantes.ItemBalancoEnum;

/**
 * Classe contendo os dados do Balanço Patrimonial
 * 
 * @see Balanco
 * 
 * @author u07669751770
 *
 */
public class BalancoPatrimonial implements BuscaItemBalancoAware, AdicionaItemAware {

    private Collection<ItemBalanco> itens;

    @Override
    public Optional<ItemBalanco> buscaItem(ItemBalancoEnum item) {
        return itens.stream().filter(i -> i.tipo().equals(item)).findFirst();
    }

    @Override
    public void addItemBalanco(ItemBalanco item) {
        if(itens == null) {
            itens = new ArrayList<>();
        }
        itens.add(item);
    }
    
    

}
