class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Director: " + director + ", Year: " + year + ", Rating: " + rating;
    }
}

class MovieList {
    Movie head;
    Movie tail;

    public void addAtBeginning(Movie newMovie) {
        if (head == null) {
            head = newMovie;
            tail = newMovie;
            return;
        }
        newMovie.next = head;
        head.prev = newMovie;
        head = newMovie;
    }

    public void addAtEnd(Movie newMovie) {
        if (head == null) {
            head = newMovie;
            tail = newMovie;
            return;
        }
        tail.next = newMovie;
        newMovie.prev = tail;
        tail = newMovie;
    }

    public void deleteByTitle(String title) {
        if (head == null) return;

        if (head.title.equals(title)) {
            head = head.next;
            if (head != null) head.prev = null; // Update prev if head is not null after deletion
            return;
        }

        Movie current = head;
        while (current != null && !current.title.equals(title)) {
            current = current.next;
        }

        if (current != null) {
            if (current == tail) {
                tail = current.prev;
                if(tail != null) tail.next = null;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
        }
    }


    public Movie searchByDirector(String director) {
        Movie current = head;
        while (current != null) {
            if (current.director.equals(director)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Movie searchByRating(double rating) {
        Movie current = head;
        while (current != null) {
            if (current.rating == rating) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayForward() {
        Movie current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void displayReverse() {
        Movie current = tail;
        while (current != null) {
            System.out.println(current);
            current = current.prev;
        }
    }

    public void updateRating(String title, double newRating) {
        Movie movie = searchByTitle(title);
        if (movie != null) {
            movie.rating = newRating;
        }
    }

    public Movie searchByTitle(String title) {
        Movie current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}

public class MovieManagement {
    public static void main(String[] args) {
        MovieList list = new MovieList();
        list.addAtEnd(new Movie("Movie A", "Director X", 2020, 8.5));
        list.addAtEnd(new Movie("Movie B", "Director Y", 2021, 7.2));
        list.addAtBeginning(new Movie("Movie C", "Director Z", 2019, 9.0));

        System.out.println("Movies (Forward):");
        list.displayForward();

        System.out.println("\nMovies (Reverse):");
        list.displayReverse();

        list.deleteByTitle("Movie B");
        System.out.println("\nAfter deleting Movie B:");
        list.displayForward();

        Movie found = list.searchByDirector("Director X");
        if (found != null) {
            System.out.println("\nFound by director: " + found);
        }

        list.updateRating("Movie A", 9.2);
        System.out.println("\nAfter updating rating:");
        list.displayForward();
    }
}