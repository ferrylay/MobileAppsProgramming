package id.ac.umn.uts_37514_ferrylay;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class Library extends AppCompatActivity {
    RecyclerView rvSoundList;
    LibraryAdapter mAdapter;
    LinkedList<SoundSource> soundList = new LinkedList<>();
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Intent mainIntent = getIntent();
        String login = mainIntent.getStringExtra("Nama");

        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(login);

        Toast.makeText(Library.this,"Selamat Datang, " + login, Toast.LENGTH_LONG).show();

        isiSoundList();
        rvSoundList = (RecyclerView) findViewById(R.id.RV);
        mAdapter = new LibraryAdapter(this, soundList);
        rvSoundList.setAdapter(mAdapter);
        rvSoundList.setLayoutManager(new LinearLayoutManager(this));

        btnDelete = (Button) findViewById(R.id.btnDelete);
    }

    public void isiSoundList(){
        soundList.add(new SoundSource("Door Bell", "Door Bell Sound", "android.resource://" + getPackageName() + "/" + R.raw.doorbell));
        soundList.add(new SoundSource("Honk", "Honk Sound", "android.resource://" + getPackageName() + "/" + R.raw.honk));
        soundList.add(new SoundSource("Sunstrike", "Game Sound", "android.resource://" + getPackageName() + "/" + R.raw.sunstrike));
        soundList.add(new SoundSource("Tuturu~", "Notification Sound", "android.resource://" + getPackageName() + "/" + R.raw.tuturu));
        soundList.add(new SoundSource("Whistle", "Whistling Sound", "android.resource://" + getPackageName() + "/" + R.raw.whistle));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_profile) {
            Intent profileIntent = new Intent(Library.this, Profile.class);
            startActivity(profileIntent);
        } else{
            Intent homeIntent = new Intent(Library.this, MainActivity.class);
            startActivity(homeIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
