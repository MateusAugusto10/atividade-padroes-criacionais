package atv2.gateway;

import atv2.sdk.pagseguro.PagSeguroApi;
import atv2.sdk.pagseguro.PagSeguroTransacao;
import com.google.inject.Inject;

import java.math.BigDecimal;


public class PagSeguroGateway implements PagamentoGateway {

    private final PagSeguroApi api;

    @Inject
    public PagSeguroGateway(PagSeguroApi api) {
        this.api = api;
    }

    @Override
    public boolean processar(BigDecimal valor, String descricao) {
        PagSeguroTransacao transacao = api.criarTransacao(valor, descricao);
        System.out.println("[PagSeguroGateway] Código: " + transacao.getCodigo()
                           + " | Status: " + transacao.getStatus());
        return transacao.isPaga();
    }

    @Override
    public String nome() { return "PagSeguro"; }
}
