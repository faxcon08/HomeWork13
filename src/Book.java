import java.util.Objects;

public class Book {
    private String bookName = "DEFAULT_BOOK_NAME";
    private final Author author;
    private int publishingYear;

    static private int bookCounter =1;

    private final int bookNumber;

    private final int firstPublishingYear = 1445;
    private final int defaultYear = 2000;

    public Book(String bookName,Author author, int publishingYear) {

        if (Author.checkString(bookName,"Неверное название книги")) {
            this.bookName=bookName.trim();
        }

        this.author = author;
        this.bookNumber=bookCounter++;

        if (publishingYear>= firstPublishingYear) {
            this.publishingYear = publishingYear;
        } else {
            System.out.println("Некорректный год издания");
            this.publishingYear = defaultYear;
        }

    }// book()
    public void setPublishingYear(int year) {
        if(year>= firstPublishingYear)
            this.publishingYear=year;
        else
            System.out.println("Попытка изменить год издания на некорректный год");
    } // setPublishigYear

    public int getPublishingYear() {
        return this.publishingYear;
    }

    public String getBookName() {
        return this.bookName;
    }

    public String getAuthor() {
        return this.author.getFullName();
    }

    @Override
    public String toString() {
        return String.format("Книга %d: %25s Автор: %15s год выпуска - %4d г.",this.bookNumber,this.getBookName(),this.author,this.getPublishingYear());
    }// toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publishingYear == book.publishingYear && bookName.equals(book.bookName) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, author, publishingYear);
    }
}
