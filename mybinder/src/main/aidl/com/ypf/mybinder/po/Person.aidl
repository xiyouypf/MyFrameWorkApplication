// Person.aidl
//这里的Person为po中的Person
package com.ypf.mybinder.po;

// Declare any non-default types here with import statements
//接下新建一个aidl文件，名称为我们自定义类型的名称，这边是Person.aidl。
//在Person.aidl申明我们的自定义类型和它的完整包名，
//注意这边parcelable是小写的，不是Parcelable接口，
//一个自定类型需要一个这样同名的AIDL文件。
parcelable Person;