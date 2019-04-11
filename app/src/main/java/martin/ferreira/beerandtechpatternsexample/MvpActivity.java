package martin.ferreira.beerandtechpatternsexample;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/*
    View has no instance of Model.
    All business logic sits in presenter.
    All communication with model is with via the presenter

 */
public class MvpActivity extends AppCompatActivity { //This is the view

    Presenter presenter = new Presenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        final TextView  name = findViewById(R.id.txt_name);
        final TextView surname = findViewById(R.id.txt_surname);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(presenter.getName());
                surname.setText(presenter.getSurname());
            }
        });

        Button btnUpdate = findViewById(R.id.btn_update);
        final EditText editName = findViewById(R.id.edit_name);
        final EditText editSurname = findViewById(R.id.edit_surname);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setSavedText(editName.getText().toString(),editSurname.getText().toString());

            }
        });
        //TODO : EditText Live editing
        //TODO : ButterKnife
    }

    private class Presenter{

        private class Model {
            private String name = "Martin";
            private String surname = "Ferreira";
        }

        private Model model = new Model();

        public String getName(){
            return model.name;
        }

        public String getSurname(){
            return model.surname;
        }

        public void setSavedText(String name, String surname) {
            model.name = name;
            model.surname = surname;
        }

    }
}
