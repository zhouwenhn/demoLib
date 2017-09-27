package vulture.service.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by zhouwen on 2017/6/13.
 * 用于经纶接收小鱼语音识别广播 Bundle（voice_recognition_str）：String
 * 注册到经纶app manifest中
 */
//        Intent intent2 = new Intent();
//                intent2.setAction("nemo.intent.action.ASR");
//                sendBroadcast(intent2);
public class NemoASRReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: 2017/6/13 处理业务 
        Log.i("NemoASRReceiver", "NemoASRReceiver>>>>result="+intent.getStringExtra("voice_recognition_str"));
    }
}
