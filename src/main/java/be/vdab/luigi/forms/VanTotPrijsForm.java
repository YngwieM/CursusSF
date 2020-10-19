package be.vdab.luigi.forms;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
public class VanTotPrijsForm {
    @NotNull @PositiveOrZero
    private final BigDecimal van;
    @NotNull @PositiveOrZero
    private final BigDecimal tot;

    public BigDecimal getVan() {
        return van;
    }

    public BigDecimal getTot() {
        return tot;
    }

    public VanTotPrijsForm(BigDecimal van, BigDecimal tot) {
        this.van = van;
        this.tot = tot;
    }



}