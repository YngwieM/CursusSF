package be.vdab.luigi.services;

import be.vdab.luigi.exceptions.KoersClientException;
import be.vdab.luigi.restclients.KoersClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
class DefaultEuroService implements EuroService {
    private final KoersClient[] koersClients;
    DefaultEuroService(KoersClient[] koersClients) {
        this.koersClients = koersClients;
    }
    @Override
    public BigDecimal naarDollar(BigDecimal euro) {
        Exception laatste = null;
        for (var client : koersClients) {
            try {
                return euro.multiply(client.getDollarKoers())
 .setScale(2, RoundingMode.HALF_UP);
            } catch (KoersClientException ex) {
                laatste = ex;
            }
        }
        throw new KoersClientException("Kan dollar koers nergens lezen.", laatste);
    }
}