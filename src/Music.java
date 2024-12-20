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
        this.len = String.format("%d:%d", k, l);
    }
    public void print(){
        System.out.println("Name: " + name);
        System.out.println("Artist: " + artist.getname());
        System.out.println("Album: " + album.getname());
        System.out.println("Length: " + len);
    }
    public String get(String what){
        switch (what){
            case "artist":
                return artist.getname();
            case "album":
                return album.getname();
            case "genre":
                return genre;
            case "length":
                return len;
            default:
                return "not find yet";
        }
    }
}
