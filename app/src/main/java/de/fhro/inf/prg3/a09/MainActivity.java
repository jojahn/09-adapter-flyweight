package de.fhro.inf.prg3.a09;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import de.fhro.inf.prg3.a09.adapter.FighterRecyclerViewAdapter;
import de.fhro.inf.prg3.a09.model.Fighter;
import de.fhro.inf.prg3.a09.model.FighterFactory;
import de.fhro.inf.prg3.a09.adapter.FighterListAdapter;

public class MainActivity extends AppCompatActivity {
    private List<Fighter> fighterList;
    public static long START_TIME = System.currentTimeMillis();
    long endTime;

    private static final int FIGHTER_COUNT = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*FighterFactory fighterFactory = new FighterFactory(this);
        FighterListAdapter fighterListAdapter = new FighterListAdapter(this);

        final ListView fighterListView = findViewById(R.id.fighter_list_view);
        fighterListView.setAdapter(fighterListAdapter);

        for (int i = 0; i < FIGHTER_COUNT; i++) {
            fighterListAdapter.add(fighterFactory.createFighter());
        }*/

        FighterFactory fighterFactory = new FighterFactory(this);
        fighterList = new ArrayList<>(FIGHTER_COUNT);

        RecyclerView mRecyclerView = findViewById(R.id.fighterListView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < FIGHTER_COUNT; i++) {
            fighterList.add(fighterFactory.createFighter());
        }

        // specify an adapter (see also next example)
        RecyclerView.Adapter mAdapter = new FighterRecyclerViewAdapter(this, fighterList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
