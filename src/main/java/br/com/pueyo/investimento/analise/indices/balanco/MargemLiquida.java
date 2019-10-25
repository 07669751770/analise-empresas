package br.com.pueyo.investimento.analise.indices.balanco;

import java.util.Optional;
import java.util.function.Function;

import br.com.pueyo.investimento.analise.indices.api.IndiceBalanco;
import br.com.pueyo.investimento.analise.modelo.balanco.BalancoPatrimonial;
import br.com.pueyo.investimento.analise.modelo.balanco.api.ItemBalanco;
import br.com.pueyo.investimento.analise.modelo.constantes.IndiceBalancoEnum;
import br.com.pueyo.investimento.analise.modelo.constantes.ItemBalancoEnum;

public class MargemLiquida implements IndiceBalanco<BalancoPatrimonial, Double> {

    @Override
    public String nome() {
        return IndiceBalancoEnum.MARGEM_LIQUIDA.name();
    }

    @Override
    public Function<BalancoPatrimonial, Double> formula() {
        return (balanco) -> {
            Optional<ItemBalanco> lucroLiquido = balanco.buscaItem(ItemBalancoEnum.LUCRO_LIQUIDO);
            Optional<ItemBalanco> vendasLiquidas = balanco.buscaItem(ItemBalancoEnum.VENDAS_LIQUIDAS);
            
            if(lucroLiquido.isPresent() && vendasLiquidas.isPresent()) {
                Double v1 = lucroLiquido.get().valorContabil();
                Double v2 = vendasLiquidas.get().valorContabil();
                
                return (v1 / v2) * 100;
            }
            return Double.MIN_VALUE;
        };
    }

}
