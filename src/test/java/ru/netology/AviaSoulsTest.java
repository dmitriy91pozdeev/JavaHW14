package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;


class AviaSoulsTest {
    AviaSouls manager = new AviaSouls();
    Ticket ticket1 = new Ticket("Ереван", "Новосибирск", 10_000, 19, 23);
    Ticket ticket2 = new Ticket("Москва", "Сыктывкар", 5_000, 8, 12);  //4
    Ticket ticket3 = new Ticket("Новосибрск", "Самара", 7_000, 5, 8);
    Ticket ticket4 = new Ticket("Сочи", "Грозный", 4_000, 2, 4);
    Ticket ticket5 = new Ticket("Москва", "Минск", 8_000, 4, 7);
    Ticket ticket6 = new Ticket("Москва", "Сыктывкар", 2_000, 2, 8);  //6
    Ticket ticket7 = new Ticket("Сочи", "Москва", 6_000, 0, 2);
    Ticket ticket8 = new Ticket("Москва", "Сыктывкар", 3_000, 13, 16); // 3

    @Test

    public void testTicketSortingByPrice() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);


        Ticket[] expected = {ticket6, ticket8, ticket2};
        Ticket[] actual = manager.search("Москва", "Сыктывкар");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void testWhenOneTicketFitsByPrice() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.search("Ереван", "Новосибирск");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void testWhenNotTicketFitsByPrice() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Калуга", "Новосибирск");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void testTicketSortingByTime() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket8, ticket2, ticket6};
        Ticket[] actual = manager.search2("Москва", "Сыктывкар", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void testWhenOneTicketFitsByTime() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket7};
        Ticket[] actual = manager.search2("Сочи", "Москва", comparator);

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test

    public void testWhenNotTicketFitsByTime() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search2("Воронеж", "Москва", comparator);

        Assertions.assertArrayEquals(expected, actual);


    }
}


