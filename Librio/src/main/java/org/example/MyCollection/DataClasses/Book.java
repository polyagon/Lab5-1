package org.example.MyCollection.DataClasses;

import org.example.MyCollection.Exceptions.InvalidFieldValue;

import java.util.Objects;

public class Book implements Cloneable, Comparable{
    private long id;
    private String title;
    private String autor;
    private ISBNmark ISBN;
    private BookStatus status;

    public Book(long id, String title, String autor, ISBNmark isbn, BookStatus status){
        this.id  = id;
        this.title = title;
        this.autor = autor;
        this.ISBN = isbn;
        this.status = status;

    }
    public long getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getAutor(){
        return this.autor;
    }
    public ISBNmark getISBN(){
        return this.ISBN;
    }
    public BookStatus getStatus(){
        return  this.status;
    }

    public void setId(long id){
        this.id = id;
    }
    public void setTitle(String title) throws InvalidFieldValue{
        if(title == "" || title == null) throw new InvalidFieldValue(this.getClass().getName(), title);
        this.title = title;
    }
    public void setAutor(String autor) throws InvalidFieldValue{
        if(autor == "" || autor == null) throw new InvalidFieldValue(this.getClass().getName(), autor);
        this.autor = autor;
    }
    public void setISBN(ISBNmark ISBN) throws InvalidFieldValue{
        if(ISBN == null || ISBN.getISBN() == "") throw new InvalidFieldValue(this.getClass().getName(), ISBN.getISBN());
        this.ISBN = ISBN;
    }

    @Override
    public Book clone() throws CloneNotSupportedException {
        return (Book) super.clone();
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, title, autor, ISBN, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book check = (Book) o;
        return hashCode() == check.hashCode();
    }
    @Override
    public String toString(){
        String out = "Book(" +
                "\n\tid=" + id +
                "\n\ttitle=" + title +
                "\n\tautor=" + autor +
                "\n\tISBN=" + ISBN.getISBN() +//.format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")) +
                "\n\tstatus=" + status;
        return  out + ");\n";
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || getClass() != o.getClass()) return 0;
        if (((Dragon)o).id > this.id) return 1;
        else return -1;
    }
}
