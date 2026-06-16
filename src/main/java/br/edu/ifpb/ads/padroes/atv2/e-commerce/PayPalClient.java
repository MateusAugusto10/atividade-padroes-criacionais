package atv2.sdk.paypal;

import java.math.BigDecimal;


public class PayPalClient {

    private final String clientId;
    private final String clientSecret;

    public PayPalClient(String clientId, String clientSecret) {
        this.clientId     = clientId;
        this.clientSecret = clientSecret;
        System.out.println("[PayPal SDK] Client inicializado. ClientId: " + clientId);
    }

    /**
     * Simula a chamada real à API de criação de ordem do PayPal.
     * Em produção isso faria uma chamada HTTP para api.paypal.com/v2/checkout/orders
     */
    public PayPalOrderResponse createOrder(BigDecimal amount, String currency, String description) {
        System.out.println("[PayPal SDK] POST /v2/checkout/orders");
        System.out.println("[PayPal SDK] amount=" + amount + " currency=" + currency);

        // Mock: sempre aprova
        return new PayPalOrderResponse("PAY-" + System.currentTimeMillis(), "COMPLETED");
    }
}
