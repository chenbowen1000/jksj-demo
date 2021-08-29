课程内容未消化完全，还在参照秦老师的GCLogAnalysis做练习，后续会补充


1.使用idea打印GC日志: edit configurations...中ALT+M
在vm options处加入

    -XX:+PrintGCDetails
    -XX:+PrintGCDateStamps
    -XX:+UseParallelGC
    -Xloggc:gc.demo.log
    -Xmx512M
    -Xms1g
                        
2.没配置xmx xms时候，会默认使用1/4物理内存作为做大堆内存 
但是假如最大只有1G的话，那么就会使用1/2

3.如何分析日志
    
    GC堆内存情况：
        youny区大小变化，堆内存的变化，GC暂停时间
        
        
    CPU使用情况 ：
    
4.-xmx -xms不同配置

    不配置-xmx的时候GC次数差别非常大，会频繁的做GC,但是配置了-xms，GC次数就少了很多
    一开始JVM会把堆内存分配的非常小，当old区满了后，就会做fullGC并且频发的扩容，然而当设定好了初始化值，就相当于提供了更大的蓄水池，GC的频次就会下来
    不过最大堆内存也不是越大越好，因为这样STW,FULLGC的时候时间会非常长
    


