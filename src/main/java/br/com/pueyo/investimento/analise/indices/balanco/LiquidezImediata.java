package br.com.pueyo.investimento.analise.indices.balanco;

import java.util.Optional;
import java.util.function.Function;

import br.com.pueyo.investimento.analise.indices.api.IndiceBalanco;
import br.com.pueyo.investimento.analise.modelo.balanco.BalancoPatrimonial;
import br.com.pueyo.investimento.analise.modelo.balanco.api.ItemBalanco;
import br.com.pueyo.investimento.analise.modelo.constantes.IndiceBalancoEnum;
import br.com.pueyo.investimento.analise.modelo.constantes.ItemBalancoEnum;

public class LiquidezImediata implements IndiceBalanco<BalancoPatrimonial, Double> {

    @Override
    public String nome() {
        return IndiceBalancoEnum.LIQUIDEZ_IMEDIATA.name();
    }

    @Override
    public Function<BalancoPatrimonial, Double> formula() {
        return (balanco) -> {
            Optional<ItemBalanco> disponibilidades = balanco.buscaItem(ItemBalancoEnum.DISPONIBILIDADES);
            Optional<ItemBalanco> passivoCirculante = balanco.buscaItem(ItemBalancoEnum.PASSIVO_CIRCULANTE);
            
            if(disponibilidades.isPresent() && passivoCirculante.isPresent()) {
                Double disponibilidadesDouble = disponibilidades.get().valorContabil();
                Double passivoCirculanteDouble = passivoCirculante.get().valorContabil();
                return disponibilidadesDouble / passivoCirculanteDouble;
                
            }
            return Double.MIN_VALUE;
        };
    }

}
