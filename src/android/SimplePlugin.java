package kyungseo.cordova.plugins;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.content.Context;
import android.widget.Toast;
import android.util.Log;

import java.util.Date;

public class SimplePlugin extends CordovaPlugin {
	private static final String TAG = "SimplePlugin";

	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing SimplePlugin");
	}

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if ("echo".equals(action)) {
			String phrase = args.getString(0);
      Log.d(TAG, phrase);
			echo(phrase, callbackContext);
			return true;
		} else if ("getDate".equals(action)) {
			final PluginResult result = new PluginResult(PluginResult.Status.OK, (new Date()).toString());
      callbackContext.sendPluginResult(result);
			return true;
    }

		return false;
	}

	private void echo(String msg, CallbackContext callbackContext) {
		if (msg == null || msg.length() == 0) {
			callbackContext.error("Empty message!");
		} else {
			Toast.makeText(webView.getContext(), msg, Toast.LENGTH_LONG).show();
			callbackContext.success(msg);
		}
	}
}
