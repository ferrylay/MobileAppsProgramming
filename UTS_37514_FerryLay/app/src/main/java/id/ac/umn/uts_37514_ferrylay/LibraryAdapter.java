package id.ac.umn.uts_37514_ferrylay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder> {

    private LinkedList<SoundSource> mSoundList;
    private LayoutInflater mInflater;
    private Context mContext;

    public LibraryAdapter(Context context, LinkedList<SoundSource> soundList){
        this.mSoundList = soundList;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_sound, parent, false);
        return new LibraryViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SoundSource mSoundSource = mSoundList.get(position);
        holder.tvJudul.setText(mSoundSource.getJudul());
        holder.tvKeterangan.setText(mSoundSource.getKeterangan());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSoundList.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSoundList.size();
    }

    public class LibraryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView soundImg;
        private TextView tvJudul, tvKeterangan;
        private Button btnDelete;
        private int mPosisi;
        private SoundSource mSoundSource;
        private LibraryAdapter mAdapter;

        public LibraryViewHolder(@NonNull View itemView, LibraryAdapter adapter) {
            super(itemView);

            mAdapter = adapter;
            soundImg =(ImageView) itemView.findViewById(R.id.soundImg);
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            tvKeterangan = (TextView) itemView.findViewById(R.id.tvKeterangan);
            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            mPosisi = getLayoutPosition();
            mSoundSource = mSoundList.get(mPosisi);
            Intent detailIntent = new Intent(mContext, SoundDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("SoundDetail", mSoundSource);
            detailIntent.putExtras(bundle);
            String namaSound = tvJudul.getText().toString();
            detailIntent.putExtra("NamaSound", namaSound);
            mContext.startActivity(detailIntent);
        }
    }
}
