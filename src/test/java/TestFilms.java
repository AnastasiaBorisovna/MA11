import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFilms {
    @Test
    public void test() {
        FilmsManager manager = new FilmsManager();

        manager.addFilm("Movie I");
        manager.addFilm("Movie II");
        manager.addFilm("Movie III");
        manager.addFilm("Movie IV");
        manager.addFilm("Movie V");

        String[] actual = manager.findAll();
        String[] expected = {"Movie I", "Movie II", "Movie III", "Movie IV", "Movie V"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOneFilm() {
        FilmsManager manager = new FilmsManager();
        manager.addFilm("Movie I");
        String[] actual = manager.findAll();
        String[] expected = {"Movie I"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotFilm() {
        FilmsManager manager = new FilmsManager();
        manager.addFilm("");
        String[] actual = manager.findAll();
        String[] expected = {""};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testLimit() {
        FilmsManager manager = new FilmsManager();

        manager.addFilm("Movie I");
        manager.addFilm("Movie II");
        manager.addFilm("Movie III");
        manager.addFilm("Movie IV");
        manager.addFilm("Movie V");


        String[] actual = manager.findLast();
        String[] expected = {"Movie V", "Movie IV", "Movie III", "Movie II", "Movie I"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void lessThanTheLimit() {
        FilmsManager manager = new FilmsManager();

        manager.addFilm("Movie I");
        manager.addFilm("Movie II");
        manager.addFilm("Movie III");
        manager.addFilm("Movie IV");


        String[] actual = manager.findLast();
        String[] expected = {"Movie IV", "Movie III", "Movie II", "Movie I"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void moreThanTheLimit() {

        FilmsManager manager = new FilmsManager();

        manager.addFilm("Movie I");
        manager.addFilm("Movie II");
        manager.addFilm("Movie III");
        manager.addFilm("Movie IV");
        manager.addFilm("Movie V");
        manager.addFilm("Movie VI");


        String[] actual = manager.findLast();
        String[] expected = {"Movie VI", "Movie V", "Movie IV", "Movie III", "Movie II"};
        Assertions.assertArrayEquals(expected, actual);
    }
}
