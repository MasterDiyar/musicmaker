import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*SecMain a = new SecMain();
        a.a();*/





        Scanner scanner = new Scanner(System.in);
        //String input = scanner.nextLine();
        //String[] words = input.split(" ");
        Albums albums;
        String[] words;
        System.out.print("""
                  for making an album: enter 'makealbum' or '0'
                  for getting a album: enter 'getalbum' or '1'
                  for get one song from album enter 'getsongfromalbum' or '2'
                  for getting song: input 'getsong' or '3'
                  for comparing songs from albums input 'comparesongsfromonealbum' or '4'""");
        boolean a = true;
        while (a) {
            switch (scanner.nextLine()) {
                case "makealbum", "0":
                        System.out.print("for making an album enter <album name> and <artist name>: ");
                        words = scanner.nextLine().split(" ");
                        System.out.println("Enter songs: split by # and ' ' like: song_name#length song_name#length");
                        albums = new Albums(words[0], words[1]);
                        String songs = scanner.nextLine();
                        albums.setalbum(songs);
                    break;
                case "getalbum", "1":
                    System.out.println("For get list of songs in album enter <album name> <artist name>:");
                    words = scanner.nextLine().split(" ");
                    albums = new Albums(words[0], words[1]);
                    albums.getallsongs();
                    break;
                case "getsongfromalbum", "2":
                    System.out.println("For take one song from album enter <album name> <artist name> and index:");
                    words = scanner.nextLine().split(" ");
                    albums = new Albums(words[0], words[1]);
                    albums.getselectedsong(Integer.parseInt(words[2]));
                    break;
                case "getsong", "3":
                    System.out.println("Enter song: <song name> <artist name> ");
                    words = scanner.nextLine().split(" ");
                    Music music = new Music(words[0], words[1], words[2], words[3], Integer.parseInt(words[4]));
                    music.print();
                    break;
                case "comparesongsfromonealbum" , "4":
                    words = scanner.nextLine().split(" ");
                    albums = new Albums(words[0], words[1]);
                    albums.compare(Integer.parseInt(words[2]), Integer.parseInt(words[3]));
                    break;
                case "aboutartist", "5":
                    String name = scanner.nextLine();
                    Artist artist = new Artist(name);
                    System.out.println("Name: "+artist.getname() +"\nalbums:");
                    artist.printAlbums();
                    break;
                case "makeplaylist" , "6":

                    break;

                case "exit":
                    a = false;
                    break;
            }

        }


    }
}