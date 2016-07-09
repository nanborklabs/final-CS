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
public class computerArchpoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;



    public computerArchpoints() {
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

        computerArchpoints frag=new computerArchpoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0: points.add("Units of a Digital Computer");
                points.add("Hardware");
                points.add("Software Interface");
                points.add("Hardware Language");
                points.add("Instruction Set Architecture");
                points.add("RISC and CISC Architectures");
                points.add("Performance Metrics –");
                points.add("Amdahl’s Law"); url.add(0,"https://en.wikipedia.org/wiki/Computer_architecture";);
                url.add(1,"https://en.wikipedia.org/wiki/Computer_hardware";);
                url.add(2,"https://en.wikipedia.org/wiki/Application_binary_interface";);
                url.add(3,"https://en.wikipedia.org/wiki/Hardware_description_language";);
                url.add(4,"https://en.wikipedia.org/wiki/Instruction_set";);
                url.add(5,"https://en.wikipedia.org/wiki/Reduced_instruction_set_computing";);
                url.add(6,"https://en.wikipedia.org/wiki/Computer_performance";);
                url.add(7,"https://en.wikipedia.org/wiki/Amdahl%27s_law";);
                break;
            case 1: points.add("Components of the Processor");
                points.add("Datapath and Control");
                points.add("Execution of a Complete Instruction");
                points.add("Hardwired and Micro programmed Control");
                points.add("Instruction Level Parallelism");
                points.add("Pipelining");
                points.add("Hazard"); url.add(0,);
                url.add(1,"https://en.wikipedia.org/wiki/Datapath";);
                url.add(2,"https://www.cs.umd.edu/class/sum2003/cmsc311/Notes/Overall/steps.html";);
                url.add(3,"https://en.wikipedia.org/wiki/Microcode";);
                url.add(4,"https://en.wikipedia.org/wiki/Instruction-level_parallelism";);
                url.add(5,"https://en.wikipedia.org/wiki/Pipelining_(DSP_implementation)";);
                url.add(6,"https://en.wikipedia.org/wiki/Pipelining_(DSP_implementation)";);
                url.add(7,"https://en.wikipedia.org/wiki/Hazard_(computer_architecture)";);
                break;
            case 2: points.add("Exploitation of more ILP");
                points.add("Dynamic Scheduling");
                points.add("Speculation");
                points.add("Compiler Approaches");
                points.add("Multiple Issue Processors");
                points.add("ILP and Thread Level Parallelism");
                points.add("Multicore Processors");
                points.add("Graphics and Computing GPUs"); url.add(0,"https://en.wikipedia.org/wiki/Instruction-level_parallelism";);
                url.add(1,"https://en.wikipedia.org/wiki/Instruction_scheduling";);
                url.add(2,"http://www-ee.eng.hawaii.edu/~tep/EE461/Notes/ILP/hw_speculate.html";);
                url.add(3,"http://cs.nyu.edu/courses/fall10/V22.0436-001/lecture17.html";);
                url.add(4,"http://pages.cs.wisc.edu/~david/courses/cs838/notes/09-18-03.html");
                url.add(5,"https://en.wikipedia.org/wiki/Multi-core_processor";);
                url.add(6,"https://en.wikipedia.org/wiki/General-purpose_computing_on_graphics_processing_units";);

                break;
            case 3:  points.add("Addition and Subtraction");
                points.add("Fast Adders");
                points.add("Binary Multiplication");
                points.add("Binary Division");
                points.add("Floating Point Numbers"); url.add(0,"https://en.wikipedia.org/wiki/Adder_(electronics)";);
                url.add(1,"https://en.wikipedia.org/wiki/Carry-lookahead_adder";);
                url.add(2,"https://en.wikipedia.org/wiki/Binary_multiplier";);
                url.add(3,"https://en.wikipedia.org/wiki/Binary_number#Division";);
                url.add(4,"https://en.wikipedia.org/wiki/Floating_point";);

                break;
            case 4:  points.add("hierarchical memory system");
                points.add("Cache memories");
                points.add("Improving cache performance");
                points.add("Virtual memory");
                points.add("Memory management technique");
                points.add("Associative memories");
                points.add("Accessing I/O devices");
                points.add("Interrupts");
                points.add("Direct Memory Access");
                points.add("Standard I/O Interfaces"); url.add(0,"https://en.wikipedia.org/wiki/Memory_hierarchy";);
                url.add(1,"https://en.wikipedia.org/wiki/CPU_cache";);
                url.add(2,"https://en.wikipedia.org/wiki/Virtual_memory";);
                url.add(3,"https://en.wikipedia.org/wiki/Memory_management";);
                url.add(4,"https://en.wikipedia.org/wiki/Content-addressable_memory";);
                url.add(5, "https://en.wikipedia.org/wiki/Input/output#Interface";);
                url.add(6,"https://en.wikipedia.org/wiki/Interrupt";);
                url.add(7,"https://en.wikipedia.org/wiki/Direct_memory_access";);
                url.add(8,"http://www.cs.uwm.edu/classes/cs458/Lecture/HTML/ch11s02.html";);
                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

