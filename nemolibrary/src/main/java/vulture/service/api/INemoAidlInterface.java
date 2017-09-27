/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\works\\projects\\fish\\client\\nemo\\nemo_remote_interface\\src\\main\\aidl\\vulture\\service\\api\\INemoAidlInterface.aidl
 */
package vulture.service.api;
// Declare any non-default types here with import statements

public interface INemoAidlInterface extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements vulture.service.api.INemoAidlInterface
{
private static final String DESCRIPTOR = "vulture.service.api.INemoAidlInterface";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an vulture.service.api.INemoAidlInterface interface,
 * generating a proxy if needed.
 */
public static vulture.service.api.INemoAidlInterface asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof vulture.service.api.INemoAidlInterface))) {
return ((vulture.service.api.INemoAidlInterface)iin);
}
return new vulture.service.api.INemoAidlInterface.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_textToSpeech:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
this.textToSpeech(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_interruptTts:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.interruptTts(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_enableSpeech:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.enableSpeech(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_registerListener:
{
data.enforceInterface(DESCRIPTOR);
vulture.service.api.ICallback _arg0;
_arg0 = vulture.service.api.ICallback.Stub.asInterface(data.readStrongBinder());
this.registerListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterListener:
{
data.enforceInterface(DESCRIPTOR);
vulture.service.api.ICallback _arg0;
_arg0 = vulture.service.api.ICallback.Stub.asInterface(data.readStrongBinder());
this.unregisterListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setNemoHelperOutOfTime:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
this.setNemoHelperOutOfTime(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_makeNemoTelephoneCall:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
this.makeNemoTelephoneCall(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_wakeupNemoHelper:
{
data.enforceInterface(DESCRIPTOR);
this.wakeupNemoHelper();
reply.writeNoException();
return true;
}
case TRANSACTION_takePicture:
{
data.enforceInterface(DESCRIPTOR);
this.takePicture();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements vulture.service.api.INemoAidlInterface
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void textToSpeech(String ttsContent) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(ttsContent);
mRemote.transact(Stub.TRANSACTION_textToSpeech, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//tts播报

@Override public void interruptTts(boolean isInterruptTTS) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((isInterruptTTS)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_interruptTts, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//是否打断tts

@Override public void enableSpeech(boolean isEnable) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((isEnable)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_enableSpeech, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//唤醒开关

@Override public void registerListener(vulture.service.api.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//注册回调

@Override public void unregisterListener(vulture.service.api.ICallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//注销回调

@Override public void setNemoHelperOutOfTime(long timeMillis) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(timeMillis);
mRemote.transact(Stub.TRANSACTION_setNemoHelperOutOfTime, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// timeMillis--设置小鱼助手超时时间 单位:ms

@Override public void makeNemoTelephoneCall(String phoneNumber) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(phoneNumber);
mRemote.transact(Stub.TRANSACTION_makeNemoTelephoneCall, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// phoneNumber--被叫手机号码

@Override public void wakeupNemoHelper() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_wakeupNemoHelper, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//唤醒小鱼助手

@Override public void takePicture() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_takePicture, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_textToSpeech = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_interruptTts = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_enableSpeech = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_registerListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_unregisterListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_setNemoHelperOutOfTime = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_makeNemoTelephoneCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_wakeupNemoHelper = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_takePicture = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
}
public void textToSpeech(String ttsContent) throws android.os.RemoteException;
//tts播报

public void interruptTts(boolean isInterruptTTS) throws android.os.RemoteException;
//是否打断tts

public void enableSpeech(boolean isEnable) throws android.os.RemoteException;
//唤醒开关

public void registerListener(vulture.service.api.ICallback callback) throws android.os.RemoteException;
//注册回调

public void unregisterListener(vulture.service.api.ICallback callback) throws android.os.RemoteException;
//注销回调

public void setNemoHelperOutOfTime(long timeMillis) throws android.os.RemoteException;
// timeMillis--设置小鱼助手超时时间 单位:ms

public void makeNemoTelephoneCall(String phoneNumber) throws android.os.RemoteException;
// phoneNumber--被叫手机号码

public void wakeupNemoHelper() throws android.os.RemoteException;
//唤醒小鱼助手

public void takePicture() throws android.os.RemoteException;
}
