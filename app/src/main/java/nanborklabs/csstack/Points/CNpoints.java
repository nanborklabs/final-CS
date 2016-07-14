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
public class CNpoints extends Fragment implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;
    RecyclerView.ItemDecoration itemDecoration;



    public CNpoints() {
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
        itemDecoration=new RecycelerviewDecorator(ContextCompat.getDrawable(getContext(),R.drawable.divider));
        mRecyclerView.addItemDecoration(itemDecoration);
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

            mAdapter = new rv_adapter(points_to_show, this,getContext());
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

            mAdapter = new rv_adapter(points_to_show, this,getContext());
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
    UrLoad callback;


    public static Fragment newInstance(int position) {

        CNpoints frag=new CNpoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){

            case 0:
                points.add("Network Architecture");
                points.add("OSI Model(7Layers)");
                points.add("HTTP");
                points.add("DNS");
                points.add("e-mail");
                points.add("FTP");
                points.add("Telnet");
                points.add("SSH");
                url.add(0,"https://en.wikipedia.org/wiki/Network_architecture");
                url.add(1,"https://en.wikipedia.org/wiki/OSI_model");
                url.add(2,"https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol");
                url.add(3,"https://en.wikipedia.org/wiki/Domain_Name_System");
                url.add(4,"https://en.wikipedia.org/wiki/Email");
                url.add(5,"https://en.wikipedia.org/wiki/File_Transfer_Protocol");
                url.add(6,"https://en.wikipedia.org/wiki/Telnet");
                url.add(7,"https://en.wikipedia.org/wiki/Secure_Shell");
                break;
            case 1:
                points.add("User Datagram Protocol");
                points.add("Transmission Control Protocol");
                points.add("Flow Control");

                points.add("Congestion Control");
                points.add("Queuing");
                points.add("Quality Of Service");
                url.add(0,"https://en.wikipedia.org/wiki/User_Datagram_Protocol");
                url.add(1,"https://en.wikipedia.org/wiki/Transmission_Control_Protocol");
                url.add(2,"https://en.wikipedia.org/wiki/Flow_control_(data)");
                url.add(3,"https://en.wikipedia.org/wiki/Network_congestion#Congestion_control");
                url.add(4,"https://en.wikipedia.org/wiki/Queueing_theory");
                url.add(5,"https://en.wikipedia.org/wiki/Quality_of_service");

                break;
            case 2:
                points.add("Circuit Switching");
                points.add("Packet Switching");
                points.add("IP");

                points.add("ARP");
                points.add("DHCP");
                points.add("ICMP");

                points.add("Routing");
                points.add("Subnetting");
                points.add("Classless_Inter-Domain_Routing");

                points.add("BGP");
                points.add("IPv6");
                points.add("Congestion Avoidance");

//              todo:check count
                url.add(0,"https://en.wikipedia.org/wiki/Circuit_switching");
                url.add(1,"https://en.wikipedia.org/wiki/Packet_switching");
                url.add(2,"https://en.wikipedia.org/wiki/Internet_Protocol");
                url.add(3,"https://en.wikipedia.org/wiki/Address_Resolution_Protocol");
                url.add(4,"https://en.wikipedia.org/wiki/Dynamic_Host_Configuration_Protocol");
                url.add(5,"https://en.wikipedia.org/wiki/Internet_Control_Message_Protocol");
                url.add(6,"https://en.wikipedia.org/wiki/Routing");
                url.add(7,"Ihttps://en.wikipedia.org/wiki/Classless_Inter-Domain_Routing");
               url.add(8,"https://https://en.wikipedia.org/wiki/Border_Gateway_Protocol");
                url.add(9,"https://en.wikipedia.org/wiki/IPv6");
                url.add(10,"https://www.cisco.com/c/en/us/td/docs/ios/12_2/qos/configuration/guide/fqos_c/qcfconav.html");
                break;
            case 3:
                points.add("Channel Access in links");
                points.add("SDMA");
                points.add("TDMA");

                points.add("FDMA");
                points.add("CDMA");
                points.add("Multiple Access Techniques");

                points.add("Issues in Data link layer");
                points.add("Framing");
                points.add("Error detection & correction");

                points.add("Link level Flow");
                points.add("Medium Access");
                points.add("Ethernet");

                points.add("Token Ring");
                points.add("FDDI");
                points.add("Wireless LAN");

                points.add("Bridges & Switches");


                url.add(0,"https://www.techopedia.com/definition/25940/channel-access-method-cam");
                url.add(1,"https://en.wikipedia.org/wiki/Channel_access_method");
                url.add(2,"https://en.wikipedia.org/wiki/Space-division_multiple_access");
                url.add(3,"https://en.wikipedia.org/wiki/Time_division_multiple_access");
                url.add(4,"https://en.wikipedia.org/wiki/Frequency-division_multiple_access");
                url.add(5,"https://en.wikipedia.org/wiki/Code_division_multiple_access");
                url.add(6,"http://www.durofy.com/multiple-access-techniques-fdma-tdma-cdma/");

                url.add(7,"http://dns2.asia.edu.tw/~wzyang/slides/info_net/info_A/Ch3.pdf");
                url.add(8,"http://www.examsoverflow.com/question/framing-explain-various-methods-used-carrying-framing-detail/");
                url.add(9,"https://en.wikipedia.org/wiki/Error_detection_and_correction");
                url.add(10,"https://en.wikipedia.org/wiki/Ethernet_flow_control");
                url.add(11,"https://en.wikipedia.org/wiki/Ethernet");
                url.add(12,"https://en.wikipedia.org/wiki/Token_ring");
                url.add(13,"https://en.wikipedia.org/wiki/Fiber_Distributed_Data_Interface");
                url.add(14,"https://en.wikipedia.org/wiki/Wireless_LAN");
                url.add(15,"http://docwiki.cisco.com/wiki/Bridging_and_Switching_Basics");
                break;
            case 4:
                points.add("Data Transmission");
                points.add("Transmission Media");
                points.add("Signal Encoding Techniques");
                points.add("Multiplexing");
                points.add("Spectrum");
                url.add(0,"https://en.wikipedia.org/wiki/Data_Transmission");
                url.add(1,"https://en.wikipedia.org/wiki/Data_Transmission");
                url.add(2,"http://www.cse.iitk.ac.in/users/dheeraj/cs425/lec03.html");
                url.add(3,"https://en.wikipedia.org/wiki/Multiplexing");
                url.add(4,"http://www.spectrumtransmission.com/");

                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

