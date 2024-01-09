package ygorgarofalo.BEU2W1D2.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalTime;
import java.util.List;

@PropertySource("application.properties")
public class Ordine extends Menu {


    private int numeroOrdine;

    private StatoOrdine statoOrdine;

    private int numeroCoperti;

    private LocalTime orarioAcquisizione;

    private double costoTotale;


    public Ordine(List<Pizza> pizzaList, List<Drink> drinkList, List<Topping> toppingList, int numeroOrdine, StatoOrdine statoOrdine, int numeroCoperti, LocalTime orarioAcquisizione) {
        super(pizzaList, drinkList, toppingList);
        this.numeroOrdine = numeroOrdine;
        this.statoOrdine = statoOrdine;
        this.numeroCoperti = numeroCoperti;
        this.orarioAcquisizione = orarioAcquisizione;
        this.costoTotale = getCostoTotale();
    }

    public int getNumeroOrdine() {
        return numeroOrdine;
    }

    public void setNumeroOrdine(int numeroOrdine) {
        this.numeroOrdine = numeroOrdine;
    }

    public StatoOrdine getStatoOrdine() {
        return statoOrdine;
    }

    public void setStatoOrdine(StatoOrdine statoOrdine) {
        this.statoOrdine = statoOrdine;
    }

    public int getNumeroCoperti() {
        return numeroCoperti;
    }

    public void setNumeroCoperti(int numeroCoperti) {
        this.numeroCoperti = numeroCoperti;
    }

    public LocalTime getOrarioAcquisizione() {
        return orarioAcquisizione;
    }

    public void setOrarioAcquisizione(LocalTime orarioAcquisizione) {
        this.orarioAcquisizione = orarioAcquisizione;
    }

    public double getCostoTotale() {
        return costoTotale;
    }

    public double setCostoTotale(@Value("$(costo_coperto)") int costoCoperto) {
        double total = this.numeroCoperti * costoCoperto;

        if (super.getPizzaList() != null && super.getDrinkList() != null && super.getToppingList() != null) {
            for (Pizza pizza : super.getPizzaList()) {
                total += pizza.getPrice();
            }
            for (Drink drink : super.getDrinkList()) {
                total += drink.getPrice();
            }
        }
        return total;

    }
}
