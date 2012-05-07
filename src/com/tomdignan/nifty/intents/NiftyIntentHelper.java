package com.tomdignan.nifty.intents;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * A collection of methods that can fire off commonly used intents, for actions
 * such as "Share via SMS", "Share via E-Mail", and "Dial In"
 * 
 * @author Tom Dignan
 */
public class NiftyIntentHelper {
	public static void shareViaEmail(Context context, String subject,
			String text) {
		Intent intent = new Intent(Intent.ACTION_SENDTO);
		intent.setType("text/html");
		intent.setData(Uri.parse("mailto:"));
		intent.putExtra(Intent.EXTRA_TEXT, text);
		intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		context.startActivity(Intent.createChooser(intent, "Share via Email"));
	}

	public static void shareViaSms(Context context, String subject, String text) {
		Intent intent = new Intent();
		intent.setType("text/plain");
		intent.setData(Uri.parse("sms:"));
		intent.setAction(Intent.ACTION_VIEW);
		intent.putExtra("sms_body", text);
		context.startActivity(Intent.createChooser(intent, "Share via SMS"));
	}

	public static void dialIn(Context context, String number) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel://" + number));
		context.startActivity(intent);
	}
}
