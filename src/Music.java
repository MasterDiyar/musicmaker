public class Music {
    private String name;
    private Artist artist;
    private Albums album;
    private String genre;
    private int length;
    private String len;
    public Music(String name, String artist, String album, String genre, int length) {
        this.name = name;
        this.artist = new Artist(artist);
        this.album = new Albums(album, artist);
        this.length = length;
        int l = this.length % 60, k = this.length / 60;
        this.len = String.format("%d %d", k, l);
    }
    public void print(){
        System.out.println("Name: " + name);
        System.out.println("Artist: " + artist);
        System.out.println("Album: " + album);
        System.out.println("Length: " + len);
    }
}
