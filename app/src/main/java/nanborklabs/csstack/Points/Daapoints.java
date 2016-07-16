package nanborklabs.csstack.Points;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import nanborklabs.csstack.R;
import nanborklabs.csstack.RecycelerviewDecorator;
import nanborklabs.csstack.RecyclerViewAnim;
import nanborklabs.csstack.UrLoad;
import nanborklabs.csstack.adapter.rv_adapter;

/**
 * Created by nandhu on 9/7/16.
 */
public class Daapoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;


    RecyclerView.ItemDecoration itemDecoration;
    public Daapoints() {
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
        mAdapter=null;callback=null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callback=(UrLoad)(getParentFragment().getContext());


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

            mAdapter=new rv_adapter(points_to_show,this,getContext());
            loaded=true;
        }

        mRecyclerView=(RecyclerView)mView.findViewById(R.id.points_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerViewAnim.startIntroAnim(mRecyclerView,getContext());
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

            mAdapter=new rv_adapter(points_to_show,this,getContext());
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            mRecyclerView.setAdapter(mAdapter);
        }

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();

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
        callback.loadUrl(url_to_load.get(position));
    }
    UrLoad callback;


    public static Fragment newInstance(int position) {

        Daapoints frag=new Daapoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0:  points.add("What is Algorithm?");
                points.add("Growth of Functions");
                points.add("Recurrence equations");
                points.add("Substitution Method");
                points.add("Maxima & minima");
                points.add("Strasses Matrix Multiplication");
                points.add("Convex Hull"); url.add(0,"https://en.wikipedia.org/wiki/Algorithm");
                url.add(1,"http://www.cs.odu.edu/~cs381/cs381content/function/growth.html");
                url.add(2,"http://www.radford.edu/~nokie/classes/360/recurrence.eqns.html");
                url.add(3,"https://en.wikipedia.org/wiki/Substitution_method");
                url.add(4,"https://en.wikipedia.org/wiki/Maxima_and_minima");
                url.add(5,"http://www.stoimen.com/blog/2012/11/26/computer-algorithms-strassens-matrix-multiplication/");
                url.add(6,"https://en.wikipedia.org/wiki/Convex_hull_algorithms");
//                url.add(7,);
                break;
            case 1:  points.add("Greedy Algorithm's");
                points.add("Knapsack Problem");
                points.add("Minimum Cost Spanning trees");
                points.add("Shortest Path Problem");
                points.add("Dynammic Programming");
                points.add("Principle of Optimality");
                points.add("All Pairs Problem");
                points.add("Longest Common SubSequence");
                points.add("Travelling Salesman Problem"); url.add(0,"https://en.wikipedia.org/wiki/Greedy_algorithm");
                url.add(1,"https://en.wikipedia.org/wiki/Knapsack_problem");
                url.add(2,"https://en.wikipedia.org/wiki/Minimum_spanning_tree");
                url.add(3,"https://en.wikipedia.org/wiki/Shortest_path_problem");
                url.add(4,"https://en.wikipedia.org/wiki/Dynamic_programming");
                url.add(5,"https://en.wikipedia.org/wiki/Bellman_equation");
                url.add(6,"https://en.wikipedia.org/wiki/Shortest_path_problem");
                url.add(7,"https://en.wikipedia.org/wiki/Longest_common_subsequence_problem");
                url.add(8,"https://en.wikipedia.org/wiki/Travelling_salesman_problem");
                break;
            case 2:  points.add("Backtracking");
                points.add("8 Queens problem");
                points.add("Graph Coloring");
                points.add("Sum of Subset problems");
                points.add("Hamiltonian Cycle");
                points.add("Branch & Bound"); url.add(0,"https://en.wikipedia.org/wiki/Backtracking");
                url.add(1,"https://en.wikipedia.org/wiki/Eight_queens_puzzle");
                url.add(2,"https://en.wikipedia.org/wiki/Graph_coloring");
                url.add(3,"https://en.wikipedia.org/wiki/Subset_sum_problem");
                url.add(4,"https://en.wikipedia.org/wiki/Hamiltonian_path");
                url.add(5,"https://en.wikipedia.org/wiki/Branch_and_bound");

                break;
            case 3: points.add("String Matching");
                points.add("KMP String Matching Algorithm");
                points.add("Prefix Computation");
                points.add("Multi Threaded Programming"); url.add(0,"https://www.hackerearth.com/notes/exact-string-matching-algorithms/");
                url.add(1,"https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm");
                url.add(2,"https://en.wikipedia.org/wiki/Prefix_sum");
//                url.add(3,);
//                // TODO:1min

                break;
            case 4:   points.add("NP Completeness");
                points.add("Polynomial Time Verification");
                points.add("Theory of Reduciblity");
                points.add("Circuit Satisfiablity");
                points.add("NP Completeness");
                points.add("Samples Problems of NP Completeness");
                points.add("Approximation Alogrithm"); url.add(0,"https://en.wikipedia.org/wiki/NP-completeness");
                url.add(1,"http://www.cs.ucr.edu/~michalis/COURSES/141/handouts/NP.html");
                url.add(2,"https://en.wikipedia.org/wiki/Reduction_(complexity)");
                url.add(3,"https://en.wikipedia.org/wiki/Circuit_satisfiability_problem");
                url.add(4,"https://en.wikipedia.org/wiki/NP-completeness");
                url.add(5,"https://en.wikipedia.org/wiki/List_of_NP-complete_problems");
                url.add(6,"https://en.wikipedia.org/wiki/Approximation_algorithm");


                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

