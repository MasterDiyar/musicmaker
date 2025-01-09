import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Playlists extends Mixxxtape
{
    public String Name;
    public List<String> songs = new ArrayList<String>();
    public int length = 0;
    public Playlists(String name){
        Name = name;
    }

    void reader(){
        File fr = new File("src/playlists/"+Name+".txt");
        if(fr.exists()){
            //Zapis budet po tipu songname#artist#album#length
            //Sobiratsa budet tolko  ^                     ^
            try {
                Scanner sc = new Scanner(fr);
                while(sc.hasNextLine()){
                    String[] k = sc.nextLine().split("#");
                    songs.add(k[0]);
                    length += Integer.parseInt(k[1]);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getallsongs() {
        String full = "";
        for (String song : songs) {
            full +=song.split("#")[0];
        }
        return full;
    }
    public int getlength(){
        return length;
    }
    @Override
    public String getname() {
        return Name;
    }
}
