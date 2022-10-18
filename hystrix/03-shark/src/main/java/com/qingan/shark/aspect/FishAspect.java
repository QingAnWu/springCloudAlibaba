package com.qingan.shark.aspect;

import com.qingan.shark.model.Fish;
import com.qingan.shark.model.FishStatus;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author qingAn
 * @Date 2022/10/18 14:37
 */
@Component
@Aspect
public class FishAspect {
    //public static final String POINT_CUT ="execution(* com.qingan.shark.controller.FishController.doRpc(..))";

    //因为一个消费者可以去调用多个提供者 每个提供者都有自己的断路器
    public static Map<String, Fish> fishMap = new HashMap<>();

    static {
        //假设 是需要去调用 order-service的服务
        fishMap.put("order-service", new Fish());
    }

    Random random = new Random();

    /**
     * 这个就类比拦截器
     * 技术要判断 当前断路器的状态 从而决定是否发起调用（执行目标的方法）
     *
     * @param joinPoint
     * @return
     */
    @Around(value = "@annotation(com.qingan.shark.anno.Shark)")
    public Object fishAround(ProceedingJoinPoint joinPoint) {

        Object result = null;
        Fish fish = fishMap.get("order-service");
        FishStatus status = fish.getStatus();
        switch (status) {
            case CLOSE:
                //正常去调用 执行目标方法
                try {
                    result = joinPoint.proceed();
                    return result;
                } catch (Throwable throwable) {
                    //说明调用失败 记录次数
                    fish.addFailCount();
                    return "我是备胎";
                }
            case OPEN:
                //不调用
                return "我是备胎";
            case HALF_OPEN:
                // 可以用少许流量调用
                int i = random.nextInt(5);
                System.out.println(i);
                if (i == 1) {
                    //去调用
                    try {
                        result = joinPoint.proceed();
                        fish.setStatus(FishStatus.CLOSE);
                        synchronized (fish.getLock()){
                            fish.getLock().notifyAll();
                        }
                        return result;
                    } catch (Throwable throwable) {
                        return "我是备胎";
                    }
                }
            default:
                return "我是备胎";
        }

    }
}
