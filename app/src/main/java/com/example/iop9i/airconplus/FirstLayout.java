package com.example.iop9i.airconplus;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

import static android.app.Activity.RESULT_CANCELED;

public class FirstLayout extends Fragment {
    private static final int REQUEST_ENABLE_BT = 100;
    private String mConnectedDeviceName = null;
    //ConnectedTask mConnectedTask = null;
    View v;

   // TextView bluetoothText;
  //  BluetoothAdapter mBT = BluetoothAdapter.getDefaultAdapter();
    static boolean isConnectionError = false;
   // private static final String TAG = "BluetoothClient";
    private ArrayAdapter<String> mConversationArrayAdapter;

    private TextView textView_intemp;
    private TextView textView_outtemp;
    private TextView textView_inhum;
    private TextView textView_outhum;
    private TextView textView_wind_strong;
    private TextView textView_wind_light;
    private TextView textView_wind_gentle;
    private ImageView imageView_ice;
    private ImageView imageView_dehum;
    private ImageView imageView_power;
    String strColor = "#546E7A";
    String strColor_2 = "#4fc3f7";
    String strColor_3 = "#aed581";


    DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mDB = mRoot.child("qi698BDarUgd2ERe1zLOr1GMx4D3");




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate (R.layout.first_layout, container, false);
        textView_intemp = (TextView)v.findViewById(R.id.textView4);
        textView_outtemp = (TextView)v.findViewById(R.id.textView7);
        textView_inhum = (TextView)v.findViewById(R.id.textView5);
        textView_outhum = (TextView)v.findViewById(R.id.textView8);
        textView_wind_strong = (TextView)v.findViewById(R.id.wind_strong);
        textView_wind_light = (TextView)v.findViewById(R.id.wind_light);
        textView_wind_gentle = (TextView)v.findViewById(R.id.wind_gentle);
        imageView_ice = (ImageView)v.findViewById(R.id.image_ice);
        imageView_dehum = (ImageView)v.findViewById(R.id.image_dehum);
        imageView_power = (ImageView)v.findViewById(R.id.image_power);


        mDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Integer temp_in = dataSnapshot.child("indoor_temp").getValue(Integer.class);
                Integer temp_out = dataSnapshot.child("outdoor_fan_temp").getValue(Integer.class);
                Integer hum_in = dataSnapshot.child("indoor_hum").getValue(Integer.class);
                Integer hum_out = dataSnapshot.child("outdoor_fan_hum").getValue(Integer.class);

                Integer power = dataSnapshot.child("on").getValue(Integer.class);
                String temp_in2 = String.valueOf(temp_in);
                String temp_out2 = String.valueOf(temp_out);
                String hum_in2 = String.valueOf(hum_in);
                String hum_out2 = String.valueOf(hum_out);
                textView_intemp.setText(temp_in2+"º");
                textView_outtemp.setText(temp_out2+"º");
                textView_inhum.setText(hum_in2+"%");
                textView_outhum.setText(hum_out2+"%");
                if(temp_in<28){
                    textView_wind_strong.setTextColor(Color.parseColor(strColor));
                    textView_wind_light.setTextColor(Color.parseColor(strColor));
                    textView_wind_gentle.setTextColor(Color.parseColor(strColor_2));
                }else if(temp_in<30){
                    textView_wind_strong.setTextColor(Color.parseColor(strColor));
                    textView_wind_light.setTextColor(Color.parseColor(strColor_2));
                    textView_wind_gentle.setTextColor(Color.parseColor(strColor));
                }else{
                    textView_wind_strong.setTextColor(Color.parseColor(strColor_2));
                    textView_wind_light.setTextColor(Color.parseColor(strColor));
                    textView_wind_gentle.setTextColor(Color.parseColor(strColor));
                }
                if(hum_in>60){
                    imageView_dehum.setColorFilter(Color.parseColor(strColor_2));
                    imageView_ice.setColorFilter(Color.parseColor(strColor));

                }else{
                    imageView_dehum.setColorFilter(Color.parseColor(strColor));
                    imageView_ice.setColorFilter(Color.parseColor(strColor_2));
                }
                if(power==1){
                    imageView_power.setColorFilter(Color.parseColor(strColor_3));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
/*
        bluetoothText = (TextView)v.findViewById(R.id.bluetooth_text);

        String sendMessage = mAuth.getCurrentUser().getUid();
        sendMessage(sendMessage);

        if(mBT == null){
            // Device does not support BLUETOOTH
            showErrorDialog("This device is not implement Bluetooth.");
//            return;
        }

        if (!mBT.isEnabled()) {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, REQUEST_ENABLE_BT);
        }
        else {
            Log.d(TAG, "Initialisation successful.");

            showPairedDevicesListDialog();
        }*/
/*
        mDB.getReference().child("qi698BDarUgd2ERe1zLOr1GMx4D3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@222222222222");
                Double d1 = (Double) dataSnapshot.child("indoor_temp").getValue();
                System.out.println(d1);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
*/
        return v;
    }



/*
    // 이부분도 블루투스 소켓 통신 부분
    private class ConnectTask extends AsyncTask<Void, Void, Boolean> {

        private BluetoothSocket mBluetoothSocket = null;
        private BluetoothDevice mBluetoothDevice = null;

        ConnectTask(BluetoothDevice bluetoothDevice) {
            mBluetoothDevice = bluetoothDevice;
            mConnectedDeviceName = bluetoothDevice.getName();

            //SPP
            UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

            try {
                mBluetoothSocket = mBluetoothDevice.createRfcommSocketToServiceRecord(uuid);
                Log.d( TAG, "create socket for "+mConnectedDeviceName);

            } catch (IOException e) {
                Log.e( TAG, "socket create failed " + e.getMessage());
            }

//            mConnectionStatus.setText("connecting...");
        }


        @Override
        protected Boolean doInBackground(Void... params) {

            // Always cancel discovery because it will slow down a connection
            mBT.cancelDiscovery();

            // Make a connection to the BluetoothSocket
            try {
                // This is a blocking call and will only return on a
                // successful connection or an exception
                mBluetoothSocket.connect();
            } catch (IOException e) {
                // Close the socket
                try {
                    mBluetoothSocket.close();
                } catch (IOException e2) {
                    Log.e(TAG, "unable to close() " +
                            " socket during connection failure", e2);
                }

                return false;
            }

            return true;
        }


        @Override
        protected void onPostExecute(Boolean isSucess) {

            if ( isSucess ) {
                connected(mBluetoothSocket);
            }
            else{

                isConnectionError = true;
                Log.d( TAG,  "Unable to connect device");
                showErrorDialog("Unable to connect device");
            }
        }
    }


    public void connected( BluetoothSocket socket ) {
        mConnectedTask = new ConnectedTask(socket);
        mConnectedTask.execute();
    }

    // 블루투스 소켓 통신 부분
    private class ConnectedTask extends AsyncTask<Void, String, Boolean> {

        private InputStream mInputStream = null;
        private OutputStream mOutputStream = null;
        private BluetoothSocket mBluetoothSocket = null;

        ConnectedTask(BluetoothSocket socket){

            mBluetoothSocket = socket;
            try {
                mInputStream = mBluetoothSocket.getInputStream();
                mOutputStream = mBluetoothSocket.getOutputStream();
            } catch (IOException e) {
                Log.e(TAG, "socket not created", e );
            }

            Log.d( TAG, "connected to "+mConnectedDeviceName);
            bluetoothText.setText( "connected to "+mConnectedDeviceName);
        }


        @Override
        protected Boolean doInBackground(Void... params) {

            byte [] readBuffer = new byte[1024];
            int readBufferPosition = 0;


            while (true) {

                if ( isCancelled() ) return false;

                try {

                    int bytesAvailable = mInputStream.available();

                    if(bytesAvailable > 0) {

                        byte[] packetBytes = new byte[bytesAvailable];

                        mInputStream.read(packetBytes);

                        for(int i=0;i<bytesAvailable;i++) {

                            byte b = packetBytes[i];
                            if(b == '\n')
                            {
                                byte[] encodedBytes = new byte[readBufferPosition];
                                System.arraycopy(readBuffer, 0, encodedBytes, 0,
                                        encodedBytes.length);
                                String recvMessage = new String(encodedBytes, "UTF-8");

                                readBufferPosition = 0;

                                Log.d(TAG, "recv message: " + recvMessage);
                                publishProgress(recvMessage);
                            }
                            else
                            {
                                readBuffer[readBufferPosition++] = b;
                            }
                        }
                    }
                } catch (IOException e) {

                    Log.e(TAG, "disconnected", e);
                    return false;
                }
            }

        }

        @Override
        protected void onProgressUpdate(String... recvMessage) {

            mConversationArrayAdapter.insert(mConnectedDeviceName + ": " + recvMessage[0], 0);
        }

        @Override
        protected void onPostExecute(Boolean isSucess) {
            super.onPostExecute(isSucess);

            if ( !isSucess ) {


                closeSocket();
                Log.d(TAG, "Device connection was lost");
                isConnectionError = true;
                showErrorDialog("Device connection was lost");
            }
        }

        @Override
        protected void onCancelled(Boolean aBoolean) {
            super.onCancelled(aBoolean);

            closeSocket();
        }

        void closeSocket(){

            try {

                mBluetoothSocket.close();
                Log.d(TAG, "close socket()");

            } catch (IOException e2) {

                Log.e(TAG, "unable to close() " +
                        " socket during connection failure", e2);
            }
        }

        void write(String msg){

            msg += "\n";

            try {
                mOutputStream.write(msg.getBytes());
                mOutputStream.flush();
            } catch (IOException e) {
                Log.e(TAG, "Exception during send", e );
            }

            bluetoothText.setText(" ");
        }
    }
    public void showErrorDialog(String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle("Quit");
        builder.setCancelable(false);
        builder.setMessage(message);
        builder.setPositiveButton("OK",  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if ( isConnectionError  ) {
                    isConnectionError = false;
//                    finish();
                    // 이부분 뭐가 문제인지 모르겠음...
                }
            }
        });
        builder.create().show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_ENABLE_BT){
            if (resultCode == Activity.RESULT_OK){
                //BlueTooth is now Enabled
                showPairedDevicesListDialog();
            }
            if(resultCode == RESULT_CANCELED){
//                showQuitDialog( "You need to enable bluetooth");
                System.out.println("You need to enable Bluetooth");
            }
        }
    }


    void sendMessage(String msg){

        if ( mConnectedTask != null ) {
            mConnectedTask.write(msg);
            Log.d(TAG, "send message: " + msg);
            mConversationArrayAdapter.insert("Me:  " + msg, 0);
        }
    }

    public void showPairedDevicesListDialog()
    {
        Set<BluetoothDevice> devices = mBT.getBondedDevices();
        final BluetoothDevice[] pairedDevices = devices.toArray(new BluetoothDevice[0]);

        if ( pairedDevices.length == 0 ){
//            showQuitDialog( "No devices have been paired.\n"
//                    +"You must pair it with another device.");
            return;
        }

        String[] items;
        items = new String[pairedDevices.length];
        for (int i=0;i<pairedDevices.length;i++) {
            items[i] = pairedDevices[i].getName();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle("Select device");
        builder.setCancelable(false);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

                ConnectTask task = new ConnectTask(pairedDevices[which]);
                task.execute();
            }
        });
        builder.create().show();
    }*/
}

