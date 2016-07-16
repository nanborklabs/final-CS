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
public class Ospoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;

    RecyclerView.ItemDecoration itemDecoration;

    public Ospoints() {
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

        Ospoints frag=new Ospoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0:  points.add("Introduction to operating systems");
                points.add("Computer system organization, architecture");
                points.add("Operating system structure");
                points.add("Protection and Security");
                points.add("Distributed systems");
                points.add("Computing Environments");
                points.add("Open-source operating systems");
                points.add("System calls");
                points.add("Types");
                points.add("Software System");
                url.add(0,"https://en.wikipedia.org/wiki/Operating_system");
                url.add(1,"https://en.wikipedia.org/wiki/Computer_architecture");
                url.add(2,"http://faculty.salina.k-state.edu/tim/ossg/Introduction/struct.html");
                url.add(3,"https://en.wikipedia.org/wiki/Distributed_operating_system");
                url.add(4,"https://en.wikipedia.org/wiki/Open-source_software");
                url.add(5,"https://en.wikipedia.org/wiki/System_call");
                url.add(6,"https://en.wikipedia.org/wiki/Operating_system#Types_of_operating_systems");
                url.add(7,"https://en.wikipedia.org/wiki/Software_system");
                url.add(8,"https://en.wikipedia.org/wiki/Booting");
             url.add(9,"https://en.wikipedia.org/wiki/Booting");//todo:2 ooting,,, 10 min;
                url.add(10,"https://en.wikipedia.org/wiki/Booting");
//                url.add(11,);




                points.add("System Boot");
                points.add("OS generation");
                points.add("Process concept");
                points.add("Cooperating processes");
                points.add("Inter-process communication");
                points.add("Multithreading models");
                points.add("Thread Libraries");
                  /*
                url.add(0,);
                url.add(1,);
                url.add(2,);
                url.add(3,);
                url.add(4,);
                url.add(5,);
                url.add(6,);
                url.add(7,);
                url.add(8,);
                url.add(9,);
                url.add(10,);
                url.add(11,);
                */
                break;
            case 1:  points.add("Basic concepts");
                points.add("Scheduling criteria");
                points.add("Scheduling algorithms");
                points.add("Thread scheduling");
                points.add("Multiple processor scheduling");
                points.add("Operating system examples");
                points.add("The critical section problem");
                points.add("Synchronization hardware");
                points.add("Synchronization hardware");
                points.add("Semaphore");
                points.add("Classic problems of synchronization");
                points.add("Critical regions");
                points.add("Monitors");
                points.add("Synchronization examples");
                points.add("Deadlocks");
                points.add("Deadlock Prevention");
                points.add("Deadlock Avoidance");
                points.add("Deadlock detection");
                points.add("Recovery from deadlock");
//                todo:10min

                url.add(0,"www");
                /*
                url.add(1,);
                url.add(2,);
                url.add(3,);
                url.add(4,);
                url.add(5,);
                url.add(6,);
                url.add(7,);
                url.add(8,);
                url.add(9,);
                url.add(10,);
                url.add(11,);
                */
                break;
            case 2: points.add("Memory Management");
                points.add("Swapping");
                points.add("Contiguous memory allocation");
                points.add("Paging");
                points.add("Segmentation");
                points.add("Virtual Memor");
                points.add("Demand paging");
                points.add("Copy on Write");
                points.add("Page replacement");
                points.add("Thrashing.");
                points.add("Allocation of frames");
//                todo:10min
                url.add(0,"www");
                /*
                url.add(1,);
                url.add(2,);
                url.add(3,);
                url.add(4,);
                url.add(5,);
                url.add(6,);
                url.add(7,);
                url.add(8,);
                url.add(9,);
                url.add(10,);
                url.add(11,);
                */
                break;
            case 3:  points.add("File concept");
                points.add("Access methods");
                points.add("Directory structure");
                points.add("File-system mounting");
                points.add("Protection");
                points.add("Directory implementation");
                points.add("Allocation methods");
                points.add("Free-space management");
                points.add("Disk scheduling");
                points.add("Swap-space");
                url.add(0,"www");
                /*
                url.add(1,);
                url.add(2,);
                url.add(3,);
                url.add(4,);
                url.add(5,);
                url.add(6,);
                url.add(7,);
                url.add(8,);
                url.add(9,);
                url.add(10,);
                url.add(11,);
                */
                break;
            case 4:   points.add("The Linux System");
                points.add("Design Principles");
                points.add("Kernel Modules");
                points.add("Process Management");
                points.add("Memory management");
                points.add("File systems");
                points.add("Input and Output");
                points.add("Inter-process Communication");
                points.add("Network Structure");
                points.add("Security");
                //                todo:10min
                url.add(0,"www");
                /*
                url.add(1,);
                url.add(2,);
                url.add(3,);
                url.add(4,);
                url.add(5,);
                url.add(6,);
                url.add(7,);
                url.add(8,);
                url.add(9,);
                url.add(10,);
                url.add(11,);
                */
                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

