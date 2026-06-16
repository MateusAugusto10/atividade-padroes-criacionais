package atv2.module;

import atv2.gateway.PagamentoGateway;
import atv2.gateway.StripeGateway;
import atv2.sdk.stripe.StripeClient;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

/**
 * Módulo Guice que configura o PagamentoService para usar Stripe.
 */
public class StripeModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PagamentoGateway.class).to(StripeGateway.class);
    }

    @Provides
    @Singleton
    StripeClient provideStripeClient() {
        return new StripeClient("sk_test_stripe_key_789");
    }
}
