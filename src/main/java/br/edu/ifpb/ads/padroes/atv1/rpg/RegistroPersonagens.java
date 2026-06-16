package singleton;

import model.Personagem;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * SINGLETON
 * ─────────────────────────────────────────────────────────────────────────────
 * Registro central que mantém todos os personagens criados durante a sessão.
 * Deve existir UMA única instância no processo inteiro — garantida pelo
 * padrão Singleton com inicialização "lazy" e thread-safe (holder idiom).
 *
 * Por que Singleton aqui?
 * O código original não tinha nenhum controle de instâncias; múltiplos
 * CriadorPersonagem podiam criar registros duplicados sem nenhuma
 * consistência global. O RegistroPersonagens resolve isso.
 */
public class RegistroPersonagens {

    // ── Holder idiom: inicialização lazy e thread-safe sem synchronized ────────
    private static class Holder {
        static final RegistroPersonagens INSTANCIA = new RegistroPersonagens();
    }

    private final Map<String, Personagem> repositorio = new LinkedHashMap<>();

    /** Construtor privado — impede instanciação externa. */
    private RegistroPersonagens() {}

    /** Ponto de acesso global à única instância. */
    public static RegistroPersonagens getInstance() {
        return Holder.INSTANCIA;
    }

    // ── Operações do registro ──────────────────────────────────────────────────

    /**
     * Registra um personagem. Lança exceção se já existir um com o mesmo nome.
     */
    public void registrar(Personagem p) {
        if (repositorio.containsKey(p.getNome())) {
            throw new IllegalArgumentException(
                "Já existe um personagem com o nome: " + p.getNome());
        }
        repositorio.put(p.getNome(), p);
        System.out.println("[Registro] Personagem registrado: " + p.getNome());
    }

    public Personagem buscar(String nome) {
        return repositorio.get(nome);
    }

    public void remover(String nome) {
        repositorio.remove(nome);
    }

    public Map<String, Personagem> listarTodos() {
        return Collections.unmodifiableMap(repositorio);
    }

    public int total() {
        return repositorio.size();
    }
}
