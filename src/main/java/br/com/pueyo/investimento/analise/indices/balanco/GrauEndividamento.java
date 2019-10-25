package br.com.pueyo.investimento.analise.indices.balanco;

import java.util.Optional;
import java.util.function.Function;

import br.com.pueyo.investimento.analise.indices.api.IndiceBalanco;
import br.com.pueyo.investimento.analise.modelo.balanco.BalancoPatrimonial;
import br.com.pueyo.investimento.analise.modelo.balanco.api.ItemBalanco;
import br.com.pueyo.investimento.analise.modelo.constantes.IndiceBalancoEnum;
import br.com.pueyo.investimento.analise.modelo.constantes.ItemBalancoEnum;

public class GrauEndividamento implements IndiceBalanco<BalancoPatrimonial, Double> {

    @Override
    public String nome() {
        return IndiceBalancoEnum.GRAU_ENDIVIDAMENTO.name();
    }

    @Override
    public Function<BalancoPatrimonial, Double> formula() {
        
        
          return (balanco) -> {
              Optional<ItemBalanco> passivoExigivelLongoPrazo = balanco.buscaItem(ItemBalancoEnum.PASSIVEL_EXIGIDO_LONGO_PRAZO);
              Optional<ItemBalanco> ativoTotal = balanco.buscaItem(ItemBalancoEnum.ATIVO_TOTAL);
              
              if(passivoExigivelLongoPrazo.isPresent() && ativoTotal.isPresent()) {
                  return passivoExigivelLongoPrazo.get().valorContabil() / ativoTotal.get().valorContabil();
              }
              return Double.MAX_VALUE;
          };
    }

}
