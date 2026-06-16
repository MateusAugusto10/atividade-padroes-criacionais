package abstractfactory;

import model.Arma;
import model.Armadura;

/** ABSTRACT FACTORY – equipamentos do Guerreiro Orc. */
public class FabricaEquipamentoGuerreiroOrc implements FabricaEquipamento {
    @Override
    public Arma criarArma() {
        return new Arma("Machado de Guerra", 30, "Machado");
    }
    @Override
    public Armadura criarArmadura() {
        return new Armadura("Armadura Brutal", 25, "Pesada");
    }
}
