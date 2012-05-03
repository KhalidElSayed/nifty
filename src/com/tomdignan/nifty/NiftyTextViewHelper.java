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
	/** For identify class in Log */
	private static final String TAG = "NiftyViewHelper";

	/** Corresponds to the constructor of TextView and children */
	public static void initialize(TextView view, Context context,
			AttributeSet attrs) {
		TypedArray attributes = context.obtainStyledAttributes(attrs,
				R.styleable.Nifty, R.attr.typeface, 0);

		String typefaceDesc = attributes.getString(R.styleable.Nifty_typeface);

		if (typefaceDesc != null) {
			Typeface typeface = NiftyTypefaceHelper.getTypeface(context,
					typefaceDesc);
			Log.d(TAG, "setTypeface(" + typeface.toString() + ")");
			view.setTypeface(typeface);
		} else {
			Log.w(TAG,
					"View had confnow:typeface attribute but no typeface was found in /assets");
		}
	}
}
