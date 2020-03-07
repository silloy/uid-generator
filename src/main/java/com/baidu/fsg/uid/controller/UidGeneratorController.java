package com.baidu.fsg.uid.controller;

import com.baidu.fsg.uid.config.GeneratorProperties;
import com.baidu.fsg.uid.impl.CachedUidGenerator;
import com.baidu.fsg.uid.impl.DefaultUidGenerator;
import com.baidu.fsg.uid.impl.UidGenerator;
import com.baidu.fsg.uid.utils.SpringBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaohuasu
 * @date 2020/3/7 2:35 PM
 * @since 1.8
 */
@RestController
public class UidGeneratorController {

    @Autowired
    GeneratorProperties properties;

    @GetMapping("/uid")
    public Long id() {
        boolean cached = properties.getCached();
        UidGenerator uidGenerator;
        if (cached) {
            uidGenerator = SpringBeanUtil.getBean("cachedUidGenerator", CachedUidGenerator.class);
        } else {
            uidGenerator = SpringBeanUtil.getBean("defaultUidGenerator", DefaultUidGenerator.class);
        }
        return uidGenerator.getUID();
    }
}
