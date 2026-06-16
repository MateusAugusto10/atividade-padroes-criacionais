package main;

import factory.FabricaElfo;
import factory.FabricaHumano;
import factory.FabricaOrc;
import model.Personagem;
import prototype.CatalogoPersonagens;
import singleton.RegistroPersonagens;

/**
 * Demonstração de todos os padrões criacionais aplicados.
 *
 * Fluxo:
 *  1. Factory Method  → FabricaHumano / FabricaElfo / FabricaOrc criam personagens
 *  2. Abstract Factory → cada fábrica usa FabricaEquipamento* para montar itens
 *  3. Builder          → PersonagemConcreto acumula estado passo a passo
 *  4. Singleton        → RegistroPersonagens.getInstance() centraliza o catálogo
 *  5. Prototype        → CatalogoPersonagens clona templates sem recriar tudo
 */
public class Main {

    public static void main(String[] args) {

        // ── 1. Factory Method + Abstract Factory + Builder ─────────────────────
        System.out.println("=== Factory Method + Abstract Factory + Builder ===");

        FabricaHumano fabricaHumano = new FabricaHumano();
        Personagem guerreiroHumano  = fabricaHumano.criarPersonagem("Arthur", "Guerreiro");
        Personagem magoHumano       = fabricaHumano.criarPersonagem("Merlin", "Mago");

        FabricaElfo fabricaElfo   = new FabricaElfo();
        Personagem arqueiroElfo   = fabricaElfo.criarPersonagem("Legolas", "Arqueiro");
        Personagem magoElfo       = fabricaElfo.criarPersonagem("Galadriel", "Mago");

        FabricaOrc fabricaOrc     = new FabricaOrc();
        Personagem guerreiroOrc   = fabricaOrc.criarPersonagem("Grom", "Guerreiro");

        System.out.println(guerreiroHumano);
        System.out.println(magoHumano);
        System.out.println(arqueiroElfo);
        System.out.println(magoElfo);
        System.out.println(guerreiroOrc);

        // ── 2. Factory Method hook – personagem lendário ───────────────────────
        System.out.println("\n=== Personagem Especial (Factory Method hook) ===");
        Personagem lendario = fabricaHumano.criarPersonagemEspecial("Arthur", "Guerreiro");
        System.out.println(lendario);

        // ── 3. Singleton – registro global ─────────────────────────────────────
        System.out.println("\n=== Singleton – RegistroPersonagens ===");
        RegistroPersonagens registro = RegistroPersonagens.getInstance();
        registro.registrar(guerreiroHumano);
        registro.registrar(magoHumano);
        registro.registrar(arqueiroElfo);
        registro.registrar(magoElfo);
        registro.registrar(guerreiroOrc);

        System.out.println("Total registrado: " + registro.total());

        // Verifica que getInstance() sempre retorna a mesma instância
        RegistroPersonagens outraRef = RegistroPersonagens.getInstance();
        System.out.println("Mesma instância? " + (registro == outraRef));  // true

        // ── 4. Prototype – clonagem a partir do catálogo ───────────────────────
        System.out.println("\n=== Prototype – CatalogoPersonagens ===");
        CatalogoPersonagens catalogo = new CatalogoPersonagens();

        Personagem npc1 = catalogo.clonar("Orc", "Arqueiro", "Uruk");
        Personagem npc2 = catalogo.clonar("Orc", "Arqueiro", "Grish");

        System.out.println(npc1);
        System.out.println(npc2);

        // Garante que os clones são objetos independentes
        System.out.println("Clones são objetos distintos? " + (npc1 != npc2));           // true
        System.out.println("Armas são objetos distintos?  " + (npc1.getArma() != npc2.getArma())); // true

        registro.registrar(npc1);
        registro.registrar(npc2);
        System.out.println("Total final: " + registro.total());
    }
}
