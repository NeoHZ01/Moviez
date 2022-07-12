package e.neo_h.moviez;

public class Movie {
    private String id;
    private String title;
    private String casts;
    private String fileLink;
    private double songLength;
    private String coverArt;
    private String synopsis;
    private String review;

    public Movie(String _id, String _title, String _casts, String _fileLink, double _songLength, String _coverArt, String _synopsis, String _review) {
        this.id = _id;
        this.title = _title;
        this.casts = _casts;
        this.fileLink = _fileLink;
        this.songLength = _songLength;
        this.coverArt = _coverArt;
        this.synopsis = _synopsis;
        this.review = _review;
    }

    public String getId() { return id; }

    public String getTitle() { return title; }

    public String getCasts() { return casts; }

    public String getFileLink() { return fileLink; }

    public double getSonglength() { return songLength; }

    public String getCoverArt() { return coverArt; }

    public String getSynopsis() { return synopsis; }

    public String getReview() { return  review; }

    public void setId(String id) { this.id = id; }

    public void setTitle(String title) { this.title = title; }

    public void setCasts(String casts) { this.casts = casts; }

    public void setFileLink(String fileLink) { this.fileLink = fileLink; }

    public void setSongLength(double songLength) { this.songLength = songLength; }

    public void setCoverArt(String coverArt) { this.coverArt = coverArt; }

    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }

    public void setReview(String review) { this.review = review; }
}
