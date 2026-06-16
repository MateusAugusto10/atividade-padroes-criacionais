package abstractfactory;

import model.Arma;
import model.Armadura;

/** ABSTRACT FACTORY – equipamentos do Mago Humano. */
public class FabricaEquipamentoMagoHumano implements FabricaEquipamento {
    @Override
    public Arma criarArma() {
        return new Arma("Cajado Mágico", 15, "Cajado");
    }
    @Override
    public Armadura criarArmadura() {
        return new Armadura("Vestes Mágicas", 8, "Leve");
    }
}
