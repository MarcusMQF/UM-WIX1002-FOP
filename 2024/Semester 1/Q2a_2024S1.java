public class Q2a_2024S1 {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "MarcusMah", 2025);
        Book book2 = new Book("C++ Programming", "MarcusMah", 2025);

        System.out.println(book1.getTitle() + " by " + book1.getAuthor() + " (" + book1.getYearPublished() + ")");
        System.out.println(book2.getTitle() + " by " + book2.getAuthor() + " (" + book2.getYearPublished() + ")");
    }
}

class Book {
    private String title, author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getYearPublished(){
        return yearPublished;
    }
}
