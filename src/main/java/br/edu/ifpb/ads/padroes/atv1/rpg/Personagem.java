package model;

import java.util.Arrays;


public class Personagem implements Cloneable {

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

    public Personagem(String nome, String raca, String classe,
                      int forca, int inteligencia, int agilidade,
                      int vida, int mana,
                      Arma arma, Armadura armadura, String[] habilidades) {
        this.nome         = nome;
        this.raca         = raca;
        this.classe       = classe;
        this.forca        = forca;
        this.inteligencia = inteligencia;
        this.agilidade    = agilidade;
        this.vida         = vida;
        this.mana         = mana;
        this.arma         = arma;
        this.armadura     = armadura;
        this.habilidades  = habilidades;
    }

    /**
     * Prototype – cópia profunda: clona também os equipamentos e o array
     * de habilidades para que cada instância seja totalmente independente.
     */
    @Override
    public Personagem clone() {
        try {
            Personagem copia = (Personagem) super.clone();
            copia.arma       = this.arma.clone();
            copia.armadura   = this.armadura.clone();
            copia.habilidades = Arrays.copyOf(this.habilidades, this.habilidades.length);
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone não suportado", e);
        }
    }

    // ── Getters ────────────────────────────────────────────────────────────────
    public String   getNome()         { return nome;         }
    public String   getRaca()         { return raca;         }
    public String   getClasse()       { return classe;       }
    public int      getForca()        { return forca;        }
    public int      getInteligencia() { return inteligencia; }
    public int      getAgilidade()    { return agilidade;    }
    public int      getVida()         { return vida;         }
    public int      getMana()         { return mana;         }
    public Arma     getArma()         { return arma;         }
    public Armadura getArmadura()     { return armadura;     }
    public String[] getHabilidades()  { return habilidades;  }

    // ── Setters mínimos (usados pelo Builder) ─────────────────────────────────
    public void setNome(String nome)              { this.nome = nome;               }
    public void setArma(Arma arma)                { this.arma = arma;               }
    public void setArmadura(Armadura armadura)    { this.armadura = armadura;       }
    public void setHabilidades(String[] hab)      { this.habilidades = hab;         }

    @Override
    public String toString() {
        return String.format(
            "%-20s | %s %s | F:%d I:%d A:%d V:%d M:%d | Arma: %s | Armadura: %s | Hab: %s",
            nome, raca, classe, forca, inteligencia, agilidade, vida, mana,
            arma, armadura, Arrays.toString(habilidades));
    }
}
