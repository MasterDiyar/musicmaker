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
        return switch (what) {
            case "artist" -> artist.getname();
            case "album" -> album.getname();
            case "genre" -> genre;
            case "length" -> len;
            default -> "not find yet";
        };
    }
    @Override
    public String toString (){
        return name+"#"+artist.getname()+"#" + album.getname() + "#" + String.valueOf(len);
    }
}
