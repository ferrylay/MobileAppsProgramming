package id.ac.umn.uts_37514_ferrylay;

import android.net.Uri;

import java.io.Serializable;

public class SoundSource implements Serializable {
    private String judul, keterangan, soundURI;

    public SoundSource(String judul, String keterangan, String soundURI){
        this.judul = judul;
        this.keterangan = keterangan;
        this.soundURI = soundURI;
    }

    public void setJudul(String judul){this.judul = judul;}
    public void setKeterangan(String keterangan){this.keterangan = keterangan;}
    public void setSoundURI(String soundURI){this.soundURI = soundURI;}
    public String toString(){return this.getJudul() + " => " + this.getKeterangan();}

    public String getJudul(){return this.judul;}
    public String getKeterangan(){return this.keterangan;}
    public Uri getSoundURI(){return Uri.parse(this.soundURI);}
}
