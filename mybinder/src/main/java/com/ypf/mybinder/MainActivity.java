package com.ypf.mybinder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ypf.mybinder.po.Person;
import com.ypf.mybinder.service.IYpfAidlInterface;
import com.ypf.mybinder.service.YpfAidlService;

import java.util.List;

//客户端
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private IYpfAidlInterface iYpfAidlInterface;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        bindService();
    }

    private void initView() {
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    iYpfAidlInterface.addPerson(new Person("ypf", 3));
                    List<Person> persons = iYpfAidlInterface.getPersonList();
                    Log.d(TAG, persons.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void bindService() {
//        Intent intent = new Intent();
//        intent.setComponent(new ComponentName("com.ypf.mybinder.service", "com.ypf.mybinder.service.YpfAidlService"));
        Intent intent = new Intent(this, YpfAidlService.class);
        intent.setAction("com.ypf.mybinder");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: success");
            iYpfAidlInterface = IYpfAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: success");
            iYpfAidlInterface = null;
        }
    };
}