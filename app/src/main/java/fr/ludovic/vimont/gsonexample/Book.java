package fr.ludovic.vimont.gsonexample;

public class Book {
    private String id;
    private String name;
    private String author;
    private String genre;
    private int numpages;
    private String release_date;
 
    public Book() {}
 
    public Book(String id, String name, String author, String genre, int numpages, String release_date) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.numpages = numpages;
        this.release_date = release_date;
    }
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
 
    public String getGenre() {
        return genre;
    }
 
    public void setGenre(String genre) {
        this.genre = genre;
    }
 
    public int getNumpages() {
        return numpages;
    }
 
    public void setNumpages(int numpages) {
        this.numpages = numpages;
    }
 
    public String getRelease_date() {
        return release_date;
    }
 
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
 
    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", numpages=" + numpages +
                ", release_date='" + release_date + '\'' +
                '}';
    }
}