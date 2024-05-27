package org.exercise.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int choice = 0, i = 0, seats = 0;
        System.out.print("Inserisci la data dell'evento!: ");
        LocalDate data = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Evento event = new Evento(40, data, "Evento incredibile!");
        System.out.print("Quante operazioni vuoi effettuare?: ");
        choice = Integer.parseInt(scanner.nextLine());
        while (i < choice) {
            try {

                System.out.println("Prenotazione (1) Disdici (2)");
                int rispostaPrenotazioni = Integer.parseInt(scanner.nextLine());

                switch (rispostaPrenotazioni) {
                    case 1:
                        // Richiedi all'utente quanti posti vuole prenotare
                        System.out.println("Quanti posti vuoi prenotare?");
                        int postiPrenotati = Integer.parseInt(scanner.nextLine());

                        event.booking(postiPrenotati);
                        System.out.println("Numero di posti prenotati: " + postiPrenotati);
                        System.out.println("Numero di posti disponibili: " + event.getTotalSeats());
                        i++;
                        break;
                    case 2:

                        System.out.println("Quanti posti vuoi disdire?");
                        int postiDisedia = Integer.parseInt(scanner.nextLine());


                        event.disdire(postiDisedia);
                        System.out.println("Numero di posti prenotati dopo le disdette: " + event.getBookedSeats());
                        System.out.println("Numero di posti disponibili dopo le disdette: " + event.getTotalSeats());
                        i++;
                        break;
                    default:
                        System.out.println("Scelta non valida!");

                }

            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido.");
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
        System.out.println(event);
    }

}

