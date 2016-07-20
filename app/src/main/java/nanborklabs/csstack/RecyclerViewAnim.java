package nanborklabs.csstack;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

/**
 * Created by nandhu on 14/7/16.
 */
public class RecyclerViewAnim {


    public static void startIntroAnim(RecyclerView recyclerView, Context mContext){

        recyclerView.setTranslationY(Utild.getScreenHeight(mContext));
        recyclerView.setAlpha(0f);
        recyclerView.animate()
                .translationY(0)
                .setDuration(500)
                .alpha(1f)
                .setStartDelay(750)
                .setInterpolator(new DecelerateInterpolator())
                .start();
    }
    public static void startTitleAnim(TextView title){
        title.setTranslationY(title.getHeight());
        title.setAlpha(0f);
        title.animate()
                .translationY(0)
                .alpha(1f)
                .setInterpolator(new AccelerateInterpolator(3.f))
                .setDuration(400)
                .setStartDelay(50)
                .start();

    }


}
