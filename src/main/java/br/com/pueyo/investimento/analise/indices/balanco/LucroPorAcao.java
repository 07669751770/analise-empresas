package br.com.pueyo.investimento.analise.indices.balanco;

import java.util.Optional;
import java.util.function.Function;

import br.com.pueyo.investimento.analise.indices.api.IndiceBalanco;
import br.com.pueyo.investimento.analise.modelo.balanco.BalancoPatrimonial;
import br.com.pueyo.investimento.analise.modelo.balanco.api.ItemBalanco;
import br.com.pueyo.investimento.analise.modelo.constantes.IndiceBalancoEnum;
import br.com.pueyo.investimento.analise.modelo.constantes.ItemBalancoEnum;

public class LucroPorAcao implements IndiceBalanco<BalancoPatrimonial, Double> {

    @Override
    public String nome() {
        return IndiceBalancoEnum.LUCRO_POR_ACAO.name();
    }

    @Override
    public Function<BalancoPatrimonial, Double> formula() {
        return (balanco) -> {
            Optional<ItemBalanco> lucroLiquido = balanco.buscaItem(ItemBalancoEnum.LUCRO_LIQUIDO);
            Optional<ItemBalanco> numeroDeAcoes = balanco.buscaItem(ItemBalancoEnum.NUMERO_DE_ACOES);
            
            if(lucroLiquido.isPresent() && numeroDeAcoes.isPresent()) {
                Double lucroLiquidoDouble = lucroLiquido.get().valorContabil();
                Double numeroDeAcoesDouble = numeroDeAcoes.get().valorContabil();
                return lucroLiquidoDouble / numeroDeAcoesDouble;
                
            }
            return Double.MIN_VALUE;
        };
    }

}
