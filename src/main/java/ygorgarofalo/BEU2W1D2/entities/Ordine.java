package ygorgarofalo.BEU2W1D2.entities;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;


public class Ordine {


    private int numeroOrdine;

    private StatoOrdine statoOrdine;

    private int numeroCoperti;

    private LocalTime orarioAcquisizione;

    private double costoTotale;

    private Tavolo tavolo;

    private List<Pizza> pizzaList;
    private List<Drink> drinkList;
    private List<Topping> toppingList;


    public Ordine(StatoOrdine statoOrdine, int numeroCoperti, Tavolo tavolo, LocalTime orarioAcquisizione, List<Pizza> pizzaList, List<Drink> drinkList, int prezzoPerCoperto) {
        Random rndm = new Random();
        this.numeroOrdine = rndm.nextInt(1, 100);
        this.statoOrdine = statoOrdine;
        this.tavolo = tavolo;
        this.numeroCoperti = numeroCoperti;
        this.pizzaList = pizzaList;
        this.drinkList = drinkList;
        this.orarioAcquisizione = orarioAcquisizione;
        this.costoTotale = setCostoTotale(prezzoPerCoperto);

    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public List<Topping> getToppingList() {
        return toppingList;
    }

    public void setToppingList(List<Topping> toppingList) {
        this.toppingList = toppingList;
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

    public void setCostoTotale(double costoTotale) {
        this.costoTotale = costoTotale;
    }

    public double setCostoTotale(int costoCoperto) {
        double costoPizze = 0.0;
        double costoBevande = 0.0;

        if (this.getPizzaList() != null && this.getDrinkList() != null) {
            for (Pizza pizza : this.getPizzaList()) {
                costoPizze += pizza.getPrice();
            }
            for (Drink drink : this.getDrinkList()) {
                costoBevande += drink.getPrice();
            }
        }

        costoTotale = costoCoperto * this.numeroCoperti + costoPizze + costoBevande;
        return (double) Math.round(costoTotale * 100) / 100;
    }


    public void printOrder() {

        System.out.println("Ordine numero: " + this.numeroOrdine);
        System.out.println("Tavolo N: " + this.tavolo.getNumeroTavolo());

        for (Pizza pizza : this.pizzaList) {
            System.out.println("Pizza: " + pizza.getName() + ", " + Math.round(pizza.getPrice() * 100) / 100 + " $");
        }
        for (Drink drink : this.drinkList) {
            System.out.println("Drink: " + drink.getName() + ", " + Math.round(drink.getPrice() * 100) / 100 + " $");
        }

        System.out.println("Numero coperti: " + this.numeroCoperti + " * 2$");


        System.out.println("-------STATO ORDINE-------");
        System.out.println(this.statoOrdine);
        System.out.println("Totale: " + this.costoTotale + " $");

        System.out.println("-------ARRIVEDERCI--------");
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "numeroOrdine=" + numeroOrdine +
                ", statoOrdine=" + statoOrdine +
                ", numeroCoperti=" + numeroCoperti +
                ", orarioAcquisizione=" + orarioAcquisizione +
                ", costoTotale=" + costoTotale +
                ", pizzaList=" + pizzaList +
                ", drinkList=" + drinkList +
                ", toppingList=" + toppingList +
                '}';
    }
}
