package abstractfactory;

import model.Arma;
import model.Armadura;

/**
 * ABSTRACT FACTORY
 * ─────────────────────────────────────────────────────────────────────────────
 * Define a interface para criar a "família" de equipamentos de uma classe
 * (Arma + Armadura). As implementações concretas garantem que os produtos
 * criados são sempre compatíveis entre si.
 *
 * Sem esse padrão seria necessário um bloco if/else gigante para escolher
 * arma e armadura, espalhando a responsabilidade por todo o sistema.
 */
public interface FabricaEquipamento {
    Arma     criarArma();
    Armadura criarArmadura();
}
