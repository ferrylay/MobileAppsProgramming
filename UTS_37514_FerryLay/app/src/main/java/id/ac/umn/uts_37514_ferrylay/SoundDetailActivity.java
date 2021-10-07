package id.ac.umn.uts_37514_ferrylay;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SoundDetailActivity extends AppCompatActivity {

    private Button btnPlay;
    private TextView tvJudul, tvKeterangan;
    private ImageView soundDetail;

    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounddetail);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        tvJudul = (TextView) findViewById(R.id.etJudul);
        tvKeterangan = (TextView) findViewById(R.id.etKeterangan);
        soundDetail = (ImageView) findViewById(R.id.soundDetail);

        Intent detailIntent = getIntent();
        Bundle bundle = detailIntent.getExtras();
        SoundSource ss =(SoundSource) bundle.getSerializable("SoundDetail");

        String judul = detailIntent.getStringExtra("NamaSound");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(judul);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvJudul.setText(ss.getJudul());
        tvKeterangan.setText(ss.getKeterangan());

        btnPlay.setOnClickListener(v -> {
            try{
                mp = MediaPlayer.create(SoundDetailActivity.this, ss.getSoundURI());
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

                mp.setOnPreparedListener(mp -> mp.start());

            } catch (Exception e){
                e.printStackTrace();
                if(mp != null){
                    mp.release();
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        mp.stop();
        mp.release();
        return true;
    }
}
