package martin.ferreira.beerandtechpatternsexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AntiPatternActivity extends AppCompatActivity {

    //no seperations of concerns
    private String nameVariable= "Martin";
    private String surnameVariable = "Ferreira";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        final TextView name = findViewById(R.id.txt_name);
        final TextView surname = findViewById(R.id.txt_surname);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(nameVariable);
                surname.setText(surnameVariable);
            }
        });

        Button btnUpdate = findViewById(R.id.btn_update);
        final EditText editName = findViewById(R.id.edit_name);
        final EditText editSurname = findViewById(R.id.edit_surname);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameVariable= editName.getText().toString();
                surnameVariable = editSurname.getText().toString();

            }
        });
        //TODO : EditText Live editing
        //TODO : ButterKnife
    }
}
