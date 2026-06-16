package abstractfactory;

import model.Arma;
import model.Armadura;

/** ABSTRACT FACTORY – equipamentos do Guerreiro Humano. */
public class FabricaEquipamentoGuerreiroHumano implements FabricaEquipamento {
    @Override
    public Arma criarArma() {
        return new Arma("Espada de Ferro", 25, "Espada");
    }
    @Override
    public Armadura criarArmadura() {
        return new Armadura("Armadura de Placas", 20, "Pesada");
    }
}
