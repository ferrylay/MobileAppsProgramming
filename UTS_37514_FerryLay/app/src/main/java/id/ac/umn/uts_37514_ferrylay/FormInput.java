package id.ac.umn.uts_37514_ferrylay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormInput extends Activity {

    EditText name;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_form);

        name = (EditText) findViewById(R.id.name);
        nextBtn = (Button) findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(name.getText())){
                    name.setError("Harap Di-isi!");
                } else{
                    Intent intentLibrary = new Intent(FormInput.this, Library.class);
                    String user = name.getText().toString();
                    intentLibrary.putExtra("Nama", user);
                    startActivity(intentLibrary);
                }
            }
        });
    }
}
