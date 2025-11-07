package app.jbc.result.back;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import app.jbc.R;

public class AddUserActivity extends AppCompatActivity {


   /* EditText etName;
    Button btnSave;
    Button btnCancel;*/

    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        name = findViewById(R.id.et_name);
              /*btnSave.setOnClickListener(v -> {
            String name = etName.getText().toString();

            Intent resultIntent = new Intent();
            resultIntent.putExtra("user_name", name);

            setResult(RESULT_OK, resultIntent);
            finish(); // close AddUserActivity and return result
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });*/
    }


    public void onButtonClick(View view) {
        int id = view.getId(); //get the id here
        if (id == R.id.btnSave) {
            String meroNaam = name.getText().toString();
            Toast.makeText(this, meroNaam, Toast.LENGTH_SHORT).show();

           /* Intent i = new Intent(AddUserActivity.this, ParentActivity.class);
            i.putExtra("user_name", meroNaam);
            startActivity(i);*/
            Intent resultIntent = new Intent();
            resultIntent.putExtra("user_name", meroNaam);
            setResult(RESULT_OK, resultIntent);
            finish(); // close AddUserActivity and return result
        }

        if (id == R.id.btnCancel) {
            Intent resultIntent = new Intent();
            setResult(RESULT_CANCELED, resultIntent);
            finish(); //
            Toast.makeText(this, "Cancel button click vayo", Toast.LENGTH_SHORT).show();
        }


    }
}