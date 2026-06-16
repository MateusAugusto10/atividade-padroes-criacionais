package abstractfactory;

import model.Arma;
import model.Armadura;

/** ABSTRACT FACTORY – equipamentos do Mago Élfico. */
public class FabricaEquipamentoMagoElfo implements FabricaEquipamento {
    @Override
    public Arma criarArma() {
        return new Arma("Cajado da Natureza", 18, "Cajado");
    }
    @Override
    public Armadura criarArmadura() {
        return new Armadura("Mantos Élficos", 10, "Leve");
    }
}
