package builder;

import abstractfactory.FabricaEquipamento;
import model.Arma;
import model.Armadura;
import model.Personagem;

/**
 * BUILDER – implementação concreta que acumula estado e entrega um
 * Personagem completo no método build().
 *
 * O método equipamentos() integra o ABSTRACT FACTORY: delega a criação
 * dos itens para a fábrica correta, sem precisar conhecer os tipos concretos.
 */
public class PersonagemConcreto implements PersonagemBuilder {

    private String   nome;
    private String   raca;
    private String   classe;
    private int      forca;
    private int      inteligencia;
    private int      agilidade;
    private int      vida;
    private int      mana;
    private Arma     arma;
    private Armadura armadura;
    private String[] habilidades;

    @Override
    public PersonagemBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public PersonagemBuilder raca(String raca) {
        this.raca = raca;
        return this;
    }

    @Override
    public PersonagemBuilder classe(String classe) {
        this.classe = classe;
        return this;
    }

    @Override
    public PersonagemBuilder atributos(int forca, int inteligencia, int agilidade,
                                       int vida, int mana) {
        this.forca        = forca;
        this.inteligencia = inteligencia;
        this.agilidade    = agilidade;
        this.vida         = vida;
        this.mana         = mana;
        return this;
    }

    @Override
    public PersonagemBuilder habilidades(String... habilidades) {
        this.habilidades = habilidades;
        return this;
    }

    /** Delega a criação dos equipamentos à Abstract Factory recebida. */
    @Override
    public PersonagemBuilder equipamentos(FabricaEquipamento fabrica) {
        this.arma     = fabrica.criarArma();
        this.armadura = fabrica.criarArmadura();
        return this;
    }

    @Override
    public Personagem build() {
        if (nome == null || raca == null || classe == null) {
            throw new IllegalStateException("nome, raça e classe são obrigatórios.");
        }
        return new Personagem(nome, raca, classe, forca, inteligencia,
                              agilidade, vida, mana, arma, armadura, habilidades);
    }
}
