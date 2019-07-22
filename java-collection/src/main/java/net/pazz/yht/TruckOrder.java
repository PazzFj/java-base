package net.pazz.yht;

import net.pazz.yto.lock.SerialNumberRuleEntity;
import org.springframework.beans.BeanUtils;

import java.time.LocalTime;

/**
 * @author: Peng Jian
 * @date: 2018/6/11 15:58
 * @description:
 */
public class TruckOrder {

    private static final LocalTime ORDER_MAGIC_NUMBER = LocalTime.of(5, 1, 8);

    public static void main(String[] args) {
//        ZoneId zone = ZoneId.systemDefault(); //
//        System.out.println("ZoneId: " + zone);
//        LocalDateTime time = LocalDateTime.of(LocalDate.now(), ORDER_MAGIC_NUMBER);
//        System.out.println("LocalDateTime: " + time);
//        long value = time.atZone(zone).toEpochSecond() + 300;
//        System.out.println("orderNumber: " + value);

        SerialNumberRuleEntity source = new SerialNumberRuleEntity();
        source.setId("1");
        source.setCode("code1");
        source.setName("p");
        SerialNumberRuleEntity target = new SerialNumberRuleEntity();
        BeanUtils.copyProperties(source, target, "id", "code");
        System.out.println(source);
        System.out.println(target);
    }

}
