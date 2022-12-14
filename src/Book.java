public class Book {
    private String bookName = "DEFAULT_BOOK_NAME";
    private final Author author;
    private int publishingYear;

    private final int firstPublishingYear = 1445;
    private final int defaultYear = 2000;

    public Book(String bookName,Author author, int publishingYear) {

        if (Author.checkString(bookName,"Неверное название книги")) {
            this.bookName=bookName.trim();
        }

        this.author = author;

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
    public String toString() {
        return String.format("Книга: %30s Автор: %15s год выпуска - %4d г.",this.getBookName(),this.author,this.getPublishingYear());
    }// toString
}
