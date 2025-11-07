package app.jbc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnForgotPass = findViewById(R.id.btn_forgot);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);

        btnForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Forgot Button", "Forgot button le kkaam garyo");
                /*1. Euta activity banauna paryo
                 *2. Tyo class ko design pani banae
                 *3. Tyo activity  ma switch hune code yo button click garda lekhna paryo
                 * 4. Switch garda data pani pathaune
                 */
                Intent intent = new Intent(
                        LoginActivity.this,
                        ForgotPassActivity.class);
                intent.putExtra("data", "hello");
                intent.putExtra("roll", 10);
                intent.putExtra("isLoggedIn", false);
                startActivity(intent);
            }
        });
    }

    public void onLoginClick(View view) {
        String email = etEmail.getText().toString();
        String pass = etPassword.getText().toString();
        Log.e("Email tag", email);
        Log.e("Password tag", pass);

        if (etEmail.getText().toString().isEmpty()) {
            etEmail.setError("This field is required");
        }

        if (pass.isEmpty()) {
            etPassword.setError("This field is required");
        }

        if (!email.isEmpty() && !pass.isEmpty()) {
            //TODO: Write your logic here, Validate form and intergata api
            Toast.makeText(LoginActivity.this, "Hello I am toast",
                    Toast.LENGTH_LONG).show();
            Intent intent = new Intent(
                    LoginActivity.this,
                    DashboardActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this, "Email and password required",
                    Toast.LENGTH_LONG).show();
        }
    }
}