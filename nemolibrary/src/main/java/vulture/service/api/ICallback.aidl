// ICallbackAidlInterface.aidl
package vulture.service.api;

// Declare any non-default types here with import statements

interface ICallback {

    void onSpeakStatusListener(boolean isCompleted);//播报tts状态
}
