package ygorgarofalo.BEU2W1D2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@ToString
public class Tavolo {

    private int numeroTavolo;

    private int numeroCoperti;

    private StatoTavolo statoTavolo;


    public Tavolo(int numeroCoperti, StatoTavolo statoTavolo) {
        Random rndm = new Random();

        this.numeroTavolo = rndm.nextInt(1, 30);
        this.numeroCoperti = numeroCoperti;
        this.statoTavolo = statoTavolo;
    }


}
