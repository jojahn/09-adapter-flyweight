package de.fhro.inf.prg3.a09.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import de.fhro.inf.prg3.a09.MainActivity;
import de.fhro.inf.prg3.a09.R;
import de.fhro.inf.prg3.a09.model.Fighter;

/**
 * Created by jonas on 06/12/17.
 */

public class FighterRecyclerViewAdapter extends RecyclerView.Adapter<FighterRecyclerViewAdapter.FighterViewHolder> {

    private List<Fighter> fighters;
    LayoutInflater inflater;

    public static class FighterViewHolder extends RecyclerView.ViewHolder {
        private TextView pilotNameView;
        private TextView fighterTypeView;
        private ImageView fighterImageView;

        FighterViewHolder(View view) {
            super(view);
            pilotNameView = view.findViewById(R.id.pilotNameView);
            fighterTypeView = view.findViewById(R.id.fighterTypeView);
            fighterImageView = view.findViewById(R.id.fighterImageView);
        }

        void setPilot(String pilot){
            pilotNameView.setText(pilot);
        }

        void setFighterType(String fighterType){
            fighterTypeView.setText(fighterType);
        }

        void setFighterImage(Drawable fighterImage){
            fighterImageView.setImageDrawable(fighterImage);
        }
    }

    public FighterRecyclerViewAdapter(List<Fighter> fighters) {
        this.fighters = fighters;
    }

    @Override
    public FighterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fighter_item, parent, false);
        FighterViewHolder fvh = new FighterViewHolder(v);
        return fvh;
    }

    @Override
    public void onBindViewHolder(FighterViewHolder holder, int position) {
        System.out.println("----position : " + position);
        holder.fighterTypeView.setText(fighters.get(position).getFighterType());
        holder.fighterImageView.setImageDrawable(fighters.get(position).getFighterImage());
        holder.fighterTypeView.setText(fighters.get(position).getPilot());
    }

    @Override
    public int getItemCount() {
        return fighters.size();
    }
}
