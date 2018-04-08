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
    private Context ctx;

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

    public FighterRecyclerViewAdapter(Context ctx, List<Fighter> fighters) {
        this.fighters = fighters;
        this.ctx = ctx;
    }

    @Override
    public FighterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fighter_item, parent, false);
        return new FighterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FighterViewHolder holder, int position) {
        Fighter f = fighters.get(position);

        System.out.println("----position : " + position);
        holder.fighterTypeView.setText(f.getFighterType());
        holder.fighterImageView.setImageDrawable(f.getFighterImage());
        holder.fighterTypeView.setText(f.getPilot());
    }

    @Override
    public int getItemCount() {
        return fighters.size();
    }
}
