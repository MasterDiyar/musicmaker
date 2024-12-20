import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Artist {
    private String name;
    private List<String> albums = new ArrayList<String>();
    public Artist(String name) {
        try {
            this.name = name;
            File file = new File("src/artist/" + name + ".txt");
            if (file.exists()) {
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    albums.add(line);
                }
            sc.close();
            }
            else {
                file.createNewFile();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addAlbum(String album) {
        albums.add(album);
        try {
            FileWriter file = new FileWriter("src/artist/" + name + ".txt");
            for (String line : albums) {
                file.write(line + "\n");
            }
            file.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void printAlbums() {
        for (String album : albums) {
            System.out.println(album);
        }
    }
    public String getname() {
        return name;
    }
    public String getAlbums(int index) {
        return albums.get(index-1);
    }
}
