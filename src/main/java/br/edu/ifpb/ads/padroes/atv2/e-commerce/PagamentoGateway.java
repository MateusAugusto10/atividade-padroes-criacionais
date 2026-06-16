package atv2.gateway;

import java.math.BigDecimal;

/**
 * Abstração central do sistema.
 *
 * PagamentoService depende apenas desta interface — nunca de um gateway
 * concreto. Isso garante extensibilidade: novos gateways (Pix, MercadoPago)
 * só precisam implementar esta interface, sem tocar em PagamentoService.
 */
public interface PagamentoGateway {

    /**
     * Processa um pagamento.
     *
     * @param valor     valor a ser cobrado
     * @param descricao descrição do pedido
     * @return true se o pagamento foi aprovado
     */
    boolean processar(BigDecimal valor, String descricao);

    /** Nome do gateway, usado apenas para log. */
    String nome();
}
