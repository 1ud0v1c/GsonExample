package fr.ludovic.vimont.gsonexample;

public class Book {
    private String id;
    private String name;
    private String author;
    private String genre;
    private int numpages;
    private String releaseDate;
    private String cover;
 
    public Book() {}
 
    public Book(String id, String name, String author, String genre, int numpages, String releaseDate, String cover) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.numpages = numpages;
        this.releaseDate = releaseDate;
        this.cover = cover;
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
 
    public String getReleaseDate() {
        return releaseDate;
    }
 
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "Book [ " +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", numpages=" + numpages +
                ", cover=" + cover +
                ", releaseDate='" + releaseDate + '\'' +
                ']';
    }
}