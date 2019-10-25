package br.com.pueyo.investimento.analise.indices.balanco;

import java.util.Optional;
import java.util.function.Function;

import br.com.pueyo.investimento.analise.indices.api.IndiceBalanco;
import br.com.pueyo.investimento.analise.modelo.balanco.BalancoPatrimonial;
import br.com.pueyo.investimento.analise.modelo.balanco.api.ItemBalanco;
import br.com.pueyo.investimento.analise.modelo.constantes.IndiceBalancoEnum;
import br.com.pueyo.investimento.analise.modelo.constantes.ItemBalancoEnum;

public class ValorPatrimonialPorAcao implements IndiceBalanco<BalancoPatrimonial, Double> {

    @Override
    public String nome() {
        return IndiceBalancoEnum.VALOR_PATRIMONIAL_POR_ACAO.name();
    }

    @Override
    public Function<BalancoPatrimonial, Double> formula() {
        return (balanco) -> {
            Optional<ItemBalanco> patrocinioLiquido = balanco.buscaItem(ItemBalancoEnum.PATRIMONIO_LIQUIDO);
            Optional<ItemBalanco> numeroDeAcoes = balanco.buscaItem(ItemBalancoEnum.NUMERO_DE_ACOES);
            
            if(patrocinioLiquido.isPresent() && numeroDeAcoes.isPresent()) {
                Double patrocinioLiquidoDouble = patrocinioLiquido.get().valorContabil();
                Double numeroDeAcoesDouble = numeroDeAcoes.get().valorContabil();
                return patrocinioLiquidoDouble / numeroDeAcoesDouble;
                
            }
            return Double.MIN_VALUE;
        };
    }

}
