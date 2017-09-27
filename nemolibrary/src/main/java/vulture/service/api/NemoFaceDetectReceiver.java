package vulture.service.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by zhouwen on 2017/6/13.

 */
//        Intent intent2 = new Intent();
//                intent2.setAction("nemo.intent.action.ASR");
//                sendBroadcast(intent2);
public class NemoFaceDetectReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: 2017/6/13 处理业务 
        Log.i("NemoFaceDetectReceiver", "NemoFaceDetectReceiver>>>>face_detect_result="+intent.getExtras().getString("face_detect_result"));
    }
}
