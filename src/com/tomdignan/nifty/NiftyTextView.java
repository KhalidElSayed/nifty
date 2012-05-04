package com.tomdignan.nifty;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * A TextView subclass that allows you to specify a custom font in XML.
 * 
 * @author Tom Dignan
 */
public class NiftyTextView extends TextView {

    /** Tag for identify class in log */
    private static final String TAG = "NiftyTextView";
    
    public NiftyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        NiftyTextViewHelper.initialize(this, context, attrs);
    }
}