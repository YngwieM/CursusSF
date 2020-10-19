package be.vdab.luigi.services;

import be.vdab.luigi.domain.Pizza;
import be.vdab.luigi.repositories.PizzaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
class DefaultPizzaService implements PizzaService {
    private final PizzaRepository pizzaRepository;
    DefaultPizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    @Override
    public long create(Pizza pizza) {
        return pizzaRepository.create(pizza);
    }
    @Override
    public void update(Pizza pizza) {
        pizzaRepository.update(pizza);
    }
    @Override
    public void delete(long id) {
        pizzaRepository.delete(id);
    }
    @Transactional(readOnly = true)
    @Override
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Pizza> findById(long id) {
        return pizzaRepository.findById(id);
    }
    @Transactional(readOnly = true)
    @Override
    public List<Pizza> findByPrijsBetween(BigDecimal van, BigDecimal tot) {
        return pizzaRepository.findByPrijsBetween(van, tot);
    }
    @Transactional(readOnly = true)
    @Override
    public long findAantal() {
        return pizzaRepository.findAantal();
    }
    @Transactional(readOnly = true)
    @Override
    public List<BigDecimal> findUniekePrijzen() {
        return pizzaRepository.findUniekePrijzen();
    }
    @Transactional(readOnly = true)
    @Override
    public List<Pizza> findByPrijs(BigDecimal prijs) {
        return pizzaRepository.findByPrijs(prijs);
    }
    @Transactional(readOnly = true)
    @Override
    public List<Pizza> findByIds(Set<Long> ids) {
        return pizzaRepository.findByIds(ids);
    }
}