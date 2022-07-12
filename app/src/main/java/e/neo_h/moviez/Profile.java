package e.neo_h.moviez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void NextPage(View view){
        Intent intent = new Intent(this, Home.class);

        startActivity(intent);
    }

    public void NEXTPAGE(View view){
        Intent intent = new Intent(this, SearchBar.class);

        startActivity(intent);
    }

    public void logout(View view){
        Intent intent= new Intent(this, Login.class);

        startActivity(intent);
    }
}
