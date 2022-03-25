package Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static HotelController controller;

    Main(HotelController _controller) {
        controller = _controller;
    }

    public static void main(String args[]) {
        controller = new HotelController();
        prepararSuites();
        prepararHospedes();
        reservaComSucesso();
        prepararReservaComMaisHospedes();
        prepararReservaComDescontoDias();
    }

    public static void prepararSuites() {

        Suite suite = new Suite(1, "Simples", 4, 150.00);
        controller.adicionarSuite(suite);

        Suite suite2 = new Suite(2, "Master", 5, 300.00);
        controller.adicionarSuite(suite2);

        Suite suite3 = new Suite(3, "Cobertura", 6, 500.00);
        controller.adicionarSuite(suite2);

        System.out.println("Suites Cadastradas: ");

        for (Suite i : controller.listarSuites()) {
            System.out.println("Suite Numero " + i.getNumero() + " Do Tipo " + i.getTipo() + " Com capacidade de " + i.getCapacidade() + " Pessoas " + "No valor de " + i.getValorDiaria());
        }

    }

    public static void prepararHospedes() {

        Hospede hospede = new Hospede(1, "Helio", "Rua Frei Livio Panizza, 661", 26);
        controller.adicionarHospede(hospede);

        Hospede hospede2 = new Hospede(2, "Luiz", "Rua Maria Woman Wisnieski, 528", 30);
        controller.adicionarHospede(hospede2);

        Hospede hospede3 = new Hospede(3, "Wesley", "Rua Augusta, 324", 28);
        controller.adicionarHospede(hospede3);

        Hospede hospede4 = new Hospede(4, "Heitor", "Rua São Joao, 77", 1);
        controller.adicionarHospede(hospede4);

        Hospede hospede5 = new Hospede(5, "Vinicius", "Rua Marcelino, 65", 22);
        controller.adicionarHospede(hospede5);

        Hospede hospede6 = new Hospede(6, "Tania", "Rua Fazendinha, 468", 35);
        controller.adicionarHospede(hospede6);

        Hospede hospede7 = new Hospede(7, "Jefferson", "Rua Campo Comprido, 111", 42);
        controller.adicionarHospede(hospede7);

        Hospede hospede8 = new Hospede(8, "Caroline", "Rua Pinheirinho, 555", 2);
        controller.adicionarHospede(hospede8);

        System.out.println("Hospedes Cadastrados: ");

        for (Hospede i : controller.listarHospedes()) {
            System.out.println("Hospede " + i.getCodigo() + ", Nome " + i.getNome() + " Residente no endereço " + i.getEndereco() + " e Idade " + i.getIdade());
        }
    }

    //TESTES PARA RESERVA
    public static void reservaComSucesso() {
        System.out.println("Realizando Teste de Reserva com Criança");
        ArrayList<Integer> hospedes = new ArrayList<Integer>();
        hospedes.add(1);
        hospedes.add(2);
        hospedes.add(3);
        hospedes.add(4); //1 ano
        hospedes.add(5);
        hospedes.add(8); // 2 anos
        int suite = 1;
        int quantidadeDias = 8;
        controller.adicionarReserva(hospedes, suite, quantidadeDias);
        System.out.println("-----------------------------------------------------------");
    }

    public static void prepararReservaComMaisHospedes() {
        System.out.println("Teste com Reserva de mais Hospedes que capacidade na Suite");
        ArrayList<Integer> hospedes = new ArrayList<Integer>();
        hospedes.add(1);
        hospedes.add(2);
        hospedes.add(3);
        hospedes.add(4);
        hospedes.add(5);
        int suite = 1;
        int quantidadeDias = 3;
        controller.adicionarReserva(hospedes, suite, quantidadeDias);
        System.out.println("------------------------------------------------------");
    }

    public static void prepararReservaComDescontoDias() {
        System.out.println("Teste com Reserva com mais de 7 Dias");
        ArrayList<Integer> hospedes = new ArrayList<Integer>();
        hospedes.add(1);
        hospedes.add(2);
        hospedes.add(3);
        int suite = 1;
        int quantidadeDias = 10;
        controller.adicionarReserva(hospedes, suite, quantidadeDias);
        System.out.println("------------------------------------------------------");
    }

    /*
    public static void prepararReservaComSuiteNaoDisponivel() {
        System.out.println("Realizando Reserva com Suite já reservada");
        ArrayList<Integer> hospedes = new ArrayList<Integer>();
        hospedes.add(1);
        hospedes.add(2);
        int suite = 1;
        int quantidadeDias = 3;
        controller.adicionarReserva(hospedes, suite, quantidadeDias);
        System.out.println("------------------------------------------------------");
    }
     */
}
