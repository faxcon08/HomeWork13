import java.util.Objects;

public class Author {
    private String firstName = "DEFAULT_FIRST_NAME";
    private String lastName = "DEFAULT_LAST_NAME";

    public static boolean checkString(String nameForCheck, String errorMessage) {
        if (nameForCheck != null && !nameForCheck.isBlank()) {
            return true;
        } else {
            System.out.println(errorMessage);
            return false;
        }
    }

    public Author(String firstName, String lastName) {
        if (checkString(firstName, "Некорректное Фамилия Автора")) {
            this.firstName = firstName.trim();
        }

        if (checkString(lastName, "Некорректное Имя Автора")) {
            this.lastName = lastName.trim();
        }
    }

    public Author(String name) {
        if (!checkString(name, "Неверное полное имя ")) {
            return;
        }
        name = name.trim().replaceAll("\\s+", " ");
        String[] names = name.split(" ");
        if (names.length != 2) {
            System.out.println("Некорректное полное имя автора");
            return;
        }
        this.firstName = names[0];
        this.lastName = names[1];
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
    @Override
    public String toString() {
        return this.getFullName();
    }

    @Override
    public boolean equals(Object o) {
        if(o==this) return true;
        if(o==null || this.getClass()!=o.getClass()) return false;
        Author authorToCare = (Author) o;
        return this.firstName.equals(authorToCare.firstName) && this.lastName.equals(authorToCare.lastName);
    }

    @Override
    public int hashCode() {
        return this.lastName.hashCode()+this.firstName.hashCode();
    }
}