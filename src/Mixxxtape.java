import java.util.ArrayList;
import java.util.List;

public abstract class Mixxxtape {
    public List<String> song = new ArrayList<String>();
    public String title = "";
    public int length;
    public abstract String getallsongs();

    public String getname() {
        return title;
    }
}
