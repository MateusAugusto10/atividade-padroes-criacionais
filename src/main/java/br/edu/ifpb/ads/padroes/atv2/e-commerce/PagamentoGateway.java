package atv2.gateway;

import java.math.BigDecimal;


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
