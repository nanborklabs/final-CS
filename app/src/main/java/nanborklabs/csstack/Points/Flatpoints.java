package nanborklabs.csstack.Points;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nanborklabs.csstack.R;
import nanborklabs.csstack.adapter.rv_adapter;

/**
 * Created by nandhu on 9/7/16.
 */
public class Flatpoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;



    public Flatpoints() {
        super();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        url_to_load=null;
        points_to_show=null;
        mAdapter=null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView=inflater.inflate(R.layout.points_showing,container,false);
        if (getArguments()==null){
            throw new NullPointerException("Arguments null");
        }
        else {
            //Arguments present , string array
            points_to_show=new ArrayList<>();
            points_to_show=getArguments().getStringArrayList("points");
            url_to_load=getArguments().getStringArrayList("url");

            mAdapter=new rv_adapter(points_to_show,this);
            loaded=true;
        }
        mRecyclerView=(RecyclerView)mView.findViewById(R.id.points_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (points_to_show == null) {
            points_to_show = new ArrayList<>();
            points_to_show = getArguments().getStringArrayList("points");
        }
        if (url_to_load == null) {

            url_to_load = getArguments().getStringArrayList("url");
        }
        if (mAdapter == null) {

            mAdapter = new rv_adapter(points_to_show, this);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (points_to_show == null) {
            points_to_show = new ArrayList<>();
            points_to_show = getArguments().getStringArrayList("points");
        }
        if (url_to_load == null) {

            url_to_load = getArguments().getStringArrayList("url");
        }
        if (mAdapter == null) {

            mAdapter = new rv_adapter(points_to_show, this);
        }
        loaded = true;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void point_clicked(int position) {

    }


    public static Fragment newInstance(int position) {

        Flatpoints frag=new Flatpoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0: points.add("Finite Automata (FA)");
                points.add("Deterministic Finite Automata (DFA)");
                points.add("Non-deterministic Finite Automata (NFA)");
                points.add("Epsilon transitions");
                points.add("Regular Expression");
                points.add("Pumping lemma");
                points.add("Equivalence and minimization"); url.add(0,"https://en.wikipedia.org/wiki/Automata_theory";);
                url.add(1,"https://en.wikipedia.org/wiki/Deterministic_finite_automaton";);
                url.add(2,"https://en.wikipedia.org/wiki/Nondeterministic_finite_automaton";);
                url.add(3,"https://en.wikipedia.org/wiki/Epsilon_transition";);
                url.add(4,"https://en.wikipedia.org/wiki/Regular_expression";);
                url.add(5,"https://en.wikipedia.org/wiki/Pumping_lemma";);
                url.add(6,"https://en.wikipedia.org/wiki/DFA_minimization";);

                break;
            case 1: points.add("Context-Free Grammar (CFG)");
                points.add("Parse Trees");
                points.add("- Normal forms for CFG");
                points.add("Pushdown\n" +
                        "automata");
                points.add("Pumping lemma for CFL"); url.add(0,);
                url.add(1,);
                url.add(2,);
                url.add(3,);
                url.add(4,);
                url.add(5,);
                url.add(6,);
//                todo:10 min
                url.add(7,);
                break;
            case 2: points.add("Closure properties");
                points.add("Turing Machines");
                points.add("Construction of TM's");
                break;
            case 3:  points.add("Recursively Enumerable");
                points.add("Undecidable problems");
                points.add("Rice theorem");
                points.add("Post’s Correspondence Problem."); url.add(0,);
                url.add(1,);
                url.add(2,);
                url.add(3,);
                //                todo:10 min
                url.add(4,);
                url.add(5,);
                url.add(6,);
                url.add(7,);
                break;
            case 4:  points.add("Matrix grammar");
                points.add("Programmed grammar");
                points.add("Random context grammar");
                points.add("Regular Control grammar");
                points.add("Lindenmayer systems");
                points.add("DNA computing and Membrane computing"); url.add(0,);
                url.add(1,);
                url.add(2,);
                url.add(3,);
                url.add(4,);
                //                todo:10 min
                url.add(5,);
                url.add(6,);
                url.add(7,);
                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}
