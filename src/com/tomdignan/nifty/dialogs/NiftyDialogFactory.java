package com.tomdignan.nifty.dialogs;

import com.tomdignan.nifty.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.text.InputType;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

/**
 * You can pretty much drop these in and use them, just call the factory methods
 * and you get a ready made dialog with bells and whistles attached.
 * 
 * @author Tom Dignan
 */
public class NiftyDialogFactory {
    /**
     * Makes a very nifty progress dialog. Slide in/out animations are played on show, dismiss, and cancel.
     * Takes over the full screen. This dialog can be styled with a theme, to change the spinner image,
     * text, and logo.
     * 
     * @param context
     * @param theme
     * @param onCancel
     * @return
     */
    public static Dialog makeProgressDialog(final Context context, int theme, OnCancelListener onCancel) {
        NiftyProgressDialog dialog = new NiftyProgressDialog(context, theme, onCancel);
        
        dialog.setOnCancelListener(onCancel);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.nifty_dialog_layout);
        
        final View root = dialog.findViewById(R.id.nifty_vRoot);
        final View spinner = dialog.findViewById(R.id.nifty_ivSpinner);
        
        dialog.setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
                root.startAnimation(slideIn);
                Animation rotate = AnimationUtils.loadAnimation(context, R.anim.nifty_rotate_indefinitely);
                rotate.setRepeatMode(Animation.INFINITE);
                spinner.startAnimation(rotate);                            
            }
        });
        
        Animation slideOut = AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right);
        dialog.setOnDismissAnimation(root, slideOut);
        return dialog;
    }
    
    /**
     * Makes a simple AlertDialog with an EditText for prompting the user for a value.
     * 
     * @param context
     * @param theme
     * @return
     */
    public static Dialog makeNumericPromptDialog(final Context context, String prompt, final OnResultListener listener) {
    	final EditText etResult = new EditText(context);
    	etResult.setInputType(InputType.TYPE_CLASS_NUMBER);
    	AlertDialog.Builder builder = new AlertDialog.Builder(context);
    	builder.setMessage(prompt)
    	       .setCancelable(false)
    	       .setView(etResult)
    	       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
    	           public void onClick(DialogInterface dialog, int id) {
    	                listener.onResult(etResult.getText().toString());
    	           }
    	       })
    	       .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    	           public void onClick(DialogInterface dialog, int id) {
    	                dialog.cancel();
    	           }
    	       });
    	AlertDialog alert = builder.create();
		return alert;
    }
}
