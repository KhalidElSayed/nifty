package com.tomdignan.nifty;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;

public class NiftyDialogFactory {
	public static Dialog makeProgressDialog(Context context, int theme, OnCancelListener onCancel) {
		Dialog dialog = new Dialog(context, theme);
		dialog.setOnCancelListener(onCancel);
		dialog.setCancelable(true);
		dialog.setContentView(R.layout.nifty_dialog_layout);
		return dialog;
	}
}
