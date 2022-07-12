package e.neo_h.moviez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private EditText Username;
    private EditText Password;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = (EditText) findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        Login = (Button) findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userUsername, String userPassword) {
        if ((userUsername.equals("Admin")) && (userPassword.equals("Admin"))) {
            Intent intent = new Intent(Login.this, Home.class);
            startActivity(intent);


        }}        }


