package model;

/**
 * PROTOTYPE: implementa Cloneable para permitir cópias de armas
 * sem acoplar o cliente à classe concreta.
 */
public class Arma implements Cloneable {

    private String nome;
    private int    dano;
    private String tipo;

    public Arma(String nome, int dano, String tipo) {
        this.nome = nome;
        this.dano = dano;
        this.tipo = tipo;
    }

    /** Prototype – devolve uma cópia independente desta arma. */
    @Override
    public Arma clone() {
        try {
            return (Arma) super.clone(); // campos são primitivos/String: cópia rasa é suficiente
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone não suportado", e);
        }
    }

    public String getNome() { return nome; }
    public int    getDano() { return dano; }
    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return String.format("%s (dano:%d, tipo:%s)", nome, dano, tipo);
    }
}
