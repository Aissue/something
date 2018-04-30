package blockQue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/5.
 */
public class delayEntity implements Delayed {

    /*时间单位*/
    private TimeUnit timeUnit;
    /*具体的时间参数*/
    private long liveTime;

    private long removeTime;

    private String name;

    public delayEntity(String name , TimeUnit tu, long lt){
        this.name = name;
        this.timeUnit = tu;
        this.liveTime = lt;
        this.removeTime = TimeUnit.NANOSECONDS.convert(liveTime, tu) + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        System.out.println("getDelay_method has run");
        return unit.convert(removeTime - System.nanoTime(), unit);
    }

    @Override
    public int compareTo(Delayed o) {
        System.out.println("compareTo_method has run");
        if (o == null) return 1;
        if (o == this) return 0;
        if (o instanceof delayEntity){
            delayEntity tmpDelayedItem = (delayEntity)o;
            if (liveTime > tmpDelayedItem.liveTime ) {
                return 1;
            }else if (liveTime == tmpDelayedItem.liveTime) {
                return 0;
            }else {
                return -1;
            }
        }
        long diff = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return diff > 0 ? 1:diff == 0? 0:-1;
    }

    @Override
    public String toString() {
        return "delayEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
