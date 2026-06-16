package atv2.service;

import atv2.gateway.PagamentoGateway;
import com.google.inject.Inject;

import java.math.BigDecimal;

/**
 * Serviço de pagamento.
 *
 * Depende APENAS da interface PagamentoGateway — nunca de PayPal, Stripe
 * ou PagSeguro diretamente. O Google Guice injeta a implementação correta
 * de acordo com o módulo configurado na Main.
 *
 * Para adicionar um novo gateway (ex.: Pix), basta:
 *  1. Criar PixGateway implements PagamentoGateway
 *  2. Criar PixModule que faz a ligação no Guice
 * Esta classe não precisa ser modificada — Open/Closed em prática.
 */
public class PagamentoService {

    private final PagamentoGateway gateway;

    @Inject
    public PagamentoService(PagamentoGateway gateway) {
        this.gateway = gateway;
    }

    /**
     * Processa um pagamento usando o gateway injetado.
     *
     * @param valor     valor a cobrar
     * @param descricao descrição do pedido
     */
    public void pagar(BigDecimal valor, String descricao) {
        System.out.println("\n>>> Iniciando pagamento via " + gateway.nome());
        System.out.println("    Valor: R$ " + valor + " | Pedido: " + descricao);

        boolean aprovado = gateway.processar(valor, descricao);

        if (aprovado) {
            System.out.println(">>> Pagamento APROVADO via " + gateway.nome());
        } else {
            System.out.println(">>> Pagamento RECUSADO via " + gateway.nome());
        }
    }
}
