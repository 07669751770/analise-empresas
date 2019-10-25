package br.com.pueyo.investimento.analise.indices.balanco;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.pueyo.investimento.analise.modelo.balanco.BalancoPatrimonial;
import br.com.pueyo.investimento.analise.modelo.balanco.api.ItemBalanco;
import br.com.pueyo.investimento.analise.modelo.constantes.IndiceBalancoEnum;
import br.com.pueyo.investimento.analise.modelo.constantes.ItemBalancoEnum;

public class RentabilidadeSobrePatrimonioLiquidoTest {

private static RentabilidadeSobrePatrimonioLiquido classUnderTest;
    
    @BeforeClass
    public static void setUp() {
        classUnderTest = new RentabilidadeSobrePatrimonioLiquido();
    }

    @Test
    public void testNome() {
        assertTrue(classUnderTest.nome().equals(IndiceBalancoEnum.RENTABILIDADE_SOBRE_PATRIMONIO_LIQUIDO.name()));
    }

    @Test
    public void testFormula() {
        BalancoPatrimonial bp = new BalancoPatrimonial();
        bp.addItemBalanco(new ItemBalanco() {
            
            @Override
            public Double valorContabil() {
                
                return 1198680000.00;
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
                
                return 240922000.00;
            }
            
            @Override
            public ItemBalancoEnum tipo() {
                return ItemBalancoEnum.LUCRO_LIQUIDO;
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
