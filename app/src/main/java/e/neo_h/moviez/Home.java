package e.neo_h.moviez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void Nextpage(View view){
        Intent intent = new Intent(this, Popular.class);

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
}
