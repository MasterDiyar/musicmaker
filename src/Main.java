import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String input = scanner.nextLine();
        //String[] words = input.split(" ");
        Albums albums;
        String[] words;
        boolean a = true;
        while (a) {
            switch (scanner.nextLine()) {
                case "makealbum", "0":
                        System.out.println("Enter songs: split by # like song_name#length");
                        words = scanner.nextLine().split(" ");
                        albums = new Albums(words[0], words[1]);
                        String songs = scanner.nextLine();
                        albums.setalbum(songs);

                    break;
                case "getalbum", "1":
                    words = scanner.nextLine().split(" ");
                    albums = new Albums(words[1], words[2]);
                    albums.getallsongs();
                    break;
                case "getsongfromalbum", "2":
                    words = scanner.nextLine().split(" ");
                    albums = new Albums(words[0], words[1]);
                    albums.getselectedsong(Integer.parseInt(words[2]));
                    break;
                case "getsong", "3":
                    System.out.println("Enter song: ");
                    words = scanner.nextLine().split(" ");
                    Music music = new Music(words[0], words[1], words[2], words[3], Integer.parseInt(words[4]));
                    music.print();
                    break;
                case "comparesongsfromonealbum" , "4":
                    words = scanner.nextLine().split(" ");
                    albums = new Albums(words[0], words[1]);
                    albums.compare(Integer.parseInt(words[2]), Integer.parseInt(words[3]));
                    break;
            }

        }


    }
}