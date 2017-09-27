// INemoAidlInterface.aidl
package vulture.service.api;

import vulture.service.api.ICallback;

// Declare any non-default types here with import statements

interface INemoAidlInterface {

     void textToSpeech(String ttsContent);//tts播报

     void interruptTts(boolean isInterruptTTS);//是否打断tts

     void enableSpeech(boolean isEnable);//唤醒开关

     void registerListener(ICallback callback);//注册回调

     void unregisterListener(ICallback callback);//注销回调

     void setNemoHelperOutOfTime(long timeMillis);// timeMillis--设置小鱼助手超时时间 单位:ms

     void makeNemoTelephoneCall(String phoneNumber);// phoneNumber--被叫手机号码

     void wakeupNemoHelper();//唤醒小鱼助手

     void takePicture();//拍照
}
