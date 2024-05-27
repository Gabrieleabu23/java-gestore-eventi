package org.exercise.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Evento {
    private String titolo;
    private final LocalDate data;
    private final int totalSeats;
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
    public void booking(int seats) {
        if (!(this.data.isBefore(LocalDate.now()) && (seats < (totalSeats - bookedSeats)))) {
            this.bookedSeats += seats;
        }
    }

    //    METODO PER DISDIRE
    public void disdire(int seats) {
        if (!(this.data.isBefore(LocalDate.now()) && (seats > totalSeats))) {
            this.bookedSeats -= seats;
        }
    }


//    OVERRIDE toString


    @Override
    public String toString() {
        return String.format("%s - %s", data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy ")), titolo);
    }
}

