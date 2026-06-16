package atv2.sdk.pagseguro;

import java.math.BigDecimal;


public class PagSeguroApi {

    private final String token;
    private final String email;

    public PagSeguroApi(String email, String token) {
        this.email = email;
        this.token = token;
        System.out.println("[PagSeguro SDK] API inicializada. Email: " + email);
    }

    /**
     * Simula a criação de uma transação no PagSeguro.
     * Em produção chamaria ws.pagseguro.uol.com.br/v2/transactions
     */
    public PagSeguroTransacao criarTransacao(BigDecimal valor, String descricao) {
        System.out.println("[PagSeguro SDK] POST /v2/transactions");
        System.out.println("[PagSeguro SDK] valor=R$" + valor + " descricao=" + descricao);

        return new PagSeguroTransacao(
            "TXN-" + System.currentTimeMillis(),
            3   // código 3 = PAGA no PagSeguro
        );
    }
}
