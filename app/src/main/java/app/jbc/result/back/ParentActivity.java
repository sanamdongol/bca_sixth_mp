package app.jbc.result.back;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import app.jbc.R;

public class ParentActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> resultAucha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_parent);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnAddUser = findViewById(R.id.btnAddUser);

        // Register the launcher to get result
        resultAucha = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent data = result.getData();
                        String userKoNaam = data.getStringExtra("user_name");
                        Toast.makeText(ParentActivity.this, userKoNaam, Toast.LENGTH_SHORT).show();

                    }
                });
       /* ActivityResultLauncher<Intent> mStartForResult =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                    }
                });*/
        // Start child activity when button clicked
        /*btnAddUser.setOnClickListener(v -> {
            Intent intent = new Intent(ParentActivity.this, AddUserActivity.class);
            mStartForResult.launch(intent);
        });*/
    }

    public void onAddClick(View view) {
        Intent intent = new Intent(ParentActivity.this, AddUserActivity.class);
        resultAucha.launch(intent);
    }
}