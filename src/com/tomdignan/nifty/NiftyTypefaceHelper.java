package com.tomdignan.nifty;

import java.util.HashMap;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

/**
 * Helper for acquiring font from assets. Lazy loads and keeps fonts cached.
 * 
 * Should be thread-safe since a font is generally a read-only thing.
 * 
 * @author Tom Dignan
 */
public class NiftyTypefaceHelper {
    private static final String TAG = "NiftyTypefaceHelper";
    
    private static final HashMap<String,Typeface> TYPEFACE_CACHE =
            new HashMap<String,Typeface>();
    
    /** Retrieve a type-face. Does not load twice, uses lazy loading. */
    public static Typeface getTypeface(Context context, String name) {
        // ensure the global context is used. just in case.
        context = context.getApplicationContext();
        Log.d(TAG, "name="+name);
        if (TYPEFACE_CACHE.containsKey(name)) {
            return TYPEFACE_CACHE.get(name);
        } 
        
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), name);
        
        if (typeface != null) {
            TYPEFACE_CACHE.put(name, typeface);
        }
        
        return typeface;
    }
}