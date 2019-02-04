package com.rappi.movies.data.network;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rappi.movies.R;
import com.rappi.movies.data.entities.Program;
import com.rappi.movies.data.persistence.LocalStorage;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Program> programs;

    private OnItemClicked onClick;


    public RecyclerAdapter(List<Program> programs) {
        this.programs = programs;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Program program = programs.get(i);
        if(program.getPoster_path()==null){
            viewHolder.movieImage.setImageResource(R.drawable.incognita);
            viewHolder.movieImage.setAdjustViewBounds(true);
        } else{
            Picasso.get().load(LocalStorage.IMGS_URL + program.getPoster_path()).into(viewHolder.movieImage);
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(i);
            }
        });
    }

    public void setOnClick(OnItemClicked onClick) {
        this.onClick = onClick;
    }

    @Override
    public int getItemCount() {
        return programs == null ? 0: programs.size();
    }

    public interface OnItemClicked {
        void onItemClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView movieImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.item_image);
        }
    }
}
