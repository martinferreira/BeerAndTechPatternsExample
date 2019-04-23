package martin.ferreira.beerandtechpatternsexample;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.lifecycle.ViewModel;

public class ExampleViewModel extends ViewModel {

    public Model model = new Model();

    public String getName(){
        return model.getName();
    }

    public String getSurname(){
        return model.getSurname();
    }

    public void setSavedText(String name, String surname) {
        model.setName(name);
        model.setSurname(surname);
    }

    public void setSavedText(View view){
        ViewGroup viewGroup = (ViewGroup) view.getParent();//Get the parent which will be the layout

        final EditText editName = viewGroup.findViewById(R.id.edit_name);
        final EditText editSurname = viewGroup.findViewById(R.id.edit_surname);

        if (editName.getText() != null && editSurname.getText() != null) {
            setSavedText(editName.getText().toString(), editSurname.getText().toString());
        }

    }

    public void refresh(View view){
        model.notifyChange();
    }
}
