# Library Management System (Java)

This repository contains a simple console-based library management system
implemented in Java. It demonstrates basic object-oriented design,
encapsulation and list management. Users can add books to a library,
remove books by ISBN and list all available books. The project is
intentionally lightweight but showcases good coding practices such as
separating concerns and using descriptive class names.

## Features

* **Book class** – represents a book with title, author and ISBN.
* **Library class** – maintains a collection of books and provides methods
  to add, remove and list books.
* **Main program** – offers a simple text menu for user interaction.

## Running the program

To compile and run the program:

```sh
javac LibraryManagement.java
java LibraryManagement
```

Follow the on-screen prompts to add or remove books or list the current
collection. The program uses an in-memory list (no persistence), so
changes are not saved between runs.

## Motivation

This project showcases understanding of classes, methods, lists and
command-line interaction in Java. It’s a good portfolio piece for
junior developer positions where knowledge of core Java and software
engineering principles is required.
