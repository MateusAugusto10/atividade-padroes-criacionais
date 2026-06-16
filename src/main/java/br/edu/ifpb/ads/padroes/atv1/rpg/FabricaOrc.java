package factory;

import abstractfactory.*;
import builder.PersonagemBuilder;
import builder.PersonagemConcreto;
import model.Personagem;

/**
 * FACTORY METHOD – fábrica concreta para a raça Orc.
 */
public class FabricaOrc extends FabricaPersonagem {

    @Override
    public Personagem criarPersonagem(String nome, String classe) {
        PersonagemBuilder builder = new PersonagemConcreto()
                .nome(nome)
                .raca("Orc")
                .classe(classe);

        switch (classe) {
            case "Guerreiro":
                return builder
                        .atributos(20, 6, 8, 150, 20)
                        .equipamentos(new FabricaEquipamentoGuerreiroOrc())
                        .habilidades("Fúria", "Pancada Devastadora")
                        .build();

            case "Mago":
                return builder
                        .atributos(10, 14, 6, 100, 120)
                        .equipamentos(new FabricaEquipamentoMagoOrc())
                        .habilidades("Magia Sombria", "Invocação")
                        .build();

            case "Arqueiro":
                return builder
                        .atributos(14, 8, 12, 120, 40)
                        .equipamentos(new FabricaEquipamentoArqueiroOrc())
                        .habilidades("Tiro Brutal", "Intimidação")
                        .build();

            default:
                throw new IllegalArgumentException("Classe inválida para Orc: " + classe);
        }
    }
}
