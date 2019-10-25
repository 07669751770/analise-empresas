package br.com.pueyo.investimento.analise.indices.balanco;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.pueyo.investimento.analise.modelo.balanco.BalancoPatrimonial;
import br.com.pueyo.investimento.analise.modelo.balanco.api.ItemBalanco;
import br.com.pueyo.investimento.analise.modelo.constantes.IndiceBalancoEnum;
import br.com.pueyo.investimento.analise.modelo.constantes.ItemBalancoEnum;

public class ValorPatrimonialPorAcaoTest {

    private static ValorPatrimonialPorAcao classUnderTest;

    @BeforeClass
    public static void setUp() {
        classUnderTest = new ValorPatrimonialPorAcao();
    }

    @Test
    public void testNome() {
        assertTrue(classUnderTest.nome().equals(IndiceBalancoEnum.VALOR_PATRIMONIAL_POR_ACAO.name()));
    }

    @Test
    public void testFormula() {
        BalancoPatrimonial bp = new BalancoPatrimonial();
        bp.addItemBalanco(new ItemBalanco() {

            @Override
            public Double valorContabil() {

                return 1198681944.00;
            }

            @Override
            public ItemBalancoEnum tipo() {
                return ItemBalancoEnum.PATRIMONIO_LIQUIDO;
            }

            @Override
            public String descricao() {
                // TODO Auto-generated method stub
                return null;
            }
        });
        bp.addItemBalanco(new ItemBalanco() {

            @Override
            public Double valorContabil() {

                return 140965000.00;
            }

            @Override
            public ItemBalancoEnum tipo() {
                return ItemBalancoEnum.NUMERO_DE_ACOES;
            }

            @Override
            public String descricao() {
                // TODO Auto-generated method stub
                return null;
            }
        });

        System.out.println(classUnderTest.formula().apply(bp));
    }

}
