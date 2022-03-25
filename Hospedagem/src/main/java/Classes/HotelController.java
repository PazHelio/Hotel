package Classes;

import java.util.ArrayList;

public class HotelController {

    private ArrayList<Hospede> hospedes = new ArrayList<>();
    private ArrayList<Suite> suites = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();

    public void adicionarSuite(Suite suite) {
        suites.add(suite);
    }

    public ArrayList<Suite> listarSuites() {
        return suites;
    }

    public void adicionarHospede(Hospede hospede) {
        hospedes.add(hospede);
    }

    public ArrayList<Hospede> listarHospedes() {
        return hospedes;
    }

    public void adicionarReserva(ArrayList<Integer> codigoHospedes, int numeroSuite, int quantidadeDias) {
        Suite suite = localizarSuite(numeroSuite);
        if (suite == null) {
            System.out.println("Suite não encontrada");
            return;
        }

        if (!validarDisponibilidadeSuite(suite)) {
            System.out.println("Suite não disponivel");
            return;
        }
        ArrayList<Hospede> listaHospedes = localizarHospedes(codigoHospedes);
        if (listaHospedes.size() != codigoHospedes.size()) {
            System.out.println("Possui Hospede com menos de 2 Anos");
        }

        Reserva reserva = new Reserva(listaHospedes, quantidadeDias, suite);
        if (reserva.verificarCapacidade(listaHospedes)) {
            reservas.add(reserva);
            System.out.println("Reserva realizada com sucesso!");
            System.out.println("O valor da reserva ficou em: " + reserva.calcularDiaria() + " Para " + reserva.getQuantidadeDias() + " dias");
        } else {
            System.out.println("A quantidade de pessoas é maior que a capacidade da Suite.");
            System.out.println("Reserva não realizada!");
        }
    }

    private Suite localizarSuite(int numeroSuite) {
        Suite suiteLocalizada = null;
        for (Suite suiteItem : suites) {
            if (suiteItem.getNumero() == numeroSuite) {
                suiteLocalizada = suiteItem;
                break;
            }
        }
        return suiteLocalizada;
    }

    private ArrayList<Hospede> localizarHospedes(ArrayList<Integer> codigoHospedes) {
        ArrayList<Hospede> listaHospedes = new ArrayList<Hospede>();
        for (Integer codigoHospede : codigoHospedes) {
            for (Hospede hospede : hospedes) {
                if (hospede.getIdade() > 2) {
                    if (hospede.getCodigo() == codigoHospede) {
                        listaHospedes.add(hospede);
                    }
                } else {
                    continue;
                }
            }
        }
        return listaHospedes;
    }

    private boolean validarDisponibilidadeSuite(Suite suite) {
        for (Reserva reserva : reservas) {
            if (reserva.getSuite().getNumero() == suite.getNumero()) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Reserva> listarReservas() {
        return reservas;
    }

}
