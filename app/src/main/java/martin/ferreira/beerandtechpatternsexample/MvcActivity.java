package martin.ferreira.beerandtechpatternsexample;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MvcActivity extends AppCompatActivity {

    MvcActivity.Controller controller = new MvcActivity.Controller(this);
    private EditText editName;
    private EditText editSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.updateView();

            }
        });

        Button btnUpdate = findViewById(R.id.btn_update);
        editName = findViewById(R.id.edit_name);
        editSurname = findViewById(R.id.edit_surname);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.update(editName.getText().toString(),editSurname.getText().toString());
            }
        });
        //TODO : EditText Live editing
        //TODO : ButterKnife
    }

    public void updateView(Model model) {
        final TextView name = findViewById(R.id.txt_name);
        final TextView surname = findViewById(R.id.txt_surname);
        name.setText(controller.getModel().getName());
        surname.setText(controller.getModel().getSurname());
    }

    private class Model {
        private String name = "Martin";
        private String surname = "Ferreira";

        public String getName(){
            return name;
        }

        public String getSurname(){
            return surname;
        }

        public void setSavedText(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }
    }

    private class Controller{

        private final MvcActivity view;
        private MvcActivity.Model model = new MvcActivity.Model();

        public Controller(MvcActivity view) {
            this.view = view;
        }

        public Model getModel(){
            return model;
        }

        public void update(String name, String surname) {
            model.setSavedText(name,surname);
        }

        public void updateView() {
            view.updateView(model);
        }
    }


}
