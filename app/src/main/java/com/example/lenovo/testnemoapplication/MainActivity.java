package com.example.lenovo.testnemoapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import vulture.service.api.ICallback;
import vulture.service.api.INemoAidlInterface;

/**
 * Created by zhouwen on 2017/6/13.
 */

public class MainActivity extends AppCompatActivity {

    private INemoAidlInterface mNemoAidlInterface;

    private ServiceConnection mServiceConnection;

    private ICallback.Stub mCallback;

    private ICallback.Stub mCallback1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mNemoAidlInterface = INemoAidlInterface.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mNemoAidlInterface = null;
            }
        };

        /**
         * 绑定服务
         */
        Intent intent = new Intent();
        intent.setAction("nemo.intent.action.NEMO_REMOTE_SERVICE");
        intent.setPackage("vulture.app.home");
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);

        /**
         * 人脸识别相关
         */
        findViewById(R.id.btn_face_detect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("face_path", Environment.getExternalStorageDirectory().getPath() + "/.nemo/faces/local/");
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClassName("vulture.app.home", "vulture.app.face.NemoFaceDetectActivity");
                startActivity(intent);

//                Intent intent1 =  new Intent();
//                intent1.setClassName("vulture.app.home", "vulture.service.api.TestActivity");
//                startActivity(intent1);
            }
        });

        /**
         * 机器人聊天唤醒
         */
        findViewById(R.id.btn_enable_speech).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mNemoAidlInterface != null) {
                        mNemoAidlInterface.enableSpeech(false);//是否开启机器人聊天唤醒

                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.btn_interrupt_tts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mNemoAidlInterface != null)
                        mNemoAidlInterface.interruptTts(true);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        /**
         * tts接口
         */
        mCallback = new ICallback.Stub() {
            @Override
            public void onSpeakStatusListener(final boolean isCompleted) throws RemoteException {
                // TODO: 2017/6/13 返回tts状态
                Log.i("MainActivity", "onSpeakStatusListener#speakStatus=" + isCompleted);

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "tts状态：speakStatus=" + isCompleted, Toast.LENGTH_LONG).show();
                    }
                });

            }
        };

        mCallback1= new ICallback.Stub() {
            @Override
            public void onSpeakStatusListener(final boolean isCompleted) throws RemoteException {
                // TODO: 2017/6/13 返回tts状态
                Log.i("MainActivity", "onSpeakStatusListener#speakStatus=" + isCompleted);

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "tts状态111：speakStatus=" + isCompleted, Toast.LENGTH_LONG).show();
                    }
                });

            }
        };

        //播tts
        findViewById(R.id.btn_tts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mNemoAidlInterface != null) {

                        mNemoAidlInterface.textToSpeech("小鱼开启机器人唤醒");//tts播报  开启机器人唤醒开启机器人唤醒开启机器人唤醒开启机器人唤醒唤醒开启机器人唤醒开启机器人唤醒开启机器人唤醒开启机器人唤醒

                        /**
                         * 返回播报状态，需要注册
                         */
                        mNemoAidlInterface.registerListener(mCallback);
                        mNemoAidlInterface.registerListener(mCallback1);
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                System.exit(0);
                Log.e("Activity", "Process.myPid()=" + Process.myPid());
//                Process.killProcess(Process.myPid());
                finish();
            }
        });

        //手机端调起视频电话界面
        findViewById(R.id.btn_call_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.ainemo.vulture", "com.ainemo.vulture.activity.business.NemoVideoPhoneActivity");
                intent.putExtra("nemo_number", "597138");
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        //进入小鱼端
        findViewById(R.id.btn_entrance_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("vulture.app.home", "vulture.service.api.EntranceHomeActivity");
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        //拨打电话
        findViewById(R.id.btn_make_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mNemoAidlInterface != null)
                        mNemoAidlInterface.makeNemoTelephoneCall("15999927306");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        //设置小鱼助手停留时间
        findViewById(R.id.btn_call_assistant).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/8/3
                try {
                    if (mNemoAidlInterface != null)
                        mNemoAidlInterface.setNemoHelperOutOfTime(60 * 1000);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.btn_call_helper).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNemoAidlInterface != null){
                    try {
                        mNemoAidlInterface.wakeupNemoHelper();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        findViewById(R.id.btn_take_picture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNemoAidlInterface != null){
                    try {
                        mNemoAidlInterface.takePicture();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        // TODO: 2017/6/13  解绑
        unbindService(mServiceConnection);
        try {
            if (mNemoAidlInterface != null){
                mNemoAidlInterface.unregisterListener(mCallback);
                mNemoAidlInterface.enableSpeech(true);//开启机器人唤醒
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.i("mMainActivity", "onDestroy>>>>>");
        super.onDestroy();
    }

    @Override
    public void finish() {
        Log.i("mMainActivity", "finish>>>>>");
        super.finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO: 2017/6/13
        Log.e("MainActivity", "onActivityResult>>>requestCode=" + resultCode + ">>resultCode=" + resultCode);
        if (data != null) {
            Bundle bundle = data.getExtras();
            Log.e("MainActivity", "onActivityResult>>>face_detect_result=" + bundle.getString("face_detect_result"));
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
