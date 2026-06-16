package prototype;

import factory.FabricaElfo;
import factory.FabricaHumano;
import factory.FabricaOrc;
import model.Personagem;

import java.util.HashMap;
import java.util.Map;

/**
 * PROTOTYPE
 * ─────────────────────────────────────────────────────────────────────────────
 * Mantém um catálogo de personagens-template pré-construídos (protótipos).
 * Quando o cliente precisar de um novo personagem de determinada raça/classe,
 * basta clonar o protótipo e alterar apenas o nome — sem reconstruir todos
 * os atributos do zero.
 *
 * Por que Prototype aqui?
 * Se o jogo precisar criar dezenas de NPCs com a mesma raça/classe, re-
 * executar toda a lógica das fábricas a cada vez é custoso e repetitivo.
 * Com o catálogo de protótipos, o custo de "configuração" paga-se apenas
 * uma vez; as cópias são baratas.
 */
public class CatalogoPersonagens {

    private final Map<String, Personagem> prototipos = new HashMap<>();

    public CatalogoPersonagens() {
        inicializarPrototipos();
    }

    /** Pré-constrói um protótipo para cada combinação raça/classe disponível. */
    private void inicializarPrototipos() {
        FabricaHumano humano = new FabricaHumano();
        FabricaElfo   elfo   = new FabricaElfo();
        FabricaOrc    orc    = new FabricaOrc();

        for (String classe : new String[]{"Guerreiro", "Mago", "Arqueiro"}) {
            registrar(humano.criarPersonagem("TEMPLATE", classe));
            registrar(elfo.criarPersonagem("TEMPLATE", classe));
            registrar(orc.criarPersonagem("TEMPLATE", classe));
        }
    }

    private void registrar(Personagem p) {
        String chave = chave(p.getRaca(), p.getClasse());
        prototipos.put(chave, p);
    }

    /**
     * Clona o protótipo correspondente e atribui o nome fornecido.
     * Retorna uma instância completamente independente.
     */
    public Personagem clonar(String raca, String classe, String nome) {
        String chave = chave(raca, classe);
        Personagem proto = prototipos.get(chave);
        if (proto == null) {
            throw new IllegalArgumentException(
                "Protótipo não encontrado para: " + raca + " " + classe);
        }
        Personagem copia = proto.clone();   // Prototype em ação
        copia.setNome(nome);
        return copia;
    }

    private String chave(String raca, String classe) {
        return raca + "_" + classe;
    }
}
