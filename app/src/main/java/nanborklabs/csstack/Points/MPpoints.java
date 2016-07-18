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
public class MPpoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;
    RecyclerView.ItemDecoration itemDecoration;


    public MPpoints() {
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

        MPpoints frag=new MPpoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0:  points.add("The 8085");
                points.add("Microprocessor Architecture");
                points.add("Instruction Set ");

                points.add("Programming the 8085");

                url.add(0,"https://en.wikipedia.org/wiki/Intel_8085");
                url.add(1,"https://en.wikibooks.org/wiki/Microprocessor_Design/Computer_Architecture");
                url.add(2,"https://en.wikipedia.org/wiki/Instruction_set");

                url.add(3,"http://www.go4expert.com/articles/8085-assembly-language-programming-code-t302/");


                break;
            case 1: points.add("8086");
                points.add("Architecture");
                points.add("Addressing Modes");

                points.add("Assembly Language Programming");
                points.add("Procedures");
                points.add("Interrupts");

                points.add("Interrupt Service Routines");

                url.add(0,"https://en.wikipedia.org/wiki/Intel_8086");
                url.add(1,"http://www.cosc.brocku.ca/~bockusd/3p92/Local_Pages/8086_achitecture.htm");
                url.add(2,"https://en.wikipedia.org/wiki/Addressing_mode");

                url.add(3,"https://en.wikipedia.org/wiki/Assembly_language");
                url.add(4,"http://www.shsu.edu/csc_tjm/spring2001/cs272/ch4b.html");
                url.add(5,"https://en.wikipedia.org/wiki/Interrupt_flag");

                url.add(6,"https://en.wikipedia.org/wiki/Interrupt_handler");

                break;
            case 2: points.add("8086 signals");
                points.add("System Design Using 8086");
                points.add("Multiprocessor Configurations");

                points.add("Coprocessor");
                points.add("Coupled Configurations");
                points.add("Advanced Processors");

                url.add(0,"http://www.allsyllabus.com/aj/note/EEE/8086%20Microprocessor%20&%20Peripherals/unit%201/Signal%20Description%20of%208086%20Microprocessor.php#.V4ztd9_I6R0");
                url.add(1,"https://en.wikipedia.org/wiki/Intel_8086#The_first_x86_design");
                url.add(2,"https://en.wikipedia.org/wiki/MultiProcessor_Specification");

                url.add(3,"https://en.wikipedia.org/wiki/Coprocessor");
                url.add(4,"https://en.wikipedia.org/wiki/Multiprocessing#Processor_coupling");
                url.add(5,"https://en.wikipedia.org/wiki/List_of_Intel_microprocessors");
                break;
            case 3: points.add("Memory Interfacing");
                points.add("I/O Interfacing");
                points.add("Parallel Communication Interface");

                points.add("Serial Communication Interface");
                points.add("Keyboard Controller");
                points.add("DMA Controller");

               url.add(0,"https://en.wikipedia.org/wiki/External_memory_interface");
                url.add(1,"https://en.wikipedia.org/wiki/Input/output#Interface");
                url.add(2,"https://en.wikipedia.org/wiki/Parallel_communication");

                url.add(3,"https://en.wikipedia.org/wiki/Serial_communication");
                url.add(4,"https://en.wikipedia.org/wiki/Keyboard_controller_(computing)");
                url.add(5,"https://en.wikipedia.org/wiki/Direct_memory_access");



                break;
            case 4: points.add("Architecture of 8051");
                points.add("Memory and I/O AddressinFg");
                points.add("Interrupts");

                points.add("Instruction Set");
                points.add("Applications");
                url.add(0,"https://en.wikipedia.org/wiki/Intel_MCS-51");
                url.add(1,"http://www.circuitstoday.com/8051-microcontroller");
                url.add(2,"https://www.ee.iitb.ac.in/student/~dghosh/EE712/8051/Interrupts");

                url.add(3,"https://www.win.tue.nl/~aeb/comp/8051/set8051.html");
                url.add(4,"https://en.wikipedia.org/wiki/Intel_MCS-51#Important_features_and_applications");


                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

