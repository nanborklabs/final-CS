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
public class SEpoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;

    RecyclerView.ItemDecoration itemDecoration;

    public SEpoints() {
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
    public void point_clicked(View v,int position) {
        callback.loadUrl(url_to_load.get(position));
    }
    UrLoad callback;

    public static Fragment newInstance(int position) {

        SEpoints frag=new SEpoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0: points.add("Rise of Software");
                points.add("Legacy Software");
                points.add("Generic View of Process");
                points.add("Capability Maturity Model");
                points.add("Waterfall Model");
                points.add("Incremental Process Model");
                points.add("The RAD Model");
                points.add("Sprial Model");
                points.add("Unified Process Model");
                url.add(0,"https://en.wikipedia.org/wiki/Software#Industry_and_organizations");
                url.add(1,"https://en.wikipedia.org/wiki/Legacy_system");
                url.add(2,"https://en.wikipedia.org/wiki/Software_development_process");
                url.add(3,"https://en.wikipedia.org/wiki/Capability_Maturity_Model");
                url.add(4,"https://en.wikipedia.org/wiki/Waterfall_model");
                url.add(5,"https://en.wikipedia.org/wiki/Incremental_build_model");
                url.add(6,"https://en.wikipedia.org/wiki/Rapid_application_development");
                url.add(7,"https://en.wikipedia.org/wiki/Spiral_model");
                url.add(8,"https://en.wikipedia.org/wiki/Unified_Process");
                break;
            case 1:  points.add("Planning & Modelling Practice");
                points.add("Construction Practice");
                points.add("Deployment");

                points.add("Requirements Engineering");
                points.add("Use case Development");
                points.add("Validating Requirements");
                url.add(0,"https://en.wikipedia.org/wiki/Software_development#Planning");
                url.add(1,"https://en.wikipedia.org/wiki/Software_construction");
                url.add(2,"https://en.wikipedia.org/wiki/Software_deployment");

                url.add(3,"https://en.wikipedia.org/wiki/Requirements_engineering");
                url.add(4,"https://en.wikipedia.org/wiki/Use-case_analysis");
                url.add(5,"https://en.wikipedia.org/wiki/Software_verification_and_validation");


                break;
            case 2:   points.add("Requirement Analysis");
                points.add("Analysis Modeling Approaches");
                points.add("Scenario Based Modeling");
                points.add("Flow Oriented Modeling");
                points.add("Class Based Modeling");
                points.add("creating a Behaviour Model");
                url.add(0,"https://en.wikipedia.org/wiki/Requirements_analysis");
                url.add(1,"https://en.wikipedia.org/wiki/Software_analysis_pattern");;
                url.add(2,"https://en.wikipedia.org/wiki/Scenario_(computing)");
                url.add(3,"https://en.wikipedia.org/wiki/Flow-based_programming");
                url.add(4,"https://en.wikipedia.org/wiki/Class-based_programming");
                url.add(5,"https://en.wikipedia.org/wiki/Behavioral_modeling");



                break;
            case 3:
                points.add("Design Engineering");
                points.add("Design Process");
                points.add("UI design");

                points.add("Testing Strategies");
                points.add("Validation Testing");
                points.add("System Testing");

                points.add("Art of Debugging");
                points.add("Project Management");
                url.add(0,"https://en.wikipedia.org/wiki/Design_engineer");
                url.add(1,"https://en.wikipedia.org/wiki/Design_process_(computing)");
                url.add(2,"https://en.wikipedia.org/wiki/User_interface_design");

                url.add(3,"https://en.wikipedia.org/wiki/Test_strategy");
                url.add(4,"https://en.wikipedia.org/wiki/Acceptance_testing");
                url.add(5,"https://en.wikipedia.org/wiki/System_testing");

                url.add(6,"https://en.wikipedia.org/wiki/Debugging");
                url.add(7,"https://en.wikipedia.org/wiki/Project_management");

                break;
            case 4:points.add("Software Evolution");
                points.add("Verification and Validation");
                points.add("Product-Quality Management");

                points.add("Process Improvement");
                points.add("Risk Management-");
                points.add("Configuration Management");
                points.add("Software Cost Estimation");
                url.add(0,"https://en.wikipedia.org/wiki/Software_evolution");
                url.add(1,"https://en.wikipedia.org/wiki/Software_verification_and_validation");
                url.add(2,"https://en.wikipedia.org/wiki/Quality_management");

                url.add(3,"https://en.wikipedia.org/wiki/Business_process_improvement");
                url.add(4,"https://en.wikipedia.org/wiki/Risk_management");
                url.add(5,"https://en.wikipedia.org/wiki/Configuration_management");

                url.add(6,"https://en.wikipedia.org/wiki/Cost_estimation_in_software_engineering");
                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

