package e.neo_h.moviez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import e.neo_h.moviez.util.AppUtil;

public class Popular extends AppCompatActivity {

    private MovieCollection movieCollection = new MovieCollection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);
    }

    public void NextPage(View view){
        Intent intent = new Intent(this, Home.class);

        startActivity(intent);
    }

    public void NEXTPAGE(View view){
        Intent intent = new Intent(this, SearchBar.class);

        startActivity(intent);
    }

    public void nextpage(View view){
        Intent intent = new Intent(this, Profile.class);

        startActivity(intent);
    }

    public void handleSelection(View view){
        String resourceId = AppUtil.getResourceId(this, view);

        Movie selectedMovie = MovieCollection.searchById(resourceId);

        AppUtil.popMessage(this, "Showing Movie Information: " + selectedMovie.getTitle());
        sendDataToActivity(selectedMovie);
    }

    public void sendDataToActivity(Movie movie){
        Intent intent = new Intent(this, PlayMovieActivity.class);
        intent.putExtra("id",movie.getId());
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("casts", movie.getCasts());
        intent.putExtra("fileLink", movie.getFileLink());
        intent.putExtra("coverArt", movie.getCoverArt());
        intent.putExtra("synopsis", movie.getSynopsis());
        intent.putExtra("review", movie.getReview());
        startActivity(intent);
    }
}
