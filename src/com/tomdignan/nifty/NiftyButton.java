package com.tomdignan.nifty;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;

/**
 * A TextView subclass that allows you to specify a custom font in XML.
 * 
 * @author Tom Dignan
 */
public class NiftyButton extends Button {
	/** Tag for identify class in log */
	private static final String TAG = "NiftyButton";
    
    public NiftyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        NiftyTextViewHelper.initialize(this, context, attrs);
    }
}