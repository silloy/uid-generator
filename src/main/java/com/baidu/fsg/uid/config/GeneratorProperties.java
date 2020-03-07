package com.baidu.fsg.uid.config;

import com.baidu.fsg.uid.buffer.RejectedPutBufferHandler;
import com.baidu.fsg.uid.buffer.RejectedTakeBufferHandler;
import com.baidu.fsg.uid.buffer.RingBuffer;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static com.baidu.fsg.uid.impl.CachedUidGenerator.DEFAULT_BOOST_POWER;


@Data
@ConfigurationProperties(prefix = "uid.config")
public class GeneratorProperties {

    /** Bits allocate */
    Integer timeBits = 28;
    Integer workerBits = 22;
    Integer seqBits = 13;
    String epochStr = "2016-05-20";

    private Boolean cached = Boolean.FALSE;

    /** Spring properties */
    private int boostPower = DEFAULT_BOOST_POWER;
    private int paddingFactor = RingBuffer.DEFAULT_PADDING_PERCENT;
    private Long scheduleInterval;

    private RejectedPutBufferHandler rejectedPutBufferHandler;
    private RejectedTakeBufferHandler rejectedTakeBufferHandler;
}
