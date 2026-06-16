package abstractfactory;

import model.Arma;
import model.Armadura;

/** ABSTRACT FACTORY – equipamentos do Mago Orc (Xamã). */
public class FabricaEquipamentoMagoOrc implements FabricaEquipamento {
    @Override
    public Arma criarArma() {
        return new Arma("Cajado Tribal", 12, "Cajado");
    }
    @Override
    public Armadura criarArmadura() {
        return new Armadura("Vestes Xamânicas", 6, "Leve");
    }
}
