# JavaDesignPatter
java设计模式 小试牛刀

Head First设计模式学习实践

一 MVP框架搭建
参考自 android-architecture，https://github.com/googlesamples/android-architecture

问题思考
   （1）BaseActivity或者BaseFragemnt应该持有presenter吗，Google不这么做，film如此
   （2）presenter应该使用接口实现吗，Google如此，film不这么做，https://blog.karumi.com/interfaces-for-presenters-in-mvp-are-a-waste-of-time/
   （3）view应该使用接口实现，为了解耦以及单元测试presenter
   （4）model层应该用接口实现吗，Google如此，因为model层有多个实现，数据来源区分了缓存和服务端数据
   （5）presenter中应该用SoftReference声明View吗，Google不这么做
   （6）T-MVP框架的优势：多态与抽象，https://github.com/north2016/T-MVP

二 观察者模式
我们自己实现了观察者模式，Observer对应java内置的Observer，Subject对应java内置的Observable

问题思考
   （1）java内置的Observable声明为class,而不是interface，优点在哪。考虑能否用abstract class替代，并且内部实现addObserver与deleteObserver
   （2）java内置的Observable的addObserver与deleteObserver采用了加锁控制，考虑了并发场景
   （3）java内置的Observable的notifyObservers(Object arg)是个很巧妙的设计，可以向观察者推送任意格式的数据
   （4）Subject的isRegister(Observer o)是个很实用的设计，Observable不提供这个接口我认为是个缺陷
   （5）java内置的Observable