package atv2;

import atv2.module.PagSeguroModule;
import atv2.module.PayPalModule;
import atv2.module.StripeModule;
import atv2.service.PagamentoService;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("  Sistema de Pagamentos — atv2");
        System.out.println("========================================");

        // ── 1. PayPal ─────────────────────────────────────────────────────────
        Injector injectorPayPal = Guice.createInjector(new PayPalModule());
        PagamentoService servicoPayPal = injectorPayPal.getInstance(PagamentoService.class);
        servicoPayPal.pagar(new BigDecimal("149.90"), "Pedido #1001 - Tênis Esportivo");

        // ── 2. Stripe ─────────────────────────────────────────────────────────
        Injector injectorStripe = Guice.createInjector(new StripeModule());
        PagamentoService servicoStripe = injectorStripe.getInstance(PagamentoService.class);
        servicoStripe.pagar(new BigDecimal("299.00"), "Pedido #1002 - Smartwatch");

        // ── 3. PagSeguro ──────────────────────────────────────────────────────
        Injector injectorPagSeguro = Guice.createInjector(new PagSeguroModule());
        PagamentoService servicoPagSeguro = injectorPagSeguro.getInstance(PagamentoService.class);
        servicoPagSeguro.pagar(new BigDecimal("59.99"), "Pedido #1003 - Livro Clean Code");

        System.out.println("\n========================================");
        System.out.println("  Todos os pagamentos processados.");
        System.out.println("========================================");
    }
}
