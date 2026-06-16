package abstractfactory;

import model.Arma;
import model.Armadura;

/** ABSTRACT FACTORY – equipamentos do Arqueiro Élfico. */
public class FabricaEquipamentoArqueiroElfo implements FabricaEquipamento {
    @Override
    public Arma criarArma() {
        return new Arma("Arco Longo Élfico", 28, "Arco");
    }
    @Override
    public Armadura criarArmadura() {
        return new Armadura("Armadura de Couro Élfico", 14, "Média");
    }
}
