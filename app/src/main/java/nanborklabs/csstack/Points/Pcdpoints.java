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
import nanborklabs.csstack.UrLoad;
import nanborklabs.csstack.adapter.rv_adapter;

/**
 * Created by nandhu on 9/7/16.
 */
public class Pcdpoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    UrLoad callback;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;

    RecyclerView.ItemDecoration itemDecoration;

    public Pcdpoints() {
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
        itemDecoration=new RecycelerviewDecorator(ContextCompat.getDrawable(getContext(),R.drawable.divider));
        mRecyclerView.addItemDecoration(itemDecoration);
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

            mAdapter=new rv_adapter(points_to_show,this,getContext());
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
        callback.loadUrl(url_to_load.get(position));
    }


    public static Fragment newInstance(int position) {

        Pcdpoints frag=new Pcdpoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0:points.add("Compilers-Intro");
                points.add("Lexical Analysis");
                points.add("Tokens");

                points.add("Syntax Analysis/Parsing");

                points.add("Types of Parsers"); url.add(0,"https://en.wikipedia.org/wiki/Compiler");
                url.add(1,"https://en.wikipedia.org/wiki/Lexical_analysis");
                url.add(2,"https://en.wikipedia.org/wiki/Lexical_analysis#Tokens");
                url.add(3,"https://en.wikipedia.org/wiki/Parsing");
                url.add(4,"https://en.wikipedia.org/wiki/Parsing#Types_of_parsers");

                break;
            case 1:  points.add("Syntax Directed Definition");
                points.add("Translation schemes");
                points.add("Three Address codes");

                points.add("Syntax tree");
                points.add("postfix code");
                points.add("Type checking");

                points.add("Back patching");
                url.add(0,"https://en.wikipedia.org/wiki/Syntax-directed_translatione");
                url.add(1,"http://www.csd.uwo.ca/~moreno//CS447/Lectures/Translation.html/node3.html");
                url.add(2,"https://en.wikipedia.org/wiki/Three-address_code");
                url.add(3,"https://en.wikipedia.org/wiki/Abstract_syntax_tree");
                url.add(4,"https://en.wikipedia.org/wiki/Reverse_Polish_notation");
                url.add(5,"https://en.wikipedia.org/wiki/Type_checking");
                url.add(6,"http://www.csd.uwo.ca/~moreno//CS447/Lectures/IntermediateCode.html/node7.html");
//                url.add(7,);
                break;
            case 2:  points.add("Storage organization");
                points.add("Stack allocation space");
                points.add("Heap Memory");
                points.add("Design of code gnenrator");
                points.add("Register Managment");
                points.add("Tree rewriting");
                points.add("Optimal code Generation");
                points.add("Dynammic Programming"); url.add(0,"https://en.wikipedia.org/wiki/Static_memory_allocation");
                url.add(1,"https://en.wikipedia.org/wiki/Stack-based_memory_allocation");
                url.add(2,"http://gribblelab.org/CBootcamp/7_Memory_Stack_vs_Heap.html");
                url.add(3,"https://en.wikipedia.org/wiki/Code_generation_(compiler)");
                url.add(4,"https://en.wikipedia.org/wiki/Register_allocation");
                url.add(5,"https://en.wikipedia.org/wiki/Tree_rearrangement");
                url.add(6,"https://en.wikipedia.org/wiki/Optimizing_compiler");
                url.add(7,"https://en.wikipedia.org/wiki/Dynamic_programming");
                break;
            case 3:   points.add("Blocks & Flow Graphs");
                //  points.add("ptimisation of locks");
                //TODO: optimisation titles check
                //  points.add("Principles sources of optimsation");

                points.add("Data Flow analysis");
                points.add("Constant Propogation");
                points.add("partial Redundancy Elimination");

                points.add("Peephole optimisation");
//
                 url.add(0,"https://en.wikipedia.org/wiki/Control_flow_graph" );
                url.add(1,"www.google.com");
//                todo:1min
                url.add(2,"https://en.wikipedia.org/wiki/Data-flow_analysis");
                url.add(3,"https://en.wikipedia.org/wiki/Constant_folding");
                url.add(4,"https://en.wikipedia.org/wiki/Partial_redundancy_elimination");
                url.add(5,"https://en.wikipedia.org/wiki/Peephole_optimization");

                break;
            case 4: points.add("Iteration spaces");
                points.add("Affine array Index");
                points.add("Data reuse");
                points.add("Array Data dependence");
                points.add("Synchronisation free parallelism");
                points.add("Locality optimisation"); url.add(0,"https://www.cs.cmu.edu/~tcm/thesis/subsection2_7_3_3.html");
                url.add(1,"https://en.wikipedia.org/wiki/Loop_optimization");
                url.add(2,"https://www.cs.umd.edu/projects/omega/sectionstar3_1.html");
//                url.add(3,);
//                todo:2min
//                url.add(4,"https://en.wikipedia.org/wiki/Locality_of_reference");
//                url.add(5,);
//                url.add(6,);
//                url.add(7,);
                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

