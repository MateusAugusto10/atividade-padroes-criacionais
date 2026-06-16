package atv2.service;

import atv2.gateway.PagamentoGateway;
import com.google.inject.Inject;

import java.math.BigDecimal;


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
