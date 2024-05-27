package org.exercise.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Evento {
    private String titolo;
    private final LocalDate data;
    private int totalSeats;
    private int bookedSeats = 0;

//    CONSTRUCTOR

    public Evento(int totalSeats, LocalDate data, String titolo) {
        this.totalSeats = checkTotalSeats(totalSeats);
        this.data = checkData(data);
        setTitolo(titolo);
    }
//    GETTER

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getData() {
        return data;
    }


    public int getTotalSeats() {
        return totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

//    SETTER

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setData(LocalDate data) {
        checkData(data);
    }

    //    METODO
    private LocalDate checkData(LocalDate data) throws IllegalArgumentException {

        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
        }
        return data;
    }

    private int checkTotalSeats(int totalSeats) {
        if (totalSeats <= 0) {
            throw new IllegalArgumentException("Il numero totale dei posti non è valido!");
        }
        return totalSeats;
    }

    //    METODO PER PRENOTARE
    public void booking(int seats) throws Exception {
        if (checkSeats(seats, 1)) {

            this.bookedSeats += seats;
            this.totalSeats -= seats;
        }
    }

    //    METODO PER DISDIRE
    public void disdire(int seats) {
        if (checkSeats(seats, 2)) {

            this.bookedSeats -= seats;
            this.totalSeats += seats;
        }

    }

    private boolean checkSeats(int seats, int i) {
        switch (i) {
            case 1:
                if (seats > this.totalSeats) {
                    throw new IllegalArgumentException("Non ci sono abbastanza posti disponibili.");
                }
                break;
            case 2:
                if (seats > this.bookedSeats) {
                    throw new IllegalArgumentException("Non ci sono abbastanza posti prenotati da disdire.");
                }
        }
        return true;
    }

//    OVERRIDE toString


    @Override
    public String toString() {
        return String.format("%s - %s", data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy ")), titolo);
    }
}

