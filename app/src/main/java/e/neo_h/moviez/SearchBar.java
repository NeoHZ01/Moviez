package e.neo_h.moviez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import e.neo_h.moviez.util.AppUtil;

public class SearchBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar);
    }

    public void searchSelection(View view){
        MovieCollection collection = new MovieCollection();
        EditText editText = (EditText) findViewById(R.id.MovieTitle);
        String input = editText.getText().toString();
        System.out.println(input);
        Movie selectedMovie = collection.searchByTitle(input);
        if (selectedMovie  == null ){
            AppUtil.popMessage(this, "Movie not found.");
        } else if (selectedMovie != null) {
            AppUtil.popMessage(this, "Showing Movie Information: " + selectedMovie.getTitle());
            sendDataToActivity(selectedMovie);
        }
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

    public void nextpage(View view){
        Intent intent = new Intent(this, Profile.class);

        startActivity(intent);
    }

    public void NextPage(View view){
        Intent intent = new Intent(this, Home.class);

        startActivity(intent);
    }
}
