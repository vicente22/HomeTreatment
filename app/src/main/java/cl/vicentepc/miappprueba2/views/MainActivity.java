package cl.vicentepc.miappprueba2.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cl.vicentepc.miappprueba2.R;
import cl.vicentepc.miappprueba2.adapters.UsersAdapter;
import cl.vicentepc.miappprueba2.models.User;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextAboutMyAnnoyance;
    private EditText editTextHomeTreatment;
    private Button completeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextAboutMyAnnoyance = findViewById(R.id.editTextAboutMyAnnoyance);
        editTextHomeTreatment = findViewById(R.id.editTextHomeTreatment);

        completeBtn = findViewById(R.id.completeBtn);

        completeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextName.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "CAMPO NOMBRE ESTÁ VACÍO(*)", Toast.LENGTH_LONG).show();
                } else if (editTextAge.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "CAMPO EDAD ESTÁ VACÍO(*)", Toast.LENGTH_LONG).show();
                } else if (editTextAge.getText().toString().equals("00")) {
                    Toast.makeText(MainActivity.this, "TU EDAD DEBE SER MAYOR A 0", Toast.LENGTH_LONG).show();
                } else if (editTextAge.getText().toString().equals("0")) {
                    Toast.makeText(MainActivity.this, "TU EDAD DEBE SER MAYOR A 0", Toast.LENGTH_LONG).show();
                } else if (editTextAboutMyAnnoyance.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "CAMPO MALESTAR ESTÁ VACÍO(*)", Toast.LENGTH_LONG).show();
                } else if (editTextHomeTreatment.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "CAMPO TRATAMIENTO ESTÁ VACÍO(*)", Toast.LENGTH_LONG).show();
                } else {

                    String name = editTextName.getText().toString();
                    int age = Integer.parseInt(editTextAge.getText().toString());
                    String myAnnoyance = editTextAboutMyAnnoyance.getText().toString();
                    String homeTreatment = editTextHomeTreatment.getText().toString();

                    User user = new User();
                    user.setName(name);
                    user.setAge(age);
                    user.setAboutMyAnnoyance(myAnnoyance);
                    user.setHomeTreatment(homeTreatment);

                    user.save();

                    //User user = new User(name, age, myAnnoyance, homeTreatment);
                    //user.save();

                    Toast.makeText(MainActivity.this, "Tratamiento guardado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, ResultDataActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("age", age);
                    intent.putExtra("myAnnoyance", myAnnoyance);
                    intent.putExtra("homeTreatment", homeTreatment);
                    startActivity(intent);
                }

            }
        });

    }


}
