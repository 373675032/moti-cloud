package com.moti.utils;

import net.sf.ehcache.Element;
import net.sf.ehcache.store.compound.ReadWriteCopyStrategy;

import java.io.Serializable;

/**
 * @Description 优化缓存策略
 * 序列化要缓存的对象，否则设置  copyOnRead="true" copyOnWrite="true" 缓存对象的时候可能报序列化错误
 * @Author xw
 * @Date 9:23 2020/2/29
 * @Param  * @param null
 * @return
 **/
public class MyCopyStrategy implements ReadWriteCopyStrategy<Element> {
    @Override
    public Element copyForWrite(Element value) {
        if (value != null) {
            Object temp = (Serializable) value.getObjectValue();
            return new Element(value.getObjectKey(), temp);
        }
        return value;
    }

    @Override
    public Element copyForRead(Element storedValue) {
        if (storedValue != null) {
            Object temp = (Serializable) storedValue.getObjectValue();
            return new Element(storedValue.getObjectKey(), temp);
        }
        return storedValue;
    }
}