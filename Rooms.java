import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.imageio.IIOException;
import java.io.IOException;

public class Rooms {
    private Document rooms;
    public Rooms () {
        connect();

    }
    private void connect () {
        try {
            rooms = Jsoup.connect("https://hotel-spb.ru/booking").get();
        } catch (IOException e) {
            System.out.println("Exception caught");
        }
    }

    public String getTitle() { return rooms.title();}
    public String getPrice() {

    }
}
