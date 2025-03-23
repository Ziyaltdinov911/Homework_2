package main;

import models.Book;
import models.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Камиль", Arrays.asList(
                        new Book("Java 8", 2015, 500),
                        new Book("Swift Programming", 2018, 600),
                        new Book("Effective Java", 2008, 400),
                        new Book("Spring in Action", 2005, 700),
                        new Book("Clean Code", 1999, 450)
                )),
                new Student("Ангелина", Arrays.asList(
                        new Book("Design Patterns", 1994, 350),
                        new Book("Refactoring", 2019, 550),
                        new Book("Android Dev", 2021, 450),
                        new Book("Algorithms", 2001, 650),
                        new Book("Data Structures", 1999, 550),
                        new Book("Design Patterns", 1999, 450),
                        new Book("Clean code", 1995, 231),
                        new Book("Swift Java", 2001, 430)
                ))
        );

        Optional<Integer> firstYear = students.stream()
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst();

                System.out.println(
                        firstYear.map(year -> "Год выпуска первой книги: " + year)
                                .orElse("Книга не найдена")
                );
    }
}