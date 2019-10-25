package br.com.pueyo.investimento.analise.indices.balanco;

import java.util.Optional;
import java.util.function.Function;

import br.com.pueyo.investimento.analise.indices.api.IndiceBalanco;
import br.com.pueyo.investimento.analise.modelo.balanco.BalancoPatrimonial;
import br.com.pueyo.investimento.analise.modelo.balanco.api.ItemBalanco;
import br.com.pueyo.investimento.analise.modelo.constantes.IndiceBalancoEnum;
import br.com.pueyo.investimento.analise.modelo.constantes.ItemBalancoEnum;

public class RentabilidadeSobrePatrimonioLiquido implements IndiceBalanco<BalancoPatrimonial, Double> {

    @Override
    public String nome() {
        return IndiceBalancoEnum.RENTABILIDADE_SOBRE_PATRIMONIO_LIQUIDO.name();
    }

    @Override
    public Function<BalancoPatrimonial, Double> formula() {
        return (balanco) -> {
            Optional<ItemBalanco> lucroLiquido = balanco.buscaItem(ItemBalancoEnum.LUCRO_LIQUIDO);
            Optional<ItemBalanco> patrimonioLiquido = balanco.buscaItem(ItemBalancoEnum.PATRIMONIO_LIQUIDO);
            
            if(lucroLiquido.isPresent() && patrimonioLiquido.isPresent()) {
                Double v1 = lucroLiquido.get().valorContabil();
                Double v2 = patrimonioLiquido.get().valorContabil();
                
                return (v1 / v2) * 100;
            }
            return Double.MIN_VALUE;
        };
    }

}
