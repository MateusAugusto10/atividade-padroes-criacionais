package atv2.module;

import atv2.gateway.PagamentoGateway;
import atv2.gateway.PagSeguroGateway;
import atv2.sdk.pagseguro.PagSeguroApi;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

/**
 * Módulo Guice que configura o PagamentoService para usar PagSeguro.
 */
public class PagSeguroModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PagamentoGateway.class).to(PagSeguroGateway.class);
    }

    @Provides
    @Singleton
    PagSeguroApi providePagSeguroApi() {
        return new PagSeguroApi("loja@exemplo.com.br", "token-pagseguro-abc");
    }
}
