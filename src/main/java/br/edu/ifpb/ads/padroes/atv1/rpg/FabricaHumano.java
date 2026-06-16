package factory;

import abstractfactory.*;
import builder.PersonagemBuilder;
import builder.PersonagemConcreto;
import model.Arma;
import model.Armadura;
import model.Personagem;

/**
 * FACTORY METHOD – fábrica concreta responsável por criar personagens
 * da raça Humano. Conhece apenas os atributos e habilidades humanas;
 * delega a criação dos equipamentos para as Abstract Factories corretas.
 */
public class FabricaHumano extends FabricaPersonagem {

    @Override
    public Personagem criarPersonagem(String nome, String classe) {
        PersonagemBuilder builder = new PersonagemConcreto()
                .nome(nome)
                .raca("Humano")
                .classe(classe);

        switch (classe) {
            case "Guerreiro":
                return builder
                        .atributos(15, 8, 10, 120, 30)
                        .equipamentos(new FabricaEquipamentoGuerreiroHumano())
                        .habilidades("Investida", "Bloqueio")
                        .build();

            case "Mago":
                return builder
                        .atributos(6, 18, 8, 80, 150)
                        .equipamentos(new FabricaEquipamentoMagoHumano())
                        .habilidades("Bola de Fogo", "Cura")
                        .build();

            case "Arqueiro":
                return builder
                        .atributos(10, 12, 16, 100, 70)
                        .equipamentos(new FabricaEquipamentoArqueiroHumano())
                        .habilidades("Tiro Certeiro", "Chuva de Flechas")
                        .build();

            default:
                throw new IllegalArgumentException("Classe inválida para Humano: " + classe);
        }
    }

    /**
     * Factory Method hook – sobrescrito para produzir a versão lendária
     * do Guerreiro Humano (Excalibur), mantendo o contrato da superclasse.
     */
    @Override
    public Personagem criarPersonagemEspecial(String nome, String classe) {
        if ("Guerreiro".equals(classe)) {
            return new PersonagemConcreto()
                    .nome(nome + " o Lendário")
                    .raca("Humano")
                    .classe("Guerreiro")
                    .atributos(18, 10, 12, 140, 40)
                    .equipamentos(new FabricaEquipamentoGuerreiroLendario())
                    .habilidades("Investida", "Bloqueio", "Liderança")
                    .build();
        }
        return criarPersonagem(nome, classe);
    }

    // ── Fábrica interna para o equipamento lendário (escopo restrito) ─────────
    private static class FabricaEquipamentoGuerreiroLendario implements abstractfactory.FabricaEquipamento {
        @Override public Arma criarArma() {
            return new Arma("Excalibur", 35, "Espada");
        }
        @Override public Armadura criarArmadura() {
            return new Armadura("Armadura do Rei", 30, "Pesada");
        }
    }
}
