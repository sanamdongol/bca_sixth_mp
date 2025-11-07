package app.jbc.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import app.jbc.R;

public class MyDialogActivity extends AppCompatActivity {

    private String[] days = {"Ax", "B", "C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_dialog);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner spin = findViewById(R.id.spinner);


        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sixth_sem, android.R.layout.simple_dropdown_item_1line);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, days);
        adapter.setDropDownViewResource(R.layout.row_spin);
        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int selectedPosition = i;

                String title = adapterView.getSelectedItem().toString();
                Toast.makeText(MyDialogActivity.this, title + "at position " + selectedPosition, Toast.LENGTH_SHORT).show();

                // String selectedItemName = adapterView.getItemAtPosition(i).toString();
                //  Toast.makeText(MyDialogActivity.this, selectedItemName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);


        //  ArrayAdapter<String> adapters = new ArrayAdapter<>(this, R.layout.row_spin, days);
        //   spin2.setAdapter(adapters);

        Button customButton = findViewById(R.id.btn_custom);

        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog meroDialog = new Dialog(MyDialogActivity.this);
                meroDialog.setCancelable(false);
                meroDialog.setContentView(R.layout.custom_dialog_box);
                //start referencing views
                Button btnLike = meroDialog.findViewById(R.id.btnLike);
                Button btnDislike = meroDialog.findViewById(R.id.btnDislike);

                btnLike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MyDialogActivity.this,
                                "Ghumna jau na ta", Toast.LENGTH_SHORT).show();
                        meroDialog.dismiss();
                    }
                });

                meroDialog.show();


            }
        });

        Button btnShowDialog = findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo; write dialog box code here
                AlertDialog.Builder dialog = new AlertDialog.Builder(
                        MyDialogActivity.this);
                dialog.setCancelable(false);
                dialog.setTitle("Yo mero dialog ko title ho");
                dialog.setMessage("Aja hamro class ma ekjana tourist ako " +
                        "cha hindai hindai pani parera garo pareko cha");
                dialog.setPositiveButton("Ho Tourist ako cha", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //todo: tourist lai welcome dance garna lagau
                        Toast.makeText(MyDialogActivity.this,
                                "Tourist nachyo",
                                Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });
                dialog.setNegativeButton("Hawa guff", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog.setNeutralButton("Khoi tha chaina", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                dialog.show();
            }
        });

        Button btnCustomDialog = findViewById(R.id.btn_custom);
        btnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(MyDialogActivity.this);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.custom_dialog_box);

                Button like = dialog.findViewById(R.id.btnLike);
                Button dislike = dialog.findViewById(R.id.btnDislike);


                like.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MyDialogActivity.this, "Yeah, lets do it", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });

                dislike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MyDialogActivity.this, "Alchi ko poko", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });
    }
}