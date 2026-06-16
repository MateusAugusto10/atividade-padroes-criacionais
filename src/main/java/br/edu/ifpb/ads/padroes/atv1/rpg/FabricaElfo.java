package factory;

import abstractfactory.*;
import builder.PersonagemBuilder;
import builder.PersonagemConcreto;
import model.Personagem;

/**
 * FACTORY METHOD – fábrica concreta para a raça Elfo.
 */
public class FabricaElfo extends FabricaPersonagem {

    @Override
    public Personagem criarPersonagem(String nome, String classe) {
        PersonagemBuilder builder = new PersonagemConcreto()
                .nome(nome)
                .raca("Elfo")
                .classe(classe);

        switch (classe) {
            case "Guerreiro":
                return builder
                        .atributos(12, 14, 16, 100, 60)
                        .equipamentos(new FabricaEquipamentoGuerreiroElfo())
                        .habilidades("Dança das Lâminas", "Agilidade Élfica")
                        .build();

            case "Mago":
                return builder
                        .atributos(4, 20, 14, 70, 180)
                        .equipamentos(new FabricaEquipamentoMagoElfo())
                        .habilidades("Magia da Natureza", "Teleporte")
                        .build();

            case "Arqueiro":
                return builder
                        .atributos(8, 16, 20, 90, 100)
                        .equipamentos(new FabricaEquipamentoArqueiroElfo())
                        .habilidades("Tiro Múltiplo", "Camuflagem")
                        .build();

            default:
                throw new IllegalArgumentException("Classe inválida para Elfo: " + classe);
        }
    }
}
