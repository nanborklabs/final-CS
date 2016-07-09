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
public class Parallelpoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;



    public Parallelpoints() {
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

        Parallelpoints frag=new Parallelpoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0: points.add("Parallel Computer Models");
                points.add("ILP, TLP and Data Parallelism");
                points.add("Processes, Tasks and Threads"); url.add(0,"https://en.wikipedia.org/wiki/Parallel_computing";);
                url.add(1,"https://en.wikipedia.org/wiki/Data_parallelism";);
                url.add(2,"http://stackoverflow.com/questions/3042717/what-is-the-diff-between-a-thread-process-task";);
                url.add(3,"https://computing.llnl.gov/tutorials/parallel_comp/";);
                url.add(4,"https://en.wikipedia.org/wiki/Message_Passing_Interface";);
                url.add(5,"https://en.wikipedia.org/wiki/Multistage_interconnection_networks";);
//               todo:check here 2 url exist

                points.add("Shared Memory Programming");
                points.add("Message Passing Paradigm");
                points.add("Interconnection Networks"); url.add(0,);
                url.add(1,);
                url.add(2,);
                url.add(3,);
                url.add(4,);
                url.add(5,);
                url.add(6,);
                url.add(7,);
                break;
            case 1:  points.add("Techniques for Parallelizing Programs");
                points.add("Issues");
                points.add("Cache coherency");

                points.add("Memory Consistency Models");
                points.add("Eventual Consistency");
                points.add("Synchronization"); url.add(0,"https://en.wikipedia.org/wiki/Parallel_computing#Algorithmic_methods";);
                url.add(1,"https://en.wikipedia.org/wiki/Parallel_computing#Race_conditions.2C_mutual_exclusion.2C_synchronization.2C_and_parallel_slowdownc";);
                url.add(2,"https://en.wikipedia.org/wiki/Cache_coherence";);
                url.add(3,"https://en.wikipedia.org/wiki/Consistency_modele";);
                url.add(4,"https://en.wikipedia.org/wiki/Eventual_consistency";);
                url.add(5,"https://en.wikipedia.org/wiki/Synchronization_(computer_science)";);

                break;
            case 2:   points.add("OpenMP Execution Model");
                points.add("Memory Model and Consistency");
                points.add("Run Time Library Routines");
                points.add("Performance Considertions");
                url.add(0,"https://en.wikipedia.org/wiki/OpenMP";);
                url.add(1,"https://en.wikipedia.org/wiki/Consistency_model";);
                url.add(2,"https://en.wikipedia.org/wiki/Library_(computing)";);
                url.add(3,"https://computing.llnl.gov/tutorials/parallel_comp/#DesignPerformance";);
                break;
            case 3: points.add("The MPI Programming Model");
                points.add("Circuit Satisfiability");
                points.add("Asynchronous Communication");
                url.add(0,"https://en.wikipedia.org/wiki/Message_Passing_Interface#Concepts";);
                url.add(1,"https://en.wikipedia.org/wiki/Circuit_satisfiability_problem";);
                url.add(2,"https://en.wikipedia.org/wiki/Asynchronous_communication";);


                break;
            case 4: points.add("GPU Architecture");
                points.add("Basics of CUDA");
                points.add("CUDA Threads");

                points.add("CUDA Memories");
                points.add("CUDA Programming"); url.add(0,"https://en.wikipedia.org/wiki/Graphics_processing_unit";);
                url.add(1,"https://en.wikipedia.org/wiki/CUDA";);
                url.add(2,"http://stackoverflow.com/questions/2392250/understanding-cuda-grid-dimensions-block-dimensions-and-threads-organization-s";);
                url.add(3,"https://www.pgroup.com/lit/articles/insider/v2n1a5.htm";);
                url.add(4,"http://docs.nvidia.com/cuda/cuda-c-programming-guide/#programming-model";);

                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

