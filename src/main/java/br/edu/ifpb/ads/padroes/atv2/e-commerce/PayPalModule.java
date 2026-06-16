package atv2.module;

import atv2.gateway.PagamentoGateway;
import atv2.gateway.PayPalGateway;
import atv2.sdk.paypal.PayPalClient;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;


public class PayPalModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PagamentoGateway.class).to(PayPalGateway.class);
    }

    @Provides
    @Singleton
    PayPalClient providePayPalClient() {
        // Em produção, viria de variáveis de ambiente ou cofre de segredos
        return new PayPalClient("client-id-paypal-123", "client-secret-paypal-456");
    }
}
