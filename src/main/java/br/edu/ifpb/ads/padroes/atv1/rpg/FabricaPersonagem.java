package factory;

import model.Personagem;

/**
 * FACTORY METHOD
 * ─────────────────────────────────────────────────────────────────────────────
 * Define o método-fábrica criarPersonagem() que subclasses concretas (uma
 * por raça) devem implementar. O código comum de log/validação fica aqui,
 * enquanto os detalhes de cada raça ficam encapsulados nas subclasses.
 *
 * No original, toda essa lógica estava espremida num único método estático
 * com cadeias de if/else aninhados — inviável de estender sem alterar o código.
 */
public abstract class FabricaPersonagem {

    /**
     * Factory Method – cada subclasse define como criar o personagem
     * para a sua raça e a classe passada como parâmetro.
     */
    public abstract Personagem criarPersonagem(String nome, String classe);

    /** Hook: subclasses podem sobrescrever para criar versões especiais/lendárias. */
    public Personagem criarPersonagemEspecial(String nome, String classe) {
        // comportamento padrão: retorna o personagem normal
        return criarPersonagem(nome, classe);
    }
}
