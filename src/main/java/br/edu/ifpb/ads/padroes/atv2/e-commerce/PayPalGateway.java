package atv2.gateway;

import atv2.sdk.paypal.PayPalClient;
import atv2.sdk.paypal.PayPalOrderResponse;
import com.google.inject.Inject;

import java.math.BigDecimal;

/**
 * Adapter que conecta o SDK do PayPal à interface PagamentoGateway.
 *
 * PagamentoService nunca enxerga PayPalClient diretamente — só vê
 * PagamentoGateway. O Guice injeta esta implementação quando configurado
 * pelo módulo PayPalModule.
 */
public class PayPalGateway implements PagamentoGateway {

    private final PayPalClient client;

    @Inject
    public PayPalGateway(PayPalClient client) {
        this.client = client;
    }

    @Override
    public boolean processar(BigDecimal valor, String descricao) {
        PayPalOrderResponse response = client.createOrder(valor, "BRL", descricao);
        System.out.println("[PayPalGateway] OrderId: " + response.getOrderId()
                           + " | Status: " + response.getStatus());
        return response.isApproved();
    }

    @Override
    public String nome() { return "PayPal"; }
}
