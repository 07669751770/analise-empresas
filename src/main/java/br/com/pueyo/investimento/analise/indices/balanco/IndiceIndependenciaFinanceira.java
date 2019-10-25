package br.com.pueyo.investimento.analise.indices.balanco;

import java.util.Optional;
import java.util.function.Function;

import br.com.pueyo.investimento.analise.indices.api.IndiceBalanco;
import br.com.pueyo.investimento.analise.modelo.balanco.BalancoPatrimonial;
import br.com.pueyo.investimento.analise.modelo.balanco.api.ItemBalanco;
import br.com.pueyo.investimento.analise.modelo.constantes.IndiceBalancoEnum;
import br.com.pueyo.investimento.analise.modelo.constantes.ItemBalancoEnum;

public class IndiceIndependenciaFinanceira implements IndiceBalanco<BalancoPatrimonial, Double> {

    @Override
    public String nome() {
        return IndiceBalancoEnum.INDICE_INDEPENDENCIA_FINANCEIRA.name();
    }

    @Override
    public Function<BalancoPatrimonial, Double> formula() {
        return (balanco) -> {
            Optional<ItemBalanco> patrimonioLiquido = balanco.buscaItem(ItemBalancoEnum.PATRIMONIO_LIQUIDO);
            Optional<ItemBalanco> ativoTotal = balanco.buscaItem(ItemBalancoEnum.ATIVO_TOTAL);
            
            if(patrimonioLiquido.isPresent() && ativoTotal.isPresent()) {
                Double patrimonioLiquidoValor = patrimonioLiquido.get().valorContabil();
                Double ativoTotalValor = ativoTotal.get().valorContabil();
                
                return (patrimonioLiquidoValor / ativoTotalValor) * 100;
            }
            return Double.MIN_VALUE;
        };
    }

}
