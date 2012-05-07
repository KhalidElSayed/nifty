package com.tomdignan.nifty;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Share functionality across multiple view subclasses using composition.
 * 
 * @author Tom Dignan
 */
class NiftyTextViewHelper {
    private static final String NS_NIFTY = "http://schemas.tomdignan.com/nifty";

    /** For identify class in Log */
    private static final String TAG = "NiftyViewHelper";

    
    /** Corresponds to the constructor of TextView and children */
    public static void initialize(TextView view, Context context,
            AttributeSet attributeSet) {
        
        
        TypedArray attributes = context.obtainStyledAttributes(attributeSet,
                R.styleable.Nifty, R.attr.typeface, 0);

        String typefaceDesc = attributes.getString(R.styleable.Nifty_typeface);

        // If not set in the style, attempt to pull from the messageTypeface
        if (typefaceDesc == null) {
            typefaceDesc = attributes.getString(R.styleable.Nifty_messageTypeface);
        }

        // If not set in the messageTypeface, attempt to pull from "nifty:typeface" 
        if (typefaceDesc == null) {
            typefaceDesc = attributeSet.getAttributeValue(NS_NIFTY, "typeface");
        }
        
        if (typefaceDesc != null) {
            Typeface typeface = NiftyTypefaceHelper.getTypeface(context,
                    typefaceDesc);
            Log.d(TAG, "setTypeface(" + typeface.toString() + ")");
            view.setTypeface(typeface);
        } else {
            Log.w(TAG,
                "View had typeface attribute but no typeface was found in /assets");
        }
    }
}
