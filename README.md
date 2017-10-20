# Groovy Delegate List Stack Overflow Demonstration

Example project for demonstration a `StackOverflowError` from what's expected to be an innocent
implementation of the `List` interface.

## Stacktrace

```
Exception in thread "main" java.lang.StackOverflowError
	at groovy.lang.MetaClassImpl.getProperty(MetaClassImpl.java:1758)
	at groovy.lang.MetaClassImpl.getProperty(MetaClassImpl.java:3689)
	at com.aspin.groovy.example.list.DelegateList$DelegatingList.getProperty(DelegateList.groovy)
	at org.codehaus.groovy.runtime.callsite.PogoGetPropertySite.getProperty(PogoGetPropertySite.java:47)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callGroovyObjectGetProperty(AbstractCallSite.java:231)
	at com.aspin.groovy.example.list.DelegateList$DelegatingList.size(DelegateList.groovy:12)
	at org.codehaus.groovy.runtime.DefaultGroovyMethods.getAt(DefaultGroovyMethods.java:6037)
	at groovy.lang.MetaClassImpl.getProperty(MetaClassImpl.java:1828)
	at groovy.lang.MetaClassImpl.getProperty(MetaClassImpl.java:3689)
	at com.aspin.groovy.example.list.DelegateList$DelegatingList.getProperty(DelegateList.groovy)
	at org.codehaus.groovy.runtime.callsite.PogoGetPropertySite.getProperty(PogoGetPropertySite.java:47)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callGroovyObjectGetProperty(AbstractCallSite.java:231)
	at com.aspin.groovy.example.list.DelegateList$DelegatingListImplementation.getDelegate(DelegateList.groovy:129)
	at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:90)
	at groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:324)
	at groovy.lang.MetaClassImpl.getProperty(MetaClassImpl.java:1843)
	at groovy.lang.MetaClassImpl.getProperty(MetaClassImpl.java:3689)
	at com.aspin.groovy.example.list.DelegateList$DelegatingList.getProperty(DelegateList.groovy)
	at org.codehaus.groovy.runtime.callsite.PogoGetPropertySite.getProperty(PogoGetPropertySite.java:47)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callGroovyObjectGetProperty(AbstractCallSite.java:231)
	at com.aspin.groovy.example.list.DelegateList$DelegatingList.size(DelegateList.groovy:12)
	at org.codehaus.groovy.runtime.DefaultGroovyMethods.getAt(DefaultGroovyMethods.java:6037)
	at groovy.lang.MetaClassImpl.getProperty(MetaClassImpl.java:1828)
	at groovy.lang.MetaClassImpl.getProperty(MetaClassImpl.java:3689)
	at com.aspin.groovy.example.list.DelegateList$DelegatingList.getProperty(DelegateList.groovy)
	at org.codehaus.groovy.runtime.callsite.PogoGetPropertySite.getProperty(PogoGetPropertySite.java:47)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callGroovyObjectGetProperty(AbstractCallSite.java:231)
	at com.aspin.groovy.example.list.DelegateList$DelegatingListImplementation.getDelegate(DelegateList.groovy:129)
	at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:90)
	at groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:324)
	at groovy.lang.MetaClassImpl.getProperty(MetaClassImpl.java:1843)
	at groovy.lang.MetaClassImpl.getProperty(MetaClassImpl.java:3689)
	at com.aspin.groovy.example.list.DelegateList$DelegatingList.getProperty(DelegateList.groovy)
	at org.codehaus.groovy.runtime.callsite.PogoGetPropertySite.getProperty(PogoGetPropertySite.java:47)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callGroovyObjectGetProperty(AbstractCallSite.java:231)
	at com.aspin.groovy.example.list.DelegateList$DelegatingList.size(DelegateList.groovy:12)

// ... <clipped>
```
