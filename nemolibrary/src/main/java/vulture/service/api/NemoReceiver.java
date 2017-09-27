package vulture.service.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;


public class NemoReceiver extends BroadcastReceiver {
    private static final String ACTION_TAKE_PICTURE = "nemo.intent.action.TAKE_PICTURE";
    private static final String ACTION_CANCEL_TAKE_PICTURE =  "nemo.intent.action.CANCEL_TAKE_PICTURE";
    private static final String INTENT_KEY_PIC_PATH = "intent_key_pic_path";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.i(getClass().getSimpleName(), "action="+action);
        if (ACTION_TAKE_PICTURE.equals(action)) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                // TODO: 2017/8/21 拍照保存路径
                String picPath = bundle.getString(INTENT_KEY_PIC_PATH);
                Log.i(getClass().getSimpleName(), "picPath="+picPath);
            }

         } else if (ACTION_CANCEL_TAKE_PICTURE.equals(action)){ // TODO: 2017/8/30 取消拍照
            Log.i(getClass().getSimpleName(), "ACTION_CANCEL_TAKE_PICTURE>>>");
        }

    }
}
