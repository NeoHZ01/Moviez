package e.neo_h.moviez;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class PlayTrailer extends YouTubeBaseActivity {
    private static final String TAG = "MainActivity";

    YouTubePlayerView mYoutubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_trailer);

        mYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);

        mYoutubePlayerView.initialize(YoutubeConfig.getApiKey(), new OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onClick: Done initializing");
                List<String> videoList = new ArrayList<>();
                videoList.add("F-eMt3SrfFU");
                videoList.add("r9-DM9uBtVI");
                videoList.add("Div0iP65aZo");
                youTubePlayer.loadVideos(videoList);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onClick: Failed to initialize");
            }
        });


        }
}
