// IYpfAidlInterface.aidl
package com.ypf.mybinder.service;
// Declare any non-default types here with import statements

//然后再在我们的AIDL接口中导入我们的AIDL类型。
import com.ypf.mybinder.po.Person;
interface IYpfAidlInterface {
    void addPerson(in Person person);
    List<Person> getPersonList();
}