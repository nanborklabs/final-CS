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

import java.net.URI;
import java.util.ArrayList;

import nanborklabs.csstack.R;
import nanborklabs.csstack.RecycelerviewDecorator;
import nanborklabs.csstack.UrLoad;
import nanborklabs.csstack.adapter.rv_adapter;

/**
 * Created by nandhu on 9/7/16.
 */
public class Securitypoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;


    RecyclerView.ItemDecoration itemDecoration;
    public Securitypoints() {
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
    UrLoad callback;

    public static Fragment newInstance(int position) {

        Securitypoints frag=new Securitypoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0: points.add("Security overivew");
                points.add("Substitution ciphers");
                points.add("Encryption Algorithams");

                points.add("Data Enryption Sstandards");
                points.add("AES");
                points.add("Public Key Encryption");

                points.add("Cryptographc hash functions");
                points.add("Key Exchange");
                points.add("digital Signature");

                points.add("certificates");
                url.add(0,"https://en.wikipedia.org/wiki/Computer_security");
                url.add(1,"https://en.wikipedia.org/wiki/Substitution_cipher");
                url.add(2,"https://en.wikipedia.org/wiki/Encryption");
                url.add(3,"https://en.wikipedia.org/wiki/Data_Encryption_Standard");
                url.add(4,"https://en.wikipedia.org/wiki/Advanced_Encryption_Standard");
                url.add(5,"https://en.wikipedia.org/wiki/Public-key_cryptography");
                url.add(6,"https://en.wikipedia.org/wiki/Cryptographic_hash_function");
                url.add(7,"https://en.wikipedia.org/wiki/Key_exchange");
                url.add(8,"https://en.wikipedia.org/wiki/Digital_signature");
                url.add(9,"https://en.wikipedia.org/wiki/Digital_signature");

                break;
            case 1: points.add("Viruses");
                points.add("Targeted Malicious code");
                points.add("Control Against Threat");
                points.add("User Autentication");
                points.add("Best Practices");
                points.add("Common Errors");
                url.add(0,"https://en.wikipedia.org/wiki/Computer_virus");
                url.add(1,"https://en.wikipedia.org/wiki/Malware");
                url.add(2,"https://en.wikipedia.org/wiki/Authentication");
                url.add(3,"https://kb.iu.edu/d/akln");
                url.add(4,"https://web.stanford.edu/class/cs101/security-1.html");

                break;
            case 2:    points.add("Virtual Private Network");
                points.add("PKI");
                points.add("SSH,SSL,IPsec");
                points.add("Access Control");
                points.add("Wireless security");
                points.add("Honeypots");
                points.add("Traffic Flow");
                points.add("firewalls");
                points.add("Intrusion Detection Systems");
                points.add("Secure e-mail");
                url.add(0,"https://en.wikipedia.org/wiki/Virtual_private_network");
                url.add(1,"https://en.wikipedia.org/wiki/Public_key_infrastructure");
                url.add(2,"https://en.wikipedia.org/wiki/Secure_Shell");
                url.add(3,"https://en.wikipedia.org/wiki/Computer_access_control");
                url.add(4,"https://en.wikipedia.org/wiki/Wireless_security");
                url.add(5,"https://en.wikipedia.org/wiki/Honeypot_(computing)");
                url.add(6,"https://en.wikipedia.org/wiki/Traffic_flow_(computer_networking)");
                url.add(7,"https://en.wikipedia.org/wiki/Firewall_(computing)");
                url.add(8,"https://en.wikipedia.org/wiki/Intrusion_detection_system");
                url.add(9,"https://en.wikipedia.org/wiki/Email_encryption");
                break;
            case 3:  points.add("Requirements in Database Systems");
                points.add("Reliablity & integrity");
                points.add("Two phase update");

                points.add("Redundancy/Internal Consistency");
                points.add("Recovery");
                points.add("Concurrency");

                points.add("Inference");
                url.add(0,"www.google.com");
                //todo:ADD FUCKING URL'S HERE
                url.add(1,"www.google.com");
                url.add(2,"https://en.wikipedia.org/wiki/Two-phase_commit_protocol");
                url.add(3,"https://en.wikipedia.org/wiki/Data_redundancy");
                url.add(4,"https://en.wikipedia.org/wiki/Data_recovery");
                url.add(5,"https://en.wikipedia.org/wiki/Concurrency_(computer_science)");
                url.add(6,"https://en.wikipedia.org/wiki/Inference");
                break;
            case 4:points.add("Secure Application Testing");
                points.add("Security Architeacure Models");
                points.add("Trusted Computing");

                points.add("Bell-Lapdula Confidentiality model");
                points.add("Biba integrity model");
                points.add("Graham-Denning Access control model");

                points.add("Harrison Ruzzo Ulman model");
                points.add("PCI DSS");
                points.add("Security Standards");

                points.add("NIST");
                url.add(0,"https://en.wikipedia.org/wiki/Application_security");
                url.add(1,"https://en.wikipedia.org/wiki/Enterprise_information_security_architecture");
                url.add(2,"https://en.wikipedia.org/wiki/Trusted_Computing");
                url.add(3,"https://en.wikipedia.org/wiki/Bell%E2%80%93LaPadula_model");
                url.add(4,"https://en.wikipedia.org/wiki/Biba_Model");
                url.add(5,"https://en.wikipedia.org/wiki/Graham-Denning_model");
                url.add(6,"https://en.wikipedia.org/wiki/HRU_(security)");
                url.add(7,"https://en.wikipedia.org/wiki/Payment_Card_Industry_Data_Security_Standard");
                url.add(8,"https://en.wikipedia.org/wiki/National_Institute_of_Standards_and_Technology");
                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

