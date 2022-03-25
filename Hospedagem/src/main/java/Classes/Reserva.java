package Classes;

import java.util.ArrayList;
import Classes.Suite;

public class Reserva {

    private ArrayList<Hospede> hospedes;
    private int quantidadePessoas;
    private int quantidadeDias;
    private Suite suite;

    public Reserva(ArrayList<Hospede> hospedes, int quantidadeDias, Suite suite) {
        this.hospedes = hospedes;
        this.quantidadeDias = quantidadeDias;
        this.suite = suite;
    }

    public int getQuantidadePessoas() {
        quantidadePessoas = 0;
        for (Hospede hospede : hospedes) {
            if (hospede.getIdade() > 2) {
                quantidadePessoas++;
            }
        }
        return quantidadePessoas;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public ArrayList<Hospede> getHospedes() {
        return hospedes;
    }

    public void setHospedes(ArrayList<Hospede> hospedes) {
        this.hospedes = hospedes;
    }

    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    public boolean verificarCapacidade(ArrayList<Hospede> listaHospedes) {
        if (suite.getCapacidade() >= listaHospedes.size()) {
            return true;
        }
        return false;
    }

    public double calcularDiaria() {
        double valorDiaria = suite.getValorDiaria() * quantidadeDias;
        if (quantidadeDias > 7) {
            valorDiaria = valorDiaria - (valorDiaria * 10 / 100);
        }
        return valorDiaria;
    }
}
