package martin.ferreira.beerandtechpatternsexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/*
    View has no instance of Model.
    All business logic sits in ViewModel.
    All communication with model is with via the ViewModel
    View binds to fields on the ViewModel

 */
public class MvvmActivity extends AppCompatActivity { //This is the view

    ExampleViewModel viewModel = new ExampleViewModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ExampleViewModel.class);
        rebind();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rebind();

            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        //TODO : EditText Live editing
        //TODO : ButterKnife
    }

    private void rebind() {
        ViewDataBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        viewDataBinding.setVariable(BR.viewModel, viewModel);
    }
}
