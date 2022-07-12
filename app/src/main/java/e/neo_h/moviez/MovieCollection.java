package e.neo_h.moviez;

public class MovieCollection {
    private static Movie[] movies = new Movie [3];

    public MovieCollection(){

        prepareMovies();
    }

    public Movie getPrevMovie(String currentMovieId){
        Movie movie = null;
        for(int index = 0; index < movies.length; index++){
            String tempMovieId = movies[index].getId();
            if(tempMovieId.equals(currentMovieId) && (index > 0)){
                movie = movies[index - 1];
                break;
            }
        }
        return movie;
    }

    public Movie getNextMovie(String currentMovieId){
        Movie movie = null;
        for(int index = 0; index < movies.length; index++){
            String tempMovieId = movies[index].getId();
            if(tempMovieId.equals(currentMovieId) && (index < movies.length -1)){
                movie = movies[index + 1];
                break;
            }
        }
        return movie;
    }

    public static Movie searchById(String id){
        Movie movie = null;

        for (int index=0; index < movies.length; index++){
            movie = movies[index];
            if(movie.getId().equals(id)){
                return movie;
            }
        }
        return movie;
    }

    public static Movie searchByTitle(String title){
        Movie movie = null;

        for (int index=0; index < movies.length; index++){
            movie = movies[index];
            if(movie.getTitle().equals(title)){

                return movie;
            }
        }

        return null;
    }

    public void prepareMovies(){
        Movie Dunkirk = new Movie("S1001", "Dunkirk", "Fionn Whitehead, Tom Glynn-Carney, Jack Lowden, Harry Styles, Aneurin Barnard", "3711e178872ea798f80e2453393b762875b718f7?cid=2afe87a64b0042dabf51f37318616965", 5.6, "dunkirk",  "In May 1940, Germany advanced into France, trapping Allied troops on the beaches of Dunkirk. Troops were slowly and methodically evacuated from the beach using every serviceable naval and civilian vessel that could be found..", "One of a kind of war adaptation movie.");

        Movie Justiceleague = new Movie("S1002", "Justice League", "Ben Affleck, Gal Gadot, Jason Momoa, Henry Cavill, Ezra Miller, Ray Fisher", "c34285bef84330545d10ef90ffcfa7cb8434fdea?cid=2afe87a64b0042dabf51f37318616965", 4.3, "jl",   "Fuelled by his restored faith in humanity, and inspired by Superman's selfless act, Bruce Wayne enlists newfound ally Diana Prince to face an even greater threat..", "Scrambling most of the top notch DC heroes for this movie." );

        Movie Logan = new Movie("S1003", "Logan", "Hugh Jackman, Dafne Keen, Patrick Stewart,  Boyd Holbrook", "70efedd39b07b619dc2625761c2108d49dc9e489?cid=2afe87a64b0042dabf51f37318616965", 2.35, "logan", "In the near future, a weary Logan cares for an ailing Professor X. His plan to hide from the outside world gets upended when he meets a young mutant like him", "Hugh Jackman never cease to amaze with this role.");

        movies[0] = Dunkirk;
        movies[1] = Justiceleague;
        movies[2] = Logan;
    }


}
