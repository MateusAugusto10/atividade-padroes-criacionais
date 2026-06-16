package abstractfactory;

import model.Arma;
import model.Armadura;

/** ABSTRACT FACTORY – equipamentos do Arqueiro Orc. */
public class FabricaEquipamentoArqueiroOrc implements FabricaEquipamento {
    @Override
    public Arma criarArma() {
        return new Arma("Arco de Osso", 24, "Arco");
    }
    @Override
    public Armadura criarArmadura() {
        return new Armadura("Couro de Besta", 16, "Média");
    }
}
