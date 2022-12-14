public class Main {
    public static void printRedLN(String str) {
        System.out.println(ANSI_RED+str+ANSI_RESET);
    }
    public static void myDelimiter() {
        printRedLN("----------------------------------------------------");
    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void main(String[] args) {

        Author firstAuthor = new Author("  Лев    Толстой  ");
        Author secondAuthor = new Author("  Деннис  "," Ричи  ");

        Book firstBook = new Book("    Война и Мир", firstAuthor, 1997);
        Book secondBook = new Book("    Язык программирования Си   ", secondAuthor, 2001);
        Book thirdBook = new Book("Война и Мир", firstAuthor, 2000);



        myDelimiter();
        System.out.println(firstBook);
        System.out.println(secondBook);
        System.out.println(thirdBook);
        myDelimiter();

        if (!(firstBook.hashCode()==thirdBook.hashCode())) {
            System.out.println("Книга1 и Книга3 имеют разный hashCode");
        }
        thirdBook.setPublishingYear(1997);
        System.out.println(thirdBook);
        if (firstBook.equals(thirdBook)) {
            System.out.println("Книга1 и Книга3 равны");
        }

    }// main
}// Main