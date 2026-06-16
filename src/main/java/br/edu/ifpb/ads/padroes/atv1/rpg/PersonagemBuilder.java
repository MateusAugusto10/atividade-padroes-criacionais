package builder;

import model.Personagem;

/**
 * BUILDER
 * ─────────────────────────────────────────────────────────────────────────────
 * Separa a construção passo a passo de um Personagem da sua representação
 * final. Evita o "telescoping constructor" que existia no CriadorPersonagem
 * original, onde todos os 11 parâmetros precisavam ser passados de uma vez.
 */
public interface PersonagemBuilder {
    PersonagemBuilder nome(String nome);
    PersonagemBuilder raca(String raca);
    PersonagemBuilder classe(String classe);
    PersonagemBuilder atributos(int forca, int inteligencia, int agilidade,
                                int vida, int mana);
    PersonagemBuilder habilidades(String... habilidades);
    /** Aplica automaticamente arma e armadura vindas de uma FabricaEquipamento. */
    PersonagemBuilder equipamentos(abstractfactory.FabricaEquipamento fabrica);
    Personagem build();
}
