package abstractfactory;

import model.Arma;
import model.Armadura;

/** ABSTRACT FACTORY – equipamentos do Guerreiro Élfico. */
public class FabricaEquipamentoGuerreiroElfo implements FabricaEquipamento {
    @Override
    public Arma criarArma() {
        return new Arma("Lâmina Élfica", 22, "Espada");
    }
    @Override
    public Armadura criarArmadura() {
        return new Armadura("Cota de Malha Élfica", 15, "Média");
    }
}
