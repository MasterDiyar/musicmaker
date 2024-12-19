import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.split(" ");
        Albums albums;
        Boolean a = true;
        while (a) {
            switch (words[0]) {
                case "makealbum":
                        System.out.println("Enter songs: split by # like song_name#length");
                        albums = new Albums(words[1], words[2]);
                        String songs = scanner.nextLine();
                        albums.setalbum(songs);

                    break;
                case "getalbum":
                    albums = new Albums(words[1], words[2]);
                    albums.getallsongs();
                    break;
                case "getsongfromalbum":
                    albums = new Albums(words[1], words[2]);
                    albums.getselectedsong(Integer.getInteger(words[3]));
                    break;
            }

        }


    }
}