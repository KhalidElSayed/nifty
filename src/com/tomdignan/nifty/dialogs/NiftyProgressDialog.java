package com.tomdignan.nifty.dialogs;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/**
 * A progress dialog with some extra features, such as the ability to play an 
 * animation on dismissal.
 * 
 * @author Tom Dignan
 */
public class NiftyProgressDialog extends NiftyBaseDialog implements INiftyDismissAnimation {
    private View mOnDismissAnimationView = null;
    private Animation mOnDismissAnimation = null;
    private boolean mIsAnimationRunning = false;
    private boolean mIsDialogDismissed = false;
    
    protected NiftyProgressDialog(Context context, int theme,
            OnCancelListener cancelListener) {
        super(context, theme);
    }
    
    @Override
    protected void onStart() {
        mIsDialogDismissed = false;
        mIsAnimationRunning = false;
        super.onStart();
    }
    
    @Override
    public void dismiss() {
        if (!mIsDialogDismissed) {
            mIsDialogDismissed = true;
            doDismiss();
        }
    }
    
    private void doDismiss() {
        if (mIsAnimationRunning == false && mOnDismissAnimationView != null
                && mOnDismissAnimation != null) {
            mIsAnimationRunning = true;
            
            mOnDismissAnimation.setAnimationListener(new AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {}
                
                @Override
                public void onAnimationRepeat(Animation animation) {}
                
                @Override
                public void onAnimationEnd(Animation animation) {
                    parentDismiss();
                    mIsAnimationRunning = false;
                }
            });
            
            mOnDismissAnimationView.startAnimation(mOnDismissAnimation);
        } else {
            super.dismiss();
        }
    }
    
    private void parentDismiss() {
        super.dismiss();
    }

    @Override
    public void setOnDismissAnimation(View view, Animation anim) {
        mOnDismissAnimationView = view;
        mOnDismissAnimation = anim;
    }
}
