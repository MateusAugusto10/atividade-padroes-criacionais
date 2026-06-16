package abstractfactory;

import model.Arma;
import model.Armadura;

/** ABSTRACT FACTORY – equipamentos do Arqueiro Humano. */
public class FabricaEquipamentoArqueiroHumano implements FabricaEquipamento {
    @Override
    public Arma criarArma() {
        return new Arma("Arco Élfico", 20, "Arco");
    }
    @Override
    public Armadura criarArmadura() {
        return new Armadura("Armadura de Couro", 12, "Média");
    }
}
