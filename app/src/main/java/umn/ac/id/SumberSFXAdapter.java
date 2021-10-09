package umn.ac.id;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class SumberSFXAdapter extends RecyclerView.Adapter<SumberSFXAdapter.ItemAudioViewHolder>{
    private LinkedList<SumberSFX> sfxList;
    private LayoutInflater audioInflater;
    private Context audioContext;

    public SumberSFXAdapter(Context audioContext, LinkedList<SumberSFX> sfxList){
        this.audioContext = audioContext;
        this.sfxList = sfxList;
        this.audioInflater = LayoutInflater.from(audioContext);
    }

    @Override
    public ItemAudioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = audioInflater.inflate(R.layout.sfx_library_layout , parent , false);
        return new ItemAudioViewHolder(view, this);
    }

    public void onBindViewHolder( ItemAudioViewHolder holder, int position) {
        SumberSFX sumberSFXs = sfxList.get(position);
        holder.judulsfx.setText(sumberSFXs.getJudulsfx());
        holder.genresfx.setText(sumberSFXs.getGenresfx());
    }


    @Override
    public int getItemCount() {
        return sfxList.size();
    }

    class ItemAudioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView delete;
        private TextView judulsfx;
        private TextView genresfx;
        private SumberSFXAdapter sfxAdapter;

        private SumberSFX sumberSFX;
        private int position;

        public ItemAudioViewHolder(View itemView, SumberSFXAdapter adapter) {
            super(itemView);
            delete = (ImageView) itemView.findViewById(R.id.deleteBtn);
            sfxAdapter = adapter;

            judulsfx = (TextView) itemView.findViewById(R.id.judulfx);
            genresfx = (TextView) itemView.findViewById(R.id.genresfx);
            itemView.setOnClickListener(this);



            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    sfxList.remove(getLayoutPosition());
                    notifyItemRemoved(getLayoutPosition());
                    notifyItemRangeChanged(getLayoutPosition(),sfxList.size());

                }
            });
        }

        public void onClick(View v) {
            position = getLayoutPosition();
            sumberSFX = sfxList.get(position);
            Intent goToDetail = new Intent(audioContext, DetailSFX.class);

            Bundle bundleSFX = new Bundle();
            bundleSFX.putSerializable("DetailSFX",sumberSFX);
            goToDetail.putExtras(bundleSFX);

            audioContext.startActivity(goToDetail);
        }
    }
}
