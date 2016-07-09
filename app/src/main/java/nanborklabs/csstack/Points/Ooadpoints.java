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
public class Ooadpoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;



    public Ooadpoints() {
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

        Ooadpoints frag=new Ooadpoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0:  points.add("Introduction");
                points.add("Object basics");
                points.add("Modeling concepts");

                points.add("UML diagrams");
                points.add("Use case Modeling");

                points.add("State modeling");
                points.add("Interaction Modeling");
                url.add(0,"https://en.wikipedia.org/wiki/Object-oriented_analysis_and_design";);
                url.add(1,"https://en.wikipedia.org/wiki/Object_(computer_science)";);
                url.add(2,"https://en.wikipedia.org/wiki/Object_model";);
                url.add(3,"https://en.wikipedia.org/wiki/Unified_Modeling_Language";);
                url.add(4,"https://en.wikipedia.org/wiki/Use_case";);
                url.add(5,"https://en.wikipedia.org/wiki/State_diagram_(UML)";);
                url.add(6,"https://en.wikipedia.org/wiki/Interaction_model");


                break;
            case 1:   points.add("Object Constraint Language");
                points.add("Evolutionary Requirements");
                points.add("Domain Models");

                points.add("Sequence Diagrams");
                points.add("Operation Contracts");
                url.add(0,"https://en.wikipedia.org/wiki/Object_Constraint_Language";);
                url.add(1,);
//                todo:1 in
                url.add(2,"https://en.wikipedia.org/wiki/Domain_model";);
                url.add(3,"https://en.wikipedia.org/wiki/Sequence_diagram";);
                url.add(4,"https://en.wikipedia.org/wiki/Design_by_contract";);
                url.add(5,);
                url.add(6,);
                url.add(7,);

                break;
            case 2:   points.add("Design Patterns");
                points.add("Logical Architecture");
                points.add("Package diagram");
                points.add("Design patterns");
                points.add("Model, View, Control pattern");
                points.add("Detailed design");
                points.add("Object design with GRASP pattern");
                points.add("class diagram");
                url.add(0,"https://en.wikipedia.org/wiki/Design_pattern";);
                url.add(1,"https://en.wikipedia.org/wiki/Multilayered_architecture";);
                url.add(2,"https://en.wikipedia.org/wiki/Package_diagram";);
                url.add(3,"https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller";);
                url.add(4,"https://en.wikipedia.org/wiki/Software_design_description";);
                url.add(5,"https://en.wikipedia.org/wiki/GRASP_(object-oriented_design)";);
                url.add(6,"https://en.wikipedia.org/wiki/Class_diagram");

                break;
            case 3:  points.add("designs to code");
                points.add("Test Driven development");
                points.add("refactoring");
                points.add("UML Tools");
                url.add(0,);
//                todo:1 min
                url.add(1,"https://en.wikipedia.org/wiki/Test-driven_development";);
                url.add(2,"https://en.wikipedia.org/wiki/Code_refactoring";);
                url.add(3,"https://en.wikipedia.org/wiki/UML_tool";);


                break;
            case 4:  points.add("Analysis update");
                points.add("Objects with responsibilities");
                points.add("Applying design patterns");
                points.add("Architectural Analysis");
                points.add("Architecture Refinement");
                points.add("Package Design");
                points.add("Persistence framework with patterns.");
                url.add(0,"https://en.wikipedia.org/wiki/Static_program_analysis";);
                url.add(1,"http://stackoverflow.com/questions/3698594/how-do-you-apply-design-patterns";);
                url.add(2,);
//                todo:5 min
                url.add(3,);
                url.add(4,);
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


