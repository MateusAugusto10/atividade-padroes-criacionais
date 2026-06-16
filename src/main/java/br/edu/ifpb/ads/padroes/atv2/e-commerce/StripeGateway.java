package atv2.gateway;

import atv2.sdk.stripe.StripeClient;
import atv2.sdk.stripe.StripePaymentIntent;
import com.google.inject.Inject;

import java.math.BigDecimal;


public class StripeGateway implements PagamentoGateway {

    private final StripeClient client;

    @Inject
    public StripeGateway(StripeClient client) {
        this.client = client;
    }

    @Override
    public boolean processar(BigDecimal valor, String descricao) {
        StripePaymentIntent intent = client.createPaymentIntent(valor, "brl", descricao);
        System.out.println("[StripeGateway] PaymentIntent: " + intent.getId()
                           + " | Status: " + intent.getStatus());
        return intent.isSucceeded();
    }

    @Override
    public String nome() { return "Stripe"; }
}
