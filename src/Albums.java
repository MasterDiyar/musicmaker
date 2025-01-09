import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Albums extends Mixxxtape{
    private String albumName;
    private String artistName;
    private String genre;
    private List<String> songlist = new ArrayList<String>();
    public Albums(String albumName, String artistName) {
        Artist artist = new Artist(artistName);
        artist.addAlbum(albumName);
        this.albumName = albumName;
        this.artistName = artist.getname();
        this.genre = "";
        getalbumfromfile();
    }


    @Override
    public String getallsongs() {
        String full = "";
        for (String song : songlist) {
            full += song.split("#")[0]+"\n";
        }
        return full;
    }
    public void getselectedsong(int index){
        String[] mus =songlist.get(index-1).split("#");
        System.out.println(songlist.get(index-1));
        Music music = new Music(mus[0], artistName, albumName, genre, Integer.parseInt(mus[1]));
        music.print();
    }
    void getalbumfromfile() {
        File file = new File("src/albums/"+albumName+artistName+".txt");
        if(file.exists()) {
            try {
                Scanner sc = new Scanner(file);
                while(sc.hasNextLine()) {
                    String line = sc.nextLine();
                    songlist.add(line);
                }
                sc.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void setalbum(String songnames) {
        File file = new File("src/albums/"+albumName+artistName+".txt");
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
    public String getname(){
        return albumName;
    }
    public void compare(int f1, int f2) {
        String[] v1 = songlist.get(f1).split("#"), v2 = songlist.get(f2).split("#");
        Music m1 = new Music(v1[0], artistName, albumName, genre, Integer.parseInt(v1[1]));
        Music m2 = new Music(v2[0], artistName, albumName, genre, Integer.parseInt(v2[1]));
        System.out.println("Songs: "+ v1[0]+" "+v2[0]);
        System.out.println("Artists: "+ m1.get("artist")+" "+m2.get("artist"));
        System.out.println("Albums: "+ m1.get("album")+" "+m2.get("album"));
        System.out.println("Genres: "+ m1.get("genre")+" "+m2.get("genre"));
        System.out.println("length: "+ m1.get("length")+" "+m2.get("length"));
    }

}
