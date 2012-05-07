package com.tomdignan.nifty.dialogs;

import android.view.View;
import android.view.animation.Animation;

/**
 * Defines an interface for the specification of unique animations for the Dialog
 * major events.
 * 
 * @author Tom Dignan
 */
public interface INiftyDismissAnimation {
    void setOnDismissAnimation(View view, Animation anim);
}
