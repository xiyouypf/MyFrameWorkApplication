package com.ypf.mybinder.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.ypf.mybinder.po.Person;
import java.util.ArrayList;
import java.util.List;

//服务端
public class YpfAidlService extends Service {
    private List<Person> persons;

    @Override
    public IBinder onBind(Intent intent) {
        persons = new ArrayList<>();
        return iBinder;
    }

    private IBinder iBinder = new IYpfAidlInterface.Stub() {
        @Override
        public void addPerson(Person person) throws RemoteException {
            persons.add(person);
        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            return persons;
        }
    };
}