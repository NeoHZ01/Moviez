package e.neo_h.moviez;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.IOException;

import e.neo_h.moviez.util.AppUtil;

public class PlayMovieActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://p.scdn.co/mp3-preview/";

    private String movieId = "";
    private String title = "";
    private String casts = "";
    private String fileLink = "";
    private String coverArt = "";
    private String synopsis = "";
    private String review = "";
    private String url = "";

    private MediaPlayer player = null;
    private int musicPosition = 0;
    private Button btnPlayPause = null;

    private MovieCollection movieCollection = new MovieCollection();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_movie);

        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        Button submit = (Button) findViewById(R.id.submit);
        final TextView ratingDisplayTextView = (TextView) findViewById(R.id.rating_display_text_view);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingDisplayTextView.setText("Your rating is: " + ratingBar.getRating());

            }
        });
        btnPlayPause = (Button) findViewById(R.id.btnPlayPause);
        retrieveData();
        displayMovie(title, casts, coverArt, synopsis, review);
    }

    public void next(View view){
        Intent intent = new Intent(this, PlayTrailer.class);

        startActivity(intent);
    }

    public void goPrevious(View view){
        Movie prevMovie = movieCollection.getPrevMovie(movieId);
        if(prevMovie != null){
            movieId = prevMovie.getId();
            title = prevMovie.getTitle();
            casts = prevMovie.getCasts();
            fileLink = prevMovie.getFileLink();
            coverArt = prevMovie.getCoverArt();
            synopsis = prevMovie.getSynopsis();
            review = prevMovie.getReview();

            displayMovie(title, casts, coverArt, synopsis, review);
        }
    }

    public void goNext(View view){
        Movie nextMovie = movieCollection.getNextMovie(movieId);
        if(nextMovie != null){
            movieId = nextMovie.getId();
            title = nextMovie.getTitle();
            casts = nextMovie.getCasts();
            fileLink = nextMovie.getFileLink();
            coverArt = nextMovie.getCoverArt();
            synopsis = nextMovie.getSynopsis();
            review = nextMovie.getReview();

            url = BASE_URL +fileLink;
            displayMovie(title, casts, coverArt, synopsis, review);
            stopActivities();
            playOrPauseMusic(view);
        }
    }

    public void playOrPauseMusic(View view){
        if(player == null){
            preparePlayer();
        }

        if(!player.isPlaying()){
            if(musicPosition > 0){
                player.seekTo(musicPosition);
            }
            player.start();
            btnPlayPause.setText("PAUSE");

            setTitle("Now Playing: " + title);
            gracefullyStopWhenMusicEnds();
        }
        else{
            pauseMusic();
        }
    }


    private void gracefullyStopWhenMusicEnds(){
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stopActivities();
                if(player !=null){
                    btnPlayPause.setText("PLAY");
                    musicPosition = 0;
                    setTitle("");
                    player.stop();
                    player.release();
                    player = null;
                }
            }
        });
    }

    private void pauseMusic(){
        player.pause();
        musicPosition = player.getCurrentPosition();
        btnPlayPause.setText("PLAY");
    }

    private void stopActivities(){
        if(player !=null){
            btnPlayPause.setText("PLAY");
            musicPosition = 0;
            setTitle("");
            player.stop();
            player.release();
            player = null;

        }
    }


    private void preparePlayer(){
        player = new MediaPlayer();

        try{
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(url);
            player.prepare();

        }
        catch (IOException e){
            e.printStackTrace();

        }
    }

    private void displayMovie(String title, String casts, String coverArt, String synopsis, String review){
        TextView txtMovieTitle = (TextView) findViewById(R.id.txtMovieTitle);
        txtMovieTitle.setText(title);

        TextView txtCasts = (TextView) findViewById(R.id.txtCasts);
        txtCasts.setText(casts);

        int imageId = AppUtil.getImageIdFromDrawable(this, coverArt);

        ImageView ivCoverArt = (ImageView) findViewById(R.id.imgCoverArt);
        ivCoverArt.setImageResource(imageId);

        TextView txtSynopsis = (TextView) findViewById(R.id.txtSynopsis);
        txtSynopsis.setText(synopsis);

        TextView txtReview = (TextView) findViewById(R.id.txtReview);
        txtReview.setText(review);

    }

    private void retrieveData(){
        Bundle movieData = this.getIntent().getExtras();
        movieId = movieData.getString("id");
        title = movieData.getString("title");
        casts = movieData.getString("casts");
        fileLink = movieData.getString("fileLink");
        coverArt = movieData.getString("coverArt");
        synopsis = movieData.getString("synopsis");
        review = movieData.getString("review");

        url = BASE_URL + fileLink;

    }
}
