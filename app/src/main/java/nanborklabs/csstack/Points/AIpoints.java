package nanborklabs.csstack.Points;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;

import java.util.ArrayList;

import nanborklabs.csstack.R;
import nanborklabs.csstack.RecyclerViewAnim;
import nanborklabs.csstack.UrLoad;
import nanborklabs.csstack.Utild;
import nanborklabs.csstack.adapter.rv_adapter;

/**
 * Created by nandhu on 9/7/16.
 */
public class AIpoints extends Fragment implements rv_adapter.Point_clicked{

    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;
    RecyclerView.ItemDecoration itemDecoration;
        UrLoad callback;
     WebView mWebView;
    Animator.AnimatorListener listener;
    int centerX;
    int centerY;




    public AIpoints() {
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
        if (callback==null){
            Log.d("CALLBACK","caal back is null");
        }
        else {
            Log.d("CALLBACK","yes working");
        }


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

        mWebView=(WebView)mView.findViewById(R.id.webview);
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
            mRecyclerView.setAdapter(mAdapter);
        }
   //    mRecyclerView.addItemDecoration(itemDecoration);
      //  mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
      //  mRecyclerView.setAdapter(mAdapter);

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

      //  callback.loadUrl(url_to_load.get(position));



//        showReavelWebview(centerX,centerY,position);
        callback.loadUrl(url_to_load.get(position));




    }

    private void showReavelWebview(int centerX, int centery, int position) {

        int end= Utild.getScreenHeight(getContext());
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Animator an=ViewAnimationUtils.createCircularReveal(getActivity().findViewById(R.id.frag_holder),centerX,centery,0,end);
            an.setDuration(300).setInterpolator(new AccelerateInterpolator());
            an.start();
        }

    }

    public AIpoints newInstance(int position) {
      AIpoints Fragment=new AIpoints();
         ArrayList<String> points;
         ArrayList<String> url;
        points=new ArrayList<>();
        url=new ArrayList<>();
        //load stringarraylist into fragmetns bsed on position
        // each position will have ive to six strings and equivalent URL's
        switch (position){

            case 0:


                points.add("Introduction ");
                points.add("Intelligent Agents");
                points.add("Types of Agents");

                points.add("Problem Solving in AI");

                url.add(0,"https://en.wikipedia.org/wiki/Artificial_intelligence");
                url.add(1,"https://en.wikipedia.org/wiki/Intelligent_agent");
                url.add(2,"https://en.wikipedia.org/wiki/Artificial_intelligence#Deduction.2C_reasoning.2C_problem_solving");

                url.add(3,"http://www-g.eng.cam.ac.uk/mmg/teaching/artificialintelligence/nonflash/problemframenf.htm");
                break;
            case 1:


                points.add("Uniformed Search Strategies");
                points.add("Heuristics");
                points.add("Local Search Algorithms");

                points.add("Constraint Satisfaction Problem");
                points.add("Backtracking");
                points.add("Game Playing");

                points.add("Pruning");
                points.add("Alpha-Beta Pruning");

                url.add(0,"http://artint.info/html/ArtInt_52.html");
                url.add(1,"https://en.wikipedia.org/wiki/Heuristic_(computer_science)");
                url.add(2,"https://en.wikipedia.org/wiki/Local_search_(optimization)");

                url.add(3,"https://en.wikipedia.org/wiki/Constraint_satisfaction_problem");
                url.add(4,"https://en.wikipedia.org/wiki/Backtracking#Description_of_the_method");
                url.add(5,"https://en.wikipedia.org/wiki/General_game_playing");

                url.add(6,"https://en.wikipedia.org/wiki/Pruning_(decision_trees)");
                url.add(7,"https://en.wikipedia.org/wiki/Alpha%E2%80%93beta_pruning");

                break;
            case 2:

                points.add("Predicate Calculus");
                points.add("First Order Predicate Logic");
                points.add("Unification");

                points.add("Forward Chaining");
                points.add("Backward Chaining");
                points.add("Knowledge Representation");

                points.add("Reasoning and Acting");

                url.add(0,"https://en.wikipedia.org/wiki/Predicate_logic");
                url.add(1,"https://en.wikipedia.org/wiki/First-order_logic");
                url.add(2,"https://en.wikipedia.org/wiki/Unification_(computer_science)");

                url.add(3,"https://en.wikipedia.org/wiki/Forward_chaining");
                url.add(4,"https://en.wikipedia.org/wiki/Backward_chaining");
                url.add(5,"http://groups.csail.mit.edu/medg/ftp/psz/k-rep.html#kr");

                url.add(6,"http://artint.info/html/ArtInt_11.html");
                break;
            case 3:

                points.add("Probability Basics");
                points.add("Bayes Rule");
                points.add("Bayesian Networks");

                points.add("Inference");
                points.add(" Markov Models");
                points.add("Types of Learning");

                points.add("Learning Decision Trees");
                points.add("Regression");
                points.add("Artificial Neural Networks");

                points.add("Non Parametric Models");
                points.add("Support Vector Machines");
                points.add("Statistical Learning");

                points.add("The EM Algorithm");
                points.add("Reinforcement Learning");

                url.add(0,"https://en.wikipedia.org/wiki/Probability");
                url.add(1,"https://en.wikipedia.org/wiki/Bayes%27_rule");
                url.add(2,"https://en.wikipedia.org/wiki/Bayesian_network");

                url.add(3,"https://en.wikipedia.org/wiki/Inference");
                url.add(4,"https://en.wikipedia.org/wiki/Markov_model");
                url.add(5,"https://en.wikipedia.org/wiki/List_of_machine_learning_concepts");

                url.add(6,"https://en.wikipedia.org/wiki/Decision_tree_learning");
                url.add(7,"https://en.wikipedia.org/wiki/Regression_analysis");
                url.add(8,"https://en.wikipedia.org/wiki/Artificial_neural_network");

                url.add(9,"https://en.wikipedia.org/wiki/Nonparametric_statistics");
                url.add(10,"https://en.wikipedia.org/wiki/Support_vector_machine");
                url.add(11,"https://en.wikipedia.org/wiki/Statistical_learning_theory");

                url.add(12,"https://en.wikipedia.org/wiki/Expectation%E2%80%93maximization_algorithm");
                url.add(13,"https://en.wikipedia.org/wiki/Reinforcement_learning");

                break;
            case 4:

                points.add("AI Applications");
                points.add("Language Models");
                points.add("Information Retrieval");

                points.add("Natural Language Processing");
                points.add("Machine Translation");
                points.add("Speech Recognition");

                points.add("Robotics");
                points.add("Perception in Robotics");


                url.add(0,"https://en.wikipedia.org/wiki/Applications_of_artificial_intelligence");
                url.add(1,"https://en.wikipedia.org/wiki/Language_model");
                url.add(2,"https://en.wikipedia.org/wiki/Information_retrieval");

                url.add(3,"https://en.wikipedia.org/wiki/Natural_language_processing");
                url.add(4,"https://en.wikipedia.org/wiki/Machine_translation");
                url.add(5,"https://en.wikipedia.org/wiki/Speech_recognition");

                url.add(6,"https://en.wikipedia.org/wiki/Robotics");
                url.add(7,"https://see.stanford.edu/materials/aiircs223a/handout5_robots_and_vision.pdf");

                break;

        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        Fragment.setArguments(points_bundle);
        return Fragment;

    }
}
