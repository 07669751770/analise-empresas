package br.com.pueyo.investimento.analise.indices.balanco;

import java.util.Optional;
import java.util.function.Function;

import br.com.pueyo.investimento.analise.indices.api.IndiceBalanco;
import br.com.pueyo.investimento.analise.modelo.balanco.BalancoPatrimonial;
import br.com.pueyo.investimento.analise.modelo.balanco.api.ItemBalanco;
import br.com.pueyo.investimento.analise.modelo.constantes.IndiceBalancoEnum;
import br.com.pueyo.investimento.analise.modelo.constantes.ItemBalancoEnum;

public class LiquidezCorrente implements IndiceBalanco<BalancoPatrimonial, Double> {

    @Override
    public String nome() {
        return IndiceBalancoEnum.LIQUIDEZ_CORRENTE.name();
    }

    @Override
    public Function<BalancoPatrimonial, Double> formula() {
        return (balanco) -> {
            Optional<ItemBalanco> ativoCirculante = balanco.buscaItem(ItemBalancoEnum.ATIVO_CIRCULANTE);
            Optional<ItemBalanco> passivoCirculante = balanco.buscaItem(ItemBalancoEnum.PASSIVO_CIRCULANTE);
            
            if(ativoCirculante.isPresent() && passivoCirculante.isPresent()) {
                Double ativoCirculanteDouble = ativoCirculante.get().valorContabil();
                Double passivoCirculanteDouble = passivoCirculante.get().valorContabil();
                return ativoCirculanteDouble / passivoCirculanteDouble;
                
            }
            return Double.MIN_VALUE;
        };
    }

}
