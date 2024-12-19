import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Albums {
    private String albumName;
    private String artistName;
    private String genre;
    private List<String> songlist = new ArrayList<String>();
    public Albums(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.genre = "";
        getalbumfromfile();
    }
    public void getallsongs() {
        for (String song : songlist) {
            System.out.println(song);
        }
    }
    public void getselectedsong(int index){
        String[] mus =songlist.get(index).split("#");
        Music music = new Music(mus[0], artistName, albumName, genre, Integer.getInteger(mus[1]));
        music.print();
    }
    void getalbumfromfile() {
        File file = new File("src/albums/"+albumName+artistName+".txt");
        if(file.exists()) {
            try {
                Scanner sc = new Scanner(file);
                while(sc.hasNextLine()) {
                    String line = sc.nextLine();
                    songlist.add(line.split("#")[0]);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void setalbum(String songnames) {
        File file = new File("src/albums"+albumName+artistName+".txt");
        if (!file.exists()) {
            try{
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            for (String song : songnames.split(" ")) {
                fileWriter.write(song+"\n");
            }
            fileWriter.close();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
