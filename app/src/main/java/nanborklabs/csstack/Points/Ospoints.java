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
    public void point_clicked(View v,int position) {
        callback.loadUrl(url_to_load.get(position));
    }
    UrLoad callback;


    public static Fragment newInstance(int position) {

        Ospoints frag=new Ospoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0:
                points.add("Introduction to Operating Systems");
                points.add("Organization and Architecture");
                points.add("Operating System Structure");

                points.add("Distributed Systems");
                points.add("Open-source Operating Systems");
                points.add("System Calls");

                points.add("Types");
                points.add("Software System");
                points.add("System Boot");

                points.add("OS Generation");
                points.add("Process Concept");
                points.add("Cooperating Processes");

                points.add("Inter-process Communication");
                points.add("Multithreading Models");
                points.add("Thread Libraries");


                url.add(0,"https://en.wikipedia.org/wiki/Operating_system");
                url.add(1,"https://en.wikipedia.org/wiki/Computer_architecture");
                url.add(2,"http://faculty.salina.k-state.edu/tim/ossg/Introduction/struct.html");

                url.add(3,"https://en.wikipedia.org/wiki/Distributed_operating_system");
                url.add(4,"https://en.wikipedia.org/wiki/Open-source_software");
                url.add(5,"https://en.wikipedia.org/wiki/System_call");

                url.add(6,"https://en.wikipedia.org/wiki/Operating_system#Types_of_operating_systems");
                url.add(7,"https://en.wikipedia.org/wiki/Software_system");
                url.add(8,"https://en.wikipedia.org/wiki/Booting");

                url.add(9,"http://www.personal.kent.edu/~rmuhamma/OpSystems/Myos/osHistory.htm");
                url.add(10,"https://en.wikipedia.org/wiki/Process_(computing)");
                url.add(11,"http://people.scs.carleton.ca/~maheshwa/courses/300/l4/node8.html");

                url.add(12,"https://en.wikipedia.org/wiki/Inter-process_communication");
                url.add(13,"https://en.wikipedia.org/wiki/Multithreading_(computer_architecture)#Types_of_multithreading");
                url.add(14,"https://en.wikipedia.org/wiki/List_of_C%2B%2B_multi-threading_libraries");

                break;
            case 1:
                points.add("Basic Concepts");
                points.add("Scheduler Criteria");
                points.add("Scheduling Algorithms");

                points.add("Thread Scheduling");
                points.add("MultiProcessor Scheduling");
                points.add("The Critical Section Problem");

                points.add("Hardware Synchronization");
                points.add("Semaphore");
                points.add("Monitors");

                points.add("Deadlocks-Conditions & Preventions");


                url.add(0,"https://en.wikipedia.org/wiki/Scheduling_(computing)");
                url.add(1,"https://en.wikipedia.org/wiki/Scheduling_(computing)#Choosing_a_scheduling_algorithm");
                url.add(2,"https://en.wikipedia.org/wiki/Scheduling_(computing)#Scheduling_disciplines");

                url.add(3,"https://en.wikipedia.org/wiki/Thread_(computing)#Scheduling");
                url.add(4,"https://en.wikipedia.org/wiki/Multiprocessor_scheduling");
                url.add(5,"https://en.wikipedia.org/wiki/Critical_section");
                url.add(6,"https://en.wikipedia.org/wiki/Synchronization_(computer_science)#Hardware_synchronization");
                url.add(8,"https://en.wikipedia.org/wiki/Semaphore_(programming)");
                url.add(7,"https://en.wikipedia.org/wiki/Monitor_(synchronization)");

                url.add(9,"https://en.wikipedia.org/wiki/Deadlock");
                url.add(10,"https://en.wikipedia.org/wiki/Deadlock#Prevention");

                break;
            case 2: points.add("Memory Management");
                points.add("Swapping");
                points.add("Contiguous Memory Allocation");

                points.add("Paging");
                points.add("Segmentation");
                points.add("Virtual MemorY");

                points.add("Demand paging");
                points.add("Copy on Write");
                points.add("Page Replacement");

                points.add("Thrashing");
                url.add(0,"https://en.wikipedia.org/wiki/Memory_management_(operating_systems)");
                url.add(1,"https://en.wikipedia.org/wiki/Virtual_memory#Address_space_swapping");
                url.add(2,"http://www.gitam.edu/eresource/comp/gvr(os)/8.3.htm");
                url.add(3,"https://en.wikipedia.org/wiki/Paging");
                url.add(4,"https://en.wikipedia.org/wiki/Memory_segmentation");
                url.add(5,"https://en.wikipedia.org/wiki/Virtual_memory");
                url.add(6,"https://en.wikipedia.org/wiki/Demand_paging");
                url.add(7,"https://en.wikipedia.org/wiki/Copy-on-write");
                url.add(8,"https://en.wikipedia.org/wiki/Page_replacement_algorithm");
                url.add(9,"https://en.wikipedia.org/wiki/Thrashing_(computer_science)");

                break;
            case 3:  points.add("File System");
                points.add("Access Methods");
                points.add("Directory Structure");

                points.add("File-system Mounting");
                points.add("File Allocation Table");
                points.add("Disk Scheduling");

                points.add("Swap-Space");
                url.add(0,"https://en.wikipedia.org/wiki/File_system");
                url.add(1,"https://en.wikipedia.org/wiki/Access_method");
                url.add(2,"https://en.wikipedia.org/wiki/Directory_structure");

                url.add(4,"https://en.wikipedia.org/wiki/File_Allocation_Table");
                url.add(3,"https://en.wikipedia.org/wiki/Mount_(computing)");
                url.add(5,"http://www.cs.iit.edu/~cs561/cs450/disksched/disksched.html");

                url.add(6,"https://en.wikipedia.org/wiki/Paging#Swap_space_size");

                break;
            case 4:   points.add("The Linux System");
                points.add("Design Principles");
                points.add("Kernel Modules");

                points.add("Process Management");
                points.add("Memory Management");
                points.add("File Systems");

                points.add("Inter-process Communication");
                points.add("Network Structure");
                points.add("Security");

                url.add(0,"http://www.linuxfoundation.org/what-is-linux");
                url.add(1,"http://www.gitam.edu/eresource/comp/gvr(os)/13.2.htm");
                url.add(2,"http://www.tldp.org/LDP/lkmpg/2.6/html/x40.html");

                url.add(3,"https://en.wikipedia.org/wiki/Process_management_(computing)");
                url.add(4,"http://www.tldp.org/LDP/tlk/mm/memory.html");
                url.add(5,"http://www.tldp.org/LDP/intro-linux/html/sect_03_01.html");

                url.add(6,"http://www.tldp.org/LDP/lpg/node7.html");
                url.add(7,"http://www.tldp.org/LDP/tlk/net/net.html");
                url.add(8,"https://en.wikipedia.org/wiki/Linux_Security_Modules");

                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

