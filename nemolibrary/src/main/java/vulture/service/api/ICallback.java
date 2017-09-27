/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\works\\projects\\fish\\client\\nemo\\nemo_remote_interface\\src\\main\\aidl\\vulture\\service\\api\\ICallback.aidl
 */
package vulture.service.api;
// Declare any non-default types here with import statements

public interface ICallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements ICallback
{
private static final String DESCRIPTOR = "vulture.service.api.ICallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an vulture.service.api.ICallback interface,
 * generating a proxy if needed.
 */
public static ICallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof ICallback))) {
return ((ICallback)iin);
}
return new Proxy(obj);
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
case TRANSACTION_onSpeakStatusListener:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.onSpeakStatusListener(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements ICallback
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
@Override public void onSpeakStatusListener(boolean isCompleted) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((isCompleted)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onSpeakStatusListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onSpeakStatusListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void onSpeakStatusListener(boolean isCompleted) throws android.os.RemoteException;
}
